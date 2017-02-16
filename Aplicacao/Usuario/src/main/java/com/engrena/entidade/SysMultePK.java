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
public class SysMultePK implements Serializable {
    @Basic(optional = false)
    
    @Size(min = 1, max = 8)
    @Column(name = "cod_mut")
    private String codMut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cod_sys")
    private String codSys;

    public SysMultePK() {
    }

    public SysMultePK(String codMut, String codSys) {
        this.codMut = codMut;
        this.codSys = codSys;
    }

    public String getCodMut() {
        return codMut;
    }

    public void setCodMut(String codMut) {
        this.codMut = codMut;
    }

    public String getCodSys() {
        return codSys;
    }

    public void setCodSys(String codSys) {
        this.codSys = codSys;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMut != null ? codMut.hashCode() : 0);
        hash += (codSys != null ? codSys.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysMultePK)) {
            return false;
        }
        SysMultePK other = (SysMultePK) object;
        if ((this.codMut == null && other.codMut != null) || (this.codMut != null && !this.codMut.equals(other.codMut))) {
            return false;
        }
        if ((this.codSys == null && other.codSys != null) || (this.codSys != null && !this.codSys.equals(other.codSys))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.SysMultePK[ codMut=" + codMut + ", codSys=" + codSys + " ]";
    }
    
}
