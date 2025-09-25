package com.ironhack.W5D2Lab1;

/**
 * Clase que representa un Trastero. Hereda de Inmueble.
 */
public class Trastero extends Inmueble {
    // Atributo final: el coste minimo de la luz por seguridad
    private final double COSTE_SEGURIDAD_FINAL = 5.0;
    // Atributo especifico de Trastero
    private boolean tieneSeguridad;

    /**
     * Constructor con parametros.
     */
    public Trastero(double superficie, double precio, String ubicacion, boolean tieneSeguridad) {
        super(superficie, precio, ubicacion, "Trastero");
        this.tieneSeguridad = tieneSeguridad;
    }

    /**
     * Constructor vacio.
     */
    public Trastero() {
        super();
        this.tipo = "Trastero";
        this.tieneSeguridad = false;
    }

    public void setTieneSeguridad(boolean tieneSeguridad) {
        this.tieneSeguridad = tieneSeguridad;
    }

    /**
     * Implementacion del metodo abstracto para mostrar todos los detalles
     * en una frase completa y descriptiva.
     */
    @Override
    public void mostrarDetallesCompletos() {
        String seguridadTxt = tieneSeguridad ? "con seguridad" : "sin seguridad";
        String costeSeguridadTxt = tieneSeguridad ? " El coste de seguridad es de " + String.format("%.2f", COSTE_SEGURIDAD_FINAL) + "E extra." : "";
        System.out.printf("Es un trastero de %.0fm2 en %s que vale %.2fE %s.%s\n",
                superficie, ubicacion, precio, seguridadTxt, costeSeguridadTxt);
    }
}
