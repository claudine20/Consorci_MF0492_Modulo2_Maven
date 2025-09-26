package com.ironhack.W6D2Lab2;

public class Student {
    private String name; // Student's name
    private int grade;   // Student's grade (0–100)

    // Constructor
    public Student(String name, int grade) {
        this.name = name;
        setGrade(grade); // validate grade
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    // Setter with validation (grades must be 0–100)
    public void setGrade(int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        this.grade = grade;
    }

    // toString for printing
    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + "}";
    }
}
