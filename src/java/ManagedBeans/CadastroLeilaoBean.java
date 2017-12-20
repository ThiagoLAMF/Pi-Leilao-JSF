/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Leilao.Leilao;
import Leilao.LeilaoController;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author User
 */
@Named(value = "cadastroLeilaoBean")
@SessionScoped
public class CadastroLeilaoBean implements Serializable{

    private String desc;
    private Float lancemin;
    private Float valorlance;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Float getLancemin() {
        return lancemin;
    }

    public void setLancemin(Float lancemin) {
        this.lancemin = lancemin;
    }

    public Float getValorlance() {
        return valorlance;
    }

    public void setValorlance(Float valorlance) {
        this.valorlance = valorlance;
    }

    
    /**
     * Creates a new instance of CadastroLeilaoBean
     */
    public CadastroLeilaoBean() {
    }
    
    
    public String cadastraLeilao()
    {
        LeilaoController lc = new LeilaoController();
        
        Leilao l = new Leilao();
        l.setDescricao(desc);
        l.setLanceMinino(lancemin);
        l.setValorLance(valorlance);
        l.setFgEncerrado(false);
        
        
        lc.cadastrarLeilao(l);
        
        return "menu";
    }
}
