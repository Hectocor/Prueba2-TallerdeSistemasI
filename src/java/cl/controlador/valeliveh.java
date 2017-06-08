package cl.controlador;

import cl.modelo.Usuario;
import cl.modelo.Vehiculo;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "valeliveh", urlPatterns = {"/valeliveh.do"})
public class valeliveh extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String patenteAEliminar = request.getParameter("patente");
        HttpSession sesionOK = request.getSession();
        Usuario usuario = (Usuario) sesionOK.getAttribute("USUARIO");
        List<Vehiculo> listaVehiculos = (List<Vehiculo>) getServletContext().getAttribute("listaVehiculos");
        
        //recorre la lista de vehiculos previamente ingresados
         for (int i = 0; i < listaVehiculos.size(); i++) {
                    Vehiculo aux = (Vehiculo) listaVehiculos.get(i);
                    //si la patente a eliminar se iguala a uno dentro de la lista lo elimina
                    if (aux.getPatente().equals(patenteAEliminar)) {
                        eliminaIndice(listaVehiculos, i);
                    } 
            }
         //testeo por consola para verificar si el vehiculo a sido eliminado
         for(Vehiculo vehiculo : listaVehiculos){
             System.out.println(vehiculo.getModelo());
         }
         //redirige a la vista de eliminacion
         RequestDispatcher rd = request.getRequestDispatcher("eliminaveh.view");
         rd.forward(request, response);
    }
    //funcion para la eliminacion
    public void eliminaIndice(List<Vehiculo> vehiculo, int index){
         vehiculo.remove(index);
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
