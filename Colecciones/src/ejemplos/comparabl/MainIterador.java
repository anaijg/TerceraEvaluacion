package ejemplos.comparabl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para ver un ejemplo de Iterator
 */

public class MainIterador {
    public static void main(String[] args) {
        // Creamos unos cuantos objetos
        Socio s1 = new Socio(15, "Bettina", LocalDate.of(2000, 1,1));
        Socio s2 = new Socio(9000, "Aladina", LocalDate.of(1968, 10,10));
        Socio s3 = new Socio(23, "Caleb", LocalDate.of(2012, 12,13));
        Socio s4 = new Socio(666, "Lucifer", LocalDate.of(1666, 12,25));
        Socio s5 = new Socio(0, "Adán", LocalDate.of(1000, 5,10));

        // Los metemos en un ArrayList
        ArrayList<Socio> socios = new ArrayList<>();
        socios.add(s1);
        socios.add(s2);
        socios.add(s3);
        socios.add(s4);
        socios.add(s5);

        // Lo nuevo aquí es que vamos a recorrer el ArrayList
        // con un iterador en lugar de for o foreach
        // OJO: a la hora de crear un iterador no utilizamos new
        // es un método que contienen las colecciones
        Iterator<Socio> it = socios.iterator();
        while (it.hasNext()) { // mientres haya un elemento más
            Socio s = it.next(); // avanzamos al siguiente elemento y
            // lo guardamos en una variable auxiliar
            System.out.println(s);
        }
        //it = socios.iterator(); haríamos esto para resetear y ponerlo al principio


    }
}
