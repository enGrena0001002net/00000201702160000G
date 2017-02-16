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
@Table(name = "systema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Systema.findAll", query = "SELECT s FROM Systema s"),
    @NamedQuery(name = "Systema.findByCodSys", query = "SELECT s FROM Systema s WHERE s.codSys = :codSys"),
    @NamedQuery(name = "Systema.findByNmSys", query = "SELECT s FROM Systema s WHERE s.nmSys = :nmSys"),
    @NamedQuery(name = "Systema.findByDscSys", query = "SELECT s FROM Systema s WHERE s.dscSys = :dscSys"),
    @NamedQuery(name = "Systema.findByDtInsSys", query = "SELECT s FROM Systema s WHERE s.dtInsSys = :dtInsSys"),
    @NamedQuery(name = "Systema.findByDtAtuSys", query = "SELECT s FROM Systema s WHERE s.dtAtuSys = :dtAtuSys")})
public class Systema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Size(min = 1, max = 8)
    @Column(name = "cod_sys")
    private String codSys;
    @Size(max = 150)
    @Column(name = "nm_sys")
    private String nmSys;
    @Size(max = 500)
    @Column(name = "dsc_sys")
    private String dscSys;
    @Column(name = "dt_ins_sys")
    @Temporal(TemporalType.DATE)
    private Date dtInsSys;
    @Column(name = "dt_atu_sys")
    @Temporal(TemporalType.DATE)
    private Date dtAtuSys;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systema")
    private List<SysMulte> sysMulteList;

    public Systema() {
    }

    public Systema(String codSys) {
        this.codSys = codSys;
    }

    public String getCodSys() {
        return codSys;
    }

    public void setCodSys(String codSys) {
        this.codSys = codSys;
    }

    public String getNmSys() {
        return nmSys;
    }

    public void setNmSys(String nmSys) {
        this.nmSys = nmSys;
    }

    public String getDscSys() {
        return dscSys;
    }

    public void setDscSys(String dscSys) {
        this.dscSys = dscSys;
    }

    public Date getDtInsSys() {
        return dtInsSys;
    }

    public void setDtInsSys(Date dtInsSys) {
        this.dtInsSys = dtInsSys;
    }

    public Date getDtAtuSys() {
        return dtAtuSys;
    }

    public void setDtAtuSys(Date dtAtuSys) {
        this.dtAtuSys = dtAtuSys;
    }

    @XmlTransient
    public List<SysMulte> getSysMulteList() {
        return sysMulteList;
    }

    public void setSysMulteList(List<SysMulte> sysMulteList) {
        this.sysMulteList = sysMulteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSys != null ? codSys.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Systema)) {
            return false;
        }
        Systema other = (Systema) object;
        if ((this.codSys == null && other.codSys != null) || (this.codSys != null && !this.codSys.equals(other.codSys))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.Systema[ codSys=" + codSys + " ]";
    }
    
}
