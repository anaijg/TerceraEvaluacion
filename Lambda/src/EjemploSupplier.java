import java.util.function.Supplier;

public class EjemploSupplier {
    public static void main(String[] args) {
        // vamos a hacer un supplier que genera un número aleatorio
        Supplier<Integer> numeroRandom = () -> (int) (Math.random() * 10 + 1);
        System.out.println(numeroRandom.get());
    }
}
