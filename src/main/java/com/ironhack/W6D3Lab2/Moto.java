package com.ironhack.W6D3Lab2;

/**
 * Clase Moto, hereda de Vehiculo.
 */
public class Moto extends Vehiculo {
    // Caracteristica Especifica
    private boolean tieneSidecar;

    public Moto(String marca, String modelo, double precioBase, boolean tieneSidecar) {
        super(marca, modelo, precioBase);
        this.tieneSidecar = tieneSidecar;
    }

    // Metodo Especifico
    public void hacerCaballito() {
        System.out.println(modelo + ": ¡Haciendo un caballito!");
    }

    // Implementacion de los detalles especificos
    @Override
    public String getDetallesEspecificos() {
        return "Moto " + (tieneSidecar ? "con sidecar" : "sin sidecar") + ".";
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Moto, Sidecar: " + (tieneSidecar ? "Si" : "No");
    }
}

