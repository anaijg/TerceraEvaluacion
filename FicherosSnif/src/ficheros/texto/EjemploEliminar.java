package ficheros.texto;

import java.io.File;
import java.util.Scanner;

public class EjemploEliminar {
    public static void main(String[] args) {
        String ruta = "FicherosSnif\\src\\ficheros\\texto\\";
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué fichero o carpeta quieres eliminar?");
        String eliminar = sc.nextLine(); // leemos el nombre del fichero o carpeta a eliminar

        File f = new File(ruta + eliminar);
        // ahora utilizamos el método delete() para eliminarlo
        boolean eliminado = f.delete();
        if (eliminado) {
            System.out.println("El fichero se ha eliminado.");
        } else {
            System.out.println("No se ha podido eliminar o no existe.");
        }


        // Si queremos borrar una carpeta que no está vacía:
        File carpetaNoVacía = new File(ruta + "DAW");
        deleteDirRecursively(carpetaNoVacía);
    }

    public static void deleteDirRecursively(File dir) { // pasamos un objeto file con la ruta de la carpeta que queremos borrar
        File[] children = dir.listFiles(); // guarda en un array el contenido de la carpeta que le hemos pasado EJ:  si hemos pasado DAW, en children guarda Primero y Segundo
        for (File child: children) { // recorre el contenido de la carpeta que hemos pasado
            if (child.isDirectory()) { // si es un directorio, vuelve a llamar a esta métoco con esa carpeta-hija ¡¡¡RECURSIVIDAD!!!
                deleteDirRecursively(child);
            } else {
                child.delete();
            } }
        // para cuando llegamos aquí la carpeta inicial ya está vacía
        dir.delete();
    }
}
