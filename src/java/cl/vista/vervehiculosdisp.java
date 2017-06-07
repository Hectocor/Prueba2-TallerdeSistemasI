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


@WebServlet(name = "vervehiculosdisp", urlPatterns = {"vervehiculosdisp.view"})
public class vervehiculosdisp extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession sesionOK = request.getSession();
        Usuario usuario = (Usuario) sesionOK.getAttribute("USUARIO");
        List<Vehiculo> listaVehiculo = (List<Vehiculo>) getServletContext().getAttribute("listaVehiculos");
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de vehiculos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            
            if (usuario == null) {
                out.println("<h1> Acceso Restringido</h1>");
                out.println("<a href = 'index.html'> Volver </a>");
            } else {
                out.println("<h1> Lista de Vehiculos</h1 >");
                if (listaVehiculo.isEmpty()) {
                    
                    out.println("<p>No hay Vehiculos disponibles</p>");
                    out.println("<br/> <br/>");
                    out.println("<a href ='menu.view'>Volver</a >");
                } else {
                    out.println("<br/> <br/>");
                    out.println("<table border = '1' align ='center'>");
                    out.println("<tr>");
                    out.println("<th>Patente</th>");
                    out.println("<th>Marca</th>");
                    out.println("<th>Modelo</th>");
                    out.println("<th>Color</th>");
                    out.println("<th>Año de fabricacion</th>");
                    out.println("<th>Estado</th>");
                    out.println("</tr>");
                    for (Vehiculo p : listaVehiculo) {
                        out.println("<tr>");
                        out.println("<td>" + p.getPatente() + "</td>");
                        out.println("<td>" + p.getMarca() + "</td>");
                        out.println("<td>" + p.getModelo() + "</td>");
                        out.println("<td>" + p.getColor() + "</td>");
                        out.println("<td>" + p.getAnioFabricacion() + "</td>");
                        out.println("<td>" + p.getEstado() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.println("<br/>");
                    out.println("<a href ='menu.view'>Volver</a>");
                }
            }
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
