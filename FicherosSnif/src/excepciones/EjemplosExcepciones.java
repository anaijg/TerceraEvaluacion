package excepciones;

public class EjemplosExcepciones {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        // dividir por 0 hace que salte una excepción
        // lo que tenemos que hacer es manejarla
       try { // dentro del bloque try ponemos el código que puede generar la excepción
           System.out.println(a/b); //--> esta lanza la ArithmeticException; salta de aquí al catch
           //int[] array = new int[5]; // lanza la excepción NegativeArraySizeException
        } catch (ArithmeticException excepción) { // si queremos especificar el tipo de excepción, la especificamos
           // aquí ponemos lo que queremos que haga en caso de que salte la excepción
           // normalmente, mostrar un mensaje de error
           System.out.println("Ha ocurrido un error");
            System.out.println(excepción.getMessage()); // / by zero
           excepción.printStackTrace();

           //excepción.printStackTrace();
        } catch (Exception e) {
           System.out.println("Ha ocurrido un error. " + e.getMessage());
       } finally { // este bloque de código se va a ejecutar en cualquier caso, tanto si salta una excepción como si no
           System.out.println("FIN. Ha finalizado la tarea");
       }





    }
}
