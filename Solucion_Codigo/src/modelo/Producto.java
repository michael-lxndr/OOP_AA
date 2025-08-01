package modelo;

public class Producto extends Recurso {
    private int id;
    private String nombre;
    private double pvp;
    private int stock;

    public Producto(int id, String nombre, double pvp, double costo, int stock) {
        super(nombre, costo);
        this.id = id;
        this.nombre = nombre;
        this.pvp = pvp;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPVP() {
        return pvp;
    }

    public int getStock() {
        return stock;
    }

    public void vender(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
        } else {
            throw new IllegalArgumentException("Stock insuficiente para vender " + cantidad + " unidades.");
        }
    }

    public void setStock(int nuevoStock) {
        this.stock = nuevoStock;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ", Stock: " + stock + ", PVP: $" + pvp + ")";
    }
}
