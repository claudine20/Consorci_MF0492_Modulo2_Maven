package com.ironhack.W5D2Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionInmobiliaria {

    private static List<Inmueble> inventario = new ArrayList<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        // Instanciar al menos dos de cada tipo usando ambos constructores
        // Casa
        Casa casa1 = new Casa(250.0, 450000.0, "Sta. Coloma", true);
        inventario.add(casa1);

        Casa casa2 = new Casa();
        casa2.setSuperficie(180.0);
        casa2.setPrecio(320000.0);
        casa2.setUbicacion("Badalona");
        casa2.setEsAdosada(false);
        inventario.add(casa2);

        // Piso
        Piso piso1 = new Piso(90.0, 250000.0, "Barcelona", 5, true);
        inventario.add(piso1);

        Piso piso2 = new Piso();
        piso2.setSuperficie(75.0);
        piso2.setPrecio(180000.0);
        piso2.setUbicacion("L'Hospitalet");
        piso2.setPlanta(2);
        piso2.setTieneAscensor(false);
        inventario.add(piso2);

        // Trastero
        Trastero trastero1 = new Trastero(15.0, 15000.0, "Barcelona", true);
        inventario.add(trastero1);

        Trastero trastero2 = new Trastero();
        trastero2.setSuperficie(8.0);
        trastero2.setPrecio(8000.0);
        trastero2.setUbicacion("Sant Boi");
        trastero2.setTieneSeguridad(false);
        inventario.add(trastero2);

        // Menu interactivo para el usuario
        int opcion;
        do {
            System.out.println("\n--- GESTION INMOBILIARIA ---");
            System.out.println("1. Mostrar todos los inmuebles");
            System.out.println("2. Mostrar inmuebles por tipo y ubicacion");
            System.out.println("3. Anadir un nuevo inmueble");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!teclado.hasNextInt()) {
                System.out.println("Entrada invalida. Por favor, ingrese un numero.");
                teclado.next(); // Consume la entrada incorrecta
                System.out.print("Seleccione una opcion: ");
            }
            opcion = teclado.nextInt();
            teclado.nextLine(); // Consumir el salto de linea

            switch (opcion) {
                case 1:
                    mostrarTodosLosInmuebles();
                    break;
                case 2:
                    mostrarInformacionBasica();
                    break;
                case 3:
                    anadirNuevoInmueble();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta la proxima!");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 0);

        teclado.close();
    }

    /**
     * Metodo para mostrar todos los inmuebles con sus detalles completos.
     */
    private static void mostrarTodosLosInmuebles() {
        System.out.println("\n--- INMUEBLES EN INVENTARIO ---");
        if (inventario.isEmpty()) {
            System.out.println("No hay inmuebles en el inventario.");
            return;
        }
        for (Inmueble inmueble : inventario) {
            inmueble.mostrarDetallesCompletos();
            System.out.println("-----------------------------------");
        }
    }

    /**
     * Metodo sobrecargado para mostrar solo el tipo y la ubicacion de los inmuebles.
     */
    private static void mostrarInformacionBasica() {
        System.out.println("\n--- INFORMACION BASICA DE INMUEBLES ---");
        for (Inmueble inmueble : inventario) {
            inmueble.mostrarInformacionBasica();
        }
    }

    /**
     * Permite al usuario anadir un nuevo inmueble desde la consola.
     */
    private static void anadirNuevoInmueble() {
        System.out.println("\n--- ANADIR NUEVO INMUEBLE ---");
        System.out.print("Que tipo de inmueble desea anadir? (Casa, Piso, Trastero): ");
        String tipo = teclado.nextLine();

        System.out.print("Superficie (m2): ");
        double superficie = teclado.nextDouble();

        System.out.print("Precio (E): ");
        double precio = teclado.nextDouble();
        teclado.nextLine(); // Consumir el salto de linea

        System.out.print("Ubicacion: ");
        String ubicacion = teclado.nextLine();

        switch (tipo.toLowerCase()) {
            case "casa":
                System.out.print("Es adosada? (si/no): ");
                boolean esAdosada = teclado.nextLine().equalsIgnoreCase("si");
                inventario.add(new Casa(superficie, precio, ubicacion, esAdosada));
                System.out.println("Casa anadida con exito.");
                break;
            case "piso":
                System.out.print("En que planta esta?: ");
                int planta = teclado.nextInt();
                System.out.print("Tiene ascensor? (si/no): ");
                teclado.nextLine(); // Consumir el salto de linea
                boolean tieneAscensor = teclado.nextLine().equalsIgnoreCase("si");
                inventario.add(new Piso(superficie, precio, ubicacion, planta, tieneAscensor));
                System.out.println("Piso anadido con exito.");
                break;
            case "trastero":
                System.out.print("Tiene seguridad? (si/no): ");
                boolean tieneSeguridad = teclado.nextLine().equalsIgnoreCase("si");
                inventario.add(new Trastero(superficie, precio, ubicacion, tieneSeguridad));
                System.out.println("Trastero anadido con exito.");
                break;
            default:
                System.out.println("Tipo de inmueble no reconocido. No se ha anadido nada.");
        }
    }
}
