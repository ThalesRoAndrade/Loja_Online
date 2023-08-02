package loja_online;

public class Usuario {
    public int ID;
    
    public String email;
    
    public String nome;
    
    Usuario(String email, String nome){
    	this.email = email;
    	this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return null; //
    }
}

