package com.craftinginterpreters.lox;

import org.testng.annotations.Test;

public class ParserTest {

    @Test
    public void testParse() {
        Scanner scanner = new Scanner("1 /*\n" +
                "123\n" +
                "*/\n" +
                "2");
    }
}