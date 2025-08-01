package modelo;

import java.util.List;

public abstract class TiendaLocal extends ActividadEconomica {
    protected Responsable owner;
    protected Vendedor vendedor;
    protected double costoReabastecer;
    protected List<Producto> inventarioPermanente;
    protected List<Producto> inventarioReabastecer;

    public TiendaLocal(List<Producto> inventarioPermanente, Responsable owner, Vendedor vendedor) {
        super("TiendaLocal");
        this.inventarioPermanente = inventarioPermanente;
        this.owner = owner;
        this.vendedor = vendedor;
    }

    public double calcularInventarioTotal() {
        return inventarioPermanente.size() + inventarioReabastecer.size();
    }

    public String mostrarInventario() {
        return inventarioPermanente.toString();
    }

    public void vender(Vendedor vendedor, Producto producto) {
        vendedor.registrarVenta(new Venta(producto, vendedor, 1, new java.util.Date()));
        producto.vender(1);
    }
}
