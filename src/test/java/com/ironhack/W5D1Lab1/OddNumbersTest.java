package com.ironhack.W5D1Lab1;

import static org.junit.jupiter.api.Assertions.*; // Import assertion methods (assertArrayEquals, assertTrue, etc.)
import org.junit.jupiter.api.Test; // Import the @Test annotation from JUnit

public class OddNumbersTest {

    @Test // Marks this method as a test case
    public void testOddNumbersUpTo1() {
        // Expecting array [1] because 1 is the only odd number ≤ 1
        assertArrayEquals(new int[]{1}, OddNumbers.getOddNumbers(1));
    }

    @Test
    public void testOddNumbersUpTo10() {
        // Expecting array [1,3,5,7,9] because these are the odd numbers ≤ 10
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, OddNumbers.getOddNumbers(10));
    }

    @Test
    public void testOddNumbersUpTo0() {
        // If n=0 → no odd numbers → empty array
        assertArrayEquals(new int[]{}, OddNumbers.getOddNumbers(0));
    }
}
