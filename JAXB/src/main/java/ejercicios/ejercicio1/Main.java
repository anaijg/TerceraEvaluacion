package ejercicios.ejercicio1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Para generar el fichero XML necesito 2 cosas:
        // 1) Un objeto
        ArrayList<String> módulos = new ArrayList<>();
        módulos.add("Programación");
        módulos.add("Bases de Datos");
        módulos.add("Lenguajes de marcas");

        Estudiante estudiante = new Estudiante("66666666B", "Carlos", "Nieto", 1, "DAW", módulos);

        // 2) Dónde queremos crear el fichero y cómo se va a llamar
        String ruta = "JAXB\\src\\main\\java\\ejercicios\\ejercicio1\\" + estudiante.getNombre() + ".xml";
        File f = new File(ruta);

        // Con esto, creamos el contexto, el marshaller, y llamamos al método marshal()
        try {
            JAXBContext context = JAXBContext.newInstance(Estudiante.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // llamamos al método marshal con el objeto y con el file
            m.marshal(estudiante, f);

        } catch (JAXBException e) {
            System.out.println("Péinate.");
            e.printStackTrace();
        }

    }
}
