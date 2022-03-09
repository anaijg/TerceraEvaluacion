package ejemplos.clasegenerica;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Contenedor<String> entero = new Contenedor<String>();
        entero.setObjeto("Esto es un poco abstracto.");
        System.out.println(entero.getObjeto());
    }
}
