/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DAO.LeilaoDAO;
import Leilao.Lance;
import Leilao.Leilao;
import Leilao.LeilaoController;
import Usuario.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@Named(value = "consultaBean")
@SessionScoped
public class ConsultaBean implements Serializable {

    /**
     * Creates a new instance of ConsultaBean
     */
    public ConsultaBean() {
    }
    
    public ArrayList<Leilao> getLeilao()
    {
        LeilaoController lc = new LeilaoController();
        return lc.getLeilao();
    }
    
    public String darLance(int idLeilao, float valorLance,float lanceMinimo)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Usuario u = (Usuario) session.getAttribute("usuario");
        
        if( u != null)
        {
            Lance lance = new Lance();
            Leilao l = new Leilao();
            l.setId(idLeilao);
        
            lance.setLeilao(l);
            lance.setUsuario(u);
            lance.setPrecolance(lanceMinimo);
        
            LeilaoController lc = new LeilaoController();
        
            lc.adicionaLance(lance);
        }
        
        return "consulta";
    }
    
    public String encerrarLeilao(int idLeilao)
    {
        LeilaoController lc = new LeilaoController();
        
        lc.encerrarLeilao(idLeilao);
        
        return "consulta";
    }
}
