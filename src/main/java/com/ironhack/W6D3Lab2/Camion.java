package com.ironhack.W6D3Lab2;

/**
 * Clase Camion, hereda de Vehiculo.
 */
public class Camion extends Vehiculo {
    // Caracteristica Especifica
    private double capacidadCargaTon;

    public Camion(String marca, String modelo, double precioBase, double capacidadCargaTon) {
        super(marca, modelo, precioBase);
        this.capacidadCargaTon = capacidadCargaTon;
    }

    // Metodo Especifico
    public void cargarMercancia() {
        System.out.println(modelo + ": Cargando " + capacidadCargaTon + " toneladas de mercancia.");
    }

    // Implementacion de los detalles especificos
    @Override
    public String getDetallesEspecificos() {
        return "Camion con capacidad de " + capacidadCargaTon + " toneladas.";
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Camion, Capacidad: " + capacidadCargaTon + "T";
    }
}

