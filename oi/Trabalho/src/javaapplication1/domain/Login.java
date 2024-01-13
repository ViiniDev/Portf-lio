package javaapplication1.domain;

import java.io.Serializable;

public class Login implements Serializable {
    private static final long serialVersionUID = 1L;


    private String nome, email, senha;

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public void cadastrar(String nome, String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;

    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }




}
