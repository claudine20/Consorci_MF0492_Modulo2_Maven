package com.ironhack.W5D1Lab1;

import static org.junit.jupiter.api.Assertions.*; // Import assertions
import org.junit.jupiter.api.Test; // Import @Test annotation

public class JavaKeywordCheckerTest {

    @Test
    public void testStringContainsKeyword() {
        // "break" is a Java keyword, appears as a separate word → should return true
        assertTrue(JavaKeywordChecker.containsKeyword("Don't break my heart"));
    }

    @Test
    public void testStringContainsKeywordButAsPartOfWord() {
        // "break" appears inside "breakdance", not as a separate word → should return false
        assertFalse(JavaKeywordChecker.containsKeyword("I love to breakdance"));
    }

    @Test
    public void testStringWithoutKeyword() {
        // No Java keyword in "Hello world" → should return false
        assertFalse(JavaKeywordChecker.containsKeyword("Hello world"));
    }
}
