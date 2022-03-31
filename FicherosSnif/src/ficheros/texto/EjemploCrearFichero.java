package ficheros.texto;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EjemploCrearFichero {
    public static void main(String[] args) {
        // empezamos teniendo clara la ruta y el nombre
        // quiero crear un fichero en esta ruta
        String ruta = "FicherosSnif\\src\\ficheros\\texto\\";
        // preguntamos qué nombre queremos darle
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del fichero:");
        String nombre = sc.nextLine();

        // A continuación, creamos el objeto File
        File nuevoFichero = new File(ruta + nombre);
        try {
            // creamos el fichero
            boolean creado = nuevoFichero.createNewFile();
            if (creado) {
                System.out.println("El fichero ha sido creado.");
            }else {
                System.out.println("El fichero ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ha sucedido un error: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
