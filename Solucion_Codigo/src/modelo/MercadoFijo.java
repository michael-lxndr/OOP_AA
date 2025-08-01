package modelo;

import java.util.List;

public class MercadoFijo extends ActividadEconomica {
    private int numeroPuestos;
    private double costoEspacio;
    private double rotacionProductos;
    private Recurso costoMantenimiento;
    private List<Responsable> responsables;
    private List<NegocioBase> puestos;

    public MercadoFijo(double costoEspacio, double rotacionProductos, int numeroPuestos, List<Responsable> responsables) {
        super("MercadoFijo");
        this.costoEspacio = costoEspacio;
        this.rotacionProductos = rotacionProductos;
        this.numeroPuestos = numeroPuestos;
        this.responsables = responsables;
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
        return ingresosNetos - (numeroPuestos * costoEspacio);
    }

    @Override
    public double calcularGananciaNeta() {
        return ingresosBrutos - costoMantenimiento.getCosto();
    }

    @Override
    public double calcularEficiencia() {
        return rotacionProductos * 100;
    }
}
