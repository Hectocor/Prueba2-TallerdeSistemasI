package cl.vista;

import cl.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "menu", urlPatterns = {"/menu.view"})
public class menu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //se recoje la session activa y almacena para utilizar acá
        HttpSession sesionActiva = request.getSession();
        Usuario user = (Usuario) sesionActiva.getAttribute("USUARIO");
        try (PrintWriter out = response.getWriter()) {
            if (user == null) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Menu</title>");
                out.println("</head>");
                out.println("<body style='background-color: red'>");
                out.println("<center>");
                out.println("<h1 class='error'>Ingrese para ver el contenido de esta pagina </h1>");
                out.println("<a href='index.html'>Volver</a>");
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");

            }
            switch (user.getRol()) {
                case "ADMINISTRADOR":
                    //System.out.println("INICIA" + user.getRol());
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Menu del Administrador</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<center>");
                    out.println("<br/><br/>");
                    out.println("<h3>Lista de Opciones</h3>");
                    out.println("<table border=1>");
                    out.println("<tr><td>1</td><td><a href='ingvehivulo.view'>Ingresas un nuevo vehiculo</a></td>");
                    out.println("<tr><td>2</td><td><a href='eliminaveh.view'>Eliminar un vehiculo de la lista</a></td>");
                    out.println("<tr><td>3</td><td><a href='monto.view'>Calcular el monto del arriendo de un vehiculo</a></td>");
                    out.println("</table>");
                    out.println("<br/><br/>");
                    out.println("<a href='cerrar.do'>Cerrar Sesion</a>");
                    break;

                case "EMPLEADO":
                    //System.out.println("INICIA" + user.getRol());
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Menu del Cliente</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<center>");
                    out.println("<br/><br/>");
                    out.println("<h3>Lista de Opciones</h3>");
                    out.println("<table border=1>");
                    out.println("<tr><td>1</td><td><a href='ingarriendo.view'>Ingresar arriendo</a></td>");
                    out.println("<tr><td>2</td><td><a href='buscarveh.view'>Buscar un vehiculo</a></td>");
                    out.println("<tr><td>2</td><td><a href='vervehiculodisp.view'>Ver vehiculos disponibles</a></td>");
                    out.println("</table>");
                    out.println("<br/><br/>");
                    out.println("<a href='cerrar.do'>Cerrar Sesion</a>");
                    out.println("</center>");
                    out.println("</body>");
                    out.println("</html>");
                    break;

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
