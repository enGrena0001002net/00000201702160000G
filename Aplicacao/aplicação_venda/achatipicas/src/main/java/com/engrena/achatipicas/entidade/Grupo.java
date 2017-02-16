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
import javax.persistence.ManyToOne;
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
@Table(name = "GRUPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByGrupoCodigo", query = "SELECT g FROM Grupo g WHERE g.grupoCodigo = :grupoCodigo"),
    @NamedQuery(name = "Grupo.findByGrupoNome", query = "SELECT g FROM Grupo g WHERE g.grupoNome = :grupoNome"),
    @NamedQuery(name = "Grupo.findByGrupoDescricao", query = "SELECT g FROM Grupo g WHERE g.grupoDescricao = :grupoDescricao")})
public class Grupo implements Serializable {

    @ManyToMany(mappedBy = "grupoList")
    private List<TipoUsuario> tipoUsuarioList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GRUPO_CODIGO")
    private Integer grupoCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "GRUPO_NOME")
    private String grupoNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "GRUPO_DESCRICAO")
    private String grupoDescricao;
    @JoinTable(name = "GRUPO_REGRAS", joinColumns = {
        @JoinColumn(name = "GRUPO_CODIGO", referencedColumnName = "GRUPO_CODIGO")}, inverseJoinColumns = {
        @JoinColumn(name = "REGRA_COD", referencedColumnName = "REGRAS_COD")})
    @ManyToMany
    private List<Regra> regraList;

    public Grupo() {
    }

    public Grupo(Integer grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

    public Grupo(Integer grupoCodigo, String grupoNome, String grupoDescricao) {
        this.grupoCodigo = grupoCodigo;
        this.grupoNome = grupoNome;
        this.grupoDescricao = grupoDescricao;
    }

    public Integer getGrupoCodigo() {
        return grupoCodigo;
    }

    public void setGrupoCodigo(Integer grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

    public String getGrupoNome() {
        return grupoNome;
    }

    public void setGrupoNome(String grupoNome) {
        this.grupoNome = grupoNome;
    }

    public String getGrupoDescricao() {
        return grupoDescricao;
    }

    public void setGrupoDescricao(String grupoDescricao) {
        this.grupoDescricao = grupoDescricao;
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
        hash += (grupoCodigo != null ? grupoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.grupoCodigo == null && other.grupoCodigo != null) || (this.grupoCodigo != null && !this.grupoCodigo.equals(other.grupoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.achatipicas.entidade.Grupo[ grupoCodigo=" + grupoCodigo + " ]";
    }

    @XmlTransient
    public List<TipoUsuario> getTipoUsuarioList() {
        return tipoUsuarioList;
    }

    public void setTipoUsuarioList(List<TipoUsuario> tipoUsuarioList) {
        this.tipoUsuarioList = tipoUsuarioList;
    }

}
