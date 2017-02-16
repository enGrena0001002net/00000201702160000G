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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cdi_fpereira
 */
@Embeddable
public class EventoPK implements Serializable {
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_evt")
    private int codEvt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usu")
    private int codUsu;

    public EventoPK() {
    }

    public EventoPK(int codEvt, int codUsu) {
        this.codEvt = codEvt;
        this.codUsu = codUsu;
    }

    public int getCodEvt() {
        return codEvt;
    }

    public void setCodEvt(int codEvt) {
        this.codEvt = codEvt;
    }

    public int getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(int codUsu) {
        this.codUsu = codUsu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codEvt;
        hash += (int) codUsu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoPK)) {
            return false;
        }
        EventoPK other = (EventoPK) object;
        if (this.codEvt != other.codEvt) {
            return false;
        }
        if (this.codUsu != other.codUsu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.bilheteria.EventoPK[ codEvt=" + codEvt + ", codUsu=" + codUsu + " ]";
    }
    
}
