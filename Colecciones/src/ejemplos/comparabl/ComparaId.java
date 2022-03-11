package ejemplos.comparabl;

import java.util.Comparator;

public class ComparaId implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Socio s1 = (Socio) o1;
        Socio s2 = (Socio) o2;
        /* if (s1.id < s2.id) {
            return -1;
        } else if (s1.id > s2.id) {
            return 1;
        } else {
            return 0;
        }*/
        // otra forma
        return s1.id - s2.id;
    }
}
