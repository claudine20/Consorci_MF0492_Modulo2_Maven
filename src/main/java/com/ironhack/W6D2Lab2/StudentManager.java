package com.ironhack.W6D2Lab2;

import java.util.HashMap;
import java.util.Map;

public class StudentManager {

    // Create a method called increaseGrades that takes a Map<String, Student> as a parameter, increases every student's grade by 10% and returns the updated map
    // Method that increases every student's grade by 10%
    public static Map<String, Student> increaseGrades(Map<String, Student> students) {
        for (Student s : students.values()) {
            int increasedGrade = (int) Math.round(s.getGrade() * 1.10); // increase by 10%
            if (increasedGrade > 100) increasedGrade = 100; // cap at 100
            s.setGrade(increasedGrade);
        }
        return students; // return updated map
    }

    public static void main(String[] args) {
        // Create 4 Student objects
        Student s1 = new Student("Alice", 80);
        Student s2 = new Student("Bob", 70);
        Student s3 = new Student("Charlie", 90);
        Student s4 = new Student("Diana", 95);

        // Create a Map with a key of the student's name (String) and a value of a Student object
        // Create a Map with names as keys
        Map<String, Student> students = new HashMap<>();
        students.put(s1.getName(), s1);
        students.put(s2.getName(), s2);
        students.put(s3.getName(), s3);
        students.put(s4.getName(), s4);

        // Print before update
        System.out.println("Before increasing grades:");
        for (Student s : students.values()) {
            System.out.println(s);
        }

        // Increase grades by 10%
        increaseGrades(students);

        // Print after update
        System.out.println("\nAfter increasing grades:");
        for (Student s : students.values()) {
            System.out.println(s);
        }
    }
}
