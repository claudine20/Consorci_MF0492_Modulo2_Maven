package com.ironhack.W6D3Lab1.establo;


/**
 * Clase Madre abstracta Animal.
 * Contiene atributos 'protected'.
 */
public abstract class Animal {

    // Acceso protected: Accesible dentro de su paquete ('establo') y por cualquier
    // CLASE HIJA (aunque este en otro paquete).
    protected String especieProtected;
    protected double pesoProtected;

    public Animal(String especie, double peso) {
        this.especieProtected = especie;
        this.pesoProtected = peso;
    }
}

