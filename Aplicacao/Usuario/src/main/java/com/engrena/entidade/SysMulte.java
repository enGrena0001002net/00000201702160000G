/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "sys_multe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysMulte.findAll", query = "SELECT s FROM SysMulte s"),
    @NamedQuery(name = "SysMulte.findByCodMut", query = "SELECT s FROM SysMulte s WHERE s.sysMultePK.codMut = :codMut"),
    @NamedQuery(name = "SysMulte.findByCodSys", query = "SELECT s FROM SysMulte s WHERE s.sysMultePK.codSys = :codSys"),
    @NamedQuery(name = "SysMulte.findByNmMut", query = "SELECT s FROM SysMulte s WHERE s.nmMut = :nmMut"),
    @NamedQuery(name = "SysMulte.findByDscMut", query = "SELECT s FROM SysMulte s WHERE s.dscMut = :dscMut"),
    @NamedQuery(name = "SysMulte.findByDtInsMut", query = "SELECT s FROM SysMulte s WHERE s.dtInsMut = :dtInsMut"),
    @NamedQuery(name = "SysMulte.findByDtAtuMut", query = "SELECT s FROM SysMulte s WHERE s.dtAtuMut = :dtAtuMut")})
public class SysMulte implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SysMultePK sysMultePK;
    @Size(max = 150)
    @Column(name = "nm_mut")
    private String nmMut;
    @Size(max = 500)
    @Column(name = "dsc_mut")
    private String dscMut;
    @Column(name = "dt_ins_mut")
    @Temporal(TemporalType.DATE)
    private Date dtInsMut;
    @Column(name = "dt_atu_mut")
    @Temporal(TemporalType.DATE)
    private Date dtAtuMut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sysMulte")
    private List<SysModulo> sysModuloList;
    @JoinColumn(name = "cod_sys", referencedColumnName = "cod_sys", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Systema systema;

    public SysMulte() {
    }

    public SysMulte(SysMultePK sysMultePK) {
        this.sysMultePK = sysMultePK;
    }

    public SysMulte(String codMut, String codSys) {
        this.sysMultePK = new SysMultePK(codMut, codSys);
    }

    public SysMultePK getSysMultePK() {
        return sysMultePK;
    }

    public void setSysMultePK(SysMultePK sysMultePK) {
        this.sysMultePK = sysMultePK;
    }

    public String getNmMut() {
        return nmMut;
    }

    public void setNmMut(String nmMut) {
        this.nmMut = nmMut;
    }

    public String getDscMut() {
        return dscMut;
    }

    public void setDscMut(String dscMut) {
        this.dscMut = dscMut;
    }

    public Date getDtInsMut() {
        return dtInsMut;
    }

    public void setDtInsMut(Date dtInsMut) {
        this.dtInsMut = dtInsMut;
    }

    public Date getDtAtuMut() {
        return dtAtuMut;
    }

    public void setDtAtuMut(Date dtAtuMut) {
        this.dtAtuMut = dtAtuMut;
    }

    @XmlTransient
    public List<SysModulo> getSysModuloList() {
        return sysModuloList;
    }

    public void setSysModuloList(List<SysModulo> sysModuloList) {
        this.sysModuloList = sysModuloList;
    }

    public Systema getSystema() {
        return systema;
    }

    public void setSystema(Systema systema) {
        this.systema = systema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysMultePK != null ? sysMultePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysMulte)) {
            return false;
        }
        SysMulte other = (SysMulte) object;
        if ((this.sysMultePK == null && other.sysMultePK != null) || (this.sysMultePK != null && !this.sysMultePK.equals(other.sysMultePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.SysMulte[ sysMultePK=" + sysMultePK + " ]";
    }
    
}
