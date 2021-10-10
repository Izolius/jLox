package com.craftinginterpreters.lox;

import com.craftinginterpreters.lox.ast.Expr;

public class RPNPrinter implements Expr.Visitor<String> {
    public static void main(String[] args) {
        Expr expression = new Expr.Binary(
                new Expr.Unary(
                        new Token(TokenType.MINUS, "-", null, 1),
                        new Expr.Literal(123)),
                new Token(TokenType.STAR, "*", null, 1),
                new Expr.Grouping(
                        new Expr.Literal(45.67)));
        System.out.println(new RPNPrinter().print(expression));
    }

    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
        return expr.expression.accept(this);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        if (expr.operator.lexeme.equals("-")) {
            return parenthesize("~", expr.right);
        } else {
            return parenthesize(expr.operator.lexeme, expr.right);
        }
    }

    private String parenthesize(String operator, Expr... exprs) {
        StringBuilder builder = new StringBuilder();
        for (Expr expr : exprs) {
            builder.append(expr.accept(this));
            builder.append(" ");
        }
        if (operator != null) {
            builder.append(operator);
            builder.append(" ");
        }
        return builder.toString();
    }
}
