/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.visao;

import com.engrena.achatipicas.entidade.Loja;
import com.engrena.achatipicas.entidade.Produto;
import com.engrena.achatipicas.entidade.TipoProduto;
import com.engrena.achatipicas.regras.LojaR;
import com.engrena.achatipicas.regras.ProdutoR;
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
@Named(value = "produtoConsultaV")
@SessionScoped
public class ProdutoConsultaV implements Serializable {

    @Inject
    ProdutoR ob3jR;
    @Inject
    TipoProdutoR obj2R;
    @Inject
    LojaR obj1R;

    String codigoPesquiosa;
    List<Produto> listarProduto;
    String produtoNome;
    Boolean produtoAtivo = null;
    Loja lojaCod;
    TipoProduto produtoTpCod;

    public void pesquisar() {

        setListarProduto(ob3jR.pesquisaProduto(getProdutoNome(), getProdutoAtivo(), getLojaCod(), getProdutoTpCod()));

    }

    public List<Loja> litsraLojas() {

        return obj1R.pesquisaLoja(null, null, true, null);
    }

    public List<TipoProduto> listarTipoProduto() {

        return obj2R.findAll();
    }

    public void limparPesquisa() {
        setListarProduto(null);
        setCodigoPesquiosa("");
        setLojaCod(null);
        setProdutoAtivo(null);
        setProdutoNome(null);
        setProdutoTpCod(null);
    }

    public String getCodigoPesquiosa() {
        return codigoPesquiosa;
    }

    public void setCodigoPesquiosa(String codigoPesquiosa) {
        this.codigoPesquiosa = codigoPesquiosa;
    }

    public List<Produto> getListarProduto() {
        return listarProduto;
    }

    public void setListarProduto(List<Produto> listarProduto) {
        this.listarProduto = listarProduto;
    }

    public ProdutoR getObjR() {
        return ob3jR;
    }

    public void setObjR(ProdutoR ob3jR) {
        this.ob3jR = ob3jR;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Boolean getProdutoAtivo() {
        return produtoAtivo;
    }

    public void setProdutoAtivo(Boolean produtoAtivo) {
        this.produtoAtivo = produtoAtivo;
    }

    public Loja getLojaCod() {
        return lojaCod;
    }

    public void setLojaCod(Loja lojaCod) {
        this.lojaCod = lojaCod;
    }

    public TipoProduto getProdutoTpCod() {
        return produtoTpCod;
    }

    public void setProdutoTpCod(TipoProduto produtoTpCod) {
        this.produtoTpCod = produtoTpCod;
    }

    /**
     * Creates a new instance of ProdutoV
     */
    public ProdutoConsultaV() {
    }

}
