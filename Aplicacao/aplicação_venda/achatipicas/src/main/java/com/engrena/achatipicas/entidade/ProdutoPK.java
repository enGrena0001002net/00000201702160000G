/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cdi_fpereira
 */
@Embeddable
public class ProdutoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PRODUTO_COD")
    private int produtoCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOJA_COD")
    private int lojaCod;

    public ProdutoPK() {
    }

    public ProdutoPK(int produtoCod, int lojaCod) {
        this.produtoCod = produtoCod;
        this.lojaCod = lojaCod;
    }

    public int getProdutoCod() {
        return produtoCod;
    }

    public void setProdutoCod(int produtoCod) {
        this.produtoCod = produtoCod;
    }

    public int getLojaCod() {
        return lojaCod;
    }

    public void setLojaCod(int lojaCod) {
        this.lojaCod = lojaCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) produtoCod;
        hash += (int) lojaCod;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoPK)) {
            return false;
        }
        ProdutoPK other = (ProdutoPK) object;
        if (this.produtoCod != other.produtoCod) {
            return false;
        }
        if (this.lojaCod != other.lojaCod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.achatipicas.entidade.ProdutoPK[ produtoCod=" + produtoCod + ", lojaCod=" + lojaCod + " ]";
    }
    
}
