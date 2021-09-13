package com.craftinginterpreters.lox;

import java.util.Collection;
import java.util.stream.Collectors;

public class TestUtils {
    public static Collection<Integer> getLines(Collection<Token> tokens) {
        return tokens.stream()
                .map(token -> token.line)
                .collect(Collectors.toList());
    }

    public static Collection<TokenType> getTokenTypes(Collection<Token> tokens) {
        return tokens.stream()
                .map(token -> token.type)
                .collect(Collectors.toList());
    }
}
