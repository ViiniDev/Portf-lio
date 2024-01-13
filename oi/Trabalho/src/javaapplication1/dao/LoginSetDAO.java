package javaapplication1.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import javaapplication1.domain.Login;

public class LoginSetDAO implements ILoginDAO {

    private Set<Login> set;

    public LoginSetDAO() {
        this.set = carregarDados();
    }

    @Override
    public Boolean cadastrar(Login login) {
        boolean sucesso = this.set.add(login);
        if (sucesso) {
            salvarDados(); // Salva os dados após cadastrar um novo login
        }
        return sucesso;
    }

    @Override
    public boolean verificarLogin(String email, String senha) {
    Login login = consultar(email);
    if (login != null && login.getSenha().equals(senha)) {
        System.out.println("Login encontrado e senha coincidente.");
        return true;
    } else {
        System.out.println("Login não encontrado ou senha incorreta.");
        return false;
    }
}

    @Override
    public Login consultar(String email) {
    for (Login clienteCadastrado : this.set) {
        if (clienteCadastrado.getEmail().equals(email)) {
            System.out.println("Login encontrado para o email: " + email);
            return clienteCadastrado;
        }
    }
    System.out.println("Login não encontrado para o email: " + email);
    return null;
}

    private Set<Login> carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("logins.dat"))) {
            return (HashSet<Login>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Arquivo ainda não existe, retornamos um conjunto vazio
            return new HashSet<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    private void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("logins.dat"))) {
            oos.writeObject(this.set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
