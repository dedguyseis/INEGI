package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConexionDB;

public class UsuarioDAO {

    public boolean validarUsuario(Usuario usuario) {
        String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND contraseña = ?";
        try (Connection conn = ConexionDB.getInstancia().getConexion();  // Cambiado aquí
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContraseña());
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Si hay resultados, el usuario es válido
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

