package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "Gregorio Antúnez", "Director gerente"));
        empleados.add(new Empleado(2, "Victoria de la Vega", "Directora de marketing"));
        empleados.add(new Empleado(3, "Mónica Salazar", "Subdirectora de marketing"));
        empleados.add(new Empleado(4, "Mari Carmen Cañizares", "Secretaria"));
        empleados.add(new Empleado(5, "Julián Palacios", "Responsable de compras"));
        empleados.add(new Empleado(6, "Jesús Quesada", "Responsable de ventas"));
        empleados.add(new Empleado(7, "Bernardo Marín", "Contabilidad"));
        empleados.add(new Empleado(8, "Nacha Ruiz", "Administrativa"));
        empleados.add(new Empleado(9, "Arturo Cañas", "Chófer"));

        System.out.println("Lista de empleados");
        System.out.println("==================");
        /*
        3. (0,6 puntos) Muestra sus datos utilizando un iterador para moverte por la lista llamando al método
mostrarEmpleado().
         */
        Iterator<Empleado> it = empleados.iterator();
        while (it.hasNext()) {
            Empleado e = it.next();
            e.mostrarEmpleado();
        }

        /*
        4. (0,6 puntos) Utilizando un stream, tuberías y los lambdas que sean necesarios, muestra los empleados
ordenados por nombre.
         */
        System.out.println("\nOrdenados por nombre:");
        System.out.println("=======================");
        empleados.stream().sorted((e1, e2) -> e1.getNombre().compareTo(e2.getNombre()))
                .forEach(empleado -> empleado.mostrarEmpleado());

    /*
    5. (0,6 puntos) Utilizando un stream, tuberías y los lambdas que sean necesarios, muestra los empleados
ordenados por id en orden inverso.
     */
        System.out.println("\nOrdenados por id inverso:");
        System.out.println("==========================");
        empleados.stream().sorted((e1, e2) -> e2.getId() - e1.getId())
                .forEach(empleado -> empleado.mostrarEmpleado());
    }
}
