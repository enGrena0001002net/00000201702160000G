/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.visao;

import com.engrena.achatipicas.entidade.TipoProduto;
import com.engrena.achatipicas.regras.TipoProdutoR;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "tipoProdutoV")
@SessionScoped
public class TipoProdutoV implements Serializable {

    @Inject
    TipoProdutoR objR;
    TipoProduto frmTipoProduto;

    String produtoTpNome, produtoTpUf;
    List<TipoProduto> listarTipoProduto;

    public void novo() {

        setFrmTipoProduto(new TipoProduto());

    }

    public void receberTipoProduto(TipoProduto item) {
        setFrmTipoProduto(item);

    }

    public void salvar() {

        objR.salvar(getFrmTipoProduto());

    }

    public void pesquisar() {

        setListarTipoProduto(objR.pesquisaTipoProduto(getProdutoTpNome(), getProdutoTpUf()));

    }

    public void limparPesquisa() {
        setListarTipoProduto(null);
        setProdutoTpNome("");
        setProdutoTpUf("");
    }

    public TipoProduto getFrmTipoProduto() {
        if (frmTipoProduto == null) {
            frmTipoProduto = new TipoProduto();
        }
        return frmTipoProduto;
    }

    public void setFrmTipoProduto(TipoProduto frmTipoProduto) {
        this.frmTipoProduto = frmTipoProduto;
    }

    public String getProdutoTpNome() {
        return produtoTpNome;
    }

    public void setProdutoTpNome(String produtoTpNome) {
        this.produtoTpNome = produtoTpNome;
    }

    public String getProdutoTpUf() {
        return produtoTpUf;
    }

    public void setProdutoTpUf(String produtoTpUf) {
        this.produtoTpUf = produtoTpUf;
    }

    public List<TipoProduto> getListarTipoProduto() {
        return listarTipoProduto;
    }

    public void setListarTipoProduto(List<TipoProduto> listarTipoProduto) {
        this.listarTipoProduto = listarTipoProduto;
    }

    /**
     * Creates a new instance of TipoProdutoV
     */
    public TipoProdutoV() {
    }

}
