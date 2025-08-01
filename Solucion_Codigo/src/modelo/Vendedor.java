package modelo;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private int id;
    private String nombre;
    private List<RegistroVenta> ventas;

    public Vendedor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.ventas = new ArrayList<>();
    }

    public void registrarVenta(RegistroVenta venta) {
        ventas.add(venta);
    }

    public List<RegistroVenta> getVentas() {
        return ventas;
    }

    @Override
    public String toString() {
        return "Vendedor: " + nombre + " | Ventas realizadas: " + ventas.size();
    }
}
