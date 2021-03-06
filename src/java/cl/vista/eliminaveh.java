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


@WebServlet(name = "eliminaveh", urlPatterns = {"/eliminaveh.view"})
public class eliminaveh extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesionOK = request.getSession();
        Usuario usuario = (Usuario) sesionOK.getAttribute("USUARIO");
        Vehiculo vehiculo = (Vehiculo) sesionOK.getAttribute("Vehiculo");
        String Patente = request.getParameter("patente");
        List<Vehiculo> listaVehiculos = (List<Vehiculo>) getServletContext().getAttribute("listaVehiculos");
        
        

        if (Patente == null) {
            Patente = "";
        }       
          try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            response.setContentType("text/html;charset=UTF-8");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Eliminar Vehiculo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Eliminacion de un vehiculo</h1>"); 
            
            //validacion de usuario
        if (usuario == null) {
                out.println("<center>");
                out.println("<h1> Inicie sesion para ver la pagina</h1>");
                out.println("<a href='index.html'>Volver al index</a>");
                out.println("</center>");
           } else {
            //verificar que la lista no este vacia
            if (listaVehiculos.isEmpty()) {
                    out.println("<p>No hay vehiculos</p>");
                    out.println("<br/> <br/>");
                    out.println("<a href ='menu.view'>Volver</a >");
                } else {
                    out.println("<form action='valeliveh.do' method='POST'>");
                    out.println("<table>");
                    out.println("<tr>");
                    //seleccionar la patente que sera eliminada
                    out.println("<td>Ingrese la patente del vehiculo que desea eliminar</td><td><select type='text' name='patente'>");
                    out.println("<option selected>Seleccione</option>");
                    for(Vehiculo aux : listaVehiculos){
                       out.println("<option>"+aux.getPatente()+"</option>");
                    }
                    
                    out.println("</select></td></br>");
                    out.println("<input type='submit' value='Eliminar Vehiculo'>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("<br/> <br/>");
                    //imprimir lista de patentes registradas
                    out.println("<table border = '1' align ='center'>");
                    out.println("<tr>");
                    out.println("<th>Patente</th>");
                    out.println("<th>Marca</th>");
                    out.println("<th>Modelo</th>");
                    out.println("<th>Color</th>");
                    out.println("<th>Año de fabricacion</th>");
                    out.println("<th>Estado</th>");
                    out.println("</tr>");
                    for (Vehiculo p : listaVehiculos) {
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
                    out.println("<br/> <br/>");
                    out.println("<a href ='menu.view'>Volver</a >");
            }
            out.println("</center>");
            out.println("</body>");
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
