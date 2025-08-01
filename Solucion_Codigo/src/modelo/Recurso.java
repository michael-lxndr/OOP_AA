package modelo;

public class Recurso {
    protected String descripcion;
    protected double costo;

    public Recurso(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion + " - $" + costo;
    }
}
