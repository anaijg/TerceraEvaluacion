package ejercicio1;

public class Empleado {
    private int id;
    private String nombre;
    private String puesto;

    public Empleado(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + puesto;
    }

    public void mostrarEmpleado() {
        System.out.println(this.toString());
    }
}
