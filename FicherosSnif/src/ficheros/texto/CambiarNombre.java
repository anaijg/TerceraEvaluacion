package ficheros.texto;

import java.io.File;

public class CambiarNombre {
    public static void main(String[] args) {
        String ruta = "FicherosSnif\\src\\ficheros\\texto\\";

        // creamos un objeto file con la ruta+nombre original
        File f = new File(ruta + "renombrable.txt");
        // a continuación llamamos al método renameTo y le pasamos un nuevo objeto File con el nuevo nombre
        boolean renombrado = f.renameTo(new File(ruta + "renombrado.txt"));
        if (renombrado) {
            System.out.println("Se ha cambiado el nombre correctamente.");
        }

    }
}
