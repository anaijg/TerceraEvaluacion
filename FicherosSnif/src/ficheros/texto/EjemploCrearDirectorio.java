package ficheros.texto;

import java.io.File;
import java.util.Scanner;

public class EjemploCrearDirectorio {
    public static void main(String[] args) {
        // empezamos teniendo clara la ruta y el nombre
        // quiero crear un fichero en esta ruta
        String ruta = "FicherosSnif\\src\\ficheros\\texto\\";
        // preguntamos qué nombre queremos darle
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del directorio:");
        String nombre = sc.nextLine();

        // A continuación, creamos el objeto File
        File nuevoDirectorio = new File(ruta + nombre);
        boolean creado = nuevoDirectorio.mkdir();
    }
}
