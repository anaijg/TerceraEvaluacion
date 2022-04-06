package ficheros.ejercicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {
    /*
    8. Escribir un programa Java que lee texto por teclado y lo escribe
en un fichero de texto llamado datos.txt. El proceso consiste en
leer una línea de texto por teclado y escribirla en el fichero.
Este proceso se repite hasta que se introduce por teclado la
cadena FIN. La cadena FIN que indica el final de lectura no se
debe escribir en el fichero.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto;
        // esto lo tenemos que escribir en:
        String ruta = "FicherosSnif\\src\\ficheros\\ejercicios\\datos.txt";
        File f = new File(ruta);
        try {
            FileWriter fw = new FileWriter(f, true);

            do {
                texto = sc.nextLine();
                // antes de escribir, compruebo si es fin
                if (!texto.equalsIgnoreCase("FIN")) { // si texto no es igual que fin lo escribo en el fichero
                    fw.write(texto + "\n");
                }
            } while (!texto.equalsIgnoreCase("FIN"));



            fw.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
