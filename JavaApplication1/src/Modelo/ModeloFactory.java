package modelo;

public class ModeloFactory {
    public static Object createModel(String modelType, Object... args) {
        switch (modelType.toLowerCase()) {
            case "actividad":
                // Crear una instancia de ActividadEconomica con id y descripcion
                return new ActividadEconomica((int) args[0], (String) args[1]);
            case "habitante":
                // Crear una instancia de Habitante con id, nombre, edad y viviendaId
                return new Habitante((int) args[0], (String) args[1], (int) args[2], (int) args[3]);
            case "vivienda":
                // Crear una instancia de Vivienda con id, tipo, localidad y municipio
                return new Vivienda((int) args[0], (String) args[1], (String) args[2], (String) args[3]);
            default:
                throw new IllegalArgumentException("Tipo de modelo no soportado: " + modelType);
        }
    }
}
