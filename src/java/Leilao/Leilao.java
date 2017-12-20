/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leilao;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Leilao {
    private int id;
    private String descricao;
    private int status;
    private float lanceMinino;
    private float valorLance;
    private ArrayList<Lance> lances;
    
    public float getValor()
    {
        if(lances == null || lances.size()==0) return lanceMinino;
        else return lances.get(lances.size()-1).getPrecolance();
    }
    public float getLanceMinino() {
        return lanceMinino;
    }

    public String getLastUser()
    {
        if(lances == null || lances.size()==0) return "";
        else return lances.get(lances.size()-1).getUsuario().getNome();
    }
    public void setLanceMinino(float lanceMinino) {
        this.lanceMinino = lanceMinino;
    }

    public float getValorLance() {
        return valorLance;
    }

    public void setValorLance(float valorLance) {
        this.valorLance = valorLance;
    }

    public ArrayList<Lance> getLances() {
        return lances;
    }

    public void setLances(ArrayList<Lance> lances) {
        this.lances = lances;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
