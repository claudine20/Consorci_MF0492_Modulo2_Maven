package com.ironhack.W6D3Lab1.invernadero;


/**
 * Clase Arbol dentro del paquete 'invernadero'.
 */
public class Arbol {

    // Acceso public: Accesible desde cualquier clase/paquete.
    public String tipoPublico;

    // Acceso private: Solo accesible DENTRO de esta clase.
    private double alturaPrivada;

    // Acceso default (package-private): Accesible solo dentro de 'invernadero'.
    String colorHojasDefault;

    public Arbol(String tipo, double altura, String colorHojas) {
        this.tipoPublico = tipo;
        this.alturaPrivada = altura;
        this.colorHojasDefault = colorHojas;
    }

    // Metodo publico para acceder a la propiedad privada
    public double getAlturaPrivada() {
        return alturaPrivada;
    }

    // EXTRA: Acceder desde Planta a un atributo public de Arbol
    public String getInformacionArbol() {
        return "Arbol de tipo: " + tipoPublico;
    }
}
