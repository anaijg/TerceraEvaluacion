package ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // creamos variables para almacenar temporalmente cada uno de los campos antes de insertarlos en
        // el objeto

        List<Persona> personas = new ArrayList<>();

        String ruta = "Parcial1\\src\\ejercicio3\\personas.csv";
        File f = new File(ruta);

        try (Scanner lector = new Scanner(f)) {
            // variables que vamos a necesitar:
            String línea;
            String[] campos;

            // adelantamos una fila para pasar la de los encabezados
            lector.nextLine(); // 1 punto
            // a partide de aquí vamos leyendo línea a línea, la "troceamos"
            // y creamos los objetos con los campos correspondientes
            while (lector.hasNextLine()) {
                línea = lector.nextLine();
                campos = línea.split(";");
                personas.add(new Persona(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
            //e.printStackTrace();
        }
        //System.out.println(personas);

        personas.stream()
                .filter(persona -> persona.ciudad.equalsIgnoreCase("Madrid"))
                .sorted((p1, p2) -> p1.nombre.compareTo(p2.nombre))
                .sorted((p1, p2) -> p1.cp.compareTo(p2.cp))
                .forEach(persona -> System.out.println(persona.cp + " - " + persona.nombre + " " + persona.apellido1 + " " + persona.apellido2));

        Map<String, String> mapa= new HashMap<>();
        Iterator<Persona> it = personas.iterator();
        while (it.hasNext()) {
            Persona p = it.next();
            mapa.put(p.DNI, p.nombre + " " + p.apellido1 + " " + p.apellido2);
        }

    }
}
