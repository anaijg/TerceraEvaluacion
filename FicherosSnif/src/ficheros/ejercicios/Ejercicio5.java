package ficheros.ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        /*
        5. Crear un programa en Java que borre el fichero cuya ruta ha sido
introducida por el usuario
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Ruta: ");
        // FicherosSnif\src\ficheros\ejercicios\Restaurantes2.csv"
        String ruta = sc.nextLine();
        File f = new File(ruta);
        boolean resultado = f.delete();
        if (resultado) {
            System.out.println("El fichero se ha borrado");
        }
    }
}
