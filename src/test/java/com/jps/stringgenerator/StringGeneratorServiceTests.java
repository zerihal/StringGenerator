package com.jps.stringgenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StringGeneratorServiceTests {

    private static StringGeneratorService service;
    private static int definedLen = 40;

    @BeforeAll
    static void setup() {
        service = new StringGeneratorService();
    }
    
    @Test
    void testGenerateRandomString() {
        Object generatedStr = service.generateRandomString();

        if (generatedStr instanceof String) {
            String str = (String)generatedStr;
            assertTrue(str.length() >= 50 && str.length() <= 100, "Generated string out of default bounds");
        } else {
            fail("Generated string is incorrect type or null");
        }
    }

    @Test
    void testGenerateRandomStringLength() {
        Object generatedStr = service.generateRandomString(definedLen);

        if (generatedStr instanceof String) {
            String str = (String)generatedStr;
            assertTrue(str.length() == definedLen, "Generated string defined length incorrect");
        } else {
            fail("Generated string is incorrect type or null");
        }
    }
}
