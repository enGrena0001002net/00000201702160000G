/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "perfil_processo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilProcesso.findAll", query = "SELECT p FROM PerfilProcesso p"),
    @NamedQuery(name = "PerfilProcesso.findByCodPfl", query = "SELECT p FROM PerfilProcesso p WHERE p.perfilProcessoPK.codPfl = :codPfl"),
    @NamedQuery(name = "PerfilProcesso.findByCodPco", query = "SELECT p FROM PerfilProcesso p WHERE p.perfilProcessoPK.codPco = :codPco")})
public class PerfilProcesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilProcessoPK perfilProcessoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfilProcesso")
    private List<Acao> acaoList;
    @JoinColumn(name = "cod_pco", referencedColumnName = "cod_pco", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Processo processo;
    @JoinColumn(name = "cod_pfl", referencedColumnName = "cod_pfl", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;

    public PerfilProcesso() {
    }

    public PerfilProcesso(PerfilProcessoPK perfilProcessoPK) {
        this.perfilProcessoPK = perfilProcessoPK;
    }

    public PerfilProcesso(String codPfl, String codPco) {
        this.perfilProcessoPK = new PerfilProcessoPK(codPfl, codPco);
    }

    public PerfilProcessoPK getPerfilProcessoPK() {
        return perfilProcessoPK;
    }

    public void setPerfilProcessoPK(PerfilProcessoPK perfilProcessoPK) {
        this.perfilProcessoPK = perfilProcessoPK;
    }

    @XmlTransient
    public List<Acao> getAcaoList() {
        return acaoList;
    }

    public void setAcaoList(List<Acao> acaoList) {
        this.acaoList = acaoList;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
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
        hash += (perfilProcessoPK != null ? perfilProcessoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilProcesso)) {
            return false;
        }
        PerfilProcesso other = (PerfilProcesso) object;
        if ((this.perfilProcessoPK == null && other.perfilProcessoPK != null) || (this.perfilProcessoPK != null && !this.perfilProcessoPK.equals(other.perfilProcessoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.PerfilProcesso[ perfilProcessoPK=" + perfilProcessoPK + " ]";
    }
    
}
