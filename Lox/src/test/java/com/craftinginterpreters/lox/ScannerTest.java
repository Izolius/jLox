package com.craftinginterpreters.lox;

import org.testng.annotations.Test;

import java.util.List;

import static com.craftinginterpreters.lox.TestUtils.getLines;
import static org.testng.Assert.assertEquals;

public class ScannerTest {

    @Test
    public void testScanTokens() {
        Scanner scanner = new Scanner("1 /*\n" +
                "123\n" +
                "*/\n" +
                "2");
        assertEquals(getLines(scanner.scanTokens()), List.of(1, 4, 4));
    }
}