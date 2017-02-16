/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.visao;

import com.engrena.achatipicas.entidade.Grupo;
import com.engrena.achatipicas.entidade.TipoUsuario;
import com.engrena.achatipicas.regras.GrupoR;
import com.engrena.achatipicas.regras.TipoUsuarioR;

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
@Named(value = "tipoUsuarioV")
@SessionScoped
public class TipoUsuarioV implements Serializable {
    
    @Inject
    TipoUsuarioR objR;
    @Inject
    GrupoR gruposR;
    
    Utilitarios util = new Utilitarios();
    TipoUsuario frmTipoUsuario;
    
    String codigoPesquiosa;
    List<TipoUsuario> listarTipoUsuario;
    List<Grupo> gruposslistSelect;
    Grupo selectGrupo;
    
    public List<Grupo> listarGrupos() {
        
        return gruposR.findAll();
    }
    
    public void novo() {
        
        setFrmTipoUsuario(new TipoUsuario());
        
    }
    
    public void adicionaGrupo() {
        if (getSelectGrupo().getTipoUsuarioList() == null) {
            getSelectGrupo().setTipoUsuarioList(new ArrayList<TipoUsuario>());
        }
        
        getSelectGrupo().getTipoUsuarioList().add(getFrmTipoUsuario());
        getFrmTipoUsuario().getGrupoList().add(getSelectGrupo());
        if (!getFrmTipoUsuario().getGrupoList().isEmpty()) {
            
            salvar();
            gruposR.salvar(getSelectGrupo());
            
        } else {
            util.retornaMessageErro("Não há Objetos para Associar!!");
        }
        
    }
    
    public void removerGrupo(Grupo grupos) {
        getFrmTipoUsuario().getGrupoList().remove(grupos);
        
        grupos.getTipoUsuarioList().remove(getFrmTipoUsuario());
        salvar();
        gruposR.salvar(grupos);
        
    }
    
    public Boolean verificaSejaSelecionado(Grupo grupos) {
        Boolean retorno = false;
        if (getFrmTipoUsuario().getGrupoList() != null) {
            retorno = getFrmTipoUsuario().getGrupoList().contains(grupos);
        }
        
        return retorno;
        
    }
    
    public void salvarGrupo() {
        
    }
    
    public void cancelar() {
        
        setFrmTipoUsuario(null);
        setSelectGrupo(null);
        
    }
    
    public void receberTipoUsuario(TipoUsuario item) {
        if (item.getGrupoList() == null) {
            item.setGrupoList(new ArrayList<Grupo>());
        }
        setFrmTipoUsuario(item);
        
    }
    
    public void salvar() {
        
        objR.salvar(getFrmTipoUsuario());
        
    }
    
    public void pesquisar() {
        System.out.println("getCodigoPesquiosa()" + getCodigoPesquiosa());
        setListarTipoUsuario(objR.pesquisaTipoUsuario(getCodigoPesquiosa()));
        
    }
    
    public void limparPesquisa() {
        setListarTipoUsuario(null);
        setCodigoPesquiosa("");
    }
    
    public TipoUsuario getFrmTipoUsuario() {
        if (frmTipoUsuario == null) {
            frmTipoUsuario = new TipoUsuario();
        }
        return frmTipoUsuario;
    }
    
    public void setFrmTipoUsuario(TipoUsuario frmTipoUsuario) {
        this.frmTipoUsuario = frmTipoUsuario;
    }
    
    public String getCodigoPesquiosa() {
        return codigoPesquiosa;
    }
    
    public void setCodigoPesquiosa(String codigoPesquiosa) {
        this.codigoPesquiosa = codigoPesquiosa;
    }
    
    public List<TipoUsuario> getListarTipoUsuario() {
        return listarTipoUsuario;
    }
    
    public void setListarTipoUsuario(List<TipoUsuario> listarTipoUsuario) {
        this.listarTipoUsuario = listarTipoUsuario;
    }
    
    public List<Grupo> getGruposlistSelect() {
        
        if (gruposslistSelect == null) {
            gruposslistSelect = new ArrayList<>();
        }
        
        return gruposslistSelect;
    }
    
    public void setGruposlistSelect(List<Grupo> gruposslistSelect) {
        this.gruposslistSelect = gruposslistSelect;
    }
    
    public Grupo getSelectGrupo() {
        return selectGrupo;
    }
    
    public void setSelectGrupo(Grupo selectGrupo) {
        this.selectGrupo = selectGrupo;
    }

    /**
     * Creates a new instance of TipoUsuarioV
     */
    public TipoUsuarioV() {
    }
    
}
