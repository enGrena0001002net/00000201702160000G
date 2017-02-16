/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByCodPfl", query = "SELECT p FROM Perfil p WHERE p.codPfl = :codPfl"),
    @NamedQuery(name = "Perfil.findByNmPfl", query = "SELECT p FROM Perfil p WHERE p.nmPfl = :nmPfl"),
    @NamedQuery(name = "Perfil.findByDscPfl", query = "SELECT p FROM Perfil p WHERE p.dscPfl = :dscPfl"),
    @NamedQuery(name = "Perfil.findByDtInsPfl", query = "SELECT p FROM Perfil p WHERE p.dtInsPfl = :dtInsPfl"),
    @NamedQuery(name = "Perfil.findByDtAtuPfl", query = "SELECT p FROM Perfil p WHERE p.dtAtuPfl = :dtAtuPfl")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cod_pfl")
    private String codPfl;
    @Size(max = 150)
    @Column(name = "nm_pfl")
    private String nmPfl;
    @Size(max = 500)
    @Column(name = "dsc_pfl")
    private String dscPfl;
    @Column(name = "dt_ins_pfl")
    @Temporal(TemporalType.DATE)
    private Date dtInsPfl;
    @Column(name = "dt_atu_pfl")
    @Temporal(TemporalType.DATE)
    private Date dtAtuPfl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<PerfilProcesso> perfilProcessoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<PerfilUsuario> perfilUsuarioList;

    public Perfil() {
    }

    public Perfil(String codPfl) {
        this.codPfl = codPfl;
    }

    public String getCodPfl() {
        return codPfl;
    }

    public void setCodPfl(String codPfl) {
        this.codPfl = codPfl;
    }

    public String getNmPfl() {
        return nmPfl;
    }

    public void setNmPfl(String nmPfl) {
        this.nmPfl = nmPfl;
    }

    public String getDscPfl() {
        return dscPfl;
    }

    public void setDscPfl(String dscPfl) {
        this.dscPfl = dscPfl;
    }

    public Date getDtInsPfl() {
        return dtInsPfl;
    }

    public void setDtInsPfl(Date dtInsPfl) {
        this.dtInsPfl = dtInsPfl;
    }

    public Date getDtAtuPfl() {
        return dtAtuPfl;
    }

    public void setDtAtuPfl(Date dtAtuPfl) {
        this.dtAtuPfl = dtAtuPfl;
    }

    @XmlTransient
    public List<PerfilProcesso> getPerfilProcessoList() {
        return perfilProcessoList;
    }

    public void setPerfilProcessoList(List<PerfilProcesso> perfilProcessoList) {
        this.perfilProcessoList = perfilProcessoList;
    }

    @XmlTransient
    public List<PerfilUsuario> getPerfilUsuarioList() {
        return perfilUsuarioList;
    }

    public void setPerfilUsuarioList(List<PerfilUsuario> perfilUsuarioList) {
        this.perfilUsuarioList = perfilUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPfl != null ? codPfl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.codPfl == null && other.codPfl != null) || (this.codPfl != null && !this.codPfl.equals(other.codPfl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.Perfil[ codPfl=" + codPfl + " ]";
    }
    
}
