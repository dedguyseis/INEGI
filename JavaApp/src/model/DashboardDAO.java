package model;

import util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DashboardDAO {

    public List<DashboardData> obtenerPoblacionPorLocalidad() {
        List<DashboardData> data = new ArrayList<>();
        String sql = """
            SELECT 
                m.nombre AS municipio, 
                l.nombre AS localidad, 
                COUNT(h.id_habitante) AS poblacion
            FROM 
                Municipios m
            JOIN 
                Localidades l ON m.id_municipio = l.id_municipio
            JOIN 
                Viviendas v ON l.id_localidad = v.id_localidad
            JOIN 
                Habitantes h ON v.id_vivienda = h.id_vivienda
            GROUP BY 
                m.nombre, l.nombre
            ORDER BY 
                m.nombre, l.nombre;
        """;

        try (Connection conn = ConexionDB.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                data.add(new DashboardData(
                        rs.getString("municipio"),
                        rs.getString("localidad"),
                        rs.getInt("poblacion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
