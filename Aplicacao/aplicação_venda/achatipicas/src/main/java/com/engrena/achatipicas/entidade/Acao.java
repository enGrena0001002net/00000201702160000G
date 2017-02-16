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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "ACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acao.findAll", query = "SELECT a FROM Acao a"),
    @NamedQuery(name = "Acao.findByAcaoCod", query = "SELECT a FROM Acao a WHERE a.acaoCod = :acaoCod"),
    @NamedQuery(name = "Acao.findByAcaoNome", query = "SELECT a FROM Acao a WHERE a.acaoNome = :acaoNome"),
    @NamedQuery(name = "Acao.findByAcaoDescricao", query = "SELECT a FROM Acao a WHERE a.acaoDescricao = :acaoDescricao")})
public class Acao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACAO_COD")
    private Integer acaoCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ACAO_NOME")
    private String acaoNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ACAO_DESCRICAO")
    private String acaoDescricao;
    @JoinTable(name = "REGRAS_ACAO", joinColumns = {
        @JoinColumn(name = "ACAO_COD", referencedColumnName = "ACAO_COD")}, inverseJoinColumns = {
        @JoinColumn(name = "REGRAS_COD", referencedColumnName = "REGRAS_COD")})
    @ManyToMany
    private List<Regra> regraList;

    public Acao() {
    }

    public Acao(Integer acaoCod) {
        this.acaoCod = acaoCod;
    }

    public Acao(Integer acaoCod, String acaoNome, String acaoDescricao) {
        this.acaoCod = acaoCod;
        this.acaoNome = acaoNome;
        this.acaoDescricao = acaoDescricao;
    }

    public Integer getAcaoCod() {
        return acaoCod;
    }

    public void setAcaoCod(Integer acaoCod) {
        this.acaoCod = acaoCod;
    }

    public String getAcaoNome() {
        return acaoNome;
    }

    public void setAcaoNome(String acaoNome) {
        this.acaoNome = acaoNome;
    }

    public String getAcaoDescricao() {
        return acaoDescricao;
    }

    public void setAcaoDescricao(String acaoDescricao) {
        this.acaoDescricao = acaoDescricao;
    }

    @XmlTransient
    public List<Regra> getRegraList() {
        return regraList;
    }

    public void setRegraList(List<Regra> regraList) {
        this.regraList = regraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acaoCod != null ? acaoCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acao)) {
            return false;
        }
        Acao other = (Acao) object;
        if ((this.acaoCod == null && other.acaoCod != null) || (this.acaoCod != null && !this.acaoCod.equals(other.acaoCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.achatipicas.entidade.Acao[ acaoCod=" + acaoCod + " ]";
    }
    
}
