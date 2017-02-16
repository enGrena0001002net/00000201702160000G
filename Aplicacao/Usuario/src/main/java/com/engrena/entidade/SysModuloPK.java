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
public class SysModuloPK implements Serializable {
    @Basic(optional = false)
   
    @Size(min = 1, max = 8)
    @Column(name = "cod_mod")
    private String codMod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cod_sys")
    private String codSys;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cod_mut")
    private String codMut;

    public SysModuloPK() {
    }

    public SysModuloPK(String codMod, String codSys, String codMut) {
        this.codMod = codMod;
        this.codSys = codSys;
        this.codMut = codMut;
    }

    public String getCodMod() {
        return codMod;
    }

    public void setCodMod(String codMod) {
        this.codMod = codMod;
    }

    public String getCodSys() {
        return codSys;
    }

    public void setCodSys(String codSys) {
        this.codSys = codSys;
    }

    public String getCodMut() {
        return codMut;
    }

    public void setCodMut(String codMut) {
        this.codMut = codMut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMod != null ? codMod.hashCode() : 0);
        hash += (codSys != null ? codSys.hashCode() : 0);
        hash += (codMut != null ? codMut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysModuloPK)) {
            return false;
        }
        SysModuloPK other = (SysModuloPK) object;
        if ((this.codMod == null && other.codMod != null) || (this.codMod != null && !this.codMod.equals(other.codMod))) {
            return false;
        }
        if ((this.codSys == null && other.codSys != null) || (this.codSys != null && !this.codSys.equals(other.codSys))) {
            return false;
        }
        if ((this.codMut == null && other.codMut != null) || (this.codMut != null && !this.codMut.equals(other.codMut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.SysModuloPK[ codMod=" + codMod + ", codSys=" + codSys + ", codMut=" + codMut + " ]";
    }
    
}
