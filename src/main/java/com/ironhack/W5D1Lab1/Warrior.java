package com.ironhack.W5D1Lab1;

public class Warrior extends Player {
    private int force; // Extra property for Warrior

    // Constructor initializes all fields including force
    public Warrior(int health, int strength, int lives, int force) {
        super(health, strength, lives); // Call parent constructor
        this.force = force;             // Set Warrior-specific property
    }

    // Getter for force
    public int getForce() { return force; }
    // Setter for force
    public void setForce(int force) { this.force = force; }

    // Convert Warrior → Elf
    public Elf convertToElf() {
        // Create new Elf using Warrior’s health, strength, lives, and force as speed
        return new Elf(this.getHealth(), this.getStrength(), this.getLives(), this.force);
    }
}
