package AppUniversidad.modelo;

public class Alumno {
    // Por cada campo en la tabla alumno creamos un atributo del tipo más parecido posible
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;

    // Constructor parametrizado
    public Alumno(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y setters para leer y modificar los atributos privados

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return id + ": " + nombre +
                ", direccion=" + direccion +
                ", telefono=" + telefono + "\n";
    }
}
