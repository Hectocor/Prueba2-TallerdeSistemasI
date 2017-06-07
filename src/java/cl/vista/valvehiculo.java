package cl.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        String Ano = request.getParameter("anioFabricacion");
        String Estado = request.getParameter("estado");
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
        if(Ano.isEmpty()){
            errores.add("Ingrese datos, Campo Año vacío");
        }
        if(Estado.isEmpty()){
            errores.add("Ingrese datos, Campo Estado vacío");
        }
        if(errores.isEmpty()){
            String msg = "Vehiculo ingresado correctamente";
            request.setAttribute("msg", msg);
            RequestDispatcher rd = request.getRequestDispatcher("valvehiculo.do");
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
