package ficheros.texto;

import java.io.File;

public class EjemploFile {
    public static void main(String[] args) {
        // creamos un objeto de tipo fichero para hacer referencia
        // a un fichero que supuestamente existe o va a existir
        // pero no es necesario que exista
        File f = new File("FicherosSnif\\src\\ficheros\\texto\\fichero.txt");

        // una vez creado el objeto File tenemos métodos para trabajar
        // con el "fichero" al que se refiere
        if (f.exists()) {
            System.out.println("Existe");
            System.out.println("¿Es un fichero o es un directorio? ");
            if (f.isFile()) {
                System.out.println("Es un fichero");
            } else if (f.isDirectory()) {
                System.out.println("Es un directorio");
            } else {
                System.out.println("No es ni un fichero ni un directorio");
            }
            System.out.println("Ruta: " + f.getPath());
            System.out.println("Está en la carpeta: " + f.getParent());
            System.out.println("Permisos: " + (f.canRead() ? "r" : "-") + (f.canWrite() ? "w" : "-") + (f.canExecute() ? "x" : "-"));
            // es lo mismo que
            /*if (f.canRead()) {
                System.out.print("r");
            } else {
                System.out.print("-");
            }*/
        } else {
            System.out.println("El fichero no existe o la ruta es incorrecta.");
        }
    }
}
