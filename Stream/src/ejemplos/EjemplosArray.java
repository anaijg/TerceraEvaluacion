package ejemplos;

import java.util.Arrays;
import java.util.stream.Stream;

public class EjemplosArray {
    public static void main(String[] args) {
        String[] frutas = {"mora", "naranja", "níspero", "pera",
                "plátano","pomelo", "sandía", "melón", "uva", "piña", "melocotón"};

        Stream<String> streamArray = Arrays.stream(frutas);
        // lo imprimo
        streamArray.forEach(elemento -> System.out.print(elemento + " "));
        System.out.println("\nFiltrado");
        Arrays.stream(frutas).filter(cadena -> cadena.contains("a")).forEach(elemento -> System.out.print(elemento + " "));
    }
}
