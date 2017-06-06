package cl.controlador;

import cl.modelo.Usuario;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "validaus", urlPatterns = {"/validaus.do"})
public class validaus extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recojemos parametros del form mediante su name
        String campo_usuario = request.getParameter("login");
        String campo_clave = request.getParameter("pass");
        //se declara un flag para controlar estado
        boolean flag = true;
        
        ArrayList errores = new ArrayList();
        //se comprueba si estan vacios los campos del form, cada uno por si solo
        if(campo_usuario.isEmpty()){
            errores.add("Ingrese datos, Campo Usuario vacío");
        }
        if(campo_clave.isEmpty()){
            errores.add("Ingrese datos, Campo Clave vacío");
        }
        //si no existen errores se procede al inicio de sesion
        if(errores.isEmpty()){
            
            Usuario usuario = new Usuario(campo_usuario, campo_clave);
            List<Usuario> listaUsuarios = (List<Usuario>) getServletContext().getAttribute("listaUsuarios");
            
            for(Usuario user : listaUsuarios){
                if(user.getLogin().equals(usuario.getLogin()) && user.getPassword().equals(usuario.getPassword())){
                   //System.out.println(user.getLogin()+" "+ user.getPassword()+" "+ user.getRol());
                   //se cambia el estado del flag controlador
                   flag = false;
                  
                   HttpSession sesionActiva = request.getSession();
                   sesionActiva.setAttribute("USUARIO", user);
                   RequestDispatcher rd = request.getRequestDispatcher("menu.view");
                  rd.forward(request, response);
                    
                }
            }
            //flag es true quiere decir que no se inició sesion ya que los datos no concuerdan
            //negar negación :D => if(flag == true)
            if(!!flag){
                errores.add("Usuario no válido | Datos erroneos");
                
                request.setAttribute("errores", errores);
                
                RequestDispatcher rd = request.getRequestDispatcher("errores.view");
                rd.forward(request, response);
            }
            
            //se envía a la vista de errores
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
