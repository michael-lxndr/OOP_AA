package modelo;

import java.util.List;

public abstract class ActividadEconomica {
    protected String tipo;
    protected List<Recurso> recursos;

    public ActividadEconomica(String tipo, List<Recurso> recursos) {
        this.tipo = tipo;
        this.recursos = recursos;
    }

    public abstract double calcularGananciaNeta();
    public abstract double calcularEficiencia();

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Recursos: " + recursos;
    }
}
