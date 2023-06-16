import java.util.Scanner;

/* Algoritmo de Luhn
 El Algoritmo de Luhn es una formula que es utilizada para validad diversos números de identificación, 
 como números de Tarjetas de Crédito. El algoritmo consiste recorrer todos los elementos en orden inverso y 
 para cada uno de los dígitos que se encuentré ubicado en la posición impar de los elementos se debe de 
 duplicar y si dicho valor es mayor que 9 se pueden sumar los dígitos que lo componen o se le puede restar 
 9 al producto. Se deben de sumar todos los números y si el módulo 10 de dicha suma es 0, o inclusive si 
 el resultado de la suma es 0, entonces se dice que es un número valido.

Escribir un programa que dado como entrada una serie de números diga si es valido o no.

Por ejemplo:

[1,2,3] = No Valido // [3, 4, 1] porque se toman en orden inverso y la suma es 8
[2,1,2,1] = Valido // [1, 4, 1, 4] porque se toman en orden inverso y la suma es 10

 */
public class AlgoritmoLuhn_alternativa {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int cantidad, suma = 0;

        System.out.println("\t.:ALGORITMO DE LUHN:.\n");
        System.out.print("Digite la cantidad de números a ingresar: ");
        cantidad = leer.nextInt();

        int numeros[] = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Digite el número[" + (i + 1) + "]: ");
            numeros[i] = leer.nextInt();
        }

        int[] invertido = new int[numeros.length];
        for(int i = 0; i < numeros.length; i++){
            invertido[i] = numeros[numeros.length-1-i];
            System.out.println("num: " + invertido [i]);
        }
        numeros = invertido;

        for (int i = cantidad - 1; i >= 0; i--) {
            if (i % 2 == 0) {  
                suma += numeros[i];
            } else {
                System.out.print("\nImpar " + numeros[i]);
                numeros[i] *= 2;
                if (numeros[i] > 9) {
                    numeros[i] -= 9;
                }
                suma += numeros[i];
            }
        }

        if (suma % 10 == 0) {
            System.out.println("Número válido");
        } else if (suma == 0) {
            System.out.println("Número válido");
        } else {
            System.out.println("No valido");
        }

        leer.close();
    }
}