/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.visao;

import com.engrena.achatipicas.entidade.Acao;
import com.engrena.achatipicas.entidade.Regra;
import com.engrena.achatipicas.regras.AcaoR;
import com.engrena.achatipicas.regras.RegraR;
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
@Named(value = "regraV")
@SessionScoped
public class RegraV implements Serializable {

    @Inject
    RegraR objR;
    @Inject
    AcaoR acaoR;

    Utilitarios util = new Utilitarios();
    Regra frmRegra;

    String codigoPesquiosa;
    List<Regra> listarRegra;
    List<Acao> acaoslistSelect;
    Acao selectAcao;

    public List<Acao> listarAcoes() {

        return acaoR.findAll();
    }

    public void novo() {

        setFrmRegra(new Regra());

    }

    public void adicionaAcao() {
        if (getSelectAcao().getRegraList() == null) {
            getSelectAcao().setRegraList(new ArrayList<Regra>());
        }
        getSelectAcao().getRegraList().add(getFrmRegra());
        getFrmRegra().getAcaoList().add(getSelectAcao());
        if (!getFrmRegra().getAcaoList().isEmpty()) {

            salvar();
            acaoR.salvar(getSelectAcao());
        } else {
            util.retornaMessageErro("Não há Objetos para Associar!!");
        }

    }

    public void removerAcao(Acao acao) {
        acao.getRegraList().remove(getFrmRegra());

        getFrmRegra().getAcaoList().remove(acao);
        salvar();
        acaoR.salvar(acao);

    }

    public Boolean verificaSejaSelecionado(Acao acao) {
        Boolean retorno = false;
        if (getFrmRegra().getAcaoList() != null) {
            retorno = getFrmRegra().getAcaoList().contains(acao);
        }

        return retorno;

    }

    public void salvarAcao() {

    }

    public void cancelar() {

        setFrmRegra(null);
        setSelectAcao(null);

    }

    public void receberRegra(Regra item) {
        if (item.getAcaoList() == null) {
            item.setAcaoList(new ArrayList<Acao>());
        }
        setFrmRegra(item);

    }

    public void salvar() {

        objR.salvar(getFrmRegra());

    }

    public void pesquisar() {
        System.out.println("getCodigoPesquiosa()" + getCodigoPesquiosa());
        setListarRegra(objR.pesquisaRegra(getCodigoPesquiosa()));

    }

    public void limparPesquisa() {
        setListarRegra(null);
        setCodigoPesquiosa("");
    }

    public Regra getFrmRegra() {
        if (frmRegra == null) {
            frmRegra = new Regra();
        }
        return frmRegra;
    }

    public void setFrmRegra(Regra frmRegra) {
        this.frmRegra = frmRegra;
    }

    public String getCodigoPesquiosa() {
        return codigoPesquiosa;
    }

    public void setCodigoPesquiosa(String codigoPesquiosa) {
        this.codigoPesquiosa = codigoPesquiosa;
    }

    public List<Regra> getListarRegra() {
        return listarRegra;
    }

    public void setListarRegra(List<Regra> listarRegra) {
        this.listarRegra = listarRegra;
    }

    public List<Acao> getAcaoslistSelect() {

        if (acaoslistSelect == null) {
            acaoslistSelect = new ArrayList<>();
        }

        return acaoslistSelect;
    }

    public void setAcaoslistSelect(List<Acao> acaoslistSelect) {
        this.acaoslistSelect = acaoslistSelect;
    }

    public Acao getSelectAcao() {
        return selectAcao;
    }

    public void setSelectAcao(Acao selectAcao) {
        this.selectAcao = selectAcao;
    }

    /**
     * Creates a new instance of RegraV
     */
    public RegraV() {
    }

}
