package com.ironhack.W5D2Lab2;

public class Person {
    private int id;          // Unique identifier for the person
    private String name;     // Name formatted as "firstName lastName"
    private int age;         // Age in years
    private String occupation; // Job or profession

    // Constructor to initialize properties
    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        setAge(age); // use setAge to ensure validation
        this.occupation = occupation;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Getter for occupation
    public String getOccupation() {
        return occupation;
    }

    // Setter for age (throws error if < 0)
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    // Equals method (ignores id, compares other properties)
    public boolean equals(Person other) {
        if (other == null) return false;
        return this.name.equals(other.name) &&
                this.age == other.age &&
                this.occupation.equals(other.occupation);
    }

    // toString method (useful for saving to file)
    @Override
    public String toString() {
        return "Person{id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
