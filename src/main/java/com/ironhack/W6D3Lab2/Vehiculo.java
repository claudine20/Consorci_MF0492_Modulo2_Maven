package com.ironhack.W6D3Lab2;

/**
 * Clase madre abstracta que define las caracteristicas comunes de todos los vehiculos.
 */
public abstract class Vehiculo {
    // Caracteristicas Comunes
    protected String marca;
    protected String modelo;
    protected double precioBase;

    // EXTRA: Variable estatica para el descuento global por fin de temporada
    private static double descuentoGlobal = 0.0;
    private static boolean descuentoActivo = false;

    public Vehiculo(String marca, String modelo, double precioBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    // Metodos getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    // Metodo estatico para activar/desactivar el descuento
    public static void activarDescuento(double descuento) {
        if (descuento >= 0.0 && descuento <= 1.0) {
            descuentoGlobal = descuento;
            descuentoActivo = true;
            System.out.println("\n[GLOBAL] Descuento de fin de temporada activado al " + (descuento * 100) + "%");
        }
    }

    public static void anularDescuento() {
        descuentoGlobal = 0.0;
        descuentoActivo = false;
        System.out.println("[GLOBAL] Descuento de fin de temporada anulado.");
    }

    /**
     * Calcula el precio final aplicando el descuento estatico global si esta activo.
     * @return El precio final con o sin descuento.
     */
    public double getPrecioFinal() {
        if (descuentoActivo) {
            return precioBase * (1.0 - descuentoGlobal);
        }
        return precioBase;
    }

    /**
     * Muestra el precio actual y el precio base (si hay descuento activo).
     */
    public void mostrarPrecios() {
        System.out.printf("- %s %s:\n", marca, modelo);
        System.out.printf("  Precio Base: %.2f€\n", precioBase);

        if (descuentoActivo) {
            System.out.printf("  Precio Final (con %.0f%% desc.): %.2f€\n", (descuentoGlobal * 100), getPrecioFinal());
        } else {
            System.out.printf("  Precio Actual: %.2f€\n", getPrecioFinal());
        }
    }

    // Metodo abstracto para obligar a las clases hijas a implementar sus detalles
    public abstract String getDetallesEspecificos();

    @Override
    public String toString() {
        String precioInfo = String.format("%.2f€", getPrecioFinal());
        if (descuentoActivo) {
            precioInfo += String.format(" (Antes: %.2f€)", precioBase);
        }
        return "Marca: " + marca + ", Modelo: " + modelo + ", Precio Final: " + precioInfo;
    }
}

