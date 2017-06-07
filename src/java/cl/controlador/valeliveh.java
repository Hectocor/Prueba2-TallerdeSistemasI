
package cl.controlador;

import cl.modelo.Usuario;
import cl.modelo.Vehiculo;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hector
 */

@WebServlet(name = "valeliveh", urlPatterns = {"/valeliveh.do"})
public class valeliveh extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String patenteAEliminar = request.getParameter("patente");
        HttpSession sesionOK = request.getSession();
        Usuario usuario = (Usuario) sesionOK.getAttribute("USUARIO");
        List<Vehiculo> listaVehiculos = (List<Vehiculo>) getServletContext().getAttribute("listaVehiculos");
        
        Iterator<Vehiculo> vehiculoIterator = listaVehiculos.iterator();
        
        while (vehiculoIterator.hasNext()) {;
            Vehiculo autito = vehiculoIterator.next();

            if (autito.getPatente().equals(patenteAEliminar)) {
                vehiculoIterator.remove();
            }
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
