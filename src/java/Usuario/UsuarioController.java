/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import DAO.UsuarioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class UsuarioController {
    
    UsuarioDAO model;
    
    public UsuarioController()
    {
        model = new UsuarioDAO();
    }
    
    public void cadastraUsuario(Usuario user)
    {
        model.insereUsuario(user);
    }
    
    public void removeUsuario(Usuario user)
    {
        model.deleteUsuario(user);
    }
    
    public Usuario getUsuario(String login)
    {
        return model.getUsuario(login);
    }
    
    public Usuario efetuaLogin(String login,String senha)
    {
        Usuario u = this.getUsuario(login);
     
        return u;
    }
}
