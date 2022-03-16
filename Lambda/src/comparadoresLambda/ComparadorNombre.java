package comparadoresLambda;

import java.util.Comparator;

public class ComparadorNombre implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Persona p1 = (Persona) o1;
        Persona p2 = (Persona) o2;
        return p1.getNombre().compareTo(p2.getNombre());
    }
}
