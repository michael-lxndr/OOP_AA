package modelo;

public class Recurso {
    private String descripcion;
    private double costo;
    private double ingreso;

    public Recurso(String descripcion, double costo, double ingreso) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.ingreso = ingreso;
    }

    public String getDescripcion() { return descripcion; }
    public double getCosto() { return costo; }
    public double getIngreso() { return ingreso; }

    @Override
    public String toString() {
        return descripcion + " | Costo: $" + costo + " | Ingreso: $" + ingreso;
    }
}
