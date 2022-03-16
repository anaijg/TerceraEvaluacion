public class Main {
    public static void main(String[] args) {
        //n -> n % 2 != 0; // coge n y comprueba si n es impar
        //(Character c) -> c == 'y'; // recibe un carácter y comprueba si es 'y'
        //(x, y) -> x + y; // recibe dos números y los suma
        //(int a, int b ) -> a * a + b * b; // recibe dos números suma sus cuadrados
        //() -> 42; // simplemente devuelve el número 42
        //() -> return 3.14; // devuelve Pi
        //(String s) -> { System.out.println(s); }; // recibe un String y lo imprime
        //() -> { System.out.println("¡Hola mundo!"); }; // imprime "Hola, mundo"

        // Vamos a instanciar la interfaz HolaMundo
        // (me salto el paso de crear una clase que la implemente)
        HolaMundo hm = new HolaMundo() {
            @Override
            public void imprimeHolaMundo() { // me crea una clase anónima y me obliga a desarrollar su método
                System.out.println("Hola, mundo");
            }
        };

        // ya tengo un "objeto". Para utilizarlo, llamo al método a través de él
        hm.imprimeHolaMundo();

        // Vamos a instanciarla otra vez, pero esta vez con una expresión lambda
        HolaMundo hm2 = () -> System.out.println("Hola, mundo otra vez");
        hm2.imprimeHolaMundo();

        // Ahora la expresión 4
        SumaCuadrados sc = (int a, int b) -> a * a + b * b;
        int resultado = sc.sumarCuadrados(4,3);
        System.out.println(resultado);
    }
}
