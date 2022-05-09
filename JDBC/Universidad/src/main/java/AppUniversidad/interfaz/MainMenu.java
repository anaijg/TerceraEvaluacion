package AppUniversidad.interfaz;

import AppUniversidad.dao.AlumnoDAO;
import AppUniversidad.modelo.Alumno;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opción = 0;
        boolean seguir = true;
        do {
            System.out.println("¿Selecciona una opción: \n1. Dar de alta un alumno\n2. Dar de baja un alumno" +
                    "\n3. Modificar datos de un alumno\n4. Consultar datos de un alumno\n0. Salir");
            try {
                opción = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("El tipo de dato introducido no es un número entero."); // TERMINAR ESTO BIEN PORQUE NO ESTÁ DEL TODO BIEN
                System.out.println(e.getMessage());
            }

            switch (opción) {
                case 1: // dar de alta un alumno
                    darDeAlta();
                    break;
                case 2: // dar de baja un alumno
                    darDeBaja();
                    break;
                case 3: // modificar datos
                    modificarDatos();
                    break;
                case 4: // consultar datos
                    consultarDatos();
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opción != 0);
    }

    private static void consultarDatos() {
        System.out.println("id del alumno a consultar");
        int id = sc.nextInt();
        sc.nextLine();
        // como el método read devuelve un alumno, lo recogemos y después lo imprimimos
        Alumno alumno2 = AlumnoDAO.read(id);
        System.out.println(alumno2);
    }

    private static void modificarDatos() {
        // tenemos que saber qué alumno queremos modificar
        System.out.println("id del alumno a modificar:");
        int id = sc.nextInt();
        sc.nextLine();
        Alumno alumno1 = AlumnoDAO.read(id);
        // tenemos que pasarle al método un alumno con los datos ya modificados
        System.out.println("¿Qué datos quieres modificar?\n(N) Nombre\n(D) Dirección\n(T) Teléfono");
        char c = sc.nextLine().toUpperCase().charAt(0);
        if (c == 'N') {
            System.out.println("Nuevo nombre: ");
            String nombre = sc.nextLine();
            alumno1.setNombre(nombre);
        } else if(c == 'D') {
            System.out.println("Nueva dirección: ");
            String direccion = sc.nextLine();
            alumno1.setDireccion(direccion);
        } else if (c == 'T') {
            System.out.println("Nuevo teléfono: ");
            String telefono = sc.nextLine();
            alumno1.setTelefono(telefono);
        } else {
            System.out.println("Opción incorrecta");
        }
        AlumnoDAO.update(alumno1);
    }

    private static void darDeBaja() {
        System.out.println("id del alumno a dar de baja:");
        int id = sc.nextInt();
        sc.nextLine();
        AlumnoDAO.delete(id);
    }

    private static void darDeAlta() {
        // ¿qué id le ponemos?
        int id = AlumnoDAO.obtenerUltimoId();
        id = id + 1; // lo incrementamos en una unidad para el alumno que vamos a dar de alta
        System.out.println("Datos del alumno");
        System.out.println("================");
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Direccion");
        String direccion = sc.nextLine();
        System.out.println("Telefono");
        String telefono = sc.nextLine();
        // ya tengo todos los datos del alumno; como al método create le tengo que pasar un alumno:
        Alumno alumno = new Alumno(id, nombre, direccion, telefono);
        AlumnoDAO.create(alumno);
    }
}
