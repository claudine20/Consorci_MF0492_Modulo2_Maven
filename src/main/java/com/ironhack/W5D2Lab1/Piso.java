package com.ironhack.W5D2Lab1;

/**
 * Clase que representa un Piso. Hereda de Inmueble.
 */
public class Piso extends Inmueble {
    // Atributos especificos de Piso
    private int planta;
    private boolean tieneAscensor;

    /**
     * Constructor con parametros.
     */
    public Piso(double superficie, double precio, String ubicacion, int planta, boolean tieneAscensor) {
        super(superficie, precio, ubicacion, "Piso");
        this.planta = planta;
        this.tieneAscensor = tieneAscensor;
    }

    /**
     * Constructor vacio.
     */
    public Piso() {
        super();
        this.tipo = "Piso";
        this.planta = 0;
        this.tieneAscensor = false;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public void setTieneAscensor(boolean tieneAscensor) {
        this.tieneAscensor = tieneAscensor;
    }

    /**
     * Implementacion del metodo abstracto para mostrar todos los detalles
     * en una frase completa y descriptiva.
     */
    @Override
    public void mostrarDetallesCompletos() {
        String ascensorTxt = tieneAscensor ? "tiene ascensor" : "no tiene ascensor";
        System.out.printf("Es un piso de %.0fm2 en %s que vale %.2fE. Esta en la planta %d y %s.\n",
                superficie, ubicacion, precio, planta, ascensorTxt);
    }
}

