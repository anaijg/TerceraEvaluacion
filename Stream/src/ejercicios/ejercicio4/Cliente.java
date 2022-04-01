package ejercicios.ejercicio4;

import java.time.LocalDate;

public class Cliente {
    String dni;
    String nombre;
    LocalDate fechaNacimiento;

    public Cliente(String dni, String nombre, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return dni + "\t" +
                nombre + "\t" +
                fechaNacimiento.getDayOfMonth() +
                "\\" + fechaNacimiento.getMonthValue() +
                "\\" + fechaNacimiento.getYear();
    }
}
