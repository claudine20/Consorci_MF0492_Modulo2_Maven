package com.ironhack.W6D2Lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para el Ejercicio 1: Gestion de Camiones.
 * Demuestra el uso de atributos y metodos estaticos (de clase) y no estaticos (de instancia).
 */
class Camion {
    // Variable estatica: Pertenece a la CLASE, todos los camiones comparten el mismo valor.
    public static final int NUM_RUEDAS = 18;

    // Variables de instancia: Pertenece a cada OBJETO Camion
    private String matricula;
    private String estado;
    private double cargaMaxima;

    /**
     * Constructor para inicializar un camion.
     */
    public Camion(String matricula, double cargaMaxima) {
        this.matricula = matricula;
        this.cargaMaxima = cargaMaxima;
        this.estado = "Parado"; // Estado inicial no estatico
    }

    // Metodos estaticos: Aplican a la CLASE Camion, no a un camion especifico.
    // Solo pueden acceder a variables estaticas.
    public static void acelerar() {
        System.out.println("Vehiculo de flota: Acelerando...");
    }

    public static void frenar() {
        System.out.println("Vehiculo de flota: Frenando...");
    }

    // Metodos no estaticos (de instancia): Modifican el estado de un objeto especifico.
    public void cargar(double peso) {
        if (peso > 0 && peso <= cargaMaxima) {
            this.estado = "Cargando " + peso + "kg";
        } else {
            this.estado = "Error de carga";
        }
    }

    /**
     * Muestra el estado completo del camion.
     */
    @Override
    public String toString() {
        return "Camion [Matricula: " + matricula + ", Carga Maxima: " + cargaMaxima + "kg, Estado: " + estado + "]";
    }
}

/**
 * Clase para el Ejercicio 2: Contador de IDs de Clientes.
 * Demuestra la gestion de contadores estaticos y no estaticos.
 */
class Cliente {
    // 3. Contador Estatico para la generacion de IDs
    // Se inicializa solo una vez y se incrementa con cada nuevo objeto.
    private static int siguienteId = 1;

    // 2. Contador Estatico simple (para ejercicio 2)
    public static int contadorLlamadasEstaticas = 0;

    // Variable de instancia: Guarda el ID consecutivo, que no cambia si se borran otros clientes.
    private final int idCliente;
    private String nombre;

    /**
     * Constructor que asigna un ID unico y consecutivo a cada nuevo cliente.
     */
    public Cliente(String nombre) {
        // Asignamos el valor actual del contador estatico a la variable de instancia (final)
        this.idCliente = siguienteId;
        // Incrementamos el contador estatico para el PROXIMO cliente
        siguienteId++;
        this.nombre = nombre;
    }

    // 1. Contador simple SIN static (Ejercicio 1)
    /**
     * Metodo simple que incrementa un contador y lo devuelve.
     * El contador se reinicia con cada nueva instancia (objeto).
     * @param contador La variable a incrementar.
     * @return El contador incrementado.
     */
    public int sumarUno(int contador) {
        return contador + 1;
    }

    // 2. Contador simple CON static (Ejercicio 2)
    /**
     * Metodo estatico que incrementa el contador de clase.
     * Muestra cuantas veces se ha llamado a este metodo en total.
     */
    public static void sumarUnoEstatico() {
        contadorLlamadasEstaticas++;
        System.out.println("El contador estatico ha sido llamado " + contadorLlamadasEstaticas + " veces.");
    }

    public int getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "Cliente ID: " + idCliente + " | Nombre: " + nombre;
    }
}


public class GestionFlotaYClientes {

    public static void main(String[] args) {

        // ===============================================
        // --- EJERCICIO 1: GESTION DE CAMIONES ---
        // ===============================================
        System.out.println("--- EJERCICIO 1: FLOTA DE CAMIONES ---");

        // Creamos 3 camiones (atributos no estaticos)
        Camion camion1 = new Camion("MAT123", 5000.0);
        Camion camion2 = new Camion("MAT456", 7500.0);
        Camion camion3 = new Camion("MAT789", 10000.0);

        // Modificamos el estado no estatico de un camion
        camion2.cargar(6000.0);

        // ¿Cómo se muestra el número de ruedas?
        // Se accede directamente a la variable estatica a traves de la CLASE (Camion.NUM_RUEDAS).
        System.out.println("Todos los camiones de la flota tienen: " + Camion.NUM_RUEDAS + " ruedas.");
        System.out.println("----------------------------------------");

        // Imprimir el estado (atributos no estaticos)
        System.out.println(camion1);
        System.out.println(camion2);
        System.out.println(camion3);
        System.out.println("----------------------------------------");

        // Llamar a los metodos estaticos (aplican a la flota, no a un camion especifico)
        Camion.acelerar();
        Camion.frenar();

        System.out.println("\n================================================\n");

        // ===============================================
        // --- EJERCICIO 2: CONTADOR ID CLIENTES ---
        // ===============================================
        System.out.println("--- EJERCICIO 2: CONTADOR ID CLIENTES ---");

        // ------------------------------------------------
        // 1º - Contador simple SIN static
        // ------------------------------------------------
        System.out.println("\n1º - Contador SIN Static (se reinicia con cada objeto):");
        Cliente cNoStatic = new Cliente("Temporal");
        int contador = 50; // Variable local
        contador = cNoStatic.sumarUno(contador); // cNoStatic.sumarUno(50) -> 51
        System.out.println("Contador despues de llamar una vez: " + contador);

        // ------------------------------------------------
        // 2º - Contador simple CON static
        // ------------------------------------------------
        System.out.println("\n2º - Contador CON Static (suma total de llamadas):");
        Cliente.sumarUnoEstatico(); // Contador = 1
        Cliente.sumarUnoEstatico(); // Contador = 2
        Cliente.sumarUnoEstatico(); // Contador = 3

        // ------------------------------------------------
        // 3º - Generador de ID con static y persistencia
        // ------------------------------------------------
        System.out.println("\n3º - Generador de IDs con Static (persistente):");

        // El ID se asigna en el constructor. El contador 'siguienteId' se incrementa
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Ana"));      // ID 1
        clientes.add(new Cliente("Beto"));     // ID 2
        clientes.add(new Cliente("Carlos"));   // ID 3

        System.out.println("Clientes iniciales:");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Borrar cliente intermedio (Beto)
        System.out.println("\n--- Eliminamos al Cliente 2 (Beto) ---");
        clientes.remove(1); // Borra el cliente en el indice 1 (Beto)

        // Crear nuevos clientes
        clientes.add(new Cliente("Diana"));    // ID 4 (No se ha repetido el ID 2)
        clientes.add(new Cliente("Enrique"));  // ID 5

        System.out.println("Clientes despues de la eliminacion y nuevas altas:");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Observa en el depurador:
        // El atributo estático 'siguienteId' llega a 6,
        // pero los ID asignados (atributo de instancia 'idCliente') a los objetos son 1, 3, 4, 5.
    }
}

