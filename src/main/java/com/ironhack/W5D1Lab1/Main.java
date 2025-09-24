package com.ironhack.W5D1Lab1;

public class Main {

    // Helper method to print player status in a cleaner way
    public static void printStatus(String name, Player p) {
        System.out.println(name + " -> Health: " + p.getHealth() + ", Lives: " + p.getLives());
    }

    public static void main(String[] args) {
        // -------------------------------
        // DEMO 1: Odd numbers generator
        // -------------------------------
        System.out.println("=== Odd Numbers Demo ===");
        int[] odds = OddNumbers.getOddNumbers(10); // Get odd numbers from 1 to 10
        for (int n : odds) {
            System.out.print(n + " "); // Expected output: 1 3 5 7 9
        }
        System.out.println("\n");

        // -------------------------------
        // DEMO 2: Java keyword checker
        // -------------------------------
        System.out.println("=== Keyword Checker Demo ===");
        String text1 = "Don't break my heart";
        String text2 = "I love to breakdance";
        System.out.println("\"" + text1 + "\" contains keyword? " + JavaKeywordChecker.containsKeyword(text1));
        // Expected: true (because "break" is a keyword)
        System.out.println("\"" + text2 + "\" contains keyword? " + JavaKeywordChecker.containsKeyword(text2));
        // Expected: false (because "breakdance" is not a keyword)
        System.out.println();

        // -------------------------------
        // DEMO 3: Player classes in action
        // -------------------------------
        System.out.println("=== Player Battle Demo ===");

        // Create a Warrior (health=100, strength=20, lives=2, force=15)
        Warrior warrior = new Warrior(100, 20, 2, 15);
        // Create a Wizard (health=80, strength=15, lives=2, spell="Fireball")
        Wizard wizard = new Wizard(80, 15, 2, "Fireball");

        // Print initial states
        System.out.println("Warrior -> Health: " + warrior.getHealth() + ", Lives: " + warrior.getLives());
        System.out.println("Wizard  -> Health: " + wizard.getHealth() + ", Lives: " + wizard.getLives());

        // Round 1: Warrior attacks Wizard
        warrior.attack(wizard);
        System.out.println("Warrior attacks Wizard!");
        System.out.println("Wizard health now: " + wizard.getHealth()); // Expected: 80 - 20 = 60

        // Round 2: Wizard attacks Warrior
        wizard.attack(warrior);
        System.out.println("Wizard casts Fireball at Warrior!");
        System.out.println("Warrior health now: " + warrior.getHealth()); // Expected: 100 - 15 = 85

        // Keep attacking until someone dies
        System.out.println("\n--- Battle Continues ---");
        while (warrior.getLives() > 0 && wizard.getLives() > 0) {
            // Warrior attacks
            warrior.attack(wizard);
            System.out.println("Warrior attacks Wizard -> Wizard health: " + wizard.getHealth() + ", lives: " + wizard.getLives());

            // Check if Wizard survived
            if (wizard.getLives() <= 0) break;

            // Wizard attacks
            wizard.attack(warrior);
            System.out.println("Wizard attacks Warrior -> Warrior health: " + warrior.getHealth() + ", lives: " + warrior.getLives());
        }

        // Print final result
        System.out.println("\n=== Battle Result ===");
        if (warrior.getLives() <= 0) {
            System.out.println("Warrior is dead. Wizard wins!");
        } else if (wizard.getLives() <= 0) {
            System.out.println("Wizard is dead. Warrior wins!");
        }

        // -------------------------------
        // DEMO 4: Conversions
        // -------------------------------
        System.out.println("\n=== Conversion Demo ===");
        Elf elfFromWarrior = warrior.convertToElf(); // Warrior → Elf
        Elf elfFromWizard = wizard.convertToElf();   // Wizard → Elf
        System.out.println("Elf from Warrior -> Health: " + elfFromWarrior.getHealth() +
                ", Strength: " + elfFromWarrior.getStrength() +
                ", Lives: " + elfFromWarrior.getLives() +
                ", Speed: " + elfFromWarrior.getSpeed());
        System.out.println("Elf from Wizard -> Health: " + elfFromWizard.getHealth() +
                ", Strength: " + elfFromWizard.getStrength() +
                ", Lives: " + elfFromWizard.getLives() +
                ", Speed: " + elfFromWizard.getSpeed()); // Expected speed=0
    }
}
