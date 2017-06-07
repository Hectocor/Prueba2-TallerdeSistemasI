package cl.vista;

import cl.modelo.Cliente;
import cl.modelo.Usuario;
import cl.modelo.Vehiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ingarriendo", urlPatterns={"ingarriendo.view"})
public class ingarriendo extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesionActiva = request.getSession();
        
        Usuario usuario = (Usuario)sesionActiva.getAttribute("USUARIO");
        ArrayList errores2 = (ArrayList) request.getAttribute("errores2");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Realizar arriendo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            if (usuario == null) {
                out.println("<h1> Acceso Restringido</h1>");
                out.println("<a href = 'index.html'> Volver </a>");
            } else {
                out.println("<h1>Solicitar arriendo</h1>");
                out.println("<fieldset style='width: 400px'>");
                out.println("<legend><b>Datos del vehiculo</b></legend>");
                out.println("<form action='valarriendo.do' method='post'>");
                out.println("<table>");
                String codigo = "", patenteV = "", rutCli = "", fecha = "", strdias = "", strvalorDia = "";
                out.println("<tr><td>Código</td><td><input type='text' name='codigo' value='" + codigo + "'></td>");
                out.println("<tr><td>Patente</td><td><select name='patenteV'>");
                ArrayList<Vehiculo> listaVehiculos = (ArrayList<Vehiculo>) getServletContext().getAttribute("listaVehiculos");
                
                
                for (Vehiculo aux : listaVehiculos){
                    out.println("<option value=>"+ aux.getPatente()+"</option>");
                }
                
                
                out.println("</select></td>");
                out.println("<tr><td>Rut Cliente</td><td><select name='rutCli'>");
               
                ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) getServletContext().getAttribute("listaClientes");
                
                
                for (Cliente aux : listaClientes){
                    out.println("<option value=>"+ aux.getRut()+"</option>");
                }
                
                
                out.println("</select></td>");
                out.println("<tr><td>Fecha</td><td><input type='text' name='fecha' value='" + fecha + "'></td>");
                out.println("<tr><td>Cantidad de dias</td><td><input type='text' name='dias' value='" + strdias + "'></td>");
                out.println("<tr><td>Valor por dia</td><td><input type='text' name='valorDia' value='" + strvalorDia + "'></td>");
                out.println("<tr><td colspan='2' align='right'><input type='submit' value='Agregar'></td>");
                out.println("</table>");
                
                if (errores2.isEmpty()){
                    
                    out.println("<table>");
                    for (Object errores : errores2) {
                        out.println("<tr>");
                        out.println("<td align='left'>" + errores.toString() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }

                out.println("<br/>");
                out.println("<a href='menu.view'>Volver</a>");
                out.println("</form>");
                out.println("</fieldset>");
                out.println("<br/><br/>");
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

