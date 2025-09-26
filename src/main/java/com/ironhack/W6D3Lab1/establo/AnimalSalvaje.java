package com.ironhack.W6D3Lab1.establo;


/**
 * Clase hija AnimalSalvaje. Hereda de Animal.
 */
public class AnimalSalvaje extends Animal {

    // Atributo especifico public
    public String habitad;

    public AnimalSalvaje(String especie, double peso, String habitad) {
        super(especie, peso);
        this.habitad = habitad;
    }

    // El toString() accede a los atributos protected (especieProtected, pesoProtected)
    // porque es una CLASE HIJA.
    @Override
    public String toString() {
        return "Animal Salvaje [Especie: " + especieProtected + ", Peso: " + pesoProtected + " kg, Habitad: " + habitad + "]";
    }
}
