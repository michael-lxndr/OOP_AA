package modelo;

import java.util.ArrayList;
import java.util.List;

public class Responsable extends Vendedor {
    private String cargo;
    private PuntoComercial responsabilidad;
    private List<Vendedor> vendedoresACargo;

    public Responsable(int id, String nombre, String cargo) {
        super(id, nombre);
        this.cargo = cargo;
        this.vendedoresACargo = new ArrayList<>();
    }

    public void setResponsabilidad(PuntoComercial punto) {
        this.responsabilidad = punto;
    }

    public void supervisar() {
        System.out.println("Supervisando vendedores...");
    }
}
