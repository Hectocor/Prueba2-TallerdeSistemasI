
package cl.controlador;
import cl.modelo.Arriendo;
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

                ArrayList errores = new ArrayList();
                int VALOR_ARRIENDO = 0;

            if (PatenteV.isEmpty()) {
            errores.add("Debe ingresar la patente del vehiculo");
        }     
        

        if (errores.isEmpty()) {
            
            List<Arriendo> listaArriendos = (List<Arriendo>) getServletContext().getAttribute("listaArriendos");
            List<Vehiculo> listaVehiculos = (List<Vehiculo>) getServletContext().getAttribute("listaVehiculos");
            
            for(Arriendo arr : listaArriendos){
                for(Vehiculo v : listaVehiculos){
                    if(arr.getPatenteV().equals(v.getPatente())){
                        if(arr.getPatenteV().equals(PatenteV)){
                            VALOR_ARRIENDO += arr.calculoArriendo();
                        }
                    }
                }
                
            }
            
            /*
            for (int i = 0; i < listaVehiculos.size(); i++) {
                Vehiculo aux = (Vehiculo) listaVehiculos.get(i);
                    if (aux.getPatente().equals(PatenteV)) {
                           */
                            
                    request.setAttribute("mensaje", "El monto es:"+VALOR_ARRIENDO);
                    RequestDispatcher rd = request.getRequestDispatcher("monto.view");
                    rd.forward(request, response);
                    }
                else {
                request.setAttribute("errores", errores);
                RequestDispatcher rd = request.getRequestDispatcher("monto.view");
                rd.forward(request, response);
                
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
