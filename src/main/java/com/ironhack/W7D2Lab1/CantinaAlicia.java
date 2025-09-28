package com.ironhack.W7D2Lab1;

import java.util.Random;
import java.util.Scanner;

public class CantinaAlicia {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        System.out.println("--- Alicia y la Cantina Misteriosa ---");

        // =======================================================
        // 1. ENTRADA A LA CANTINA
        // =======================================================
        System.out.println("\n[GUARDA] ¡Alto ahi! ¿Eres Alicia?");
        System.out.print("Tu respuesta (S/N): ");
        String respuestaNombre = teclado.nextLine();

        if (!respuestaNombre.equalsIgnoreCase("S")) {
            System.out.println("\n[GUARDA] Respuesta incorrecta. ¡Largo de aqui!");
            teclado.close();
            return; // El programa termina si no es Alicia
        }

        System.out.println("\n[GUARDA] Adelante, Alicia. ¡Bienvenida!");

        // =======================================================
        // 2. PEDIDO INICIAL Y CONDICION DE CAMBIO
        // =======================================================

        // Variables de control
        String pedidoDeAlicia = "Birra sin alcohol";
        boolean cambioDePedido = false;
        final int HORA_CORRECTA = 20;

        System.out.println("\n[ALICIA] Pedido inicial: " + pedidoDeAlicia);
        System.out.println("Alicia tiene una condicion: si hay un evento magico, pedira birra CON alcohol.");

        // Condicion: Tres intentos o menos para que ocurra la magia
        for (int intento = 1; intento <= 3; intento++) {
            if (cambioDePedido) break; // Si ya se ha cumplido la condicion, salimos del bucle.

            System.out.println("\n--- Intento de condicion #" + intento + " ---");

            // Simular si el Barman baila (50% de probabilidad)
            boolean barmanBaila = random.nextBoolean();

            // Simular la hora que dice el conejo (entre 18h y 22h)
            int horaConejo = random.nextInt(5) + 18; // Genera 18, 19, 20, 21, 22
            boolean conejoDiceHoraCorrecta = (horaConejo == HORA_CORRECTA);

            System.out.println("  [Barman] ¿Baila?: " + (barmanBaila ? "Si" : "No"));
            System.out.println("  [Conejo] Dice que son las " + horaConejo + "h.");

            if (barmanBaila || conejoDiceHoraCorrecta) {
                System.out.println("  ¡MAGIA! La condicion se ha cumplido.");
                pedidoDeAlicia = "Birra CON alcohol";
                cambioDePedido = true;
            } else {
                System.out.println("  Aun no hay magia...");
            }
        }

        // =======================================================
        // 3. INTERACCION CON EL BARMAN Y RESULTADO FINAL
        // =======================================================
        System.out.println("\n[ALICIA] ¡Quiero una " + pedidoDeAlicia + "!");
        System.out.print("[BARMAN] ¿Que desea tomar?: ");
        String pedidoBarman = teclado.nextLine();

        if (pedidoBarman.toLowerCase().contains("birra")) {
            // Si el pedido contiene "birra", se lo sirve.
            System.out.println("\n[BARMAN] Entendido. Servido queda: " + pedidoDeAlicia);
        } else {
            // Si no es birra, la echa.
            System.out.println("\n[BARMAN] Solo servimos birras. ¡Fuera de mi cantina!");
        }

        teclado.close();
    }
}
