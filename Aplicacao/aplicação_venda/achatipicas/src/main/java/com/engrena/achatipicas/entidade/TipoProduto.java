/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "TIPO_PRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProduto.findAll", query = "SELECT t FROM TipoProduto t"),
    @NamedQuery(name = "TipoProduto.findByProdutoTpCod", query = "SELECT t FROM TipoProduto t WHERE t.produtoTpCod = :produtoTpCod"),
    @NamedQuery(name = "TipoProduto.findByProdutoTpNome", query = "SELECT t FROM TipoProduto t WHERE t.produtoTpNome = :produtoTpNome"),
    @NamedQuery(name = "TipoProduto.findByProdutoTpDesc", query = "SELECT t FROM TipoProduto t WHERE t.produtoTpDesc = :produtoTpDesc"),
    
    @NamedQuery(name = "TipoProduto.findByProdutoTpUf", query = "SELECT t FROM TipoProduto t WHERE t.produtoTpUf = :produtoTpUf")})
public class TipoProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUTO_TP_COD")
    private Integer produtoTpCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PRODUTO_TP_NOME")
    private String produtoTpNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "PRODUTO_TP_DESC")
    private String produtoTpDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PRODUTO_TP_UF")
    private String produtoTpUf;
    @OneToMany(mappedBy = "produtoTpCod")
    private List<Produto> produtoList;

    public TipoProduto() {
    }

    public TipoProduto(Integer produtoTpCod) {
        this.produtoTpCod = produtoTpCod;
    }

    public TipoProduto(Integer produtoTpCod, String produtoTpNome, String produtoTpDesc, String produtoTpUf) {
        this.produtoTpCod = produtoTpCod;
        this.produtoTpNome = produtoTpNome;
        this.produtoTpDesc = produtoTpDesc;
        this.produtoTpUf = produtoTpUf;
    }

    public Integer getProdutoTpCod() {
        return produtoTpCod;
    }

    public void setProdutoTpCod(Integer produtoTpCod) {
        this.produtoTpCod = produtoTpCod;
    }

    public String getProdutoTpNome() {
        return produtoTpNome;
    }

    public void setProdutoTpNome(String produtoTpNome) {
        this.produtoTpNome = produtoTpNome;
    }

    public String getProdutoTpDesc() {
        return produtoTpDesc;
    }

    public void setProdutoTpDesc(String produtoTpDesc) {
        this.produtoTpDesc = produtoTpDesc;
    }

    public String getProdutoTpUf() {
        return produtoTpUf;
    }

    public void setProdutoTpUf(String produtoTpUf) {
        this.produtoTpUf = produtoTpUf;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoTpCod != null ? produtoTpCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProduto)) {
            return false;
        }
        TipoProduto other = (TipoProduto) object;
        if ((this.produtoTpCod == null && other.produtoTpCod != null) || (this.produtoTpCod != null && !this.produtoTpCod.equals(other.produtoTpCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.achatipicas.entidade.TipoProduto[ produtoTpCod=" + produtoTpCod + " ]";
    }
    
}
