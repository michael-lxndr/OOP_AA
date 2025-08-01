package modelo;

import java.util.Date;

public class RegistroVenta {
    private Producto producto;
    private int cantidad;
    private Date fecha;

    public RegistroVenta(Producto producto, int cantidad, Date fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.producto.vender(cantidad);
    }

    public double calcularTotal() {
        return cantidad * producto.getPrecio();
    }

    @Override
    public String toString() {
        return "Venta de " + cantidad + " x " + producto.getNombre() + " el " + fecha + " | Total: $" + calcularTotal();
    }
}
