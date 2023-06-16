import java.util.Scanner;

/* Tarea 2
Diferencia de 2
Descripción
Escribir una función que dado como parámetro un arreglo de enteros debe de buscar e imprimir el conjunto 
de pares cuya diferencia entre ellos sea de dos.

La información se debe de imprimir de manera ascendente; se debe de asumir que no hay elementos duplicados 
y que no importa el orden en el que se introduce los elementos.

Por ejemplo:

pares([1, 2, 3, 4]) = 1,3 2,4
pares([4, 1, 2, 3]) = 1,3 2,4
pares([1, 23, 3, 4, 7]) = 1,3
Se debe de introducir el número de elementos que va a tener el arreglo.
 */

public class Diferenciade2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int nElementos, aux;

        System.out.print("Ingrese la cantidad de números: ");
        nElementos = leer.nextInt();

        int numeros[] = new int[nElementos];

        // Llenado del arreglo
        System.out.println("\nLlenado del arreglo");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite el numero (" + (i + 1) + "): ");
            numeros[i] = leer.nextInt();
        }

        // Ordenamiento
        for (int i = 0; i < (numeros.length - 1); i++) {
            for (int j = 0; j < (numeros.length - 1); j++) {
                if (numeros[j] > numeros[j + 1]) {
                    aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                }
            }
        }

        // Pares
        boolean band = false;
        for (int i = 0; i < (numeros.length - 1); i++) {
            for (int j = 0; j < (numeros.length - 1); j++) {
                if (numeros[i] + 2 == numeros[j + 1]) {
                    band = true;
                    if (band == true) {
                        System.out.println(numeros[i] + ", " + numeros[j + 1]);
                        // numeros[i] = 0;
                        // numeros[j + 1] = 0;
                    }
                }
            }
        }

        System.out.println();

        leer.close();
    }
}