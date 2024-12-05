package model;

import util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MunicipioDAO {

    // Método para obtener todos los municipios (poblar combo)
    public List<String> obtenerMunicipios() {
        List<String> municipios = new ArrayList<>();
        String sql = "SELECT nombre FROM Municipios";

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                municipios.add(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return municipios;
    }

    // Método para obtener el ID de un municipio por su nombre
    public int obtenerIdMunicipio(String nombreMunicipio) {
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

    // Método para obtener el ID de un municipio por su nombre (agregado)
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
