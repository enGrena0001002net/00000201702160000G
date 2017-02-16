/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.visao;

import com.engrena.achatipicas.entidade.Loja;
import com.engrena.achatipicas.entidade.Usuario;
import com.engrena.achatipicas.regras.LojaR;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "lojaV")
@SessionScoped
public class LojaV implements Serializable {

    @Inject
    LojaR objR;
    Loja frmLoja;
    String codigoPesquiosa;
    List<Loja> listarLoja;
    String lojaNome;
    Boolean lojaDeliv;
    Boolean lojaAtiva;
    String lojaEndCep;
    Boolean fone;

    public void novo() {

        setFrmLoja(new Loja());

    }

    public void desativar(Loja obj) {
        objR.desativar(obj);
    }

    public void ativar(Loja obj) {
        objR.ativar(obj);
    }

    public void receberLoja(Loja item) {
        setFrmLoja(item);

    }

    public void salvar() {

        objR.salvar(getFrmLoja());

    }

    public void pesquisar() {

        setListarLoja(objR.pesquisaLoja(getLojaNome(), getLojaDeliv(), getLojaAtiva(), getLojaEndCep()));

    }

    public void limparPesquisa() {
        setListarLoja(null);
        setCodigoPesquiosa("");
        setLojaNome(null);
        setLojaDeliv(null);
        setLojaAtiva(null);
        setLojaEndCep(null);
    }

    public Loja getFrmLoja() {
        if (frmLoja == null) {
            frmLoja = new Loja();
        }
        return frmLoja;
    }

    public void setFrmLoja(Loja frmLoja) {
        this.frmLoja = frmLoja;
    }

    public String getCodigoPesquiosa() {
        return codigoPesquiosa;
    }

    public void setCodigoPesquiosa(String codigoPesquiosa) {
        this.codigoPesquiosa = codigoPesquiosa;
    }

    public List<Loja> getListarLoja() {
        return listarLoja;
    }

    public void setListarLoja(List<Loja> listarLoja) {
        this.listarLoja = listarLoja;
    }

    public String getLojaNome() {
        return lojaNome;
    }

    public void setLojaNome(String lojaNome) {
        this.lojaNome = lojaNome;
    }

    public Boolean getLojaDeliv() {
        return lojaDeliv;
    }

    public void setLojaDeliv(Boolean lojaDeliv) {
        this.lojaDeliv = lojaDeliv;
    }

    public Boolean getLojaAtiva() {
        return lojaAtiva;
    }

    public void setLojaAtiva(Boolean lojaAtiva) {
        this.lojaAtiva = lojaAtiva;
    }

    public String getLojaEndCep() {
        return lojaEndCep;
    }

    public void setLojaEndCep(String lojaEndCep) {
        this.lojaEndCep = lojaEndCep;
    }

    public Boolean getFone() {
        return fone;
    }

    public void setFone(Boolean fone) {
        this.fone = fone;
    }

    /**
     * Creates a new instance of LojaV
     */
    public LojaV() {
    }

}
