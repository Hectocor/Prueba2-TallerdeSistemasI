
package cl.vista;

import cl.modelo.Usuario;
import cl.modelo.Vehiculo;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name="monto", urlPatterns= {"monto.view"})
public class monto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sesionActiva = request.getSession();
        Usuario usuario = (Usuario) sesionActiva.getAttribute("USUARIO");
        List<Vehiculo> listaVehiculos = (List<Vehiculo>) getServletContext().getAttribute("listaVehiculos");
        String mensaje = (String) request.getAttribute("mensaje");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            response.setContentType("text/html;charset=UTF-8");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calcular Monto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Calcular Monto</h1>"); 
            out.println("<form action='calcmonto.do' method='POST'>");
            out.println("<tr><td>Patente </td><td><select name='patente'>");
            out.println("<option selected>Seleccione </option>");
            for (Vehiculo aux : listaVehiculos) {
                out.println("<option>" + aux.getPatente() + "</option>");
            }
            if(mensaje != null){
                out.println("<p>"+mensaje+"</p>");
            }

        if (usuario == null) {
                out.println("<center>");
                out.println("<h1> Inicie sesion para ver la pagina</h1>");
                out.println("<a href='index.html'>Volver al index</a>");
                out.println("</center>");
           } 
            out.println("</tr><tr><td><input type='submit' value='Calcular'></td></tr>");
            out.println("</form>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
    
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
