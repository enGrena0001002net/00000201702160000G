/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "LOJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loja.findAll", query = "SELECT l FROM Loja l"),
    @NamedQuery(name = "Loja.findByLojaCod", query = "SELECT l FROM Loja l WHERE l.lojaCod = :lojaCod"),
    @NamedQuery(name = "Loja.findByLojaLocLong", query = "SELECT l FROM Loja l WHERE l.lojaLocLong = :lojaLocLong"),
    @NamedQuery(name = "Loja.findByLojaLocLatt", query = "SELECT l FROM Loja l WHERE l.lojaLocLatt = :lojaLocLatt"),
    @NamedQuery(name = "Loja.findByLojaNome", query = "SELECT l FROM Loja l WHERE l.lojaNome = :lojaNome"),
    @NamedQuery(name = "Loja.findByLojaEndCep", query = "SELECT l FROM Loja l WHERE l.lojaEndCep = :lojaEndCep"),
    @NamedQuery(name = "Loja.findByLojaEndNum", query = "SELECT l FROM Loja l WHERE l.lojaEndNum = :lojaEndNum"),
    @NamedQuery(name = "Loja.findByLojaFone", query = "SELECT l FROM Loja l WHERE l.lojaFone = :lojaFone"),
    @NamedQuery(name = "Loja.findByLojaDeliv", query = "SELECT l FROM Loja l WHERE l.lojaDeliv = :lojaDeliv"),
    @NamedQuery(name = "Loja.findByLojaAtiva", query = "SELECT l FROM Loja l WHERE l.lojaAtiva = :lojaAtiva")})
public class Loja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOJA_COD")
    private Integer lojaCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "LOJA_LOC_LONG")
    private String lojaLocLong;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "LOJA_LOC_LATT")
    private String lojaLocLatt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LOJA_NOME")
    private String lojaNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "LOJA_END_CEP")
    private String lojaEndCep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "LOJA_END_NUM")
    private String lojaEndNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "LOJA_FONE")
    private String lojaFone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOJA_DELIV")
    private boolean lojaDeliv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOJA_ATIVA")
    private boolean lojaAtiva;
    @JoinColumn(name = "USUARIO_CODIGO", referencedColumnName = "USUARIO_COD")
    @ManyToOne(optional = false)
    private Usuario usuarioCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loja")
    private List<Produto> produtoList;

    public Loja() {
    }

    public Loja(Integer lojaCod) {
        this.lojaCod = lojaCod;
    }

    public Loja(Integer lojaCod, String lojaLocLong, String lojaLocLatt, String lojaNome, String lojaEndCep, String lojaEndNum, String lojaFone, boolean lojaDeliv, boolean lojaAtiva) {
        this.lojaCod = lojaCod;
        this.lojaLocLong = lojaLocLong;
        this.lojaLocLatt = lojaLocLatt;
        this.lojaNome = lojaNome;
        this.lojaEndCep = lojaEndCep;
        this.lojaEndNum = lojaEndNum;
        this.lojaFone = lojaFone;
        this.lojaDeliv = lojaDeliv;
        this.lojaAtiva = lojaAtiva;
    }

    public Integer getLojaCod() {
        return lojaCod;
    }

    public void setLojaCod(Integer lojaCod) {
        this.lojaCod = lojaCod;
    }

    public String getLojaLocLong() {
        return lojaLocLong;
    }

    public void setLojaLocLong(String lojaLocLong) {
        this.lojaLocLong = lojaLocLong;
    }

    public String getLojaLocLatt() {
        return lojaLocLatt;
    }

    public void setLojaLocLatt(String lojaLocLatt) {
        this.lojaLocLatt = lojaLocLatt;
    }

    public String getLojaNome() {
        return lojaNome;
    }

    public void setLojaNome(String lojaNome) {
        this.lojaNome = lojaNome;
    }

    public String getLojaEndCep() {
        return lojaEndCep;
    }

    public void setLojaEndCep(String lojaEndCep) {
        this.lojaEndCep = lojaEndCep;
    }

    public String getLojaEndNum() {
        return lojaEndNum;
    }

    public void setLojaEndNum(String lojaEndNum) {
        this.lojaEndNum = lojaEndNum;
    }

    public String getLojaFone() {
        return lojaFone;
    }

    public void setLojaFone(String lojaFone) {
        this.lojaFone = lojaFone;
    }

    public boolean getLojaDeliv() {
        return lojaDeliv;
    }

    public void setLojaDeliv(boolean lojaDeliv) {
        this.lojaDeliv = lojaDeliv;
    }

    public boolean getLojaAtiva() {
        return lojaAtiva;
    }

    public void setLojaAtiva(boolean lojaAtiva) {
        this.lojaAtiva = lojaAtiva;
    }

    public Usuario getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(Usuario usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
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
        hash += (lojaCod != null ? lojaCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loja)) {
            return false;
        }
        Loja other = (Loja) object;
        if ((this.lojaCod == null && other.lojaCod != null) || (this.lojaCod != null && !this.lojaCod.equals(other.lojaCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.achatipicas.entidade.Loja[ lojaCod=" + lojaCod + " ]";
    }
    
}
