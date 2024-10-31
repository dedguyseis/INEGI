package test;

import controlador.ActividadEconomicaController;
import modelo.ActividadEconomica;
import java.sql.SQLException;

public class TestCRUD {
    public static void main(String[] args) {
        ActividadEconomicaController actividadController = new ActividadEconomicaController();

        try {
            // Crear una nueva actividad económica
            ActividadEconomica nuevaActividad = new ActividadEconomica(0, "Comercio");
            actividadController.agregarActividad(nuevaActividad);
            System.out.println("Actividad económica creada");

            // Leer todas las actividades económicas
            System.out.println("Lista de actividades económicas:");
            actividadController.obtenerActividades().forEach(System.out::println);

            // Actualizar actividad económica
            nuevaActividad.setDescripcion("Comercio Actualizado");
            actividadController.actualizarActividad(nuevaActividad);
            System.out.println("Actividad económica actualizada");

            // Eliminar actividad económica
            actividadController.eliminarActividad(nuevaActividad.getId());
            System.out.println("Actividad económica eliminada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
