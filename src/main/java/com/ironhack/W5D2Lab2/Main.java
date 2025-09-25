package com.ironhack.W5D2Lab2;

public class Main {
    public static void main(String[] args) {
        // -------------------------------
        // DEMO 1: Create Person objects
        // -------------------------------
        System.out.println("=== Creating Persons ===");
        Person p1 = new Person(1, "Alice Smith", 25, "Doctor");
        Person p2 = new Person(2, "Bob Brown", 40, "Teacher");
        Person p3 = new Person(3, "Charlie White", 33, "Artist");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // -------------------------------
        // DEMO 2: Add to PersonsList
        // -------------------------------
        System.out.println("\n=== Adding to PersonsList ===");
        PersonsList list = new PersonsList();
        list.addPerson(p1);
        list.addPerson(p2);
        list.addPerson(p3);
        System.out.println("3 persons added to list.");

        // -------------------------------
        // DEMO 3: Find by name
        // -------------------------------
        System.out.println("\n=== Find By Name ===");
        try {
            Person found = list.findByName("Alice Smith");
            System.out.println("Found: " + found);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Example with bad formatting
        try {
            list.findByName("Alice"); // Not valid
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // -------------------------------
        // DEMO 4: Clone a Person
        // -------------------------------
        System.out.println("\n=== Cloning Person ===");
        Person cloneOfBob = list.clone(p2);
        System.out.println("Original Bob: " + p2);
        System.out.println("Clone of Bob: " + cloneOfBob);

        // Check equality (ignoring id)
        System.out.println("Are Bob and his clone equal (ignoring id)? " + p2.equals(cloneOfBob));

        // -------------------------------
        // DEMO 5: Write to file
        // -------------------------------
        System.out.println("\n=== Writing Persons to File ===");
        list.writePersonToFile(p1, "persons.txt");
        list.writePersonToFile(p2, "persons.txt");
        list.writePersonToFile(cloneOfBob, "persons.txt");
        System.out.println("Persons written to persons.txt file.");
    }
}
