
package cl.contexto;

import cl.modelo.Vehiculo;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
/**
 *
 * @author Hector
 */
@javax.servlet.annotation.WebListener
public class contexto implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    
        List<Vehiculo> listaVehiculos;
        listaVehiculos = new ArrayList<>();
        // Se añade a la lista el vehiculo segun parametros Patente, Marca, Modelo, Color, Año fabricación, Estado
        listaVehiculos.add(new Vehiculo("AS-ZX-12", "Toyota", "Yaris", "Rojo", 2010, "DISPONIBLE"));
        listaVehiculos.add(new Vehiculo("DF-ER-11", "Chevrolet", "Luv", "Blanco", 1990, "DISPONIBLE"));
        listaVehiculos.add(new Vehiculo("HY-CC-42", "Ford", "Escape", "Azul", 2009, "DISPONIBLE"));
        listaVehiculos.add(new Vehiculo("MN-CT-59", "Renault", "Clio", "Blanco", 2013, "DISPONIBLE"));
        listaVehiculos.add(new Vehiculo("UI-UI-09", "Nissan", "V16", "Verde", 2000, "DISPONIBLE"));
        listaVehiculos.add(new Vehiculo("RT-IL-89", "Volkswagen", "Saveiro", "Negro", 2017, "DISPONIBLE"));
                                         
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
    }
    
}
