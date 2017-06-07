
package cl.controlador;
import cl.modelo.Vehiculo;
import java.util.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "calcmonto", urlPatterns = {"/calcmonto.do"})
public class calcmonto extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                String PatenteV = request.getParameter("patenteV");
                String Dias = request.getParameter("dias");
                String ValorDia = request.getParameter("valorDia");
                ArrayList errores = new ArrayList();
                
            int monto=0;
            int dias=0;
            if (PatenteV.isEmpty()) {
            errores.add("Debe ingresar la patente del vehiculo");
        }     
        if (Dias.isEmpty()) {
                try {
                dias = Integer.parseInt(Dias);
            } catch (NumberFormatException e) {
            errores.add("El vehiculo debe haber estado arrendado por un dia o mas para calcular el total del arriendo");
            }
        }     
          if (ValorDia.isEmpty()) {
                try {
                     monto = Integer.parseInt(ValorDia);
                    if (monto < 0) {
                    errores.add("Precio debe ser mayor a cero");
                }

            } catch (NumberFormatException e) {
                errores.add("Campo debe ser numerico");
            }     
        }     
        
        
        if (errores.isEmpty()) {
            List<Vehiculo> listaVehiculos = (ArrayList) getServletContext().getAttribute("listaVehiculos");
            for (int i = 0; i < listaVehiculos.size(); i++) {
                Vehiculo aux = (Vehiculo) listaVehiculos.get(i);
                    if (aux.getPatente().equals(PatenteV)) {
                            monto*=dias;
                            
                    request.setAttribute("mensaje", "El monto es:");
                    RequestDispatcher rd = request.getRequestDispatcher("monto.view");
            rd.forward(request, response);
                    }
                else {
                request.setAttribute("errores", errores);
                RequestDispatcher rd = request.getRequestDispatcher("monto.view");
                rd.forward(request, response);
                }
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
