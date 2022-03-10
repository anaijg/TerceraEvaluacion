package ejemplos.comparabl;

import java.util.Comparator;

public class ComparaNombres implements Comparator {


    @Override
    public int compare(Object o1, Object o2) {
        // Empezamos convirtiendo los dos objetos al tipo que queramos
        Socio s1 = (Socio) o1; // convertimos o1 en un socio
        Socio s2 = (Socio) o2; // convertimos o2 en un socio
        // indicamos para este par cuál irá antes en la ordenación
        /*
        • Negativo, si objeto1 va va antes que objeto2.
• Positivo, si objeto 1 va después que objeto2.
• 0, si ambos objetos son iguales.
         */
        if (s1.nombre.compareToIgnoreCase(s2.nombre) < 0)
            return -1;
        else if (s1.nombre.compareToIgnoreCase(s2.nombre) > 0)
            return 1;
        else
            return 0;
    }
}
