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
public class Socio implements Comparable{
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
        return id + ". " + nombre + " (" + fechaNacimiento.getDayOfMonth() + "/" + fechaNacimiento.getMonthValue() + "/" + fechaNacimiento.getYear() + ")";
    }


    @Override
    public int compareTo(Object o) {
        // Lo primero que hacemos es convertir el objeto al tipo que queremos
        // hacemos un casting a Socio
        Socio s = (Socio) o;

        // vamos a querer comparar por id
        // vamos a hacer un if de forma que devuelva:

        //• Negativo, si objeto1 va a antes que objeto2.
        //• Positivo, si objeto1 va después de objeto2.
        //• 0, si los dos objetos son iguales

        if (this.id < s.id) {
            //• Negativo, si objeto1 va a antes que objeto2.
            return  -1;
        } else if(this.id > s.id) {
            //• Positivo, si objeto1 va después de objeto2.
            return 1;
        } else {
            return 0;
        }

    }
}
