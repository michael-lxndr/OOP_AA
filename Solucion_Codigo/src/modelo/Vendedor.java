package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Vendedor extends Persona {
    protected List<Venta> ventas;

    public Vendedor(int id, String nombre) {
        super(id, nombre);
        this.ventas = new ArrayList<>();
    }

    public void registrarVenta(Venta venta) {
        ventas.add(venta);
    }

    public List<Venta> getVentas() {
        return ventas;
    }
}
