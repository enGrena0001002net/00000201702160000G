/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "acao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acao.findAll", query = "SELECT a FROM Acao a"),
    @NamedQuery(name = "Acao.findByCodAco", query = "SELECT a FROM Acao a WHERE a.codAco = :codAco"),
    @NamedQuery(name = "Acao.findByDscAco", query = "SELECT a FROM Acao a WHERE a.dscAco = :dscAco"),
    @NamedQuery(name = "Acao.findByAtvAco", query = "SELECT a FROM Acao a WHERE a.atvAco = :atvAco")})
public class Acao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cod_aco")
    private String codAco;
    @Size(max = 250)
    @Column(name = "dsc_aco")
    private String dscAco;
    @Column(name = "atv_aco")
    private Boolean atvAco;
    @JoinColumns({
        @JoinColumn(name = "cod_pfl", referencedColumnName = "cod_pfl"),
        @JoinColumn(name = "cod_pco", referencedColumnName = "cod_pco")})
    @ManyToOne
    private PerfilProcesso perfilProcesso;

    public Acao() {
    }

    public Acao(String codAco) {
        this.codAco = codAco;
    }

    public String getCodAco() {
        return codAco;
    }

    public void setCodAco(String codAco) {
        this.codAco = codAco;
    }

    public String getDscAco() {
        return dscAco;
    }

    public void setDscAco(String dscAco) {
        this.dscAco = dscAco;
    }

    public Boolean getAtvAco() {
        return atvAco;
    }

    public void setAtvAco(Boolean atvAco) {
        this.atvAco = atvAco;
    }

    public PerfilProcesso getPerfilProcesso() {
        return perfilProcesso;
    }

    public void setPerfilProcesso(PerfilProcesso perfilProcesso) {
        this.perfilProcesso = perfilProcesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAco != null ? codAco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acao)) {
            return false;
        }
        Acao other = (Acao) object;
        if ((this.codAco == null && other.codAco != null) || (this.codAco != null && !this.codAco.equals(other.codAco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.Acao[ codAco=" + codAco + " ]";
    }
    
}
