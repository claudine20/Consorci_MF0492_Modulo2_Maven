package com.ironhack.W6D1Lab2;

public class MainApp {
    public static void main(String[] args) {

        // --- EJERCICIO 1: CACATÚA ESTÁTICA ---
        System.out.println("--- Ejercicio 1: La Cacatúa ---");

        // Creamos una instancia de Cacatua (le damos un nombre)
        Cacatua miCacatua = new Cacatua("Coco");

        // Accedemos a los datos:
        // 1. Nombre (variable de instancia)
        String nombre = miCacatua.getNombre();

        // 2. El habla (metodo estatico, se llama directamente desde la clase)
        String habla = Cacatua.hablar();

        // 3. Cantidad minima (variable estatica, se accede desde la clase)
        int cacahuetesMinimos = Cacatua.CANTIDAD_MINIMA_CACAHUETES;

        // Imprimir el resultado
        System.out.println("La cacatua se llama " + nombre + ", dice '" + habla + "' y lo minimo para que se calle son " + cacahuetesMinimos + " cacahuetes.");

        System.out.println("\n------------------------------------------------\n");


        // --- EJERCICIO 2: BLACK FRIDAY CON DESCUENTO ESTÁTICO ---
        System.out.println("--- Ejercicio 2: Black Friday ---");

        // 1. Instanciar moviles para la prueba
        TelefonoMovil movil1 = new TelefonoMovil("Samsung Galaxy X", 800.00);
        TelefonoMovil movil2 = new TelefonoMovil("Xiaomi Red 10", 350.00);
        TelefonoMovil movil3 = new TelefonoMovil("iPhone 15 Pro", 1200.00);

        System.out.println("--- BLACK FRIDAY ACTIVO (20% Descuento) ---");

        // Mostrar precios con descuento
        movil1.mostrarPrecios();
        movil2.mostrarPrecios();
        movil3.mostrarPrecios();

        // 2. EXTRA: Anular el descuento Black Friday
        // Llamamos al metodo estatico para cambiar el estado global de la tienda.
        TelefonoMovil.anularDescuento();

        System.out.println("--- DESCUENTO ANULADO (Precio Base) ---");

        // Mostrar precios SIN descuento (el metodo getPrecioFinal lee la variable estatica actualizada)
        movil1.mostrarPrecios();
        movil2.mostrarPrecios();
        movil3.mostrarPrecios();
    }
}



