package controlador;

import modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private List<Producto> productos;

    public ProductoController() {
        this.productos = new ArrayList<>();
    }

    public void registrarProducto(Producto producto) {
        productos.add(producto);
    }

    public void actualizarStock(int id, int nuevoStock) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                System.out.println("Actualizando stock de: " + p.getNombre());
                // NOTA: en este diseño el stock se manipula directamente desde Producto
                break;
            }
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
