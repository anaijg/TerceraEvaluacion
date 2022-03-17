package ejercicios.ejercicio1;

/*
Crea una interfaz funcional para cada uno de los siguientes métodos y crea las
expresiones lambda correspondientes:
 */
public class Ejercicio1 {
    public static void main(String[] args) {
// Escribe aquí el código correspondiente
    DeterminarSigno ds = num ->  Integer.compare(num, 0);
        System.out.println(determinarSigno(5));
        System.out.println(determinarSigno(-15));
        System.out.println(determinarSigno(0));
    }

    // Ejercicio 1.1
    private static int determinarSigno(int num) {
        if (num > 0) {
            return 1;
        } else if (num < 0) {
            return -1;
        } else {
            return 0;
        }
    }


    // Ejercicio 1.2
    public static String print(String arg) {
        return "\"" + arg + "\"";
    }


    // Ejercicio 3
    public static int[] getPrimeroYÚltimo(int[] array) {
        return new int[]{array[0], array[array.length-1]};
    }
}
