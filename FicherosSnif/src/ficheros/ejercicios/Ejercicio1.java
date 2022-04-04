package ficheros.ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
//        1. Escribir un programa en Java que para cualquier ruta indicada
//        por el usuario (metida por teclado)
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta: ");
        // FicherosSnif\src\ficheros\ejercicios\cadenas.txt
        String ruta = sc.nextLine();

        File f = new File(ruta); // basta con crear este objeto y llamar a sus métodos para hacer el resto del ejercicio

//        , muestre:
//        a. Si el fichero existe o no
        if (f.exists()) {
            System.out.print("Existe");

            //b. Si se trata de un directorio o de un fichero
            if (f.isDirectory()) {
                System.out.println(" y es un directorio.");
            } else { // si no es un directorio, es un fichero
                System.out.println(" y es un fichero");

                //c. En caso de ser un fichero, debe mostrar los siguientes
//        datos:
//        i. Nombre
                System.out.println("Nombre: " + f.getName());
//        ii. Tamaño
                System.out.println("Tamaño: " + f.length()); // *** NEW *** length da el tamaño en bytes del fichero
//        iii. Permisos de lectura y escritura
                System.out.print("Permisos: ");
                // que nos mouestre algo sólo si tiene esos permisos
                if (f.canRead()) {
                    System.out.print("lectura");
                }
                if (f.canWrite()) {
                    System.out.println(" escritura");
                }
            }
//

        } else {
            System.out.println("No existe");
        }
//
    }
}
