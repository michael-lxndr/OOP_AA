package controlador;

import modelo.PuntoComercial;
import modelo.ActividadEconomica;

import java.util.ArrayList;
import java.util.List;

public class ComercioController {
    private List<PuntoComercial> puntos;

    public ComercioController() {
        this.puntos = new ArrayList<>();
    }

    public void registrarPuntoComercial(PuntoComercial punto) {
        puntos.add(punto);
        System.out.println("Punto comercial registrado: " + punto.getTipoComercio().getTipo());
    }

    public void simularActividad() {
        for (PuntoComercial punto : puntos) {
            ActividadEconomica act = punto.getTipoComercio();
            System.out.println("Rentabilidad de " + act.getTipo() + ": " + act.calcularRentabilidad());
        }
    }

    public void generarReporte() {
        for (PuntoComercial punto : puntos) {
            System.out.println(punto.verBalance());
        }
    }

    public List<PuntoComercial> getPuntos() {
        return puntos;
    }
}
