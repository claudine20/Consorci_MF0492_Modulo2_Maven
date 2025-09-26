package com.ironhack.W6D3Lab1.establo;

/**
 * Clase hija AnimalDomestico. Hereda de Animal.
 */
public class AnimalDomestico extends Animal {

    // Atributo especifico public
    public String nombre;

    public AnimalDomestico(String especie, double peso, String nombre) {
        super(especie, peso);
        this.nombre = nombre;
    }

    // El toString() accede a los atributos protected (especieProtected, pesoProtected)
    // porque es una CLASE HIJA.
    @Override
    public String toString() {
        return "Animal Domestico [Nombre: " + nombre + ", Especie: " + especieProtected + ", Peso: " + pesoProtected + " kg]";
    }
}
