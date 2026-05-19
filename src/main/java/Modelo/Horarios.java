/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author guillermo.barchino
 */
import java.time.LocalTime;
import java.io.Serializable;
public class Horarios implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    private DiaSemana dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    public Horarios(DiaSemana dia, LocalTime horaInicio, LocalTime horaFin){
        this.dia=dia;
        this.horaFin=horaFin;
        this.horaInicio=horaInicio;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }
    
    public boolean contieneHora(LocalTime hora){
        return !hora.isBefore(horaInicio)&&!hora.isAfter(horaFin);
    }

    @Override
    public String toString() {
        return "Horarios{" + "dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
}
