package model;

import util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalidadDAO {

    // Método para obtener localidades por municipio
    public List<String> obtenerLocalidadesPorMunicipio(String municipio) {
        List<String> localidades = new ArrayList<>();
        String sql = """
            SELECT l.nombre
            FROM Localidades l
            JOIN Municipios m ON l.id_municipio = m.id_municipio
            WHERE m.nombre = ?
        """;

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, municipio);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                localidades.add(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return localidades;
    }

    // Método para obtener el ID de una localidad por su nombre
    public int obtenerIdLocalidadPorNombre(String nombreLocalidad) {
        String sql = "SELECT id_localidad FROM Localidades WHERE nombre = ?";
        int idLocalidad = -1;

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreLocalidad);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idLocalidad = rs.getInt("id_localidad");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idLocalidad;
    }

    // Método para obtener el nombre de una localidad por su ID
    public String obtenerNombreLocalidadPorId(int idLocalidad) {
        String sql = "SELECT nombre FROM Localidades WHERE id_localidad = ?";
        String nombreLocalidad = null;

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idLocalidad);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nombreLocalidad = rs.getString("nombre");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombreLocalidad;
    }

    // Método para obtener todas las localidades
    public List<String> obtenerTodasLasLocalidades() {
        List<String> localidades = new ArrayList<>();
        String sql = "SELECT nombre FROM Localidades";

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                localidades.add(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return localidades;
    }

    // Método para obtener el ID del municipio por su nombre
    public int obtenerIdMunicipioPorNombre(String nombreMunicipio) {
        String sql = "SELECT id_municipio FROM Municipios WHERE nombre = ?";
        int idMunicipio = -1;

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreMunicipio);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idMunicipio = rs.getInt("id_municipio");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idMunicipio;
    }
}
