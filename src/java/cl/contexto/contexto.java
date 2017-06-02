
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
        listaVehiculos = new ArrayList();
        
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
    }
    
}
