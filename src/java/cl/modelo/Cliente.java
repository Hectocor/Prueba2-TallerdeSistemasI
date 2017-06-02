
package cl.modelo;

/**
 *
 * @author Miguel
 */
public class Cliente {
    private String rut;
    private String nombre;
    private String domicilio;
    private int celular;
    private String email;

    public Cliente(String rut, String nombre, String domicilio, int celular, String email) {
        this.rut = rut;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.celular = celular;
        this.email = email;
    }
    
    public Cliente(){
        
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
