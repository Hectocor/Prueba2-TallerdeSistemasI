
package cl.modelo;

/**
 *
 * @author Hector
 */
public class Arriendo {
    private String codigo;
    private String patenteV;
    private String rutCli;
    private String fecha;
    private int dias;
    private int valorDia;
    
    public Arriendo(){
        
    }

    public Arriendo(String codigo, String patenteV, String rutCli, String fecha, int dias, int valorDia){
        this.codigo = codigo;
        this.patenteV = patenteV;
        this.rutCli = rutCli;
        this.fecha = fecha;
        this.dias = dias;
        this.valorDia = valorDia;
    }
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPatenteV() {
        return patenteV;
    }

    public void setPatenteV(String patenteV) {
        this.patenteV = patenteV;
    }

    public String getRutCli() {
        return rutCli;
    }

    public void setRutCli(String rutCli) {
        this.rutCli = rutCli;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getValorDia() {
        return valorDia;
    }

    public void setValorDia(int valorDia) {
        this.valorDia = valorDia;
    }
    
    public int calculoArriendo(){
        int calcularArriendo = this.valorDia * this.dias;
        return calcularArriendo;
    }
}
