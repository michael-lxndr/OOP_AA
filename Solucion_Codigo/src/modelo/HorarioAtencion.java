package modelo;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class HorarioAtencion {
    private DayOfWeek dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public HorarioAtencion(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Getters y setters si es necesario
}
