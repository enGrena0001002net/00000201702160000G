/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "PRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByProdutoCod", query = "SELECT p FROM Produto p WHERE p.produtoPK.produtoCod = :produtoCod"),
    @NamedQuery(name = "Produto.findByLojaCod", query = "SELECT p FROM Produto p WHERE p.produtoPK.lojaCod = :lojaCod"),
    @NamedQuery(name = "Produto.findByProdutoNome", query = "SELECT p FROM Produto p WHERE p.produtoNome = :produtoNome"),
    @NamedQuery(name = "Produto.findByProdutoDescr", query = "SELECT p FROM Produto p WHERE p.produtoDescr = :produtoDescr"),
    @NamedQuery(name = "Produto.findByProdutoVlr", query = "SELECT p FROM Produto p WHERE p.produtoVlr = :produtoVlr"),
    @NamedQuery(name = "Produto.findByProdutoAtivo", query = "SELECT p FROM Produto p WHERE p.produtoAtivo = :produtoAtivo")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutoPK produtoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "PRODUTO_NOME")
    private String produtoNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "PRODUTO_DESCR")
    private String produtoDescr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUTO_VLR")
    private BigDecimal produtoVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUTO_ATIVO")
    private boolean produtoAtivo;
    @JoinColumn(name = "PRODUTO_TP_COD", referencedColumnName = "PRODUTO_TP_COD")
    @ManyToOne
    private TipoProduto produtoTpCod;
    @JoinColumn(name = "LOJA_COD", referencedColumnName = "LOJA_COD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Loja loja;

    public Produto() {
    }

    public Produto(ProdutoPK produtoPK) {
        this.produtoPK = produtoPK;
    }

    public Produto(ProdutoPK produtoPK, String produtoNome, String produtoDescr, BigDecimal produtoVlr, boolean produtoAtivo) {
        this.produtoPK = produtoPK;
        this.produtoNome = produtoNome;
        this.produtoDescr = produtoDescr;
        this.produtoVlr = produtoVlr;
        this.produtoAtivo = produtoAtivo;
    }

    public Produto(int produtoCod, int lojaCod) {
        this.produtoPK = new ProdutoPK(produtoCod, lojaCod);
    }

    public ProdutoPK getProdutoPK() {
        return produtoPK;
    }

    public void setProdutoPK(ProdutoPK produtoPK) {
        this.produtoPK = produtoPK;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getProdutoDescr() {
        return produtoDescr;
    }

    public void setProdutoDescr(String produtoDescr) {
        this.produtoDescr = produtoDescr;
    }

    public BigDecimal getProdutoVlr() {
        return produtoVlr;
    }

    public void setProdutoVlr(BigDecimal produtoVlr) {
        this.produtoVlr = produtoVlr;
    }

    public boolean getProdutoAtivo() {
        return produtoAtivo;
    }

    public void setProdutoAtivo(boolean produtoAtivo) {
        this.produtoAtivo = produtoAtivo;
    }

    public TipoProduto getProdutoTpCod() {
        return produtoTpCod;
    }

    public void setProdutoTpCod(TipoProduto produtoTpCod) {
        this.produtoTpCod = produtoTpCod;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoPK != null ? produtoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.produtoPK == null && other.produtoPK != null) || (this.produtoPK != null && !this.produtoPK.equals(other.produtoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.achatipicas.entidade.Produto[ produtoPK=" + produtoPK + " ]";
    }
    
}
