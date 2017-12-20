/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leilao;

import Usuario.Usuario;

/**
 *
 * @author User
 */
public class Lance {
    private int id;
    private float precolance;
    private Leilao leilao;
    private Usuario usuario;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecolance() {
        return precolance;
    }

    public void setPrecolance(float precolance) {
        this.precolance = precolance;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getUsuarioNome()
    {
        return this.usuario.getNome();
    }
}
