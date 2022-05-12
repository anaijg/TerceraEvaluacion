package AppUniversidad.modelo;

import AppUniversidad.dao.DepartamentoDAO;

public class Asignatura {
    private int id;
    private String nombre;
    private int numHoras;
    private double precio;
    private int departamentoId;


    public Asignatura(int id, String nombre, int numHoras, double precio, int departamentoId) {
        this.id = id;
        this.nombre = nombre;
        this.numHoras = numHoras;
        this.precio = precio;
        this.departamentoId = departamentoId;
    }

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

    public int getNumHoras() {
        return numHoras;
    }
    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }
    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    @Override
    public String toString() {
        return id +
                " - " + nombre +
                ", numHoras=" + numHoras +
                ", precio=" + precio +
                "€, departamento=" + DepartamentoDAO.read(departamentoId).getNombre()  +
                '}';
    }
}
