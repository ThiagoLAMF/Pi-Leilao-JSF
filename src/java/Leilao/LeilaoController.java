/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leilao;

import DAO.LeilaoDAO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class LeilaoController {
    
    public ArrayList<Leilao> getLeilao()
    {
        return LeilaoDAO.getLeilao();
    }
    
    public void cadastrarLeilao(Leilao l)
    {
        LeilaoDAO.insereLeilao(l);
    }
    
    public void adicionaLance(Lance l)
    {
        LeilaoDAO.addLance(l);
    }
    
    public ArrayList<Lance> getLance(int idleilao)
    {
        return LeilaoDAO.getLances(idleilao);
    }
    
    public void encerrarLeilao(int idLeilao)
    {
        LeilaoDAO.encerraLeilao(idLeilao);
    }
}
