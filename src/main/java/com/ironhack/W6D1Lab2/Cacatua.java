package com.ironhack.W6D1Lab2;

/**
 * Clase que demuestra el uso de metodos y variables estaticas (static).
 */
public class Cacatua {
    // Variable de instancia (pertenece a cada objeto)
    private String nombre;

    // Variable estatica (pertenece a la clase)
    // Es una constante que aplica a todas las cacatuas
    public static final int CANTIDAD_MINIMA_CACAHUETES = 100;

    /**
     * Constructor para darle un nombre a la cacatua.
     * @param nombre El nombre de la cacatua.
     */
    public Cacatua(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo estatico: no necesita que se cree un objeto Cacatua para llamarlo.
     * Siempre dice lo mismo, independientemente del nombre del objeto.
     */
    public static String hablar() {
        return "Cacatura cacahuete!";
    }

    /**
     * Metodo de instancia para obtener el nombre.
     */
    public String getNombre() {
        return nombre;
    }
}

