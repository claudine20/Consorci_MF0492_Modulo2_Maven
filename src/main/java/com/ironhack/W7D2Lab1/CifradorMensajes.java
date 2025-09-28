package com.ironhack.W7D2Lab1;
import java.util.Scanner;

//Usaremos un cifrado simple (sustitución por índice)
// El metodo elegido es un Cifrado César simple basado en el desplazamiento del índice de las letras,
//  con una "clave traductora" que es el número de desplazamiento (claveDesplazamiento = 5).
//  Este tipo de cifrado es fácil de ver en el debugger (o simplemente observando el resultado) y la lógica es reversible.

public class CifradorMensajes {

    // Clave Traductora: Ambas partes la conocen. Es el numero de desplazamiento.
    private static final int CLAVE_DESPLAZAMIENTO = 5;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("--- Sistema de Codificacion Militar ---");

        // --- CODIFICAR ---
        System.out.print("\n[EMISOR] Introduce el mensaje a enviar (solo letras A-Z): ");
        String mensajeOriginal = teclado.nextLine();

        String mensajeCodificado = codificar(mensajeOriginal);

        System.out.println("\n-------------------------------------");
        System.out.println("MENSAJE CODIFICADO ENVIADO (Ilegible):");
        System.out.println(mensajeCodificado);
        System.out.println("-------------------------------------");

        // --- DESCODIFICAR ---
        System.out.println("\n[RECEPTOR] Recibiendo mensaje codificado...");
        String mensajeDescodificado = descodificar(mensajeCodificado);

        System.out.println("\n-------------------------------------");
        System.out.println("MENSAJE DESCODIFICADO:");
        System.out.println(mensajeDescodificado);
        System.out.println("-------------------------------------");

        teclado.close();
    }

    /**
     * Codifica un mensaje moviendo cada letra un numero fijo de posiciones.
     * @param mensaje El texto plano a codificar.
     * @return El mensaje transformado (en mayusculas).
     */
    public static String codificar(String mensaje) {
        // Aseguramos que el mensaje este en mayusculas para facilitar el trabajo con ASCII
        String mensajeMayus = mensaje.toUpperCase();
        StringBuilder codificado = new StringBuilder();

        for (int i = 0; i < mensajeMayus.length(); i++) {
            char caracter = mensajeMayus.charAt(i);

            if (caracter >= 'A' && caracter <= 'Z') {
                // Formula de cifrado Cesar: (caracter - 'A' + CLAVE) % 26 + 'A'

                // 1. Convertir el caracter a un indice de 0 a 25.
                int indiceLetra = caracter - 'A';

                // 2. Aplicar el desplazamiento y asegurar que se mantenga dentro de 0-25.
                int nuevoIndice = (indiceLetra + CLAVE_DESPLAZAMIENTO) % 26;

                // 3. Convertir el nuevo indice de vuelta a un caracter ASCII.
                char nuevoCaracter = (char) (nuevoIndice + 'A');

                codificado.append(nuevoCaracter);
            } else {
                // Mantenemos espacios y otros caracteres sin cifrar.
                codificado.append(caracter);
            }
        }
        return codificado.toString();
    }

    /**
     * Descodifica un mensaje revirtiendo el proceso de codificacion.
     * @param mensajeCodificado El mensaje cifrado.
     * @return El texto plano original.
     */
    public static String descodificar(String mensajeCodificado) {
        StringBuilder descodificado = new StringBuilder();

        for (int i = 0; i < mensajeCodificado.length(); i++) {
            char caracter = mensajeCodificado.charAt(i);

            if (caracter >= 'A' && caracter <= 'Z') {
                // Formula de descifrado: (caracter - 'A' - CLAVE + 26) % 26 + 'A'

                // 1. Convertir el caracter a un indice de 0 a 25.
                int indiceLetra = caracter - 'A';

                // 2. Revertir el desplazamiento. Se suma 26 para asegurar que el resultado
                // de la resta sea positivo antes de aplicar el modulo.
                int nuevoIndice = (indiceLetra - CLAVE_DESPLAZAMIENTO + 26) % 26;

                // 3. Convertir el nuevo indice de vuelta a un caracter.
                char nuevoCaracter = (char) (nuevoIndice + 'A');

                descodificado.append(nuevoCaracter);
            } else {
                // Mantenemos caracteres que no son letras sin descifrar.
                descodificado.append(caracter);
            }
        }
        return descodificado.toString();
    }
}
