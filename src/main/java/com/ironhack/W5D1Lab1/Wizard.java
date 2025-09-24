package com.ironhack.W5D1Lab1;
public class Wizard extends Player {
    private String spell; // Extra property for Wizard

    // Constructor initializes all fields including spell
    public Wizard(int health, int strength, int lives, String spell) {
        super(health, strength, lives); // Call parent constructor
        this.spell = spell;             // Set Wizard-specific property
    }

    // Getter for spell
    public String getSpell() { return spell; }
    // Setter for spell
    public void setSpell(String spell) { this.spell = spell; }

    // Convert Wizard → Elf
    public Elf convertToElf() {
        // Create new Elf using Wizard’s health, strength, lives, and default speed = 0
        return new Elf(this.getHealth(), this.getStrength(), this.getLives(), 0);
    }
}
