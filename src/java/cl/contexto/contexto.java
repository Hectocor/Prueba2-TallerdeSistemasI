
package cl.contexto;

import cl.modelo.Vehiculo;
import cl.modelo.Cliente;
import cl.modelo.Usuario;
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
        
        //Se crea una lista tipo arraylist de cliente, la cual almacenará los datos de Clientes e inicializará para el uso del Sistema
        List<Cliente> listaClientes;
        listaClientes = new ArrayList<>();
        //Se añade a la lista cada cliente segun sus parametros Rut, Nombre, Domicilio, Celular, Email
        listaClientes.add(new Cliente("19.123.431-3", "José Orellana", "Av. Circunvalación N 32", 98283493, "jose_o@gmail.com"));
        listaClientes.add(new Cliente("19.002.343-4","Nicolás Acosta", "4 Ote. 2 Sur N 22", 74321232, "nico.acosta@gmail.com"));
        listaClientes.add(new Cliente("18.234.123-4", "Miguel Torres", "3 Nte. 23 Sur N 32", 99898998, "miguel.torres@gmail.com"));
        
        List<Usuario> listaUsuarios;
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("admin", "admin", ""));
                                         
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
    }
    
}
