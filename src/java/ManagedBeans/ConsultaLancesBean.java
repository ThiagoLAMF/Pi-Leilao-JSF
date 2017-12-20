/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DAO.LeilaoDAO;
import Leilao.Lance;
import Leilao.LeilaoController;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author User
 */
@Named(value = "consultaLancesBean")
@SessionScoped
public class ConsultaLancesBean implements Serializable {
    private int idLeilao;
    
    /**
     * Creates a new instance of ConsultaLancesBean
     */
    public ConsultaLancesBean() {
         
    }
    
    public int getIdLeilao()
    {
        return idLeilao;
    }
    
    public void setIdLeilao(int id)
    {
        this.idLeilao = id;
    }
    
    public ArrayList<Lance> getLance()
    {
        LeilaoController lc = new LeilaoController();
        return lc.getLance(idLeilao);
    }
    
    public String action()
    {
        idLeilao = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idLeilao"));
        System.out.println("ID: " + idLeilao );
        return "consultalances";
    }
    
    
}
