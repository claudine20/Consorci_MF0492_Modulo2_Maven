package com.ironhack.W5D1Lab1;

public class Elf extends Player {
    private int speed; // Extra property for Elf

    // Constructor initializes all fields including speed
    public Elf(int health, int strength, int lives, int speed) {
        super(health, strength, lives); // Call parent constructor
        this.speed = speed;             // Set Elf-specific property
    }

    // Getter for speed
    public int getSpeed() { return speed; }
    // Setter for speed
    public void setSpeed(int speed) { this.speed = speed; }
}
