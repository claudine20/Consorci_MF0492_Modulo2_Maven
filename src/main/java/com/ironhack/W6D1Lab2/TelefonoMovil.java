package com.ironhack.W6D1Lab2;

/**
 * Clase que representa un Telefono Movil en la tienda.
 * Utiliza variables y metodos estaticos para aplicar un descuento
 * global a todos los productos.
 */
public class TelefonoMovil {
    private String modelo;
    private double precioBase;

    // Variable estatica: define el descuento a aplicar (0.20 = 20%)
    private static double descuentoBlackFriday = 0.20;

    // Variable estatica de control: indica si el descuento esta activo
    private static boolean blackFridayActivo = true;

    /**
     * Constructor para crear un nuevo telefono.
     * @param modelo Nombre del modelo del telefono.
     * @param precioBase El precio original sin descuento.
     */
    public TelefonoMovil(String modelo, double precioBase) {
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    // Metodos estaticos de control (aplicables a toda la tienda)

    /**
     * EXTRA: Desactiva el Black Friday para todos los productos.
     */
    public static void anularDescuento() {
        blackFridayActivo = false;
        System.out.println("\n*** El Black Friday ha terminado. Descuento anulado para todos los productos. ***\n");
    }

    /**
     * Metodo de instancia: calcula el precio final.
     * Lee la variable estatica 'blackFridayActivo' para saber si aplicar el descuento.
     * @return El precio final con o sin descuento.
     */
    public double getPrecioFinal() {
        if (blackFridayActivo) {
            return precioBase * (1 - descuentoBlackFriday);
        } else {
            return precioBase;
        }
    }

    // Metodos getters
    public String getModelo() {
        return modelo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Muestra la informacion del telefono (antiguo y nuevo precio).
     */
    public void mostrarPrecios() {
        System.out.printf("- %s:\n", modelo);
        System.out.printf("  Precio Base: %.2f€\n", precioBase);

        if (blackFridayActivo) {
            System.out.printf("  Precio Black Friday (20%%): %.2f€\n", getPrecioFinal());
        } else {
            System.out.printf("  Precio Actual: %.2f€\n", getPrecioFinal());
        }
    }
}

