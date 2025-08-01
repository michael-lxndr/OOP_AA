package modelo;

import java.util.List;

public class FeriaItinerante extends ActividadEconomica {
    private double costoTransporte;
    private double costoInstalacion;

    public FeriaItinerante(String tipo, List<Recurso> recursos, double costoTransporte, double costoInstalacion) {
        super(tipo, recursos);
        this.costoTransporte = costoTransporte;
        this.costoInstalacion = costoInstalacion;
    }

    @Override
    public double calcularGananciaNeta() {
        double ingresos = recursos.stream().mapToDouble(Recurso::getIngreso).sum();
        double costos = recursos.stream().mapToDouble(Recurso::getCosto).sum();
        return ingresos - (costos + costoTransporte + costoInstalacion);
    }

    @Override
    public double calcularEficiencia() {
        return 0; // Implementar lógica de productos vendidos / disponibles si aplica
    }

    @Override
    public String toString() {
        return "Feria Itinerante - " + super.toString() +
               ", Transporte: $" + costoTransporte +
               ", Instalación: $" + costoInstalacion;
    }
}
