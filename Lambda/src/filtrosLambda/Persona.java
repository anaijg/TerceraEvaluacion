package filtrosLambda;

public class Persona {
    // Atributos
    String nombre;
    String apellido;
    int edad;

    // Constructor
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    // ToString
    @Override
    public String toString() { return nombre + " " + apellido + " (" + edad + ")"; }
}