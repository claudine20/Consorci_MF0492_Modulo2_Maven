package com.ironhack.W5D1Lab1;

import java.util.ArrayList; // To store odd numbers dynamically
import java.util.List;      // Interface for ArrayList

public class OddNumbers {
    // Method takes integer n and returns an array of odd numbers from 1 to n
    public static int[] getOddNumbers(int n) {
        List<Integer> result = new ArrayList<>(); // Temporary list to collect odd numbers
        for (int i = 1; i <= n; i++) {            // Loop from 1 up to n
            if (i % 2 != 0)                       // Check if i is odd (remainder when divided by 2 is not 0)
                result.add(i);                    // Add odd number to list
        }
        // Convert List<Integer> → int[] using streams
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
