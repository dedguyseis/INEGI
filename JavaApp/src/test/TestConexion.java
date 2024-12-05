package test;

import model.LocalidadDAO;
import model.MunicipioDAO;
import util.ConexionDB;

import java.sql.Connection;
import java.util.List;

public class TestConexion {
    public static void main(String[] args) {
        // Probar conexión a la base de datos
        System.out.println("Probando conexión...");
        Connection conexion = ConexionDB.getInstancia().getConexion();
        if (conexion != null) {
            System.out.println("Conexión exitosa.");
        } else {
            System.out.println("Error al conectar a la base de datos.");
            return; // Salir si la conexión falla
        }

        // Probar MunicipioDAO
        System.out.println("\nProbando MunicipioDAO...");
        MunicipioDAO municipioDAO = new MunicipioDAO();
        List<String> municipios = municipioDAO.obtenerMunicipios();
        if (!municipios.isEmpty()) {
            System.out.println("Municipios encontrados:");
            for (String municipio : municipios) {
                System.out.println("- " + municipio);
            }
        } else {
            System.out.println("No se encontraron municipios en la base de datos.");
        }

        // Probar LocalidadDAO
        System.out.println("\nProbando LocalidadDAO...");
        LocalidadDAO localidadDAO = new LocalidadDAO();
        if (!municipios.isEmpty()) {
            String municipio = municipios.get(2); // Tomar el primer municipio como ejemplo
            System.out.println("Buscando localidades para el municipio: " + municipio);
            List<String> localidades = localidadDAO.obtenerLocalidadesPorMunicipio(municipio);
            if (!localidades.isEmpty()) {
                System.out.println("Localidades encontradas:");
                for (String localidad : localidades) {
                    System.out.println("- " + localidad);
                }
            } else {
                System.out.println("No se encontraron localidades para el municipio: " + municipio);
            }
        } else {
            System.out.println("No se pueden probar localidades porque no hay municipios.");
        }

        // Cerrar conexión para finalizar
        ConexionDB.getInstancia().cerrarConexion();
        System.out.println("\nConexión cerrada correctamente.");
    }
}
