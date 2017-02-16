/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.visao;

import com.engrena.achatipicas.entidade.Acao;
import com.engrena.achatipicas.regras.AcaoR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "acaoV")
@SessionScoped
public class AcaoV implements Serializable {
    
    @Inject
    AcaoR acaoR;
    Acao frmAcao;
    
    String codigoPesquiosa;
    List<Acao> listarAcao;
    
    public void novo() {
        
        setFrmAcao(new Acao());
        
    }

    public void receberAcao(Acao item) {
        setFrmAcao(item);
        
    }
    
    public void salvar() {
        
        acaoR.salvar(getFrmAcao());
        
    }
    
    public void pesquisar() {
        
        setListarAcao(acaoR.pesquisaAcao(getCodigoPesquiosa()));
        
    }
    
    public void limparPesquisa() {
        setListarAcao(null);
        setCodigoPesquiosa("");
    }
    
    public Acao getFrmAcao() {
        if (frmAcao == null) {
            frmAcao = new Acao();
        }
        return frmAcao;
    }
    
    public void setFrmAcao(Acao frmAcao) {
        this.frmAcao = frmAcao;
    }
    
    public String getCodigoPesquiosa() {
        return codigoPesquiosa;
    }
    
    public void setCodigoPesquiosa(String codigoPesquiosa) {
        this.codigoPesquiosa = codigoPesquiosa;
    }
    
    public List<Acao> getListarAcao() {
        return listarAcao;
    }
    
    public void setListarAcao(List<Acao> listarAcao) {
        this.listarAcao = listarAcao;
    }

    /**
     * Creates a new instance of AcaoV
     */
    public AcaoV() {
    }
    
}
