package modelo;

import java.util.List;

public class PuntoComercial {
    private int id;
    private String nombre;
    private String ubicacion;
    private boolean abierto;
    private boolean cerradoPermanentemente;
    private ActividadEconomica tipoComercio;
    private List<HorarioAtencion> horario;

    public PuntoComercial(int id, String nombre, String ubicacion, List<HorarioAtencion> horario, ActividadEconomica tipoComercio) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.tipoComercio = tipoComercio;
        this.abierto = true;
        this.cerradoPermanentemente = false;
    }

    public boolean isAbierto() {
        return abierto && !cerradoPermanentemente;
    }

    public ActividadEconomica getTipoComercio() {
        return tipoComercio;
    }

    public String verBalance() {
        return tipoComercio.toString();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return "PuntoComercial{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", tipoComercio=" + tipoComercio.getTipo() +
                '}';
    }
}
