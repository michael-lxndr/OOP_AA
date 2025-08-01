package modelo;

import java.util.ArrayList;
import java.util.List;

public class FeriaItinerante extends ActividadEconomica {
    private List<String> ubicacionesPasadas;
    private List<String> ubicacionesFuturas;
    private List<Responsable> responsables;
    private List<NegocioBase> puestos;

    public FeriaItinerante(String tipo, List<Responsable> responsables) {
        super(tipo);
        this.responsables = responsables;
        this.ubicacionesPasadas = new ArrayList<>();
        this.ubicacionesFuturas = new ArrayList<>();
        this.puestos = new ArrayList<>();
    }

    public void setPuestos(List<NegocioBase> puestos, Responsable admin) {
        this.puestos = puestos;
        if (!responsables.contains(admin)) {
            responsables.add(admin);
        }
    }

    public void setPuesto(NegocioBase puesto, Responsable admin) {
        this.puestos.add(puesto);
        if (!responsables.contains(admin)) {
            responsables.add(admin);
        }
    }

    public List<NegocioBase> getPuestos() {
        return puestos;
    }

    @Override
    public double calcularRentabilidad() {
        return ingresosNetos / (recursos.size() + 1);
    }

    @Override
    public double calcularGananciaNeta() {
        return ingresosBrutos - deficit;
    }

    @Override
    public double calcularEficiencia() {
        return (ingresosNetos / (recursosAVG + 1)) * 100;
    }
}
