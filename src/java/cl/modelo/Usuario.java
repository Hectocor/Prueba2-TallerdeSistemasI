package cl.modelo;

public class Usuario {
        private String login;
        private String password;
        private String rol;


    public Usuario(){

    }
    
    public Usuario(String login,String password,String rol){
        this.login=login;
        this.password=password;
        this.rol=rol;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}