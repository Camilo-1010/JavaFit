package Modelo;

/**
 *
 * @author monto
 */
public class PruebaGym {
    public static void main(String[] args) {
        System.out.println("=== ARRANCANDO PRUEBA DEL MODELO JAVAFIT ===");
        
        // 1. Intentamos cargar los datos previos del archivo .dat si existe
        Gimnasio gym = Gimnasio.cargarDatos();
        
        // 2. Ejecutamos el generador automático (solo creará los 4 socios y 6 actividades si el archivo no existía)
        gym.generarDatosDePrueba();
        
        // 3. Imprimimos los datos por consola para comprobar visualmente que todo está en memoria
        System.out.println("\n--- SOCIOS REGISTRADOS ---");
        for (Usuario u : gym.getUsuarios()) {
            System.out.println(u);
        }
        
        System.out.println("\n--- CATÁLOGO DE ACTIVIDADES ---");
        for (Actividad a : gym.getActividades()) { 
            System.out.println(a);
        }
        
        System.out.println("\n--- RESERVAS HISTÓRICAS ---");
        for (Reserva r : gym.getReservas()) {
            System.out.println(r);
        }
        
        System.out.println("\nCerrando simulación...");
        gym.guardarDatos();
        
        System.out.println("=== PRUEBA FINALIZADA CON ÉXITO ===");
    }
}
