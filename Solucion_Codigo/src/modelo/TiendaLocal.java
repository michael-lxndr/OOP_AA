package modelo;

import java.util.List;

public class TiendaLocal extends ActividadEconomica {
    private List<Producto> inventarioPermanente;

    public TiendaLocal(String tipo, List<Recurso> recursos, List<Producto> inventarioPermanente) {
        super(tipo, recursos);
        this.inventarioPermanente = inventarioPermanente;
    }

    @Override
    public double calcularGananciaNeta() {
        double ingresos = inventarioPermanente.stream().mapToDouble(p -> p.getPrecio() * p.getStock()).sum();
        double costos = inventarioPermanente.stream().mapToDouble(p -> p.getCosto() * p.getStock()).sum();
        return ingresos - costos;
    }

    @Override
    public double calcularEficiencia() {
        int vendidos = inventarioPermanente.stream().mapToInt(Producto::getVendidos).sum();
        int disponibles = inventarioPermanente.stream().mapToInt(Producto::getStock).sum();
        return disponibles == 0 ? 0 : (vendidos / (double) disponibles) * 100;
    }

    @Override
    public String toString() {
        return "Tienda Local - " + super.toString();
    }
}
