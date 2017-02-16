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
@Table(name = "REGRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regra.findAll", query = "SELECT r FROM Regra r"),
    @NamedQuery(name = "Regra.findByRegrasCod", query = "SELECT r FROM Regra r WHERE r.regrasCod = :regrasCod"),
    @NamedQuery(name = "Regra.findByRegrasNome", query = "SELECT r FROM Regra r WHERE r.regrasNome = :regrasNome"),
    @NamedQuery(name = "Regra.findByRegrasDescricao", query = "SELECT r FROM Regra r WHERE r.regrasDescricao = :regrasDescricao"),
    @NamedQuery(name = "Regra.findByRegrasFrm", query = "SELECT r FROM Regra r WHERE r.regrasFrm = :regrasFrm")})
public class Regra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REGRAS_COD")
    private Integer regrasCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "REGRAS_NOME")
    private String regrasNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "REGRAS_DESCRICAO")
    private String regrasDescricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "REGRAS_FRM")
    private String regrasFrm;
    @ManyToMany(mappedBy = "regraList",cascade = CascadeType.ALL)
    private List<Grupo> grupoList;
    @ManyToMany(mappedBy = "regraList",cascade = CascadeType.ALL)
    private List<Acao> acaoList;

    public Regra() {
    }

    public Regra(Integer regrasCod) {
        this.regrasCod = regrasCod;
    }

    public Regra(Integer regrasCod, String regrasNome, String regrasDescricao, String regrasFrm) {
        this.regrasCod = regrasCod;
        this.regrasNome = regrasNome;
        this.regrasDescricao = regrasDescricao;
        this.regrasFrm = regrasFrm;
    }

    public Integer getRegrasCod() {
        return regrasCod;
    }

    public void setRegrasCod(Integer regrasCod) {
        this.regrasCod = regrasCod;
    }

    public String getRegrasNome() {
        return regrasNome;
    }

    public void setRegrasNome(String regrasNome) {
        this.regrasNome = regrasNome;
    }

    public String getRegrasDescricao() {
        return regrasDescricao;
    }

    public void setRegrasDescricao(String regrasDescricao) {
        this.regrasDescricao = regrasDescricao;
    }

    public String getRegrasFrm() {
        return regrasFrm;
    }

    public void setRegrasFrm(String regrasFrm) {
        this.regrasFrm = regrasFrm;
    }

    @XmlTransient
    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    @XmlTransient
    public List<Acao> getAcaoList() {
        return acaoList;
    }

    public void setAcaoList(List<Acao> acaoList) {
        this.acaoList = acaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regrasCod != null ? regrasCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regra)) {
            return false;
        }
        Regra other = (Regra) object;
        if ((this.regrasCod == null && other.regrasCod != null) || (this.regrasCod != null && !this.regrasCod.equals(other.regrasCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.achatipicas.entidade.Regra[ regrasCod=" + regrasCod + " ]";
    }
    
}
