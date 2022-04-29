package ejercicios.ejercicio1;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "estudiante")
@XmlType(propOrder = {"DNI", "nombre", "apellido", "curso", "ciclo", "módulos"})
public class Estudiante {
    private String DNI;
    private String nombre;
    private String apellido;
    private int curso;
    private String ciclo;
    ArrayList<String> módulos = new ArrayList<>();

    public Estudiante(String DNI, String nombre, String apellido, int curso, String ciclo, ArrayList<String> módulos) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.ciclo = ciclo;
        this.módulos = módulos;
    }

    public Estudiante() {

    }

    @XmlElement(name = "DNI", required = true)
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "apellidos")
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCurso() {
        return curso;
    }
    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getCiclo() {
        return ciclo;
    }
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    @XmlElementWrapper(name = "módulos") // así vamos a llamar a la lista
    @XmlElement(name = "módulo")
    public ArrayList<String> getMódulos() {
        return módulos;
    }
    public void setMódulos(ArrayList<String> módulos) {
        this.módulos = módulos;
    }
}
