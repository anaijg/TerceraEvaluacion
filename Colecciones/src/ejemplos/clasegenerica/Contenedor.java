package ejemplos.clasegenerica;

/*
Por ejemplo, queremos definir la clase Contenedor, que permite guardar un solo objeto
de cualquier tipo. Tendrá un atributo objeto del tipo que metamos por parámetro, y
dos métodos: guardar() y extraer():
 */
public class Contenedor<T> {
    T objeto; // este es el atributo, se llama objeto y es de tipo T

    public Contenedor() {
    }

    void setObjeto(T nuevo) { // es como si fuera un set
        this.objeto = nuevo;
    }

    T getObjeto() {
        return objeto;
    }

    // el método extraer devuelve el objeto guardado
    // y lo elimina
    T extraer() {
        T aux = objeto; // guardo el objeto en una variable auxiliar
        this.objeto = null; // elimino el objeto
        return aux; // devuelvo el valor del objeto que he eliminado
    }
}
