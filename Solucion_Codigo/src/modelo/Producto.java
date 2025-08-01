package modelo;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private double costo;
    private int stock;
    private int vendidos;

    public Producto(int id, String nombre, double precio, double costo, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
        this.stock = stock;
        this.vendidos = 0;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public double getCosto() { return costo; }
    public int getStock() { return stock; }
    public int getVendidos() { return vendidos; }

    public void vender(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            vendidos += cantidad;
        } else {
            throw new IllegalArgumentException("Stock insuficiente.");
        }
    }

    @Override
    public String toString() {
        return nombre + " | Precio: $" + precio + " | Stock: " + stock;
    }
}
