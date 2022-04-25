package ejercicios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ejercicio1 {
    /*
    1. Escribe como una cadena, en el fichero binario elBuenMomento.dat, el siguiente poema de
José Hierro:
Aquel momento que flota
nos toca de su misterio.
Tendremos siempre el presente
roto por aquel momento.
Toca la vida sus palmas
y tañe sus instrumentos.
Acaso encienda su música
sólo para que olvidemos.
Pero hay cosas que no mueren
y otras que nunca vivieron
y las hay que llenan todo
nuestro universo.
Y no es posible librarse
de su recuerdo.
     */
    public static void main(String[] args) {
        // 1) Meto el poema en un String
        String poema = "Aquel momento que flota\n" +
                "nos toca de su misterio.\n" +
                "Tendremos siempre el presente\n" +
                "roto por aquel momento.\n" +
                "Toca la vida sus palmas\n" +
                "y tañe sus instrumentos.\n" +
                "Acaso encienda su música\n" +
                "sólo para que olvidemos.\n" +
                "Pero hay cosas que no mueren\n" +
                "y otras que nunca vivieron\n" +
                "y las hay que llenan todo\n" +
                "nuestro universo.\n" +
                "Y no es posible librarse\n" +
                "de su recuerdo.\n";
        // 2) Lo grabo en el fichero binario
        // lo metemos to-do en una línea
        // para escribir en el fichero hacemos lo siguiente -> siempre igual, lo único que cambiará será la ruta
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Binarios\\src\\ejercicios\\elBuenMomento.dat"))) { // con esta expresión: try-with-resources, se cierra autométicamente, no hace falta utilizar el close()
            out.writeObject(poema); // escribimos el poema en el fichero
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
