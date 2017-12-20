/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Usuario.Usuario;
import Usuario.UsuarioController;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author User
 */
@Named(value = "cadastroUsuarioBean")
@SessionScoped
public class CadastroUsuarioBean implements Serializable{

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    private String login;
    private String senha;
    /**
     * Creates a new instance of CadastroUsuarioBean
     */
    public CadastroUsuarioBean() {
    }
    
    
    public String efetuarCadastro()
    {   
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setLogin(login);
        novoUsuario.setSenha(senha);
        novoUsuario.setAdmin(false);
        
        UsuarioController uc = new UsuarioController();
        
        uc.cadastraUsuario(novoUsuario);
        
        return "index";
    
    }
}
