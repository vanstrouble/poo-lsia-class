// import java.util.Arrays;
import java.util.Scanner;

/* Tarea 4
    Andrés Manuel el buscador de petróleo
    Descripción
    Andrés Manuel es un Ingeniero Petrolero que desea conocer en qué punto del Golfo de México debe de colocar una 
    plataforma con la finalidad de extraer la mayor cantidad de petróleo que se hubica en esa zona. El Golfo de México 
    se puede representar como una Matriz bidimensional de MxN, el cual tiene una cantidad determinada de petróleo en cada 
    una de las posiciones, la plataforma que Andrés Manuel puede poner como una Matriz bidimensional de OxP la cual se puede 
    poner de manera horizontal (tamaño OxP) o de manera vertical (tamaño PxO).

    Elaborar un programa que permita determina en que coordenadas Andrés Manuel debe de colocar su plataforma con la finalidad 
    de que pueda extraer la mayor cantidad de petróleo, además se debe de mostrar la cantidad de petróleo que se puede obtener 
    en dichas coordenadas y la posición en la que debe de lanzar la Red (I si es lo mismo lanzarla en Verticial u Horizontal, 
    V vertical o H horizontal).

    Datos de Entrada
    M, N, O, P variable de tipo entero
    G_i variable de entero con la información de la cantidad de petróleo en cada posición.

    Ejemplos:
    10,10,5,3
    7,0,0,7,8,8,7,0,8,6
    7,7,9,2,8,8,4,5,0,5
    0,5,2,2,6,3,9,9,6,7
    6,1,8,7,4,0,1,5,7,7
    2,5,6,0,2,9,6,1,9,4
    6,1,8,1,9,7,7,6,9,6
    1,3,1,6,5,0,5,9,8,0
    3,8,8,4,4,3,4,6,2,4
    8,9,3,5,8,9,9,6,4,3
    9,1,1,3,4,7,2,9,5,3

    (2, 6)
    97
    H


    5,5,2,2
    1,2,5,4,1
    7,1,0,6,5
    6,1,5,6,4
    7,6,4,3,5
    8,8,6,5,7

    (3, 0)
    29
    I
 */

public class Amlo {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        // leer.useDelimiter("\n");
        int m, n, o, p;

        String valores[] = leer.next().split(",");
        m = Integer.valueOf(valores[0]);
        n = Integer.valueOf(valores[1]);
        o = Integer.valueOf(valores[2]);
        p = Integer.valueOf(valores[3]);

        int lago[][] = new int[m][n];

        for (int i = 0; i < lago.length; i++) {
            String linea[] = leer.next().split(",");
            for (int j = 0; j < linea.length; j++) {
                lago[i][j] = Integer.valueOf(linea[j]);
            }
        }

        int[] valoresV = sumarValores(lago, m, n, o, p);
        int aux = o;
        o = p;
        p = aux;
        int[] valoresH = sumarValores(lago, m, n, o, p);

        if (valoresV[0] == valoresH[0] && valoresV[1] == valoresH[1] && valoresV[2] == valoresH[2]) {
            System.out.printf("(%d, %d)\n%d\n%c\n", valoresV[1], valoresV[2], valoresH[0], 'I');
        } else if (valoresV[0] >= valoresH[0]) {
            System.out.printf("(%d, %d)\n%d\n%c\n", valoresV[1], valoresV[2], valoresV[0], 'V');
        } else {
            System.out.printf("(%d, %d)\n%d\n%c\n", valoresH[1], valoresH[2], valoresH[0], 'H');
        }

        leer.close();
    }

    public static int[] sumarValores(int[][] lago, int m, int n, int o, int p) {
        int suma = 0, total = 0, x = 0, y = 0;

        for (int i = 0; i < m - o + 1; i++) {
            for (int j = 0; j < n - p + 1; j++) {
                for (int k = i; k < o + i; k++) {
                    for (int l = j; l < p + j; l++) {
                        suma += lago[k][l];
                    }
                }
                if (suma > total) {
                    total = suma;
                    x = i;
                    y = j;
                }
                suma = 0;
            }
        }
        int[] valores = {total, x, y};
        return valores;
    }
}