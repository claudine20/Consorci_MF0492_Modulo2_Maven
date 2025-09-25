package com.ironhack.W5D2Lab1;

/**
 * Clase abstracta que sirve como plantilla para diferentes tipos de inmuebles.
 * Contiene los atributos comunes como superficie, precio y ubicacion.
 */
public abstract class Inmueble {
    // Atributos protegidos para que las clases hijas puedan acceder a ellos
    protected double superficie;
    protected double precio;
    protected String ubicacion;
    protected String tipo;

    /**
     * Constructor con todos los parametros.
     */
    public Inmueble(double superficie, double precio, String ubicacion, String tipo) {
        this.superficie = superficie;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }

    /**
     * Constructor vacio.
     */
    public Inmueble() {
        this.superficie = 0.0;
        this.precio = 0.0;
        this.ubicacion = "desconocida";
        this.tipo = "desconocido";
    }

    // Metodos getters y setters
    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    // Metodo para mostrar informacion basica (sobrecarga de metodo)
    public void mostrarInformacionBasica() {
        System.out.println("Tipo: " + this.tipo + " en " + this.ubicacion);
    }

    /**
     * Metodo abstracto que obliga a las clases hijas a implementar
     * su propia version para mostrar todos los detalles.
     */
    public abstract void mostrarDetallesCompletos();
}
