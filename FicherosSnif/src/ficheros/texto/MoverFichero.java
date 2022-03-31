package ficheros.texto;

import java.io.File;

public class MoverFichero {
    public static void main(String[] args) {
        String ruta = "FicherosSnif\\src\\ficheros\\texto\\";

        // mover un fichero es lo mismo que renombrarlo, si tenemos en cuenta que para el sistema realmente el nombre del fichero es su ruta cumpleta, incluido el nombre

        // creamos un objeto file con la ruta+nombre original
        File f = new File(ruta + "movible.txt");
        // a continuación llamamos al método renameTo y le pasamos un nuevo objeto File con la nueva ruta
        boolean movido = f.renameTo(new File("FicherosSnif\\src\\excepciones\\" + "movible.txt"));
        if (movido) {
            System.out.println("El fichero se ha movido correctamente.");
        }
    }
}
