import java.util.LinkedList;
import java.util.Scanner;

public class Ejemplo {

    public static void main(String[] args) {

        Integer suma = 0;

        Scanner in = new Scanner (System.in);
        in.useDelimiter("\n");
        System.out.println("Digite los numeros a validar (Inserte '-1' para detener):");

        LinkedList<Integer> tarjeta = new LinkedList<>();
        Integer valor;

        while(true){
            valor = in.nextInt();
            if (valor == -1){
                break;
            }
            else tarjeta.addLast(valor);
        }


        if (tarjeta.size() % 2 == 0) {

            for (int i = tarjeta.size() - 1 ; i >= 0; i--) {
                if(i % 2 == 0){
                    if(tarjeta.get(i) > 4 ){
                        suma += tarjeta.get(i) * 2 - 9;
                    }
                    else { suma += tarjeta.get(i) * 2;}
                }
                else { suma += tarjeta.get(i);}
            }

        }

        else {

            for (int i = tarjeta.size() - 1 ; i >= 0; i--) {
                if(i % 2 != 0){
                    if(tarjeta.get(i) > 4){
                        suma += tarjeta.get(i) * 2 - 9;
                    }
                    else { suma += tarjeta.get(i) * 2;}
                }
                else { suma += tarjeta.get(i);}
            }

        }

        if(suma % 10 == 0){
            System.out.println("Valido");
        }

        else if (suma == 0){
            System.out.println("Valido");
        }

        else System.out.println("No Valido");

    }

}