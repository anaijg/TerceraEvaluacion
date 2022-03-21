package ejercicios.ejercicio5;

public class MainMetodosF {
    public static void main(String[] args) {
        System.out.println("1. " + f1("Rosalía"));

        System.out.println("2. " + f2(4));

    }

    /*
    Escribe un método que reciba un String y devuelva su longitud.
     */
    static int f1(String s) {
        return s.length();
    }

    /*
    Escribe un método que reciba un entero y
devuelva su cuadrado.
     */
    static int f2(int n) {
        return (int) Math.pow(n, 2);
    }

    /*
    Escribe un método que devuelva el 10%
de un número.
     */
}
