package controlador;

import modelo.PuntoComercial;

import java.sql.*;
import java.util.List;

public class DBController {
    private final String url = "jdbc:sqlite:comercio.db";

    public void guardarEnDB(List<PuntoComercial> puntos) {
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS puntos (id INTEGER PRIMARY KEY, nombre TEXT, ubicacion TEXT)");

            for (PuntoComercial p : puntos) {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO puntos(id, nombre, ubicacion) VALUES (?, ?, ?)");
                ps.setInt(1, p.getId());
                ps.setString(2, p.getNombre());
                ps.setString(3, p.getUbicacion());
                ps.executeUpdate();
            }

            System.out.println("Datos guardados en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cargarDesdeDB(List<PuntoComercial> puntos) {
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM puntos");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String ubicacion = rs.getString("ubicacion");
                puntos.add(new PuntoComercial(id, nombre, ubicacion, null, null)); // se debe construir con tipo y horario reales
            }

            System.out.println("Datos cargados desde la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
