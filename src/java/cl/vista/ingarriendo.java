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
        Usuario usuario = (Usuario) sesionActiva.getAttribute("USUARIO");
        String msj = (String) request.getAttribute("msj");
                ArrayList errores = (ArrayList) request.getAttribute("errores2");
                
        String codigo = request.getParameter("codigo");
        String patenteV = request.getParameter("patenteV");
        String rutCli = request.getParameter("rutCli");
        String fecha = request.getParameter("fecha");
        String strdias = request.getParameter("dias");
        String strvalorDia = request.getParameter("valorDia");
        
        if (codigo == null) {
            codigo = "";
        }
        if (patenteV == null) {
            patenteV = "";
        }
        if (rutCli == null) {
            rutCli = "";
        }
        if (fecha == null) {
            fecha = "";
        }
        if (strdias == null) {
            strdias = "";
        }
        if (strvalorDia == null) {
            strvalorDia = "";
        }
        
        
        if (msj != null) {
            codigo = "";
            patenteV = "";
            rutCli = "";
            fecha = "";
            strdias = "";
            strvalorDia = "";
        }
        
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

                out.println("<tr><td>Código</td><td><input type='text' name='codigo' value='"+codigo+"'></td>");
                out.println("<tr><td>Patente</td><td><select name='patenteV'>");
                
                List<Vehiculo> listaVehiculos = (List<Vehiculo>) getServletContext().getAttribute("listaVehiculos");
                out.println("<option selected value='1'>Selecione </option>");
                for (Vehiculo aux : listaVehiculos){
                    out.println("<option>"+ aux.getPatente()+"</option>");
                }
                
                out.println("</select></td></tr>");
                out.println("<tr><td>Rut Cliente</td><td><select name='rutCli'>");
               
                List<Cliente> listaClientes = (List<Cliente>) getServletContext().getAttribute("listaClientes");
                out.println("<option selected value='1'>Selecione </option>");
                for(Cliente aux2 : listaClientes){
                    out.println("<option value>"+ aux2.getRut()+"</option>");
                }
 
                out.println("</select></td></tr>");
                out.println("<tr><td>Fecha</td><td><input type='date' name='fecha' value='"+fecha+"'></td></tr>");
                out.println("<tr><td>Cantidad de días</td><td><input type='text' name='dias' value='"+strdias+"'></td></tr>");
                out.println("<tr><td>Valor por día</td><td><input type='text' name='valorDia' value='"+strvalorDia+"'></td></tr>");
                out.println("<tr><td colspan='2' align='right'><input type='submit' value='Agregar'></td></tr>");
                out.println("</table>");
                out.println("<br/>");
                
                 
                if (errores != null) {
                    out.println("<table>");
                    for (int i = 0; i < errores.size(); i++) {
                        out.println("<tr>");
                        out.println("<td align='left'>" + errores.get(i) + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
                if (errores == null && msj != null) {
                    out.println("<font>" + msj + "</font>");
                }
                
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

