import java.util.Scanner;

/*  Tarea 3
    Letra Faltante
    Descripción
    Elaborar un programa que dado como parámetro un arreglo de letras posicionadas de manera consecutiva regrese 
    cual es la letra que hace falta.

    El arreglo solo puede contener letras Mayúsculas o Minúsculas, la dimensión mínima de dicho arreglo es de 2.

    Por ejemplo:

    letra(['a','b','c','d','f']) = 'e'
    letra(['O','Q','R','S']) = 'P'
    Para el presente ejercicio considere que el alfabeto usado es el Ingles.
 */

public class LetraFaltante {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int nElementos;
        int nLetra;

        while (true) { // Restricción de 2 
            System.out.print("Digite el tamaño del arreglo: ");
            nElementos = leer.nextInt();
            if (nElementos >= 2) {
                break;
            } else {
                System.out.println("\nDigite un número mayor a 2\n");
            }
        }
        
        char letras[] = new char[nElementos];
        int ascii[] = new int[nElementos];

        // Llenado del arreglo
        for (int i = 0; i < letras.length; i++) {
            System.out.print("Digite la letra (" + (i + 1) + "): ");
            letras[i] = leer.next().charAt(0);
        }   

        // Convertir el arreglo a ASCII
        for (int i = 0; i < nElementos; i++) {
            ascii[i] = letras[i];
        }

        // Letra faltante 
        for (int i = 0; i < nElementos - 1; i++) {
            if ((ascii[i] + 1) != ascii[i + 1]) {
                nLetra = ascii[i + 1] - 1;
                System.out.println("\nLa letra que falta es: " + Character.toString((char) nLetra));
            }
        }

        leer.close();
    }
}