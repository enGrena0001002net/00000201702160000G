/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "perfil_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilUsuario.findAll", query = "SELECT p FROM PerfilUsuario p"),
    @NamedQuery(name = "PerfilUsuario.findByCodUsu", query = "SELECT p FROM PerfilUsuario p WHERE p.perfilUsuarioPK.codUsu = :codUsu"),
    @NamedQuery(name = "PerfilUsuario.findByCodPfl", query = "SELECT p FROM PerfilUsuario p WHERE p.perfilUsuarioPK.codPfl = :codPfl"),
    @NamedQuery(name = "PerfilUsuario.findByDtIni", query = "SELECT p FROM PerfilUsuario p WHERE p.dtIni = :dtIni"),
    @NamedQuery(name = "PerfilUsuario.findByDtFim", query = "SELECT p FROM PerfilUsuario p WHERE p.dtFim = :dtFim")})
public class PerfilUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilUsuarioPK perfilUsuarioPK;
    @Column(name = "dt_ini")
    @Temporal(TemporalType.DATE)
    private Date dtIni;
    @Column(name = "dt_fim")
    @Temporal(TemporalType.DATE)
    private Date dtFim;
    @JoinColumn(name = "cod_usu", referencedColumnName = "cod_usu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "cod_pfl", referencedColumnName = "cod_pfl", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;

    public PerfilUsuario() {
    }

    public PerfilUsuario(PerfilUsuarioPK perfilUsuarioPK) {
        this.perfilUsuarioPK = perfilUsuarioPK;
    }

    public PerfilUsuario(int codUsu, String codPfl) {
        this.perfilUsuarioPK = new PerfilUsuarioPK(codUsu, codPfl);
    }

    public PerfilUsuarioPK getPerfilUsuarioPK() {
        return perfilUsuarioPK;
    }

    public void setPerfilUsuarioPK(PerfilUsuarioPK perfilUsuarioPK) {
        this.perfilUsuarioPK = perfilUsuarioPK;
    }

    public Date getDtIni() {
        return dtIni;
    }

    public void setDtIni(Date dtIni) {
        this.dtIni = dtIni;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilUsuarioPK != null ? perfilUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilUsuario)) {
            return false;
        }
        PerfilUsuario other = (PerfilUsuario) object;
        if ((this.perfilUsuarioPK == null && other.perfilUsuarioPK != null) || (this.perfilUsuarioPK != null && !this.perfilUsuarioPK.equals(other.perfilUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.PerfilUsuario[ perfilUsuarioPK=" + perfilUsuarioPK + " ]";
    }
    
}
