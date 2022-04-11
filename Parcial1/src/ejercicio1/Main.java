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

        System.out.println("1.3. Lista de empleados:");
        System.out.println("======================");
        Iterator<Empleado> iterator = empleados.iterator();
        while (iterator.hasNext()) {
            iterator.next().mostrarEmpleado();
        }
        //empleados.stream().forEach(empleado -> empleado.mostrarEmpleado());
        System.out.println("\n1.4. Empleados ordenados por nombre: ");
        System.out.println("=======================================");
        empleados.stream().sorted((e1, e2) -> e1.getNombre().compareTo(e2.getNombre())).forEach(empleado -> empleado.mostrarEmpleado());
        System.out.println("\n1.5. Empleados ordenados por id (orden inverso)");
        System.out.println("============================================");
        empleados.stream().sorted((e1, e2) -> e2.getId() - e1.getId()).forEach(empleado -> empleado.mostrarEmpleado());

        /* ESTO AL FINAL NO ENTRÓ
         System.out.println("\n1.6. Directores y responsables ordenados por puesto:");

        System.out.println("=====================================================");
        empleados.stream()
                .filter(empleado -> empleado.getPuesto().startsWith("Director") || empleado.getPuesto().startsWith("Responsable"))
                .forEach(empleado -> empleado.mostrarEmpleado());
    */
    }


}
