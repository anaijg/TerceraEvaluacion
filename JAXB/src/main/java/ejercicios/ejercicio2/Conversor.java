package ejercicios.ejercicio2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Conversor {
    private Ciudad ciudad;
    private String nombreFichero;

    public Conversor(Ciudad ciudad, String nombreFichero) {
        this.ciudad = ciudad;
        this.nombreFichero = nombreFichero;
    }

    public Conversor(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public void generarXML() {
        File f = new File("JAXB\\src\\main\\java\\ejercicios\\ejercicio2\\" + nombreFichero + ".xml");
        try {
            JAXBContext contexto = JAXBContext.newInstance(Ciudad.class);
            Marshaller ma = contexto.createMarshaller();
            ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            ma.marshal(ciudad,  f);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void crearCiudad() {
        File f = new File("JAXB\\src\\main\\java\\ejercicios\\ejercicio2\\" + nombreFichero + ".xml");
        try {
            JAXBContext contexto = JAXBContext.newInstance(Ciudad.class);
            Unmarshaller um = contexto.createUnmarshaller();
            // Necesitamos un objeto para guardar el resultado del método
            Ciudad resultado = (Ciudad) um.unmarshal(f);
            System.out.println(resultado.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
