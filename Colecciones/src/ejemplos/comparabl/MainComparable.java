package ejemplos.comparabl;

import java.time.LocalDate;
import java.util.Arrays;

public class MainComparable {
    public static void main(String[] args) {
        // Creamos unos cuantos objetos
        Socio s1 = new Socio(15, "Bettina", LocalDate.of(2000, 1,1));
        Socio s2 = new Socio(9, "Aladina", LocalDate.of(1968, 10,10));
        Socio s3 = new Socio(23, "Caleb", LocalDate.of(2012, 12,13));
        Socio s4 = new Socio(666, "Lucifer", LocalDate.of(1666, 12,25));
        Socio s5 = new Socio(0, "Adán", LocalDate.of(1000, 5,10));

        // Los metemos en un array
        Socio[] socios = {s1, s2, s3, s4, s5};
        System.out.println("IMPRIMIMOS EL ARRAY SEGÚN HAN ENTRADO LOS ELEMENTOS");
        for (Socio elemento: socios) {
            System.out.println(elemento);
        }

        // AHORA VAMOS A ORDENAR
        // el método sort() de Arrays implementa Comparable
        // no tenemos más que hacer un Arrays.sort() y nos lo
        // ordenará según hayamos escrito en compareTo()
        Arrays.sort(socios);

        System.out.println("\n DESPUÉS DE ORDENAR POR ID");
        for (Socio elemento: socios) {
            System.out.println(elemento);
        }
    }
}
