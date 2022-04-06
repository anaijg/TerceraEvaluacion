package ficheros.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        /*
        10. Escribir un programa Java para buscar una palabra o una
cadena en un fichero de texto. El programa pedirá que se
introduzca una palabra o un texto por teclado y realizará su
búsqueda por el archivo. Se mostrará por pantalla el número de
línea y el contenido de la línea del fichero que contiene la
cadena buscada. Si la cadena buscada aparece en varias líneas se
mostrarán todas ellas. Si el fichero no contiene el texto
buscado se mostrará un mensaje indicándolo
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Texto a buscar: ");
        String texto = sc.nextLine(); // ejemplo: Avenue
        // Como queremos recuperar la línea en que está el texto a buscar, vamos a leer línea a línea

        String ruta = "FicherosSnif\\src\\ficheros\\ejercicios\\Restaurantes.csv";
        File f = new File(ruta);
        int numLínea = 0; // incrementaremos esta variable cada vez que avancemos una línea
        String línea = "";
        boolean encontrado = false;
        try (Scanner lector = new Scanner(f)) {
            while (lector.hasNextLine()) {
                línea = lector.nextLine();
                numLínea++;
                if (línea.toLowerCase().contains(texto.toLowerCase())) { // ponemos texto y línea en minúsculas para que dé igual si están en mayúsculas o minúsculas
                    System.out.println("Línea " + numLínea + ": " + línea);
                    encontrado = true;
                }
            }
            // si al salir del while encontrado sigue siendo false, es que no hemos encontrado el texto
            if (!encontrado) {
                System.out.println("El fichero no contiene el texto buscado.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado: " + e.getMessage());
            //e.printStackTrace();
        }

    }
}
