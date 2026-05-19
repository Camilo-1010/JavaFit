/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author guillermo.barchino
 */
import java.time.LocalDate;
import java.io.Serializable;
public class Reserva implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    private Socios socio;
    private Actividad actividad;
    private Horarios horario;
    private LocalDate fecha;
    private double importe;
    
    public Reserva(Socios socio, Actividad actividad, Horarios horario, LocalDate fecha, double importe){
        this.socio=socio;
        this.actividad=actividad;
        this.horario=horario;
        this.fecha=fecha;
        this.importe=importe;
    }

    public Socios getSocio() {
        return socio;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public Horarios getHorario() {
        return horario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    @Override
    public String toString() {
        return "Reserva{" + "socio=" + socio + ", actividad=" + actividad + ", horario=" + horario + ", fecha=" + fecha + ", importe=" + importe + '}';
    }
    
}
