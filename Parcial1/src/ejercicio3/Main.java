package ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Crea una lista de personas y
        List<Persona> personas = new ArrayList<>();
//        rellénala con los datos que aparecen en el fichero.
//        Es decir, debes ir leyendo el fichero,
        String ruta = "Parcial1\\src\\ejercicio3\\personas.csv";
        File f = new File(ruta);
        try {
            Scanner lector = new Scanner(f);
            // La lista no debe contener la primera fila del fichero,
            lector.nextLine(); // paso la primera linea, de los encabezados, sin hacer nada
            while (lector.hasNextLine()) {
                // obtengo la siguiente línea
                String línea = lector.nextLine(); // la primera vez ya es la segunda línea
                // la troceo, cada elemento del array será un parámetro: el DNI, el nombre...
                String[] campos = línea.split(";");
//                String DNI = campos[0];
//                String nombre = campos[1];
//                String apellido1 = campos[2];
//                ...
                // con esos valores creo el objeto persona para esa línea
                Persona p = new Persona(campos[0], campos[1], campos[2], campos[3],campos[4],campos[5],campos[6],campos[7],campos[8] );
                // y la añado a la lista
                personas.add(p);
            }


            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero" + e.getMessage());
            //e.printStackTrace();
        }

//        crear un objeto para
//        cada registro y meterlo en la lista. Ten en cuenta que:
//        a. La lista no debe contener la primera fila del fichero, que es la de los encabezados.
//                b. Debes gestionar las posibles excepciones de forma que, en caso de que no se encuentre el fichero, no
//        muestre la pila de líneas de error y sí un mensaje indicando qué error se ha producido.

//        3. (1 punto) Utilizando streams, muestra código postal, nombre, apellido1 y apellido2 de las personas que viven
//        en Madrid, ordenadas primero por código postal y después por nombre.
            personas.stream()
                    .filter(persona -> persona.ciudad.equalsIgnoreCase("Madrid"))
                    .sorted((p1, p2) -> p1.nombre.compareTo(p2.nombre))
                    .sorted((p1, p2) -> p1.cp.compareTo(p2.cp))
                    .forEach(persona -> System.out.println(persona.cp + " " + persona.nombre + " " + persona.apellido1 + " " + persona.apellido2));
//
//        4. (1 punto) Crea un mapa en que la clave sea el dni, y el valor sea el nombre y los apellidos separados por
//        espacios formando un único String. Rellena el mapa iterando sobre la lista de personas.
        Map<String, String> mapa = new HashMap<>();
        // mapa.put(DNI, nombre + " " + apellido1 + " " + apellido2)
        Iterator<Persona> it = personas.iterator();
        while (it.hasNext()) {
            Persona p = it.next();
            mapa.put(p.DNI, p.nombre + " " + p.apellido1 + " " + p.apellido2);
        }
    }
}
