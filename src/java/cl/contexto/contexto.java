
package cl.contexto;

import cl.modelo.Usuario;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Hector
 */
@javax.servlet.annotation.WebListener
public class contexto implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    
        List<Usuario> listaUsuarios;
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
    }
    
}
