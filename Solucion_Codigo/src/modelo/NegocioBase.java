package modelo;

import java.util.List;

public class NegocioBase extends TiendaLocal {
    private int numeroDePuesto;

    public NegocioBase(List<Producto> inventarioPermanente, Responsable owner, Vendedor vendedor) {
        super(inventarioPermanente, owner, vendedor);
    }

    public int getNumeroDePuesto() {
        return numeroDePuesto;
    }

    public void setNumeroDePuesto(int numero) {
        this.numeroDePuesto = numero;
    }

    @Override
    public String toString() {
        return "NegocioBase en puesto #" + numeroDePuesto;
    }

    @Override
    public double calcularRentabilidad() {
        return ingresosNetos / (costoReabastecer + 1);
    }

    @Override
    public double calcularGananciaNeta() {
        return ingresosBrutos - costoReabastecer;
    }

    @Override
    public double calcularEficiencia() {
        return calcularInventarioTotal() > 0 ? 100.0 : 0;
    }
}
