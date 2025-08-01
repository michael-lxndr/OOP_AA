package controlador;

import modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private List<Producto> productos;

    public ProductoController() {
        productos = new ArrayList<>();
    }

    public void registrarProducto(Producto p) {
        productos.add(p);
    }

    public void actualizarStock(int id, int nuevoStock) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                // Este método debe estar implementado en Producto
                System.out.println("Stock actualizado para producto: " + p);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
