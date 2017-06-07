package cl.vista;

import cl.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ingarriendo extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesionOK = request.getSession();
        Usuario usuario = (Usuario) sesionOK.getAttribute("usuario");
        ArrayList errores = (ArrayList) request.getAttribute("errores");
        String msg = (String) request.getAttribute("msg");
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
        int dias = 0;
        int valorDia = 0;
        try {
            dias = Integer.parseInt(strdias);
        } catch (NumberFormatException e) {
            strdias = "";
        }
        try {
            valorDia = Integer.parseInt(strvalorDia);
        } catch (NumberFormatException e) {
            strvalorDia = "";
        }

        if (msg != null) {
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
                out.println("<form action='ingresar.do' method='POST'>");
                out.println("<table>");
                out.println("<tr><td>Código</td><td><input type='text' name='codigo' value='" + codigo + "'></td>");
                out.println("<tr><td>Patente</td><td><input type='text' name='patenteV' value='" + patenteV + "' size='40'></td>");
                out.println("<tr><td>Rut Cliente</td><td><input type='text' name='rutCli' value='" + rutCli + "'></td>");
                out.println("<tr><td>Fecha</td><td><input type='text' name='fecha' value='" + fecha + "'></td>");
                out.println("<tr><td>Cantidad de dias</td><td><input type='text' name='dias' value='" + strdias + "'></td>");
                out.println("<tr><td>Valor por dia</td><td><input type='text' name='valorDia' value='" + strvalorDia + "'></td>");
                out.println("<tr><td colspan='2' align='right'><input type='submit' value='Agregar'></td>");
                out.println("</table>");
                if (errores == null) {
                    out.println("<table>");
                    for (int i = 0; i < errores.size(); i++) {
                        out.println("<tr>");
                        out.println("<td align='left'>" + errores.get(i) + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
                if (errores == null && msg != null) {
                    out.println("<font>" + msg + "</font>");
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
}
