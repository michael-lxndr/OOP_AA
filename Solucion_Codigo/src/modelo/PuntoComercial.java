package modelo;

import java.util.List;

public class PuntoComercial {
    private int id;
    private String nombre;
    private String ubicacion;
    private ActividadEconomica tipoComercio;
    private List<Producto> productos;
    private List<Vendedor> vendedores;

    public PuntoComercial(int id, String nombre, String ubicacion, ActividadEconomica tipoComercio, List<Producto> productos, List<Vendedor> vendedores) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipoComercio = tipoComercio;
        this.productos = productos;
        this.vendedores = vendedores;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public List<Producto> getProductos() { return productos; }
    public List<Vendedor> getVendedores() { return vendedores; }

    public ActividadEconomica getTipoComercio() { return tipoComercio; }

    @Override
    public String toString() {
        return "Punto Comercial: " + nombre + " (" + tipoComercio.getClass().getSimpleName() + ") en " + ubicacion;
    }
}
