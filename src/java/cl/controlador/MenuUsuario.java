import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/menu.view"})
public class MenuUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesionOK = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           if (Usuario == null) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Menu</title>");
                out.println("</head>");
                out.println("<center>");
                out.println("<h1 class='error'>Ingrese para ver el contenido de esta pagina </h1>");
                out.println("<a href='index.html'>Volver</a>");
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");
            }else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                if (Usuario.getLogin().equals("*****") && usuario.getPassword().equals("*****")) {
                    out.println("<title>Menu del Administrador</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<center>");
                    out.println("<br/><br/>");
                    out.println("<h3>Lista de Opciones</h3>");
                    out.println("<table>");
                    out.println("<tr><td>1</td><td><a href='ingvehivulo.view'>Ingresas un nuevo vehiculo</a></td>");
                    out.println("<tr><td>2</td><td><a href='eliminaveh.view'>Eliminar un vehiculo de la lista</a></td>");
                    out.println("<tr><td>3</td><td><a href='monto.view'>Calcular el monto del arriendo de un vehiculo</a></td>");
                    out.println("</table>");
                    out.println("<br/><br/>");
                    out.println("<a href='cerrar.do'>Cerrar Sesion</a>");
                } else {
                    out.println("<title>Menu del Cliente</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<center>");
                    out.println("<br/><br/>");
                    out.println("<h3>Lista de Opciones</h3>");
                    out.println("<table>");
                    out.println("<tr><td>1</td><td><a href='ingarriendo.view'>Ingresar arriendo</a></td>");
                    out.println("<tr><td>2</td><td><a href='buscarveh.view'>Buscar un vehiculo</a></td>");
                    out.println("<tr><td>2</td><td><a href='vervehiculodisp.view'>Ver vehiculos disponibles</a></td>");
                    out.println("</table>");
                    out.println("<br/><br/>");
                    out.println("<a href='cerrar.do'>Cerrar Sesion</a>");
                    out.println("</center>");
                    out.println("</body>");
                }
                out.println("</head>");
                out.println("</html>");
            }
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
