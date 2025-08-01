package modelo;

import java.util.Date;

public class Venta {
    private Producto producto;
    private Vendedor vendedor;
    private int cantidad;
    private Date fecha;

    public Venta(Producto producto, Vendedor vendedor, int cantidad, Date fecha) {
        this.producto = producto;
        this.vendedor = vendedor;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public double calcularTotal() {
        return producto.getPVP() * cantidad;
    }

    @Override
    public String toString() {
        return cantidad + " x " + producto + " vendido por " + vendedor + " el " + fecha;
    }
}
