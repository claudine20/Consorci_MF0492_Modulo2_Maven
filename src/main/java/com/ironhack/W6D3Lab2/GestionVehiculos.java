package com.ironhack.W6D3Lab2;

import java.util.ArrayList;
import java.util.List;

public class GestionVehiculos {

    public static void main(String[] args) {

        // --- 1. CREACION DE ARRAYLISTS SEPARADOS ---

        List<Coche> listaCoches = new ArrayList<>();
        listaCoches.add(new Coche("Ford", "Focus", 25000.0, 5));
        listaCoches.add(new Coche("Tesla", "Model 3", 45000.0, 4));
        listaCoches.add(new Coche("Seat", "Ibiza", 18000.0, 3));

        List<Moto> listaMotos = new ArrayList<>();
        listaMotos.add(new Moto("Honda", "CBR600RR", 12000.0, false));
        listaMotos.add(new Moto("Ural", "Sidecar Retro", 8500.0, true));

        List<Camion> listaCamiones = new ArrayList<>();
        listaCamiones.add(new Camion("Volvo", "FH16", 150000.0, 40.0));
        listaCamiones.add(new Camion("Mercedes", "Actros", 180000.0, 60.0));

        // --- EXTRA: Descuento Global Activo (20%) ---
        Vehiculo.activarDescuento(0.20);

        // --- 2. MOSTRAR INVENTARIO CON DESCUENTO ---
        System.out.println("\n--- INVENTARIO CON DESCUENTO ACTIVO ---\n");
        imprimirLista(listaCoches, "Coches");
        imprimirLista(listaMotos, "Motos");
        imprimirLista(listaCamiones, "Camiones");

        // --- 3. ENCONTRAR UN MODELO ESPECÍFICO ---
        System.out.println("\n--- BUSQUEDA DE MODELO ('Focus') ---");
        Coche focus = buscarCochePorModelo(listaCoches, "Focus");
        if (focus != null) {
            System.out.println("¡Coche encontrado! " + focus);
            focus.pitar(); // Llamada a metodo especifico
        } else {
            System.out.println("Modelo no encontrado.");
        }

        // --- 4. GUARDAR TODAS LAS MARCAS ---
        System.out.println("\n--- LISTA DE TODAS LAS MARCAS DISPONIBLES ---");
        List<String> todasLasMarcas = obtenerTodasLasMarcas(listaCoches, listaMotos, listaCamiones);
        System.out.println(todasLasMarcas);

        // --- 5. ARRAYLIST MIXTO ---
        System.out.println("\n--- ARRAYLIST MIXTO (Tipo Vehiculo) ---");
        List<Vehiculo> listaMixta = new ArrayList<>();
        listaMixta.addAll(listaCoches);
        listaMixta.addAll(listaMotos);
        listaMixta.addAll(listaCamiones);

        System.out.println("Vehiculos en la lista mixta:");
        for (Vehiculo v : listaMixta) {
            // Se muestra el toString() de la clase hija gracias al polimorfismo
            System.out.println("- " + v + " | Detalles: " + v.getDetallesEspecificos());
        }

        // --- EXTRA: Anular el descuento global ---
        Vehiculo.anularDescuento();

        System.out.println("\n--- PRECIOS DESPUES DE ANULAR EL DESCUENTO ---");
        listaCoches.get(0).mostrarPrecios();
    }

    // =========================================================================
    // --- METODOS DE UTILIDAD ---
    // =========================================================================

    /**
     * Metodo para imprimir una lista de vehiculos.
     */
    private static <T extends Vehiculo> void imprimirLista(List<T> lista, String titulo) {
        System.out.println("--- Lista de " + titulo + " ---");
        for (T vehiculo : lista) {
            System.out.println(vehiculo);
        }
        System.out.println();
    }

    /**
     * Metodo para buscar un Coche por su modelo.
     */
    public static Coche buscarCochePorModelo(List<Coche> lista, String modeloBuscado) {
        for (Coche coche : lista) {
            if (coche.getModelo().equalsIgnoreCase(modeloBuscado)) {
                return coche;
            }
        }
        return null; // Si no se encuentra
    }

    /**
     * Metodo para obtener una lista de todas las marcas de todos los vehiculos.
     */
    @SafeVarargs
    public static List<String> obtenerTodasLasMarcas(List<? extends Vehiculo>... listas) {
        List<String> marcas = new ArrayList<>();
        for (List<? extends Vehiculo> lista : listas) {
            for (Vehiculo vehiculo : lista) {
                marcas.add(vehiculo.getMarca());
            }
        }
        return marcas;
    }
}
