package com.ironhack.W6D3Lab2;

/**
 * Clase Coche, hereda de Vehiculo.
 */
public class Coche extends Vehiculo {
    // Caracteristica Especifica
    private int numPuertas;

    public Coche(String marca, String modelo, double precioBase, int numPuertas) {
        super(marca, modelo, precioBase);
        this.numPuertas = numPuertas;
    }

    // Metodo Especifico
    public void pitar() {
        System.out.println(modelo + ": ¡Piip! ¡Piip!");
    }

    // Implementacion de los detalles especificos
    @Override
    public String getDetallesEspecificos() {
        return "Coche con " + numPuertas + " puertas.";
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Coche, Puertas: " + numPuertas;
    }
}
