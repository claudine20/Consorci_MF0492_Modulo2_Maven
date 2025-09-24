package com.ironhack.W5D1Lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Constantes para los tipos de IVA
    private static final double IVA_GENERAL = 0.21;
    private static final double IVA_REDUCIDO = 0.10;
    private static final double IVA_SUPER_REDUCIDO = 0.04;
    private static final double IVA_EXENTO = 0.00;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // --- Ejercicio 1: Calculo de IVA ---
        System.out.println("--- Ejercicio 1: Calculo de IVA ---");
        try {
            System.out.print("Introduce el precio del producto: ");
            double precioProducto = teclado.nextDouble();
            System.out.println("Selecciona el tipo de IVA:");
            System.out.println("1 - General (21%)");
            System.out.println("2 - Reducido (10%)");
            System.out.println("3 - Super-reducido (4%)");
            System.out.println("4 - Exento (0%)");
            System.out.print("Opcion: ");
            int tipoIVA = teclado.nextInt();

            // Limpiar el buffer del scanner
            teclado.nextLine();

            double ivaAplicado;
            switch (tipoIVA) {
                case 1:
                    ivaAplicado = IVA_GENERAL;
                    break;
                case 2:
                    ivaAplicado = IVA_REDUCIDO;
                    break;
                case 3:
                    ivaAplicado = IVA_SUPER_REDUCIDO;
                    break;
                case 4:
                    ivaAplicado = IVA_EXENTO;
                    break;
                default:
                    System.out.println("Opcion de IVA invalida. Se aplicara el 21% por defecto.");
                    ivaAplicado = IVA_GENERAL;
            }

            double precioFinal = calcularPrecioFinal(precioProducto, ivaAplicado);
            System.out.printf("El precio final del producto es: %.2f€\n", precioFinal);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada invalida. Por favor, introduce un numero.");
            teclado.nextLine(); // Limpiar el buffer en caso de error
        }

        System.out.println("\nPresiona ENTER para continuar con el siguiente ejercicio...");
        teclado.nextLine();

        // --- Ejercicio 2: Validacion de clientes y ArrayLists ---
        System.out.println("\n--- Ejercicio 2: Clientes de Discoteca ---");
        ejercicioClientesDiscoteca(teclado);

        System.out.println("\nPresiona ENTER para continuar con el siguiente ejercicio...");
        teclado.nextLine();

        // --- Ejercicio 3: Trabajo con cadenas de caracteres ---
        System.out.println("\n--- Ejercicio 3: Capitalizar Frase ---");
        System.out.print("Introduce una frase: ");
        String frase = teclado.nextLine();
        String fraseCapitalizada = capitalizarFrase(frase);
        System.out.println("Frase capitalizada: " + fraseCapitalizada);

        teclado.close();
    }

    /**
     * Calcula el precio final de un producto aplicando un tipo de IVA.
     * @param precioProducto El precio base del producto.
     * @param iva El tipo de IVA a aplicar (como constante).
     * @return El precio final del producto.
     */
    public static double calcularPrecioFinal(double precioProducto, double iva) {
        return precioProducto + (precioProducto * iva);
    }

    /**
     * Bucle para gestionar la entrada de clientes a la discoteca.
     * @param teclado Objeto Scanner para leer la entrada del usuario.
     */
    private static void ejercicioClientesDiscoteca(Scanner teclado) {
        List<ClienteDiscoteca> aceptados = new ArrayList<>();
        List<ClienteDiscoteca> rechazados = new ArrayList<>();

        String nombre;
        while (true) {
            System.out.print("Introduce el nombre del cliente o 'salir' para terminar: ");
            nombre = teclado.nextLine();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Introduce la edad de " + nombre + ": ");
            int edad;
            while (!teclado.hasNextInt()) {
                System.out.println("Edad invalida. Por favor, introduce un numero.");
                System.out.print("Introduce la edad de " + nombre + ": ");
                teclado.nextLine(); // Consumir la entrada incorrecta
            }
            edad = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer

            ClienteDiscoteca cliente = new ClienteDiscoteca(nombre, edad);
            if (cliente.esMayorDeEdad()) {
                aceptados.add(cliente);
                System.out.println(cliente.getNombre() + ", bienvenid@ a nuestra discoteca.");
            } else {
                rechazados.add(cliente);
                System.out.println(cliente.getNombre() + ", lo sentimos, no puedes entrar. Debes ser mayor de 18 anos.");
            }
        }

        System.out.println("\n--- Resumen de Clientes ---");
        System.out.println("Clientes aceptados:");
        if (aceptados.isEmpty()) {
            System.out.println("Ningun cliente aceptado.");
        } else {
            for (ClienteDiscoteca c : aceptados) {
                System.out.println("- " + c);
            }
        }

        System.out.println("\nClientes rechazados:");
        if (rechazados.isEmpty()) {
            System.out.println("Ningun cliente rechazado.");
        } else {
            for (ClienteDiscoteca c : rechazados) {
                System.out.println("- " + c);
            }
        }
    }

    /**
     * Capitaliza la primera letra de cada palabra en una frase.
     * @param frase La frase de entrada.
     * @return La frase con cada palabra capitalizada.
     */
    private static String capitalizarFrase(String frase) {
        if (frase == null || frase.isEmpty()) {
            return "";
        }

        String[] palabras = frase.split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (palabra.length() > 0) {
                // Capitaliza la primera letra y anade el resto de la palabra
                resultado.append(Character.toUpperCase(palabra.charAt(0)))
                        .append(palabra.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        // Elimina el espacio extra al final y retorna la cadena
        return resultado.toString().trim();
    }
}
