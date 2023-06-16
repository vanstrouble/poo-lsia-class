import java.util.Scanner;

/*
    BigBoss

    Descripción
    BigBoss se encuentra en una misión secretar. Uno de los elementos que se ha encontrado es una puerta con una chapa 
    cuyo código de seguridad cambia cada minuto. Los agentes de apoyo de BigBoss se dieron cuenta de que la contraseña 
    cambia según el número 𝐾 que se muestra en la chapa, dicha contraseña sigue una serie denominada S.

    𝑆(𝐾)=∑𝑛/2𝑖=1𝐵(2𝑖)

    Donde 𝐵(𝑛) es la suma de los dígitos de n en su representación binaria, como por ejemplo:

    n	Binario	𝐵(𝑛)
    1	1	    1
    2	10	    1
    3	11	    2
    4	100	    1
    5	101	    2
    6	110	    2
    1527	10111110111	9

    Elaborar un programa que dado el número 𝐾 actual regrese la contraseña que se debe de ingresar para poder abrir la puerta.

    Datos de Entrada
    K variable de tipo entero

    Ejemplos de Casos de Uso
    Entrada	    Salida

    7             4
            
    10            7

 */
public class bigBoss {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        int numero, digito = 0, suma = 0;

        System.out.print("Digite un número: ");
        numero = leer.nextInt();

        for (int i = 1; i <= numero / 2; i++) {
            digito += 2 * i;
            do {
                suma += digito % 2;
                digito /= 2;
            } while (digito != 0);
        }

        System.out.println(suma);

        leer.close();
    }
}