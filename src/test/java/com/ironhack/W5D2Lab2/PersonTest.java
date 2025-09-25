package com.ironhack.W5D2Lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    // ✅ Test Case 1:
    // Test that setAge() throws an error if a negative age is passed
    @Test
    public void testSetAgeThrowsError() {
        Person p = new Person(1, "John Doe", 30, "Engineer"); // create a valid Person
        // Expect IllegalArgumentException when setting negative age
        assertThrows(IllegalArgumentException.class, () -> {
            p.setAge(-5);
        });
    }

    // ✅ Test Case 2:
    // Test that findByName() successfully finds a Person when name is properly formatted
    @Test
    public void testFindByNameSuccess() {
        PersonsList list = new PersonsList(); // create new list
        Person p1 = new Person(1, "Alice Smith", 25, "Doctor"); // create Person
        list.addPerson(p1); // add to list

        // Should find Alice by exact name
        Person found = list.findByName("Alice Smith");
        assertNotNull(found); // ensure not null
        assertEquals("Alice Smith", found.getName()); // verify name matches
    }

    // ✅ Test Case 3:
    // Test that findByName() throws error if name format is wrong (not "firstName lastName")
    @Test
    public void testFindByNameThrowsError() {
        PersonsList list = new PersonsList(); // new list
        Person p1 = new Person(1, "Bob Brown", 40, "Teacher"); // create Person
        list.addPerson(p1); // add to list

        // Searching with invalid format "Bob" should throw error
        assertThrows(IllegalArgumentException.class, () -> {
            list.findByName("Bob");
        });
    }

    // ✅ Test Case 4:
    // Test that clone() creates a new Person with same properties but different id
    @Test
    public void testCloneCreatesNewPerson() {
        PersonsList list = new PersonsList(); // create list
        Person original = new Person(5, "Charlie White", 33, "Artist"); // original Person

        Person copy = list.clone(original); // clone original

        // equals() ignores id, so properties should match
        assertTrue(original.equals(copy));
        // but ids must be different
        assertNotEquals(original.getId(), copy.getId());
    }
}

