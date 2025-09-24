package com.ironhack.W5D1Lab2;

/**
 * Clase que representa un cliente para una discoteca.
 */
public class ClienteDiscoteca {
    // Atributos del cliente
    private String nombre;
    private int edad;

    /**
     * Constructor para inicializar un cliente.
     * @param nombre El nombre del cliente.
     * @param edad La edad del cliente.
     */
    public ClienteDiscoteca(String nombre, int edad) {
        this.nombre = nombre;
        this.setEdad(edad); // Usamos el setter para validar la edad al crear el objeto
    }

    // Metodo getter para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Metodo getter para obtener la edad
    public int getEdad() {
        return edad;
    }

    /**
     * Setter para la edad con una simple validacion.
     * En este caso, solo establece la edad si es mayor o igual a 0.
     * En un contexto real, se podria lanzar una excepcion.
     * @param edad La edad a establecer.
     */
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            this.edad = 0; // O podriamos ignorar el cambio o lanzar una excepcion
            System.out.println("Error: La edad no puede ser negativa.");
        }
    }

    /**
     * Comprueba si el cliente es mayor de edad (18 o mas).
     * @return true si es mayor de edad, false en caso contrario.
     */
    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    /**
     * Devuelve una representacion en cadena del objeto ClienteDiscoteca.
     * @return Una cadena con el nombre y la edad del cliente.
     */
    @Override
    public String toString() {
        return "Cliente: " + nombre + ", Edad: " + edad;
    }
}

