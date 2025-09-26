package com.ironhack.W6D3Lab1.invernadero;

/**
 * Clase Planta dentro del paquete 'invernadero'.
 */
public class Planta {

    // Acceso public
    public String nombrePublico;

    // Acceso private
    private boolean esToxicaPrivada;

    // Acceso default (package-private)
    int stockDefault;

    public Planta(String nombre, boolean esToxica, int stock) {
        this.nombrePublico = nombre;
        this.esToxicaPrivada = esToxica;
        this.stockDefault = stock;
    }

    // Metodo publico para acceder a la propiedad privada
    public boolean getEsToxicaPrivada() {
        return esToxicaPrivada;
    }

    // +EXTRA: Probar a acceder desde Planta a un atributo de la clase Arbol
    public void accederAAtributoDeArbol(Arbol arbol) {
        // Se puede acceder a 'tipoPublico' de Arbol porque es public.
        // Se puede acceder a 'colorHojasDefault' de Arbol porque estan en el mismo paquete.
        System.out.println("  [Desde Planta] Se accede al tipo (public) del arbol: " + arbol.tipoPublico);
        System.out.println("  [Desde Planta] Se accede al color (default) del arbol: " + arbol.colorHojasDefault);
        // NO se puede acceder a arbol.alturaPrivada
    }
}

