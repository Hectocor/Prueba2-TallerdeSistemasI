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
}