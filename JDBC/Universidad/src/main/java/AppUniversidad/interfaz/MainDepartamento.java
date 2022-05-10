package AppUniversidad.interfaz;

import AppUniversidad.dao.DepartamentoDAO;
import AppUniversidad.modelo.Departamento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainDepartamento {
    public static void main(String[] args) {
        // creamos un mapa
        Map<Integer, String> departamentos = new HashMap<>();
        // le añadimos los pares clave-valor
        departamentos.put(1, "Arquitectura y Tecnología de Sistemas Informáticos");
        departamentos.put(2, "Inteligencia Artificial");
        departamentos.put(3, "Lenguajes y Sistemas Informáticos e Ingeniería del Software");
        departamentos.put(4, "Matemática aplicada a las Tecnologías de la Información y de la Comunicación");

        // tenemos que extraer los elementos del mapa para crear objetos de tipo Departamento
        List<Integer> id = departamentos.keySet().stream().toList(); // el método keySet nos devuelve el conjunto de claves del mapa
        List<String> nombres = departamentos.values().stream().toList(); // el método values() nos extrae los valores del mapa

        for (int i = 0; i < id.size(); i++) {
            // creamos un objeto cogiendo el id de una lista y el nombre de otra
            Departamento departamento = new Departamento((id.get(i)), nombres.get(i));
            // esto lo tenemos que cargar en la tabla departamento
            //DepartamentoDAO.create(departamento);
        }


        // obtenemos el departamento con id = 3
        Departamento departamento = DepartamentoDAO.read(3);
        System.out.println(departamento);

    }
}
