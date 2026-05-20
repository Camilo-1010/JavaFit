package Modelo;

/**
 *
 * @author guillermo.barchino
 */
import java.util.List;
public class ActividadEspecial extends Actividad{
    
    private static final long serialVersionUID=1L;
    
    private double precio;
    private String descripcion;
    
    public ActividadEspecial(String titulo, TipoActividad tipo, Sala sala, List<Horarios> horarios, String monitor, String imagen, double precio, String descripcion){
        super(titulo, tipo, sala, horarios, monitor, imagen);
        this.precio=precio;
        this.descripcion=descripcion;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ActividadEspecial{" + "titulo='" + getTitulo() + ", tipo=" + getTipo() +", precio=" + precio + '}';

    }
    
}
