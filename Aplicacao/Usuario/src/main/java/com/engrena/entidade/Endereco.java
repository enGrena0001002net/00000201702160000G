/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByCodEnd", query = "SELECT e FROM Endereco e WHERE e.codEnd = :codEnd"),
    @NamedQuery(name = "Endereco.findByCidEnd", query = "SELECT e FROM Endereco e WHERE e.cidEnd = :cidEnd"),
    @NamedQuery(name = "Endereco.findByUfEnd", query = "SELECT e FROM Endereco e WHERE e.ufEnd = :ufEnd"),
    @NamedQuery(name = "Endereco.findByCepEnd", query = "SELECT e FROM Endereco e WHERE e.cepEnd = :cepEnd"),
    @NamedQuery(name = "Endereco.findByRuaEnd", query = "SELECT e FROM Endereco e WHERE e.ruaEnd = :ruaEnd"),
    @NamedQuery(name = "Endereco.findByBroEnd", query = "SELECT e FROM Endereco e WHERE e.broEnd = :broEnd"),
    @NamedQuery(name = "Endereco.findByCmpEnd", query = "SELECT e FROM Endereco e WHERE e.cmpEnd = :cmpEnd"),
    @NamedQuery(name = "Endereco.findByNrEnd", query = "SELECT e FROM Endereco e WHERE e.nrEnd = :nrEnd")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
    
    @Column(name = "cod_end")
    private Integer codEnd;
    @Size(max = 100)
    @Column(name = "cid_end")
    private String cidEnd;
    @Size(max = 2)
    @Column(name = "uf_end")
    private String ufEnd;
    @Size(max = 11)
    @Column(name = "cep_end")
    private String cepEnd;
    @Size(max = 800)
    @Column(name = "rua_end")
    private String ruaEnd;
    @Size(max = 100)
    @Column(name = "bro_end")
    private String broEnd;
    @Size(max = 150)
    @Column(name = "cmp_end")
    private String cmpEnd;
    @Column(name = "nr_end")
    private Integer nrEnd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEnd")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEnd")
    private List<Empresa> empresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEnd")
    private List<Funcionario> funcionarioList;

    public Endereco() {
    }

    public Endereco(Integer codEnd) {
        this.codEnd = codEnd;
    }

    public Integer getCodEnd() {
        return codEnd;
    }

    public void setCodEnd(Integer codEnd) {
        this.codEnd = codEnd;
    }

    public String getCidEnd() {
        return cidEnd;
    }

    public void setCidEnd(String cidEnd) {
        this.cidEnd = cidEnd;
    }

    public String getUfEnd() {
        return ufEnd;
    }

    public void setUfEnd(String ufEnd) {
        this.ufEnd = ufEnd;
    }

    public String getCepEnd() {
        return cepEnd;
    }

    public void setCepEnd(String cepEnd) {
        this.cepEnd = cepEnd;
    }

    public String getRuaEnd() {
        return ruaEnd;
    }

    public void setRuaEnd(String ruaEnd) {
        this.ruaEnd = ruaEnd;
    }

    public String getBroEnd() {
        return broEnd;
    }

    public void setBroEnd(String broEnd) {
        this.broEnd = broEnd;
    }

    public String getCmpEnd() {
        return cmpEnd;
    }

    public void setCmpEnd(String cmpEnd) {
        this.cmpEnd = cmpEnd;
    }

    public Integer getNrEnd() {
        return nrEnd;
    }

    public void setNrEnd(Integer nrEnd) {
        this.nrEnd = nrEnd;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEnd != null ? codEnd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.codEnd == null && other.codEnd != null) || (this.codEnd != null && !this.codEnd.equals(other.codEnd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.Endereco[ codEnd=" + codEnd + " ]";
    }
    
}
