package Modelo;

/**
 *
 * @author guillermo.barchino
 */
import java.util.ArrayList;
import java.util.List;
public class Socio extends Usuario{
    
    private static final long serialVersionUID=1L;
    
    private String nombre;
    private String telefono;
    private String direccion;
    private String tarjetaCredito;
    private TipoSocio tipo;
    private List<Reserva> reservas;
    
    public Socio (String nombre, String correo, String clave, String telefono, String direccion, String tarjetaCredito, TipoSocio tipo){
        super(correo, clave);
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
        this.tarjetaCredito=tarjetaCredito;
        this.tipo=tipo;
        this.reservas=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public TipoSocio getTipo() {
        return tipo;
    }

    public void setTipo(TipoSocio tipo) {
        this.tipo = tipo;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
    
    public void añadirReserva(Reserva reserva){
        reservas.add(reserva);
    }
    public void cancelarReserva(Reserva reserva){
        reservas.remove(reserva);
    }
    public boolean esVip(){
        return tipo == TipoSocio.VIP;
    } 

    @Override
    public String toString() {
        return "Socios{" + "nombre=" + nombre + "correo=" + correo + "tipo=" + tipo + '}';
    }
    
}
