package ejemplos.comparabl;

import java.time.LocalDate;

/*
Creamos una clase Socio (de biblioteca, por ejemplo),
con los siguientes atributos:
número identificativo del socio,
nombre y
fecha de nacimiento,
y un constructor parametrizado.
También queremos un método toString() algo personalizado (esto ya
sabemos hacerlo, no lo ponemos aquí).
 */
public class Socio {
    // atributos
    int id; // nº identificativo
    String nombre;
    LocalDate fechaNacimiento;

    // constructor

    public Socio(int id, String nombre, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    // toString()

    @Override
    public String toString() {
        return id + ". " + nombre + " (" + fechaNacimiento + ")";
    }
}
