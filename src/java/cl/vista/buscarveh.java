package cl.vista;

import java.io.IOException;
import java.io.PrintWriter;
import cl.modelo.Usuario;
import cl.modelo.Vehiculo;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "buscarveh", urlPatterns = {"/buscarveh.view"})
public class buscarveh extends HttpServlet {
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sesionOK = request.getSession();
        Usuario usuario = (Usuario) sesionOK.getAttribute("USUARIO");
        
        List<Vehiculo> listaVehiculos = (List<Vehiculo>) getServletContext().getAttribute("listaVehiculos");
        String patentes = request.getParameter("patente");
 
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet buscarveh</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            if (usuario == null) {
                
                out.println("<h1> Acceso Restringido</h1>");
                out.println("<a href = 'index.html'> Volver </a>");
            } else {
                out.println("<h1>Buscar Vehiculo </h1>");
                out.println("<form action='buscarveh.view' method='POST'>");
                out.println("<tr><td>Patente:</td><td><select name='patente'"+patentes+"></td>");
                out.println("<option selected value = '1'>Seleccione</option>");
                
                for (Vehiculo aux : listaVehiculos){
                    out.println("<option>"+ aux.getPatente()+"</option>");
                }
                out.println("</tr>");
                out.println("<tr><td>Patente:</td><td><input type='submit' value='Buscar'></td></tr>");
                
                
                if(patentes!=null){
                    out.println("<table border=1>");
                    out.println("<tr>");
                    out.println("<th>Patente</th>");
                    out.println("<th>Marca</th>");
                    out.println("<th>Modelo</th>");
                    out.println("<th>Color</th>");
                    out.println("<th>Año de fabricacion</th>");
                    out.println("<th>Estado</th>");
                    out.println("</tr>");
                    for (Vehiculo p : listaVehiculos) {
                        if(patentes.equals(p.getPatente())){
                            out.println("<tr>");
                            out.println("<td>" + p.getPatente() + "</td>");
                            out.println("<td>" + p.getMarca() + "</td>");
                            out.println("<td>" + p.getModelo() + "</td>");
                            out.println("<td>" + p.getColor() + "</td>");
                            out.println("<td>" + p.getAnioFabricacion() + "</td>");
                            out.println("<td>" + p.getEstado() + "</td>");
                            out.println("</tr>");
                        }else{
                        }
                    }
                }
                out.println("</table>");
                out.println("</form>");
                out.println("<br/>");
                out.println("<a href ='menu.view'>Volver</a>");
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
    }// </editor-fold>

}
