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
public class PerfilProcessoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cod_pfl")
    private String codPfl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cod_pco")
    private String codPco;

    public PerfilProcessoPK() {
    }

    public PerfilProcessoPK(String codPfl, String codPco) {
        this.codPfl = codPfl;
        this.codPco = codPco;
    }

    public String getCodPfl() {
        return codPfl;
    }

    public void setCodPfl(String codPfl) {
        this.codPfl = codPfl;
    }

    public String getCodPco() {
        return codPco;
    }

    public void setCodPco(String codPco) {
        this.codPco = codPco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPfl != null ? codPfl.hashCode() : 0);
        hash += (codPco != null ? codPco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilProcessoPK)) {
            return false;
        }
        PerfilProcessoPK other = (PerfilProcessoPK) object;
        if ((this.codPfl == null && other.codPfl != null) || (this.codPfl != null && !this.codPfl.equals(other.codPfl))) {
            return false;
        }
        if ((this.codPco == null && other.codPco != null) || (this.codPco != null && !this.codPco.equals(other.codPco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.PerfilProcessoPK[ codPfl=" + codPfl + ", codPco=" + codPco + " ]";
    }
    
}
