package ejercicios.ejercicio2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "ciudades")
public class Ciudad {
    String continente;
    String nombre;
    String pais;
    ArrayList<Ciudad> ciudades = new ArrayList<>();

    public Ciudad(String continente, String nombre, String pais, ArrayList<Ciudad> ciudades) {
        this.continente = continente;
        this.nombre = nombre;
        this.pais = pais;
        this.ciudades = ciudades;
    }

    public Ciudad() {

    }


    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @XmlElement(name = "ciudad")
    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "continente='" + continente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", ciudades=" + ciudades +
                '}';
    }
}
