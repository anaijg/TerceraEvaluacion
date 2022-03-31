package ficheros.texto;

import java.io.File;

public class EjemploMkdirs {
    public static void main(String[] args) {
        // mkdirs, a diferencia de mkdir te crea una jerarquía de carpeta con carpetas intermedias si no existen
        String ruta = "FicherosSnif\\src\\ficheros\\texto\\";
        String carpetasPrimero = "DAW\\Primero\\Programación";
        String carpetasSegundo = "DAW\\Segundo\\DWES";

        File primero = new File(ruta + carpetasPrimero);
        boolean primeroOK = primero.mkdirs();
        if (primeroOK) {
            System.out.println("Se ha creado lo de primero.");
        }

        File segundo = new File(ruta + carpetasSegundo);
        boolean segundoOK = segundo.mkdirs();
        if (segundoOK) {
            System.out.println("Se ha creado lo de segundo");
        }
    }
}
