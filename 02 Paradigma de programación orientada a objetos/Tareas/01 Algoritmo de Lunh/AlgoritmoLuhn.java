import java.util.LinkedList;
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
public class AlgoritmoLuhn {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        leer.useDelimiter("\n");
        LinkedList<Integer> numeros = new LinkedList<>();
        int valor, suma = 0;

        // Leyendo números
        while (true) {
            System.out.print("Digite el numero (-1 para terminar): ");
            valor = leer.nextInt();
            if (valor == -1) {
                break;
            }
            numeros.add(valor);
        }

        numeros = invertir(numeros);

        System.out.println(numeros);
        
        for (int i = numeros.size() - 1; i >= 0; i--) {
            if (i % 2 == 0) { // Números impares
                int impar = numeros.get(i) * 2;
                if (impar > 9) {
                    impar -= 9;
                }
                suma += (impar + numeros.get(i));
            } else { // Números pares
                suma += numeros.get(i);
            }
        }

        if (suma % 10 == 0) {
            System.out.println("Válido");
        } else if (suma == 0) {
            System.out.println("Válido");
        } else {
            System.out.println("No válido");
        }

        leer.close();
    }

    // Método para invertir LinkedListe o ArrayList
    public static LinkedList<Integer> invertir(LinkedList<Integer> numeros) {                             
        // Crea una lista para el resultado del método
        LinkedList<Integer> resultado = new LinkedList<>();
        // Recorre la lista de nombres en orden inverso
        for (int i = numeros.size() - 1; i >= 0; i--) {                                                           
             // Añade cada nombre al resultado
              resultado.add(numeros.get(i));
        }
        return resultado;
    }
}