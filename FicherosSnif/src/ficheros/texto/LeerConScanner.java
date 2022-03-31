package ficheros.texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerConScanner {
    public static void main(String[] args) {
        String ruta = "FicherosSnif\\src\\ficheros\\texto\\";

        // Para leer un fichero:

        // 1) Creamos un objeto File con la ruta del fichero
        File f = new File(ruta + "fichero1.txt");

        // 2) Creamos un scanner pero en vez de System.in le pasamos el File
        // con esto le decimos en vez de "lee lo que venga por el teclado"
        // le decimos "lee lo que contenga el fichero"
        // me obliga a gestionar la excepción que ocurriría si no encuenta el fichero
        try {
            Scanner lector = new Scanner(f);
            System.out.println("Línea a línea");
            //  vamos a leer el fíchero línea a línea
            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }
            // ahora lo leemos número a número
            System.out.println("Nú");
            lector = new Scanner(f);
            while ((lector.hasNextInt())) {
                System.out.println(lector.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero. " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
