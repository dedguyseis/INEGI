package model;

import util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViviendaDAO {

    public int registrarVivienda(String direccion, int idLocalidad, String tipoVivienda, int idMunicipio) {
        String sql = "INSERT INTO Viviendas (direccion, id_localidad, tipo_vivienda, id_municipio) VALUES (?, ?, ?, ?)";
        int idVivienda = -1;

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, direccion);
            stmt.setInt(2, idLocalidad);
            stmt.setString(3, tipoVivienda);
            stmt.setInt(4, idMunicipio);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    idVivienda = rs.getInt(1); // Obtener el ID generado
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idVivienda;
    }

    public List<Vivienda> obtenerTodasLasViviendas() {
        List<Vivienda> viviendas = new ArrayList<>();
        String sql = "SELECT v.id_vivienda, v.direccion, v.tipo_vivienda, l.nombre AS localidad, m.nombre AS municipio " +
                     "FROM Viviendas v " +
                     "JOIN Localidades l ON v.id_localidad = l.id_localidad " +
                     "JOIN Municipios m ON l.id_municipio = m.id_municipio";

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Vivienda vivienda = new Vivienda(
                    rs.getInt("id_vivienda"),
                    rs.getString("direccion"),
                    rs.getString("tipo_vivienda"),
                    rs.getString("localidad"),
                    rs.getString("municipio")
                );
                viviendas.add(vivienda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viviendas;
    }

    public Vivienda obtenerViviendaPorId(int idVivienda) {
        String sql = "SELECT v.id_vivienda, v.direccion, v.tipo_vivienda, l.nombre AS localidad, m.nombre AS municipio " +
                     "FROM Viviendas v " +
                     "JOIN Localidades l ON v.id_localidad = l.id_localidad " +
                     "JOIN Municipios m ON l.id_municipio = m.id_municipio " +
                     "WHERE v.id_vivienda = ?";
        Vivienda vivienda = null;

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVivienda);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vivienda = new Vivienda(
                        rs.getInt("id_vivienda"),
                        rs.getString("direccion"),
                        rs.getString("tipo_vivienda"),
                        rs.getString("localidad"),
                        rs.getString("municipio")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vivienda;
    }

    public boolean actualizarVivienda(int idVivienda, String direccion, String tipoVivienda, int idLocalidad) {
        String sql = "UPDATE Viviendas SET direccion = ?, tipo_vivienda = ?, id_localidad = ? WHERE id_vivienda = ?";

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, direccion);
            stmt.setString(2, tipoVivienda);
            stmt.setInt(3, idLocalidad);
            stmt.setInt(4, idVivienda);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int obtenerIdLocalidadPorNombre(String nombreLocalidad) {
        String sql = "SELECT id_localidad FROM Localidades WHERE nombre = ?";
        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreLocalidad);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_localidad");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retornar -1 si no se encuentra la localidad
    }

    // Nuevo método: Eliminar una vivienda por ID
    public boolean eliminarVivienda(int idVivienda) {
        String sql = "DELETE FROM Viviendas WHERE id_vivienda = ?";

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVivienda);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
