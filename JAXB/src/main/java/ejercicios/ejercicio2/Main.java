package ejercicios.ejercicio2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // a los elementos del fichero no les añadimos arraylist
        Ciudad m = new Ciudad("Europa", "Madrid", "España", null);
        Ciudad w = new Ciudad("América", "Washington", "EEUU", null);
        Ciudad s = new Ciudad("Oceanía", "Sidney", "Australia", null);

        ArrayList<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(m);
        ciudades.add(w);
        ciudades.add(s);

        // el fichero en sí es un objeto que sólo contiene el arraylist de ciudades, lo demás, null
        Ciudad ciudad = new Ciudad(null, null, null, ciudades);


        // Instancio la clase Conversor
        Conversor c = new Conversor(ciudad, "ciudades2");
        c.generarXML();

        Conversor c2 = new Conversor("convertirAObjeto");
        c2.crearCiudad();

    }
}
