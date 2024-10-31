package controlador;
import util.DatabaseConnection;
import modelo.Habitante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitanteController {
    public List<Habitante> obtenerHabitantes() throws SQLException {
        List<Habitante> habitantes = new ArrayList<>();
        Connection conn = DatabaseConnection.getInstance().getConnection();

        String sql = "SELECT * FROM habitantes";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Habitante habitante = new Habitante(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getInt("edad"),
                rs.getInt("vivienda_id")
            );
            habitantes.add(habitante);
        }
        conn.close();
        return habitantes;
    }

    public void agregarHabitante(Habitante habitante) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();

        String sql = "INSERT INTO habitantes (nombre, edad, vivienda_id) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, habitante.getNombre());
        pstmt.setInt(2, habitante.getEdad());
        pstmt.setInt(3, habitante.getViviendaId());
        pstmt.executeUpdate();
        conn.close();
    }

    public void actualizarHabitante(Habitante habitante) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();

        String sql = "UPDATE habitantes SET nombre = ?, edad = ?, vivienda_id = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, habitante.getNombre());
        pstmt.setInt(2, habitante.getEdad());
        pstmt.setInt(3, habitante.getViviendaId());
        pstmt.setInt(4, habitante.getId());
        pstmt.executeUpdate();
        conn.close();
    }

    public void eliminarHabitante(int id) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();

        String sql = "DELETE FROM habitantes WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        conn.close();
    }
}
