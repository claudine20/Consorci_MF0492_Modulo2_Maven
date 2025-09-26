package com.ironhack.W6D3Lab1;

/**
 * Clase para demostrar los modificadores de acceso en el mismo directorio principal.
 */
public class Establecimiento {

    // Acceso public: Se puede acceder desde cualquier lugar.
    public String nombrePublico;

    // Acceso private: Solo se puede acceder DENTRO de esta clase.
    private String codigoPrivado;

    // Acceso default (package-private): Se puede acceder solo dentro del mismo PAQUETE
    // (o en este caso, dentro del mismo directorio, ya que no tiene 'package' definido).
    double precioDefault;

    // Constructor
    public Establecimiento(String nombre, String codigo, double precio) {
        this.nombrePublico = nombre;
        this.codigoPrivado = codigo;
        this.precioDefault = precio;
    }

    // Metodo publico para acceder a la propiedad privada.
    public String getCodigoPrivado() {
        return codigoPrivado;
    }
}
