package com.ironhack.W6D1Lab1;

/**
 * Clase que representa la tienda de papeleria.
 * Implementa la interfaz SorteoClientes para gestionar el sorteo.
 */
public class Papeleria implements sorteoClientes {

    private String nombreTienda = "Papeleria 'El Lapicero'";

    /**
     * Implementacion del metodo para inscribir datos.
     */
    @Override
    public void inscribirDatos(String nombre, String telefono) {
        System.out.println("--- Inscripcion en la " + nombreTienda + " ---");
        System.out.println("Cliente: " + nombre + ", Telefono: " + telefono);
        System.out.println("¡Datos inscritos con exito para el sorteo!");
        System.out.println("------------------------------------------");
    }

    /**
     * Implementacion del metodo para comunicar el resultado.
     */
    @Override
    public void comunicarResultado(int numeroGanador) {
        System.out.println("--- Sorteo en la " + nombreTienda + " ---");
        System.out.println("El numero ganador es el " + numeroGanador + ".");
        System.out.println("¡Mucha suerte a todos los participantes!");
        System.out.println("------------------------------------------");
    }
}
