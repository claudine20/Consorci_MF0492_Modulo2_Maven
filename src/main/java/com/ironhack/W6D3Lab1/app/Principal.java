package com.ironhack.W6D3Lab1.app;


// Importamos las clases de los paquetes 'invernadero' y 'establo'
import com.ironhack.W6D3Lab1.establo.AnimalDomestico;
import com.ironhack.W6D3Lab1.establo.AnimalSalvaje;
import com.ironhack.W6D3Lab1.invernadero.Arbol;
import com.ironhack.W6D3Lab1.invernadero.Planta;

// Importamos la clase Establecimiento del directorio principal (no tiene package)
// NOTA: Para que esto funcione, la clase Establecimiento debe estar en el classpath.
import com.ironhack.W6D3Lab1.Establecimiento;


/**
 * Clase principal que prueba el acceso a atributos con diferentes modificadores
 * desde un paquete distinto (app).
 */
public class Principal {

    public static void main(String[] args) {

        // --- 1. INSTANCIA DE CLASE EN DIRECTORIO PRINCIPAL (Establecimiento.java) ---
        // Asume que la clase Establecimiento esta disponible en el classpath.
        // La clase Establecimiento no usa 'package'.
        Establecimiento tienda = new Establecimiento("Libreria Central", "ISBN-978-84-18738", 15.50);

        System.out.println("--- 1. Acceso a Clase en Directorio Principal ---");

        // Acceso PUBLIC: Se accede directamente.
        System.out.println("PUBLIC (Nombre): " + tienda.nombrePublico);

        // Acceso PRIVATE: NO se puede acceder directamente (tienda.codigoPrivado daria error).
        // Se accede mediante un metodo publico (GETTER).
        System.out.println("PRIVATE (Codigo): " + tienda.getCodigoPrivado());

        // Acceso DEFAULT (precio): NO se puede acceder directamente porque Principal.java
        // esta en el paquete 'app' y Establecimiento.java no tiene paquete definido (paquete 'default').
        // Si Principal.java estuviera en el directorio raiz, si funcionaria el acceso default.
        // System.out.println("DEFAULT (Precio): " + tienda.precioDefault); // ESTO DARIA ERROR

        System.out.println("\n-------------------------------------------------\n");


        // --- 2. INSTANCIAS DE PAQUETES (invernadero y establo) ---

        // INVERNADERO (Paquete distinto a 'app')
        Planta planta = new Planta("Orquidea", false, 50);
        Arbol arbol = new Arbol("Roble", 15.2, "Verde Oscuro");

        // ESTABLO (Paquete distinto a 'app')
        AnimalSalvaje leon = new AnimalSalvaje("Panthera Leo", 190.0, "Sabana");
        AnimalDomestico perro = new AnimalDomestico("Canis Lupus Familiaris", 25.5, "Max");

        System.out.println("--- 2. Acceso a Paquetes Remotos ---");

        // Imprimir todos los objetos
        System.out.println("OBJETO ANIMAL SALVAJE: " + leon);
        System.out.println("OBJETO PLANTA: " + planta.nombrePublico);
        System.out.println("OBJETO ARBOL: " + arbol.getInformacionArbol());
        System.out.println("OBJETO ANIMAL DOMESTICO: " + perro);
        System.out.println("\n-------------------------------------------------\n");


        // --- PRUEBA DE ACCESO A MODIFICADORES DESDE EL MAIN (Paquete 'app') ---
        System.out.println("--- PRUEBA DE MODIFICADORES DESDE EL MAIN ('app') ---");

        // Acceso PUBLIC (Planta y Arbol)
        System.out.println("PUBLIC: Nombre de la planta: " + planta.nombrePublico);

        // Acceso PRIVATE (Planta y Arbol): Solo se puede acceder mediante Getter.
        System.out.println("PRIVATE: Es toxica (Planta)? " + planta.getEsToxicaPrivada());

        // Acceso DEFAULT (Planta y Arbol): DARÁ ERROR porque 'app' y 'invernadero' son paquetes distintos.
        // System.out.println("DEFAULT: Stock de planta: " + planta.stockDefault); // ESTO DARIA ERROR

        // Acceso PROTECTED (Animales): DARÁ ERROR porque 'app' no es el paquete 'establo' ni es una CLASE HIJA.
        // System.out.println("PROTECTED: Especie del leon: " + leon.especieProtected); // ESTO DARIA ERROR

        // EXTRA: Comprobamos el acceso default dentro del paquete 'invernadero'
        System.out.println("\n--- EXTRA: Acceso Default dentro de su paquete ---");
        planta.accederAAtributoDeArbol(arbol); // El metodo usa el acceso default internamente


        System.out.println("\n--- Resumen de Acceso ---");
        System.out.println("PUBLIC: Siempre accesible.");
        System.out.println("PRIVATE: Solo accesible con un método publico (Getter).");
        System.out.println("DEFAULT: No accesible. El Main esta en un paquete diferente.");
        System.out.println("PROTECTED: No accesible. El Main no esta en el paquete 'establo' ni es clase hija.");
    }
}
