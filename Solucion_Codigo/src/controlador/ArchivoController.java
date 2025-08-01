package controlador;

import modelo.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoController {

    public void guardarProductos(String path, List<Producto> productos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            for (Producto p : productos) {
                writer.println(p.getId() + "," + p.getNombre() + "," + p.getPrecio() + "," + p.getCosto() + "," + p.getStock());
            }
            System.out.println("Productos guardados en: " + path);
        } catch (IOException e) {
            System.err.println("Error al guardar productos: " + e.getMessage());
        }
    }

    public List<Producto> cargarProductos(String path) {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                double costo = Double.parseDouble(datos[3]);
                int stock = Integer.parseInt(datos[4]);
                productos.add(new Producto(id, nombre, precio, costo, stock));
            }
            System.out.println("Productos cargados desde: " + path);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar productos: " + e.getMessage());
        }
        return productos;
    }
}
