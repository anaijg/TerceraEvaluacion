package ejercicio3;

public class Persona {
    String DNI;
    String nombre;
    String apellido1;
    String apellido2;
    String direccion;
    String ciudad;
    String cp;
    String telefono;
    String fechaNac;

    public Persona(String DNI, String nombre, String apellido1, String apellido2, String direccion, String ciudad, String cp, String telefono, String fechaNac) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.cp = cp;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
    }

}
