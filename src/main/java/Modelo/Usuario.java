package Modelo;

/**
 *
 * @author guillermo.barchino
 */

import java.io.Serializable;
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected String correo;
    protected String clave;
    
    public Usuario(String correo, String clave){
        this.correo=correo;
        this.clave=clave;
    }
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public boolean ComprobarClave(String clave){
        return this.clave.equals(clave);
    }

    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", clave=" + clave + '}';
    }
}
