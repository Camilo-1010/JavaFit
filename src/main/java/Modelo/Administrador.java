package Modelo;

/**
 *
 * @author guillermo.barchino
 */
import java.io.Serializable;
public class Administrador extends Usuario implements Serializable{
    private static final long serialVersionUID =1L;
    
    public Administrador(String correo, String clave){
        super(correo, clave);
    }

    @Override
    public String toString() {
        return "Administrador{" + "correo=" + correo + '}';
    }
    
}
