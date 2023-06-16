package Ejercicio9;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static ArrayList <Poligono> poligono = new ArrayList<>(); // Arreglo dinámico
    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {
        // Llenar un polígono
        llenarPoligono();

        // Mostrar los datos y el área de cada polígono
        mostrarResultados();
    }

    public static void llenarPoligono() {
        byte opcion;
        char respuesta; 

        do {
            do {
                System.out.println("Digite qué polígono desea");
                System.out.println("1. Triángulo");
                System.out.println("2. Rectángulo");
                System.out.print("Opción: ");
                opcion = entry.nextByte();
            } while (opcion < 1 || opcion > 2);
            
            switch (opcion) {
                case 1: // Llenar un triangulo
                    llenarTriangulo();
                    break;
                case 2: // Llenar un rectángulo
                    llenarRectangulo();
                    break;
            }

            System.out.print("\n¿Desea introducir otro polígono? (s/n): ");
            respuesta = entry.next().charAt(0);
            System.out.println();
        } while (respuesta == 's' || respuesta == 'S');
    }

    public static void llenarTriangulo() {
        double lado1, lado2, lado3;

        System.out.print("\nDigite el Lado 1 del Triángulo: ");
        lado1 = entry.nextDouble();
        System.out.print("Digite el Lado 2 del Triángulo: ");
        lado2 = entry.nextDouble();
        System.out.print("Digite el Lado 3 del Triángulo: ");
        lado3 = entry.nextDouble();

        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
        poligono.add(triangulo); // Añadiendo el triángulo al arreglo dinámico
    }

    public static void llenarRectangulo() {
        double lado1, lado2;

        System.out.print("\nDigite el Lado 1 del Rectángulo: ");
        lado1 = entry.nextDouble();
        System.out.print("Digite el Lado 2 del Rectángulo: ");
        lado2 = entry.nextDouble(); 

        Rectangulo rectangulo = new Rectangulo(lado1, lado2);
        poligono.add(rectangulo); // Añadiendo el rectángulo al arreglo dinámico
    }

    public static void mostrarResultados() {
        // Recorriendo el arreglo de polígonos
        for (Poligono poli : poligono) {
            System.out.println(poli.toString());
            System.out.println("Área = " + poli.area());
            System.out.println("Perímetro = " + poli.perimetro());
            System.out.println();
        }
    }
}
