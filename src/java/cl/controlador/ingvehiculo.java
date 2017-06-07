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
        
         Usuario usuario = (Usuario) sesionOK.getAttribute("usuario");
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
            out.println("<tr><td>Año de fabricacion:</td><td><input type='text' name='anio' "+Año+"></td>");
            out.println("<tr><td>Estado:</td><td><input type='text' name='estado' "+Estado+"></td>");
            out.println("</td>");
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
