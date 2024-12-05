package model;

import util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabitanteDAO {

    // Método para registrar un habitante
    public boolean registrarHabitante(String nombre, int edad, String sexo, String actividad, int idVivienda) {
        String sql = "INSERT INTO Habitantes (nombre, edad, sexo, act_eco, id_vivienda) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setInt(2, edad);
            stmt.setString(3, sexo);
            stmt.setString(4, actividad);
            stmt.setInt(5, idVivienda);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener un habitante por ID
    public Habitante obtenerHabitantePorId(int id) {
        String sql = "SELECT * FROM Habitantes WHERE id_habitante = ?";
        Habitante habitante = null;

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                habitante = new Habitante(
                        rs.getInt("id_habitante"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("sexo"),
                        rs.getString("act_eco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return habitante;
    }

    // Método para actualizar un habitante
    public boolean actualizarHabitante(int id, String nombre, int edad, String sexo, String actividad) {
        String sql = "UPDATE Habitantes SET nombre = ?, edad = ?, sexo = ?, act_eco = ? WHERE id_habitante = ?";

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setInt(2, edad);
            stmt.setString(3, sexo);
            stmt.setString(4, actividad);
            stmt.setInt(5, id);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un habitante por ID
    public boolean eliminarHabitante(int id) {
        String sql = "DELETE FROM Habitantes WHERE id_habitante = ?";

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar todos los habitantes de una vivienda
    public boolean eliminarHabitantesPorVivienda(int idVivienda) {
        String sql = "DELETE FROM Habitantes WHERE id_vivienda = ?";

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

    // Método para obtener los habitantes por ID de vivienda
    public List<Habitante> obtenerHabitantesPorVivienda(int idVivienda) {
        List<Habitante> habitantes = new ArrayList<>();
        String sql = "SELECT id_habitante, nombre, edad, sexo, act_eco " +
                     "FROM Habitantes WHERE id_vivienda = ?";

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVivienda);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Habitante habitante = new Habitante(
                        rs.getInt("id_habitante"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("sexo"),
                        rs.getString("act_eco")
                    );
                    habitantes.add(habitante);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return habitantes;
    }
}
