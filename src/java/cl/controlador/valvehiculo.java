package cl.controlador;



import cl.modelo.Vehiculo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "valvehiculo", urlPatterns = {"/valvehiculo.do"})
public class valvehiculo extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Patente = request.getParameter("patente");
        String Marca = request.getParameter("marca");
        String Modelo = request.getParameter("modelo");
        String Color = request.getParameter("color");
        String Estado = request.getParameter("estado");
        
        int intAnyo = 0;
        
        ArrayList errores = new ArrayList();
        
        if(Patente.isEmpty()){
            errores.add("Ingrese datos, Campo Patente vacío");
        }
        if(Marca.isEmpty()){
            errores.add("Ingrese datos, Campo Marca vacío");
        }
        if(Modelo.isEmpty()){
            errores.add("Ingrese datos, Campo Modelo vacío");
        }
        if(Color.isEmpty()){
            errores.add("Ingrese datos, Campo Color vacío");
        }
        if(Estado.isEmpty()){
            errores.add("Ingrese datos, Campo Estado vacío");
        }
        
        try {
            intAnyo = Integer.parseInt(request.getParameter("anio"));
        } catch (NumberFormatException e) {
           errores.add("ERROR, Solo ingresar datos numéricos para cantidad año");
        }
         
        
        if(errores.isEmpty()){

            
            Vehiculo vehiculo = new Vehiculo(Patente, Marca, Modelo, Color, intAnyo, Estado);
            List<Vehiculo> listaVehiculos = (List<Vehiculo>) getServletContext().getAttribute("listaVehiculos");
            
            listaVehiculos.add(vehiculo);
            
            getServletContext().setAttribute("listaVehiculos", listaVehiculos);
            String msg = "Vehiculo ingresado correctamente";
            request.setAttribute("msg", msg);
            RequestDispatcher rd = request.getRequestDispatcher("ingvehiculo.view");
            rd.forward(request, response);
            
        }else{
            request.setAttribute("errores", errores);
            RequestDispatcher rd = request.getRequestDispatcher("errores.view");
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
