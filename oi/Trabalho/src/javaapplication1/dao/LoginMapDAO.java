package javaapplication1.dao;
import java.util.Map;
import java.util.TreeMap;
import javaapplication1.domain.Login;


public class LoginMapDAO implements ILoginDAO {
    
    private Map<String, Login> map;
    
    public LoginMapDAO() {
        map = new TreeMap<>();
    }

    @Override
    public Boolean cadastrar(Login login) {
        if (map.containsKey(login.getEmail())) {
            System.out.println("Falha ao cadastrar: Email já existe");
            return false;
        }
        
        map.put(login.getEmail(), login);
        System.out.println("Cadastro bem-sucedido: " + login.getEmail());
        return true;
    }
    
    @Override
    public boolean verificarLogin(String email, String senha) {
        Login login = map.get(email);
        return login != null && login.getSenha().equals(senha);
    }

    @Override
    public Login consultar(String email) {
        return this.map.get(email);
    }
    
}
