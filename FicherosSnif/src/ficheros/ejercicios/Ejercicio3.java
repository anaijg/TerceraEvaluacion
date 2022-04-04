package ficheros.ejercicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        /*
        3. Partiendo del fichero de csv de ejemplo, crear un programa de
Java que permita al usuario añadir datos nuevos a ese fichero,
utilizando el mismo formato que los ya existentes.
         */
        // pedimos datos
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre");
        String nombre = sc.nextLine();
        System.out.println("Primer apellido: ");
        String apellido1 = sc.nextLine();
        System.out.println("Segundo apellido: ");
        String apellido2 = sc.nextLine();

        // los vamos a hacer un String
        String línea = "\n" + nombre + "|" + apellido1 + "|" + apellido2;

        // ahora tenemos que escribir esta línea en el fichero, al final de todo
        File f = new File("FicherosSnif\\src\\ficheros\\ejercicios\\nombres.csv");
        try {
            FileWriter fw = new FileWriter(f, true);

            fw.write(línea);

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
