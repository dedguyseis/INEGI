package controlador;
import util.DatabaseConnection;
import modelo.ActividadEconomica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActividadEconomicaController {
    public List<ActividadEconomica> obtenerActividades() throws SQLException {
        List<ActividadEconomica> actividades = new ArrayList<>();
        Connection conn = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM actividades_economicas";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            ActividadEconomica actividad = new ActividadEconomica(
                rs.getInt("id"),
                rs.getString("descripcion")
            );
            actividades.add(actividad);
        }
        conn.close();
        return actividades;
    }

    public void agregarActividad(ActividadEconomica actividad) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO actividades_economicas (descripcion) VALUES (?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, actividad.getDescripcion());
        pstmt.executeUpdate();
        conn.close();
    }

    public void actualizarActividad(ActividadEconomica actividad) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE actividades_economicas SET descripcion = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, actividad.getDescripcion());
        pstmt.setInt(2, actividad.getId());
        pstmt.executeUpdate();
        conn.close();
    }

    public void eliminarActividad(int id) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM actividades_economicas WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        conn.close();
    }
}
