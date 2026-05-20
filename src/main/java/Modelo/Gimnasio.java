package Modelo;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author monto
 */
public class Gimnasio implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Usuario> usuarios;
    private List<Actividad> actividades;
    private List<Reserva> reservas;
    private List<Sala> salas;

    public Gimnasio() {
        this.usuarios = new ArrayList<>();
        this.actividades = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.salas = new ArrayList<>();
        
        asegurarAdminPorDefecto();
    }
    private void asegurarAdminPorDefecto() {
        boolean existeAdmin = false;
        for (Usuario u : usuarios) {
            if (u.getCorreo().equals("admin@javafit.com")) {
                existeAdmin = true;
                break;
            }
        }
        if (!existeAdmin) {
            usuarios.add(new Administrador("admin@javafit.com", "admin"));
        }
    }

    public void registrarSocio(Socio socio) {
        usuarios.add(socio);
    }

    public void registrarActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public void añadirSala(Sala sala) {
        salas.add(sala);
    }
    
    public void registrarReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.getSocio().añadirReserva(reserva); 
    }


    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public List<Actividad> getActividades() {
        return actividades;
    }
    public List<Reserva> getReservas() {
        return reservas;
    }
    public List<Sala> getSalas() {
        return salas;
    }
    
    //GENERACIÓN DE DATOS
    public void generarDatosDePrueba() {
        if (usuarios.size() > 1 || !actividades.isEmpty()) {
            return; 
        }
        System.out.println("Datos de prueba iniciales:");

        //Crear Salas
        Sala salaFitness = new Sala("Sala Fitness", 20);
        Sala salaZen = new Sala("Sala Zen", 15);
        Sala salaPiscina = new Sala("Piscina", 10);
        añadirSala(salaFitness);
        añadirSala(salaZen);
        añadirSala(salaPiscina);

        //Crear Horarios
        //Horario de mañana
        List<Horarios> horaManana = new ArrayList<>();
        Horarios horario1 = new Horarios(DiaSemana.LUNES, LocalTime.of(10, 0), LocalTime.of(11, 0));
        horaManana.add(horario1);
        //Horario de tarde
        List<Horarios> horaTarde = new ArrayList<>();
        Horarios horario2 = new Horarios(DiaSemana.MIERCOLES, LocalTime.of(18, 0), LocalTime.of(19, 30));
        horaTarde.add(horario2);
        //Horario de fin de semana
        List<Horarios> horaFinde = new ArrayList<>();
        Horarios horario3 = new Horarios(DiaSemana.SABADO, LocalTime.of(12, 0), LocalTime.of(13, 0));
        horaFinde.add(horario3);

        //Crear 6 Actividades
        Actividad act1 = new Actividad("Yoga", TipoActividad.YOGA, salaZen, horaManana, "Marta Arizona", "img/yoga.png");
        Actividad act2 = new Actividad("Zumba", TipoActividad.ZUMBA, salaFitness, horaTarde, "Juan Carlos", "img/zumba.png");
        Actividad act3 = new Actividad("Ciclo Indoor", TipoActividad.SPINNING, salaFitness, horaManana, "Luis Felipe", "img/spin.png");
        Actividad act4 = new Actividad("Pilates Terapéutico", TipoActividad.PILATES, salaZen, horaTarde, "Marta Arizona", "img/pilates.png");
        Actividad act5 = new Actividad("Crossfit", TipoActividad.CROSSFIT, salaFitness, horaFinde, "Popa", "img/cross.png");
        ActividadEspecial act6 = new ActividadEspecial("clase de Natación", TipoActividad.NATACION, salaPiscina, horaFinde, "Michael Phelps", "img/natacion.png", 25.0, "Clase centrada en mejorar tu técnica y tiempos");

        registrarActividad(act1); registrarActividad(act2); registrarActividad(act3);
        registrarActividad(act4); registrarActividad(act5); registrarActividad(act6);

        //Crear 4 Socios
        Socio socio1 = new Socio("Juan camilo", "juan@mail.com", "1234", "600111000", "Calle Verdugo 12", "ES123", TipoSocio.BASICO);
        Socio socio2 = new Socio("Ana Gómez", "ana@mail.com", "1234", "600333222", "Avenida Sol 45", "ES333", TipoSocio.VIP);
        Socio socio3 = new Socio("Miguel Martínez", "luis@mail.com", "1234", "600444666", "Plaza Mayor 1", "ES112", TipoSocio.BASICO);
        Socio socio4 = new Socio("Laura López", "laura@mail.com", "1234", "600666888", "Calle Luna 9", "ES999", TipoSocio.VIP);

        registrarSocio(socio1); registrarSocio(socio2);
        registrarSocio(socio3); registrarSocio(socio4);

        //Crear Reservas de prueba
        registrarReserva(new Reserva(socio1, act1, act1.getHorarios().get(0), LocalDate.now().plusDays(1), 0.0));
        double precioEspecial = act6.getPrecio() * 0.90; // 10% desc VIP
        registrarReserva(new Reserva(socio2, act6, act6.getHorarios().get(0), LocalDate.now().plusDays(3), precioEspecial));
    }
    
    //MÉTODOS DE GUARDAR/CARGAR
    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("javafit_datos.dat"))) {
            oos.writeObject(this);
            System.out.println("Datos de JavaFit guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public static Gimnasio cargarDatos() {
        File archivo = new File("javafit_datos.dat");
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                System.out.println("Datos de JavaFit cargados correctamente.");
                return (Gimnasio) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar los datos: " + e.getMessage());
            }
        }
        System.out.println("No hay archivo previo. Iniciando gimnasio desde cero.");
        return new Gimnasio();
    }
}
