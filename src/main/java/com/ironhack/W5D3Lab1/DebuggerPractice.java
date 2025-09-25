package com.ironhack.W5D3Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DebuggerPractice {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Ejercicio 1: Par o impar? Multiplica!
        ejercicio1_ParOImpar(teclado);

        // Ejercicio 2: Ciudades aleatorias
        ejercicio2_Ciudades();

        // Ejercicio 3: Bar de copas
        ejercicio3_Bar(teclado);

        teclado.close();
    }

    /**
     * Ejercicio 1: Par o impar? Multiplica!
     * Pide al usuario dos numeros y realiza operaciones en un bucle.
     */
    private static void ejercicio1_ParOImpar(Scanner teclado) {
        System.out.println("--- Ejercicio 1: Par o impar? Multiplica! ---");
        System.out.print("Introduce el primer numero: ");
        int numero1 = teclado.nextInt();
        System.out.print("Introduce el segundo numero: ");
        int numero2 = teclado.nextInt();
        teclado.nextLine(); // Consumir el salto de linea

        int contadorPares = 0;
        int contadorImpares = 0;
        List<Integer> resultados = new ArrayList<>();

        for (int i = numero1; i <= numero2; i++) {
            if (i % 2 == 0) {
                // El numero es par
                resultados.add(i * 2);
                contadorPares++;
            } else {
                // El numero es impar
                resultados.add(i * 3);
                contadorImpares++;
            }
        }

        System.out.println("Resultados de la serie:");
        for (int resultado : resultados) {
            System.out.print(resultado + " ");
        }
        System.out.println("\n");
        System.out.println("De la serie inicial, hay " + contadorPares + " numeros pares y " + contadorImpares + " numeros impares.");

        System.out.println("\n------------------------------------------------\n");
    }

    /**
     * Ejercicio 2: Ciudades aleatorias
     * Selecciona e imprime 3 ciudades aleatorias de una lista.
     */
    private static void ejercicio2_Ciudades() {
        System.out.println("--- Ejercicio 2: Ciudades aleatorias ---");

        String[] ciudades = {
                "Madrid", "Barcelona", "Sevilla", "Valencia", "Bilbao",
                "Malaga", "Zaragoza", "Granada", "Salamanca", "Toledo",
                "Palma", "Leon", "Oviedo", "Cadiz", "Murcia",
                "Valladolid", "Cordoba", "Gijon", "Vigo", "Alicante"
        };

        Random random = new Random();

        System.out.println("Se seleccionan 3 ciudades aleatorias:");
        for (int i = 0; i < 3; i++) {
            // Pon un punto de interrupcion aqui y observa como cambian i y el indice aleatorio
            int indiceAleatorio = random.nextInt(ciudades.length);
            System.out.println("- " + ciudades[indiceAleatorio]);
        }

        System.out.println("\n------------------------------------------------\n");
    }

    /**
     * Ejercicio 3: Bar de copas
     * Un bucle condicional que se detiene por multiples razones.
     */
    private static void ejercicio3_Bar(Scanner teclado) {
        System.out.println("--- Ejercicio 3: Bar de copas ---");

        // Estas son las variables de control. Observalas en el depurador.
        boolean musicaSonando = true;
        boolean seguirPreguntando = true;
        String respuesta;
        int mesaActual = 1;

        while (musicaSonando && seguirPreguntando) {
            System.out.print("Mesa " + mesaActual + ": ¿Quieren tomar algo mas? (S/N): ");
            respuesta = teclado.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("El cliente de la mesa " + mesaActual + " pide otra copa. Continúas preguntando a otras mesas.");
                mesaActual++;
            } else if (respuesta.equalsIgnoreCase("n")) {
                System.out.println("El cliente de la mesa " + mesaActual + " dice que no. Dejas de preguntar.");
                // Pon un punto de interrupcion aqui para ver como cambia 'seguirPreguntando'
                seguirPreguntando = false;
            } else {
                System.out.println("Respuesta no valida. Por favor, responde 'S' o 'N'.");
            }

            // Simula el fin de la musica despues de la mesa 5
            if (mesaActual > 5) {
                // Si la musica se detiene, el bucle tambien deberia parar
                musicaSonando = false;
                System.out.println("\nLa musica ha parado.");
            }
        }

        System.out.println("\nSe ha terminado la ronda de preguntas.");
        System.out.println("\n------------------------------------------------\n");
    }
}

