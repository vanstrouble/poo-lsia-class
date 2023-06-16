import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner entry = new Scanner(System.in);
        int numerador, denominador;

        System.out.print("Digigte el númerador de la fracción 1: ");
        numerador = entry.nextInt();
        System.out.print("Digite el denominador de la fracción 1: ");
        denominador = entry.nextInt();
        Fraccion f1 = new Fraccion(numerador, denominador);

        System.out.println();

        System.out.print("Digigte el númerador de la fracción 2: ");
        numerador = entry.nextInt();
        System.out.print("Digite el denominador de la fracción 2: ");
        denominador = entry.nextInt();
        Fraccion f2 = new Fraccion(denominador, denominador);

        entry.close();

        System.out.println();
        System.out.println("El resultado de la fracción es: ");
        System.out.println(f1.sumar(f2).toString());
    }
}
