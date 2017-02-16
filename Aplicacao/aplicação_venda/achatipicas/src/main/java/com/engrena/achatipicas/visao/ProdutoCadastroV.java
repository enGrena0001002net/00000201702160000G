/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.visao;

import com.engrena.achatipicas.entidade.Loja;
import com.engrena.achatipicas.entidade.Produto;
import com.engrena.achatipicas.entidade.ProdutoPK;
import com.engrena.achatipicas.entidade.TipoProduto;
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
@Named(value = "produtoCadastroV")
@SessionScoped
public class ProdutoCadastroV implements Serializable {
    
    @Inject
    ProdutoR ob3jR;
    @Inject
    TipoProdutoR obj2R;
    Produto frmProduto;
    ProdutoPK frmProdutoPK;
    Loja frmLoja;
    
    String codigoPesquiosa;
    List<Produto> listarProduto;
    String produtoNome;
    Boolean produtoAtivo = null;
    Loja lojaCod;
    TipoProduto produtoTpCod;
    
    public void novo() {
        
        setFrmProduto(new Produto());
        setFrmProdutoPK(new ProdutoPK());
        getFrmProdutoPK().setLojaCod(getFrmLoja().getLojaCod());
        getFrmProduto().setLoja(getFrmLoja());
        
    }
    
    public void recebLoja(Loja loja) {
        setFrmLoja(loja);
        setListarProduto(null);
        
    }
    
    public void desativar(Produto obj) {
        ob3jR.desativar(obj);
    }
    
    public void ativar(Produto obj) {
        ob3jR.ativar(obj);
    }
    
    public void receberProduto(Produto item) {
        setFrmProduto(item);
        
    }
    
    public void salvar() {
        
        ob3jR.salvar(getFrmProduto(), getFrmProdutoPK());
        
    }
    
    public void pesquisar() {
        
        setListarProduto(ob3jR.pesquisaProduto(getProdutoNome(), getProdutoAtivo(), getFrmLoja(), getProdutoTpCod()));
        
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
    
    public Produto getFrmProduto() {
        if (frmProduto == null) {
            frmProduto = new Produto();
        }
        return frmProduto;
    }
    
    public void setFrmProduto(Produto frmProduto) {
        this.frmProduto = frmProduto;
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
    
    public ProdutoPK getFrmProdutoPK() {
        return frmProdutoPK;
    }
    
    public void setFrmProdutoPK(ProdutoPK frmProdutoPK) {
        this.frmProdutoPK = frmProdutoPK;
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
    
    public Loja getFrmLoja() {
        return frmLoja;
    }
    
    public void setFrmLoja(Loja frmLoja) {
        this.frmLoja = frmLoja;
    }

    /**
     * Creates a new instance of ProdutoV
     */
    public ProdutoCadastroV() {
    }
    
}
