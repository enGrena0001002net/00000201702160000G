/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cdi_fpereira
 */
@Embeddable
public class PerfilUsuarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usu")
    private int codUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cod_pfl")
    private String codPfl;

    public PerfilUsuarioPK() {
    }

    public PerfilUsuarioPK(int codUsu, String codPfl) {
        this.codUsu = codUsu;
        this.codPfl = codPfl;
    }

    public int getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(int codUsu) {
        this.codUsu = codUsu;
    }

    public String getCodPfl() {
        return codPfl;
    }

    public void setCodPfl(String codPfl) {
        this.codPfl = codPfl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codUsu;
        hash += (codPfl != null ? codPfl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilUsuarioPK)) {
            return false;
        }
        PerfilUsuarioPK other = (PerfilUsuarioPK) object;
        if (this.codUsu != other.codUsu) {
            return false;
        }
        if ((this.codPfl == null && other.codPfl != null) || (this.codPfl != null && !this.codPfl.equals(other.codPfl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.PerfilUsuarioPK[ codUsu=" + codUsu + ", codPfl=" + codPfl + " ]";
    }
    
}
