package com.ironhack.W5D1Lab1;

public abstract class Player {
    private int health;          // Current health of the player
    private int strength;        // Attack power of the player
    private int lives;           // Number of lives remaining
    private final int originalHealth; // Store original health for reset on life loss

    // Constructor initializes properties
    public Player(int health, int strength, int lives) {
        this.health = health;            // Set health
        this.strength = strength;        // Set strength
        this.lives = lives;              // Set lives
        this.originalHealth = health;    // Store original health
    }

    // Getters
    public int getHealth() { return health; }
    public int getStrength() { return strength; }
    public int getLives() { return lives; }

    // Setters
    public void setHealth(int health) { this.health = health; }
    public void setStrength(int strength) { this.strength = strength; }
    public void setLives(int lives) { this.lives = lives; }

    // Method to decrement life count and reset health
    public void decrementLive() {
        lives--;                          // Subtract 1 life
        if (lives <= 0) {                 // If no lives left
            System.out.println("This character is dead"); // Print death message
        } else {
            health = originalHealth;      // Reset health if still alive
        }
    }

    // Attack another player (damage = this.strength)
    public void attack(Player playerToAttack) {
        // Reduce target's health by attacker's strength
        playerToAttack.setHealth(playerToAttack.getHealth() - this.strength);
        // Check if target’s health dropped to 0 or below
        playerToAttack.checkHealth();
    }

    // Check if health is below or equal to zero
    public void checkHealth() {
        if (this.health <= 0) { // If dead
            decrementLive();    // Lose one life and reset health
        }
    }
}
