package com.ironhack.W6D1Lab1;

import java.util.Random;
import java.util.Scanner;

public class SorteoMain {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Creamos instancias de las tiendas, que implementan la misma interfaz
        sorteoClientes papeleria = new Papeleria();
        sorteoClientes tiendaInformatica = new TiendaInformatica();

        // --- Simulacion de la inscripcion de clientes ---
        System.out.println("Inscripcion de clientes para el sorteo.");

        // Cliente 1 en la Papeleria
        System.out.print("Introduce tu nombre para la papeleria: ");
        String nombre1 = teclado.nextLine();
        System.out.print("Introduce tu telefono para la papeleria: ");
        String telefono1 = teclado.nextLine();
        papeleria.inscribirDatos(nombre1, telefono1);

        // Cliente 2 en la Tienda de Informatica
        System.out.print("Introduce tu nombre para la tienda de informatica: ");
        String nombre2 = teclado.nextLine();
        System.out.print("Introduce tu telefono para la tienda de informatica: ");
        String telefono2 = teclado.nextLine();
        tiendaInformatica.inscribirDatos(nombre2, telefono2);

        // --- Anuncio del resultado del sorteo ---
        System.out.println("\n--- Se va a realizar el sorteo... ---");

        // Genera un numero aleatorio entre 1 y 1000
        Random random = new Random();
        int numeroGanador = random.nextInt(1000) + 1;

        // Se comunica el resultado a traves de ambas tiendas,
        // demostrando que se usa la misma logica.
        papeleria.comunicarResultado(numeroGanador);
        tiendaInformatica.comunicarResultado(numeroGanador);

        teclado.close();
    }
}

