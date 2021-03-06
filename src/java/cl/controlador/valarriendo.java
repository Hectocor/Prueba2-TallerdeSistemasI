package cl.controlador;

import cl.modelo.Arriendo;
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

/**
 *
 * @author Hector
 */
@WebServlet(name = "valarriendo", urlPatterns = {"valarriendo.do"})
public class valarriendo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList errores2 = new ArrayList();

        String codigo = request.getParameter("codigo");
        String patenteV = request.getParameter("patenteV");
        String rutCli = request.getParameter("rutCli");
        String fecha = request.getParameter("fecha");
        String strdias = request.getParameter("dias");
        String strvalorDia = request.getParameter("valorDia");
        int dias = 0;
        int valorDia = 0;

        if (codigo.isEmpty()) {
            errores2.add("Falta ingresar Codigo");
        }

        if (request.getParameter("patenteV").equals("1")){
            errores2.add("Falta ingresar Patente");
        }
        if(request.getParameter("rutCli").equals("1")){
            errores2.add("Falta ingresar Rut Cliente");
        }
        
        if (fecha.isEmpty()) {
            errores2.add("Falta ingresar Fecha");
        }
        if (strdias.isEmpty()) {
            errores2.add("Falta ingresar cantidad de dias");
        } else {
            try {
                dias = Integer.parseInt(strdias);
            } catch (NumberFormatException e) {
                errores2.add("ERROR, Solo ingresar datos numéricos para cantidad de días");
            }
        }

        if (strvalorDia.isEmpty()) {
            errores2.add("Falta ingresar valor por día");
        } else {
            try {
                valorDia = Integer.parseInt(strvalorDia);
            } catch (NumberFormatException e) {
                errores2.add("Error, Solo ingresar datos numéricos para valor por día");
            }
        }

        if (errores2.isEmpty()) {

            Arriendo arriendo = new Arriendo(codigo, patenteV, rutCli, fecha, dias, valorDia);

            List<Arriendo> listaArriendos = (List<Arriendo>) getServletContext().getAttribute("listaArriendos");
            listaArriendos.add(arriendo);
            //se deja en ambito de contexto la lista de arriendos
            getServletContext().setAttribute("listaArriendos", listaArriendos);

            List<Vehiculo> listaVehiculos = (List<Vehiculo>) getServletContext().getAttribute("listaVehiculos");

            for (int i = 0; i < listaVehiculos.size(); i++) {
                Vehiculo aux = (Vehiculo) listaVehiculos.get(i);
                if (aux.getPatente().equals(patenteV)) {
                    aux.setPatente(aux.getPatente());
                    aux.setEstado("NO DISPONIBLE");
                    aux.setColor(aux.getColor());
                    aux.setAnioFabricacion(aux.getAnioFabricacion());
                    aux.setMarca(aux.getMarca());
                    aux.setModelo(aux.getModelo());
                    listaVehiculos.set(i, aux);
                }
            }

            getServletContext().setAttribute("listaVehiculos", listaVehiculos);

            String msj = "Arriendo añadido correctamente";
            System.out.println(msj);
            request.setAttribute("msj", msj);
            RequestDispatcher rd = request.getRequestDispatcher("ingarriendo.view");
            rd.forward(request, response);

        } else {

            //Dejar en al ambito de solicitud los errores
            request.setAttribute("errores2", errores2);
            String msj = "Se han encontrado los siguientes errores: ";
            request.setAttribute("msj", msj);
            //Redireccionar a otro componente (pasar el control)
            RequestDispatcher vista = request.getRequestDispatcher("ingarriendo.view");
            vista.forward(request, response);
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
