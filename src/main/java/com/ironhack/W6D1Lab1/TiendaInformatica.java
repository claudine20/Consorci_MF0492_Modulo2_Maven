package com.ironhack.W6D1Lab1;

/**
 * Clase que representa la tienda de informatica.
 * Implementa la interfaz SorteoClientes para gestionar el sorteo.
 */
public class TiendaInformatica implements sorteoClientes {

    private String nombreTienda = "Tienda de Informatica 'El Bit Feliz'";

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
        System.out.println("¡Mantente atento a tu movil!");
        System.out.println("------------------------------------------");
    }
}

