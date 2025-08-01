package modelo;

import java.util.List;

public class MercadoFijo extends ActividadEconomica {
    private double costoEspacio;
    private double rotacionProductos;

    public MercadoFijo(String tipo, List<Recurso> recursos, double costoEspacio, double rotacionProductos) {
        super(tipo, recursos);
        this.costoEspacio = costoEspacio;
        this.rotacionProductos = rotacionProductos;
    }

    @Override
    public double calcularGananciaNeta() {
        double ingresos = recursos.stream().mapToDouble(Recurso::getIngreso).sum();
        double costos = recursos.stream().mapToDouble(Recurso::getCosto).sum();
        return ingresos - (costos + costoEspacio);
    }

    @Override
    public double calcularEficiencia() {
        return rotacionProductos; // Puede ser reinterpretado como métrica de eficiencia
    }

    @Override
    public String toString() {
        return "Mercado Fijo - " + super.toString() +
               ", Costo Espacio: $" + costoEspacio +
               ", Rotación: " + rotacionProductos;
    }
}
