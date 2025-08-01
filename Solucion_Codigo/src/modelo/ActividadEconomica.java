package modelo;

import java.util.List;

public abstract class ActividadEconomica {
    protected String tipo;
    protected double deficit;
    protected double ingresosBrutos;
    protected double ingresosNetos;
    protected double recursosAVG;
    protected boolean abierto;
    protected boolean estaCerradoPermanentemente;
    protected List<Recurso> recursos;

    public ActividadEconomica(String tipo) {
        this.tipo = tipo;
        this.abierto = true;
        this.estaCerradoPermanentemente = false;
    }

    public abstract double calcularRentabilidad();
    public abstract double calcularGananciaNeta();
    public abstract double calcularEficiencia();

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    public void setCerradoPermanentemente(boolean cerrado) {
        this.estaCerradoPermanentemente = cerrado;
    }

    public boolean isCerradoPermanentemente() {
        return estaCerradoPermanentemente;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getAbierto() {
        return abierto;
    }

    @Override
    public String toString() {
        return tipo + " - Rentabilidad: " + calcularRentabilidad();
    }
}
