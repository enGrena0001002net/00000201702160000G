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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "TIPO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t"),
    @NamedQuery(name = "TipoUsuario.findByTpCodigo", query = "SELECT t FROM TipoUsuario t WHERE t.tpCodigo = :tpCodigo"),
    @NamedQuery(name = "TipoUsuario.findByTpNome", query = "SELECT t FROM TipoUsuario t WHERE t.tpNome = :tpNome"),
    @NamedQuery(name = "TipoUsuario.findByTpDescricao", query = "SELECT t FROM TipoUsuario t WHERE t.tpDescricao = :tpDescricao")})
public class TipoUsuario implements Serializable {

    @JoinTable(name = "TIPO_USUARIO_GRUPO", joinColumns = {
        @JoinColumn(name = "TP_CODIGO", referencedColumnName = "TP_CODIGO")}, inverseJoinColumns = {
        @JoinColumn(name = "GRUPO_CODIGO", referencedColumnName = "GRUPO_CODIGO")})
    @ManyToMany
    private List<Grupo> grupoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpCod")
    private List<Usuario> usuarioList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TP_CODIGO")
    private Integer tpCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "TP_NOME")
    private String tpNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "TP_DESCRICAO")
    private String tpDescricao;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer tpCodigo) {
        this.tpCodigo = tpCodigo;
    }

    public TipoUsuario(Integer tpCodigo, String tpNome, String tpDescricao) {
        this.tpCodigo = tpCodigo;
        this.tpNome = tpNome;
        this.tpDescricao = tpDescricao;
    }

    public Integer getTpCodigo() {
        return tpCodigo;
    }

    public void setTpCodigo(Integer tpCodigo) {
        this.tpCodigo = tpCodigo;
    }

    public String getTpNome() {
        return tpNome;
    }

    public void setTpNome(String tpNome) {
        this.tpNome = tpNome;
    }

    public String getTpDescricao() {
        return tpDescricao;
    }

    public void setTpDescricao(String tpDescricao) {
        this.tpDescricao = tpDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpCodigo != null ? tpCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.tpCodigo == null && other.tpCodigo != null) || (this.tpCodigo != null && !this.tpCodigo.equals(other.tpCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.achatipicas.entidade.TipoUsuario[ tpCodigo=" + tpCodigo + " ]";
    }

    @XmlTransient
    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    
}
