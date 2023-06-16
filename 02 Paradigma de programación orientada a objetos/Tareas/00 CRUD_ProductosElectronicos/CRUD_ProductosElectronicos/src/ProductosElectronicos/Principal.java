package ProductosElectronicos;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    static ArrayList <Electronico> electronicos = new ArrayList<>();
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        byte opcion;

        do {
            System.out.println("\t.:MENU:.\n");
            System.out.println("1. Crear producto electrónico");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Modificar productos");
            System.out.println("4. Borrar productos");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextByte();

            switch (opcion) {
                case 1:
                    System.out.println();
                    crear();
                    break;
                case 2:
                    System.out.println();
                    mostrar();
                    break;
                case 3: 
                    System.out.println();
                    modificar();
                    break;
                case 4:
                    System.out.println();
                    eliminar();
                    break;
                case 5:
                    break;

                default:
                    System.out.println("Error. Digite una opción válida");
                    break;
            }

        } while (opcion != 5);
    }

    public static void crear() {
        byte opcion;

        System.out.println("¿Qué desea crear?");
        System.out.println("1. Computadora");
        System.out.println("2. Microcomponente");
        System.out.println("3. Television");
        System.out.print("Opción: ");
        opcion = entrada.nextByte();

        switch (opcion) {
            case 1:
                crearComputadora();
                break;
            case 2:
                crearMicrocomponente();
                break;
            case 3:
                crearTelevision();
                break;
        
            default:
                System.out.println("Error. Digite una opción válida");
                break;
        }
    }

    public static void mostrar() {
        // byte opcion;

        // System.out.println("¿Qué electrónico desea mostrar?");
        // System.out.println("1. Computadora");
        // System.out.println("2. Microcomponente");
        // System.out.println("3. Television");
        // System.out.print("Opción: ");
        // opcion = entrada.nextByte();

        // switch (opcion) {
        //     case 1:
                
        //         break;
        //     case 2:

        //         break;
        //     case 3:

        //         break;
        
        //     default:
        //         System.out.println("Error. Digite una opción válida");
        //         break;
        // }
        System.out.println("\nLos electronicos ingresados son: ");
        mostrarElectronicos();
    }

    public static void modificar() {
        // byte opcion;

        // System.out.println("¿Qué electrónico desea modificar?");
        // System.out.println("1. Computadora");
        // System.out.println("2. Microcomponente");
        // System.out.println("3. Television");
        // System.out.print("Opción: ");
        // opcion = entrada.nextByte();

        // switch (opcion) {
        //     case 1:
                
        //         break;
        //     case 2:

        //         break;
        //     case 3:

        //         break;
        
        //     default:
        //         System.out.println("Error. Digite una opción válida");
        //         break;
        // }
        System.out.println();
        modificarElectronico();
    }

    public static void eliminar() {
        // byte opcion;

        // System.out.println("¿Qué electrónico desea eliminar?");
        // System.out.println("1. Computadora");
        // System.out.println("2. Microcomponente");
        // System.out.println("3. Television");
        // System.out.print("Opción: ");
        // opcion = entrada.nextByte();

        // switch (opcion) {
        //     case 1:
                
        //         break;
        //     case 2:

        //         break;
        //     case 3:

        //         break;
        
        //     default:
        //         System.out.println("Error. Digite una opción válida");
        //         break;
        // }
        System.out.println();
        eliminarElectronico();
    }

    public static void crearComputadora() {
        String nS, marca, modelo, procesador, grafica;
        int almacenamiento, ram;

        entrada.nextLine();
        System.out.println("\nIngrese los datos de la Computadora");
        System.out.print("Digite el Numero de Serie: ");
        nS = entrada.nextLine();
        System.out.print("Digite la marca: ");
        marca = entrada.nextLine();
        System.out.print("Digite el modelo: ");
        modelo = entrada.nextLine();
        System.out.print("Digite el procesador: ");
        procesador = entrada.nextLine();
        System.out.print("Digite la grafica: ");
        grafica = entrada.nextLine();
        System.out.print("Digite el almacenamiento: ");
        almacenamiento = entrada.nextInt();
        System.out.print("Digite la memoria RAM: ");
        ram = entrada.nextInt();

        Computadora computadora = new Computadora(nS, marca, modelo, procesador, grafica, almacenamiento, ram);
        electronicos.add(computadora);

        System.out.println();
    }

    public static void crearMicrocomponente() {
        String nS, marca, modelo;
        double potencia;
        int nBocinas;

        entrada.nextLine();
        System.out.println("\nIngrese los datos del Microcomponente");
        System.out.print("Digite el Numero de Serie: ");
        nS = entrada.nextLine();
        System.out.print("Digite la marca: ");
        marca = entrada.nextLine();
        System.out.print("Digite el modelo: ");
        modelo = entrada.nextLine();
        System.out.print("Digite la potencia (Watts): ");
        potencia = entrada.nextDouble();
        System.out.print("Digite el número de bocinas: ");
        nBocinas = entrada.nextInt();

        Microcomponente microcomponente = new Microcomponente(nS, marca, modelo, potencia, nBocinas);
        electronicos.add(microcomponente);

        System.out.println();
    }

    public static void crearTelevision() {
        String nS, marca, modelo, tipoPanel;
        int pulgadas;

        entrada.nextLine();
        System.out.println("\nIngrese los datos de la Televisión");
        System.out.print("Digite el Numero de Serie: ");
        nS = entrada.nextLine();
        System.out.print("Digite la marca: ");
        marca = entrada.nextLine();
        System.out.print("Digite el modelo: ");
        modelo = entrada.nextLine();
        System.out.print("Digite el tipo de panel: ");
        tipoPanel = entrada.nextLine();
        System.out.print("Digite el tamaño (pulgadas): ");
        pulgadas = entrada.nextInt();

        Television television = new Television(nS, marca, modelo, pulgadas, tipoPanel);
        electronicos.add(television);

        System.out.println();
    }
    
    public static void mostrarElectronicos() {
        // for (Electronico electronico : electronicos) {
        //     System.out.println(electronico);
        // }

        for (Electronico elec : electronicos) {
            System.out.println(elec.toString());
            System.out.println();
        }

        System.out.println();
    }

    public static void modificarElectronico() {
        String nS;
        int indice;
        entrada.nextLine();
        System.out.print("\nDigite el identificador del electronico: ");
        nS = entrada.nextLine();
        indice = electronicos.indexOf(nS);
        if (indice != -1) {
            electronicos.remove(nS);
            System.out.println("Ingrese el dato de nuevo");
            crear();
        } else {
            System.out.println("Dato no encontrado");
        }
    }

    public static void eliminarElectronico() {
        String nS;
        int indice;
        entrada.nextLine();
        System.out.print("\nDigite el identificador del electronico: ");
        nS = entrada.nextLine();
        indice = electronicos.indexOf(nS);
        if (indice != -1) {
            electronicos.remove(nS);
            System.out.println("Dato eliminado");
        } else {
            System.out.println("Dato no encontrado");
        }
    }
}
