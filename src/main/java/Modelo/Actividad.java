package Modelo;

/**
 *
 * @author guillermo.barchino
 */
import java.io.Serializable;
import java.util.List;
public class Actividad implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    private String titulo;
    private TipoActividad tipo;
    private Sala sala;
    private List<Horarios> horarios;
    private String monitor;
    private String imagen;
    
    public Actividad(String titulo, TipoActividad tipo, Sala sala, List<Horarios> horarios, String monitor, String imagen){
        this.titulo=titulo;
        this.tipo=tipo;
        this.sala=sala;
        this.horarios=horarios;
        this.monitor=monitor;
        this.imagen=imagen;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo;
    }

    public TipoActividad getTipo() {
        return tipo;
    }
    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Horarios> getHorarios() {
        return horarios;
    }
    public void setHorarios(List<Horarios> horarios) {
        this.horarios = horarios;
    }

    public String getMonitor() {
        return monitor;
    }
    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Actividad{" + "titulo=" + titulo + ", tipo=" + tipo + ", sala=" + sala + ", monitor=" + monitor + '}';
    }
    
    
        
}
