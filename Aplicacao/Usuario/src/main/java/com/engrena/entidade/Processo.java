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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "processo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processo.findAll", query = "SELECT p FROM Processo p"),
    @NamedQuery(name = "Processo.findByCodPco", query = "SELECT p FROM Processo p WHERE p.codPco = :codPco"),
    @NamedQuery(name = "Processo.findByNmPco", query = "SELECT p FROM Processo p WHERE p.nmPco = :nmPco"),
    @NamedQuery(name = "Processo.findByDscPco", query = "SELECT p FROM Processo p WHERE p.dscPco = :dscPco"),
    @NamedQuery(name = "Processo.findByDtInsPco", query = "SELECT p FROM Processo p WHERE p.dtInsPco = :dtInsPco"),
    @NamedQuery(name = "Processo.findByDtAtuPco", query = "SELECT p FROM Processo p WHERE p.dtAtuPco = :dtAtuPco")})
public class Processo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Size(min = 1, max = 8)
    @Column(name = "cod_pco")
    private String codPco;
    @Size(max = 150)
    @Column(name = "nm_pco")
    private String nmPco;
    @Size(max = 500)
    @Column(name = "dsc_pco")
    private String dscPco;
    @Column(name = "dt_ins_pco")
    @Temporal(TemporalType.DATE)
    private Date dtInsPco;
    @Column(name = "dt_atu_pco")
    @Temporal(TemporalType.DATE)
    private Date dtAtuPco;
    @JoinColumns({
        @JoinColumn(name = "cod_mod", referencedColumnName = "cod_mod"),
        @JoinColumn(name = "cod_sys", referencedColumnName = "cod_sys"),
        @JoinColumn(name = "cod_mut", referencedColumnName = "cod_mut")})
    @ManyToOne(optional = false)
    private SysModulo sysModulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processo")
    private List<PerfilProcesso> perfilProcessoList;

    public Processo() {
    }

    public Processo(String codPco) {
        this.codPco = codPco;
    }

    public String getCodPco() {
        return codPco;
    }

    public void setCodPco(String codPco) {
        this.codPco = codPco;
    }

    public String getNmPco() {
        return nmPco;
    }

    public void setNmPco(String nmPco) {
        this.nmPco = nmPco;
    }

    public String getDscPco() {
        return dscPco;
    }

    public void setDscPco(String dscPco) {
        this.dscPco = dscPco;
    }

    public Date getDtInsPco() {
        return dtInsPco;
    }

    public void setDtInsPco(Date dtInsPco) {
        this.dtInsPco = dtInsPco;
    }

    public Date getDtAtuPco() {
        return dtAtuPco;
    }

    public void setDtAtuPco(Date dtAtuPco) {
        this.dtAtuPco = dtAtuPco;
    }

    public SysModulo getSysModulo() {
        return sysModulo;
    }

    public void setSysModulo(SysModulo sysModulo) {
        this.sysModulo = sysModulo;
    }

    @XmlTransient
    public List<PerfilProcesso> getPerfilProcessoList() {
        return perfilProcessoList;
    }

    public void setPerfilProcessoList(List<PerfilProcesso> perfilProcessoList) {
        this.perfilProcessoList = perfilProcessoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPco != null ? codPco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processo)) {
            return false;
        }
        Processo other = (Processo) object;
        if ((this.codPco == null && other.codPco != null) || (this.codPco != null && !this.codPco.equals(other.codPco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.Processo[ codPco=" + codPco + " ]";
    }
    
}
