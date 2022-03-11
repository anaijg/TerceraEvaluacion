package ejemplos.comparabl;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainComparator {
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

        // Mostrar el arraylist
        System.out.println("MOSTRAMOS LOS ELEMENTOS TAL CUAL ENTRARON");
        imprimirArrayList(socios);

        // pero nosotros queremos ordenar por nombre
        // creamos un objeto de tipo ComparaNombres
        ComparaNombres cn = new ComparaNombres();
        // a continuación, este objeto se lo pasamos al método sort del arraylist
        socios.sort(cn); // con esto el arraylist queda ordenado por nombre
        System.out.println("\nMOSTRAMOS EL ARRAYLIST ORDENADO POR NOMBRE");
        imprimirArrayList(socios);

        // ahora ordenamos por id
        // ya tenemos la clase hecha, ahora creamos un objeto
        ComparaId cId = new ComparaId();
        // y ahora se lo pasamos al método sort
        socios.sort(cId);
        // y ahora imprimimos
        System.out.println("\nMOSTRAMOS EL ARRAYLIST ORDENADO POR ID");
        imprimirArrayList(socios);

        // ordenar por fecha de nacimiento (lo dejamos pendiente)
    }

    private static void imprimirArrayList(ArrayList<Socio> socios) {
        for (Socio elemento: socios) {
            System.out.println(elemento);
        }
    }
}
