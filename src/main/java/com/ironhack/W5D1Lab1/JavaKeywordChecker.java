package com.ironhack.W5D1Lab1;

import java.util.Arrays;  // To create a list of keywords
import java.util.HashSet; // To store keywords for fast lookup
import java.util.Set;     // Interface for HashSet

public class JavaKeywordChecker {

    // A set containing all Java reserved words
    private static final Set<String> JAVA_KEYWORDS = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
            "class", "const", "continue", "default", "do", "double", "else", "enum",
            "extends", "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native", "new",
            "package", "private", "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while", "_", "null", "true", "false"
    ));

    // Method to check if a given string contains a Java keyword
    public static boolean containsKeyword(String input) {
        // Split input into words using non-word characters as delimiters (regex \W+)
        String[] words = input.split("\\W+");
        // Loop through each word
        for (String word : words) {
            if (JAVA_KEYWORDS.contains(word)) { // Check if it's a Java keyword
                return true;                    // If yes → return true
            }
        }
        return false; // If no keyword found → return false
    }
}

