package excepciones;

public class OtroEjemploExcepciones{
    public static void main(String[] args) {
        divideDosNúmeros();

    }

    private static void divideDosNúmeros() {
        int a = 5;
        int b = 0;

        if (b == 0) {
          throw new ArithmeticException("Estás dividiendo por 0");
        } else {
            System.out.println(a / b);
        }
    }


}
