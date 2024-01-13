package javaapplication1.dao;

import javaapplication1.domain.Login;

public interface ILoginDAO {
    
   public Boolean cadastrar(Login login);
   public boolean verificarLogin(String email, String senha);
   public Login consultar(String email);

 
}
