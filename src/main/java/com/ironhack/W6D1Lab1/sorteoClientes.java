package com.ironhack.W6D1Lab1;

/**
 * Interfaz que define los metodos para la gestion de clientes en un sorteo.
 * Cualquier tienda que implemente esta interfaz podra inscribir datos
 * y comunicar el resultado de un sorteo.
 */
public interface sorteoClientes {

    /**
     * Metodo para registrar los datos de un cliente en el sorteo.
     * @param nombre El nombre del cliente.
     * @param telefono El numero de telefono del cliente.
     */
    void inscribirDatos(String nombre, String telefono);

    /**
     * Metodo para comunicar el resultado del sorteo.
     * @param numeroGanador El numero que ha salido ganador.
     */
    void comunicarResultado(int numeroGanador);
}
