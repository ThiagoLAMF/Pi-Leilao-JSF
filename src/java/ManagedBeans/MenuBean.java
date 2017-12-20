/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@Named(value = "menuBean")
@SessionScoped
public class MenuBean implements Serializable {

    /**
     * Creates a new instance of MenuBean
     */
    public MenuBean() {
    }
    
    
    public String efetuarLogout()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.setAttribute("usuario", null);
        
        return "index";
    }
}
