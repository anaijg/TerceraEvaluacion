package ejercicios.ejercicio4;

public class MainMetodosP {
    public static void main(String[] args) {
        System.out.println("1. " + esMúltiploDe5(15));

        System.out.println("2." + noTerminaEns("Xokas"));
        System.out.println("3. " +noTerminaEns( "Ibai"));

        System.out.println("4. " + parYMultiploDe3(6));


    }

    // Escribe un método para comprobar si un entero es múltiplo de 5.
    static boolean esMúltiploDe5(int n) {
        /*if (n % 5 == 0) {
            return true;
        } else {
            return false;
        } */
        // lo reformulamos en una única línea
        return n % 5 == 0;
    }

   // Escribe un método para comprobar si un String no termina en “s”.
    static boolean noTerminaEns(String s) {
        return !s.endsWith("s");
    }

   // Escribe un método para comprobar si un
    //entero es par y múltiplo de 3.
    static boolean parYMultiploDe3(int n) {
        return n % 2 == 0 && n % 3 == 0;
    }

    // Escribe un método para comprobar si un
    //carácter es una letra y está en mayúscula.

    /*Escribe un método para comprobar si un
    entero es impar y múltiplo de 7. */

    /*
    Escribe un método para comprobar si un
entero es impar o múltiplo de 7.
     */
}
