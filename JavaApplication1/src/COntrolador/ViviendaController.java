package controlador;

import util.DatabaseConnection;
import modelo.Vivienda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViviendaController {
    public List<Vivienda> obtenerViviendas() throws SQLException {
        List<Vivienda> viviendas = new ArrayList<>();
        Connection conn = DatabaseConnection.getInstance().getConnection();

        String sql = "SELECT * FROM viviendas";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Vivienda vivienda = new Vivienda(
                rs.getInt("id"),
                rs.getString("tipo"),
                rs.getString("localidad"),
                rs.getString("municipio")
            );
            viviendas.add(vivienda);
        }
        conn.close();
        return viviendas;
    }

    public void agregarVivienda(Vivienda vivienda) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();

        String sql = "INSERT INTO viviendas (tipo, localidad, municipio) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vivienda.getTipo());
        pstmt.setString(2, vivienda.getLocalidad());
        pstmt.setString(3, vivienda.getMunicipio());
        pstmt.executeUpdate();
        conn.close();
    }

    public void actualizarVivienda(Vivienda vivienda) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();

        String sql = "UPDATE viviendas SET tipo = ?, localidad = ?, municipio = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vivienda.getTipo());
        pstmt.setString(2, vivienda.getLocalidad());
        pstmt.setString(3, vivienda.getMunicipio());
        pstmt.setInt(4, vivienda.getId());
        pstmt.executeUpdate();
        conn.close();
    }

    public void eliminarVivienda(int id) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();

        String sql = "DELETE FROM viviendas WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        conn.close();
    }
}

