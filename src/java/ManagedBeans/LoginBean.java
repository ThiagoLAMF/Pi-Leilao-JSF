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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    private String login;
    private String senha;
    
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    
    public String getLogin()
    {
        return this.login;
    }
    
    public void setLogin(String login)
    {
        this.login = login;
    }
    
    public String getSenha()
    {
        return this.senha;
    }
    
    public void setSenha(String senha)
    {
        this.senha = senha;
    }
    
    public String efetuaLogin()
    {
        UsuarioController uc = new UsuarioController();
        
        Usuario u = uc.efetuaLogin(login, senha);
        
        
        
        if(u == null) //Login sem sucesso
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos!", null));
            return null;
        }
        else //Sucesso -> Login retorna usuário
        {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.setAttribute("usuario", u);
            return "menu";
        }
    }
}
