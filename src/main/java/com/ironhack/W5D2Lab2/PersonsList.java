package com.ironhack.W5D2Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons; // Holds list of persons
    private int nextId; // Counter for assigning new ids in clone()

    // Constructor initializes the list and id counter
    public PersonsList() {
        persons = new ArrayList<>();
        nextId = 1; // start new ids from 1
    }

    // Add a person to the list
    public void addPerson(Person p) {
        persons.add(p);
    }

    // Find a person by exact name (must be "firstName lastName")
    public Person findByName(String name) {
        // Ensure proper formatting: should contain exactly one space
        if (name == null || !name.matches("^[A-Za-z]+\\s+[A-Za-z]+$")) {
            throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
        }

        for (Person p : persons) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null; // If not found
    }

    // Clone a person with same properties but new id
    public Person clone(Person original) {
        Person copy = new Person(nextId++, original.getName(), original.getAge(), original.getOccupation());
        return copy;
    }

    // Write a Person to file using toString()
    public void writePersonToFile(Person p, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(p.toString() + "\n"); // append person info
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
