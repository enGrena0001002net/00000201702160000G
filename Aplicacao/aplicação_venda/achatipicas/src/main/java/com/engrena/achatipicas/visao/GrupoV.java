/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.visao;

import com.engrena.achatipicas.entidade.Regra;
import com.engrena.achatipicas.entidade.Grupo;
import com.engrena.achatipicas.regras.RegraR;
import com.engrena.achatipicas.regras.GrupoR;
import com.engrena.achatipicas.util.Utilitarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "grupoV")
@SessionScoped
public class GrupoV implements Serializable {
    
    @Inject
    GrupoR objR;
    @Inject
    RegraR regrasR;
    
    Utilitarios util = new Utilitarios();
    Grupo frmGrupo;
    
    String codigoPesquiosa;
    List<Grupo> listarGrupo;
    List<Regra> regrasslistSelect;
    Regra selectRegra;
    
    public List<Regra> listarRegras() {
        
        return regrasR.findAll();
    }
    
    public void novo() {
        
        setFrmGrupo(new Grupo());
        
    }
    
    public void adicionaRegra() {
        if (getSelectRegra().getGrupoList() == null) {
            getSelectRegra().setGrupoList(new ArrayList<Grupo>());
        }
        getSelectRegra().getGrupoList().add(getFrmGrupo());
        getFrmGrupo().getRegraList().add(getSelectRegra());
        if (!getFrmGrupo().getRegraList().isEmpty()) {
            
            salvar();
            regrasR.salvar(getSelectRegra());
            
        } else {
            util.retornaMessageErro("Não há Objetos para Associar!!");
        }
        
    }
    
    public void removerRegra(Regra regras) {
        regras.getGrupoList().remove(getFrmGrupo());
        
        getFrmGrupo().getRegraList().remove(regras);
        salvar();
        regrasR.salvar(regras);
        
    }
    
    public Boolean verificaSejaSelecionado(Regra regras) {
        Boolean retorno = false;
        if (getFrmGrupo().getRegraList() != null) {
            retorno = getFrmGrupo().getRegraList().contains(regras);
        }
        
        return retorno;
        
    }
    
    public void salvarRegra() {
        
    }
    
    public void cancelar() {
        
        setFrmGrupo(null);
        setSelectRegra(null);
        
    }
    
    public void receberGrupo(Grupo item) {
        if (item.getRegraList() == null) {
            item.setRegraList(new ArrayList<Regra>());
        }
        setFrmGrupo(item);
        
    }
    
    public void salvar() {
        
        objR.salvar(getFrmGrupo());
        
    }
    
    public void pesquisar() {
        System.out.println("getCodigoPesquiosa()" + getCodigoPesquiosa());
        setListarGrupo(objR.pesquisaGrupo(getCodigoPesquiosa()));
        
    }
    
    public void limparPesquisa() {
        setListarGrupo(null);
        setCodigoPesquiosa("");
    }
    
    public Grupo getFrmGrupo() {
        if (frmGrupo == null) {
            frmGrupo = new Grupo();
        }
        return frmGrupo;
    }
    
    public void setFrmGrupo(Grupo frmGrupo) {
        this.frmGrupo = frmGrupo;
    }
    
    public String getCodigoPesquiosa() {
        return codigoPesquiosa;
    }
    
    public void setCodigoPesquiosa(String codigoPesquiosa) {
        this.codigoPesquiosa = codigoPesquiosa;
    }
    
    public List<Grupo> getListarGrupo() {
        return listarGrupo;
    }
    
    public void setListarGrupo(List<Grupo> listarGrupo) {
        this.listarGrupo = listarGrupo;
    }
    
    public List<Regra> getRegraslistSelect() {
        
        if (regrasslistSelect == null) {
            regrasslistSelect = new ArrayList<>();
        }
        
        return regrasslistSelect;
    }
    
    public void setRegraslistSelect(List<Regra> regrasslistSelect) {
        this.regrasslistSelect = regrasslistSelect;
    }
    
    public Regra getSelectRegra() {
        return selectRegra;
    }
    
    public void setSelectRegra(Regra selectRegra) {
        this.selectRegra = selectRegra;
    }

    /**
     * Creates a new instance of GrupoV
     */
    public GrupoV() {
    }
    
}
