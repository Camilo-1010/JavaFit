package Modelo;

/**
 *
 * @author guillermo.barchino
 */
import java.io.Serializable;
public class Sala implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    private String nombre;
    private int aforoMaximo;
    
    public Sala(String nombre, int aforoMaximo){
        this.nombre=nombre;
        this.aforoMaximo=aforoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    @Override
    public String toString() {
        return "Sala{" + "nombre=" + nombre + ", aforoMaximo=" + aforoMaximo + '}';
    }
    
}
