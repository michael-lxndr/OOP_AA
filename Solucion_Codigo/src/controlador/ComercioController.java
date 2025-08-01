package controlador;

import modelo.*;

import java.util.ArrayList;
import java.util.List;

public class ComercioController {
    private List<PuntoComercial> puntos;

    public ComercioController() {
        this.puntos = new ArrayList<>();
    }

    public void registrarPuntoComercial(PuntoComercial punto) {
        puntos.add(punto);
    }

    public void simularActividad() {
        for (PuntoComercial pc : puntos) {
            System.out.println("Simulando: " + pc);
            System.out.println("Ganancia neta: $" + pc.getTipoComercio().calcularGananciaNeta());
            System.out.println("Eficiencia: " + pc.getTipoComercio().calcularEficiencia() + "%\n");
        }
    }

    public void generarReporte() {
        for (PuntoComercial pc : puntos) {
            System.out.println(pc);
            pc.getVendedores().forEach(System.out::println);
            pc.getProductos().forEach(System.out::println);
            System.out.println();
        }
    }

    public List<PuntoComercial> getPuntos() {
        return puntos;
    }
}
