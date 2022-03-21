package filtrosLambda;

// tendríamos que crear otra clase para apellidos
// y otra clase para edad
public class FiltroPersonaNombre implements FiltroPersona{
    private String nombre;

    public FiltroPersonaNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean test(Persona p) {
        return p.getNombre().equals(nombre); // este método hace lo que hacía el método que hemos visto
        // es más resumido que el if que hay en los apuntes
    }


}
