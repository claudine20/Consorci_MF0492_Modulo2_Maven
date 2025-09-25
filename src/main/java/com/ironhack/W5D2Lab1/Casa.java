package com.ironhack.W5D2Lab1;

/**
 * Clase que representa una Casa. Hereda de Inmueble.
 */
public class Casa extends Inmueble {
    // Atributo especifico de Casa
    private boolean esAdosada;

    /**
     * Constructor con parametros.
     */
    public Casa(double superficie, double precio, String ubicacion, boolean esAdosada) {
        super(superficie, precio, ubicacion, "Casa");
        this.esAdosada = esAdosada;
    }

    /**
     * Constructor vacio.
     */
    public Casa() {
        super();
        this.tipo = "Casa";
        this.esAdosada = false;
    }

    public void setEsAdosada(boolean esAdosada) {
        this.esAdosada = esAdosada;
    }

    /**
     * Implementacion del metodo abstracto para mostrar todos los detalles
     * en una frase completa y descriptiva.
     */
    @Override
    public void mostrarDetallesCompletos() {
        String adosadaTxt = esAdosada ? "esta adosada" : "no esta adosada";
        System.out.printf("Es una casa de %.0fm2 en %s que vale %.2fE y %s.\n",
                superficie, ubicacion, precio, adosadaTxt);
    }
}

