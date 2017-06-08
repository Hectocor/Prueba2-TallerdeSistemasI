package cl.vista;

import cl.modelo.Usuario;
import cl.modelo.Vehiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ingvehiculo", urlPatterns = {"/ingvehiculo.view"})
public class ingvehiculo extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesionOK = request.getSession();
        
         Usuario usuario = (Usuario) sesionOK.getAttribute("USUARIO");
        Vehiculo vehiculo = (Vehiculo) sesionOK.getAttribute("Vehiculo");
        ArrayList errores = (ArrayList) request.getAttribute("errores");
        
        String Patente = request.getParameter("patente");
        String Marca = request.getParameter("marca");
        String Modelo = request.getParameter("modelo");
        String Color = request.getParameter("color");
        String Año = request.getParameter("anioFabricacion");
        String Estado = request.getParameter("estado");
       
        if (Patente == null) {
            Patente = "";
        }
        if (Marca == null) {
            Marca = "";
        }
        if (Modelo == null) {
            Modelo = "";
        }
        if (Color == null) {
            Color = "";
        }
        if (Año == null) {
            Año = "";
        }
        if (Estado == null) {
            Estado = "";
        }
        String msg = (String) request.getAttribute("msg");
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
           if (usuario == null) {
                out.println("<center>");
                out.println("<h1> Inicie sesion para ver la pagina</h1>");
                out.println("<a href='index.html'>Volver al index</a>");
                out.println("</center>");
           } else {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ingreso de Vehiculos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Ingreso de un nuevo vehiculo</h1>");
            out.println("<form action='valvehiculo.do' method='POST'>");
            out.println("<table>");
            out.println("<tr><td>Patente:</td><td><input type='text' name='patente'"+Patente+"></td>");
            out.println("<tr><td>Marca:</td><td><input type='text' name='marca' "+Marca+"></td>");
            out.println("<tr><td>Modelo:</td><td><input type='text' name='modelo' "+Modelo+"></td>");
            out.println("<tr><td>Color:</td><td><input type='text' name='color' "+Color+"></td>");
            out.println("<tr><td>Año de fabricacion:</td><td><input type='number' name='anio' min='1950' max='2017'></td>");
            out.println("<tr><td>Estado:</td><td><select name='estado'>");
            
            String[] arregloEstado = {"DISPONIBLE", "NO DISPONIBLE"};
            
                for (String var : arregloEstado){
                    out.println("<option>"+var.toString()+"</option>");
                }
                
            out.println("</select></td>");
            out.println("<br>");
            out.println("</tr>");
            out.println("<tr><td><input type='submit' value='Ingresar vehiculo nuevo'></td>");
            out.println("</table>");
            if (errores != null) {
                    out.println("<table>");
                    for (int i = 0; i < errores.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + errores.get(i) + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
                if (errores == null && msg != null) {
                    out.println("<font>" + msg + "</font>");
                }
                
            out.println("<a href='menu.view'>Volver al menu</a>");
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
