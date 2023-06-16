public class Fraccion {
     private int numerador;
     private int denominador;

     // Método constructor
     public Fraccion(final int numerador, final int denominador) {
          this.numerador = numerador;
          this.denominador = denominador;
     }

     // Métodos getters
     public int getNumerador() {
          return numerador;
     }

     public int getDenominador() {
          return denominador;
     }

    public Fraccion sumar(final Fraccion f1) {
         final Fraccion aux = new Fraccion((numerador * f1.denominador) + (denominador * f1.numerador), denominador * f1.denominador);
         aux.simplificar();
         return aux;
    }

    public Fraccion restar(Fraccion f1) {
          Fraccion aux = new Fraccion(numerador * f1.denominador - (denominador * f1.numerador), denominador * f1.denominador);
          aux.simplificar();
          return aux;
    }

    public Fraccion multiplicar(Fraccion f1) {
         Fraccion aux = new Fraccion(numerador * f1.numerador, denominador * f1.denominador);
         aux.simplificar();
         return aux;
    }

    public Fraccion dividir(Fraccion f1) {
         Fraccion aux = new Fraccion(numerador * f1.denominador, denominador * f1.numerador);
         aux .simplificar();
         return aux;
    }


    private int mcd() {
         int num = numerador, den = denominador;

         if (num == 0) {
              return 1;
         } else {
              if (num < 0) {
                   num += -1; // -2 2
              }
              if (den < 0) {
                   den += -1; // -2 2
              }
              if (den > num) {
                   final int aux = num;
                   num  = den;
                   den = aux;
              }
              int mcd = 1;
              while (den != 0) {
                   mcd = den; // 4
                   den = num % den;
                   num = mcd; // 4
              }
              return mcd;
         }
    }

    private void simplificar() {
          final int mcd = mcd();

          numerador /= mcd;
          denominador /= mcd;

          if (numerador < 0 && denominador < 0) {
               numerador *= -1;
               denominador *= -1;
          } else if (numerador >= 0 && denominador < 0) {
               numerador *= -1;
               denominador *= -1;
          }
    }
     
    @Override
     public String toString() {
          if (denominador != 0) {
               simplificar();
               if (denominador != 1) {
                    return numerador + " / " + denominador;
               } else {
                    return numerador + "";
               } 
          } else {
               return "El denominador debe ser disitnto de 0";
               }
          }
}

