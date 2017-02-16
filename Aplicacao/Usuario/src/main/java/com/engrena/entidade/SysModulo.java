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
import javax.persistence.JoinColumns;
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
@Table(name = "sys_modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysModulo.findAll", query = "SELECT s FROM SysModulo s"),
    @NamedQuery(name = "SysModulo.findByCodMod", query = "SELECT s FROM SysModulo s WHERE s.sysModuloPK.codMod = :codMod"),
    @NamedQuery(name = "SysModulo.findByCodSys", query = "SELECT s FROM SysModulo s WHERE s.sysModuloPK.codSys = :codSys"),
    @NamedQuery(name = "SysModulo.findByCodMut", query = "SELECT s FROM SysModulo s WHERE s.sysModuloPK.codMut = :codMut"),
    @NamedQuery(name = "SysModulo.findByNmMod", query = "SELECT s FROM SysModulo s WHERE s.nmMod = :nmMod"),
    @NamedQuery(name = "SysModulo.findByDscMod", query = "SELECT s FROM SysModulo s WHERE s.dscMod = :dscMod"),
    @NamedQuery(name = "SysModulo.findByDtInsMod", query = "SELECT s FROM SysModulo s WHERE s.dtInsMod = :dtInsMod"),
    @NamedQuery(name = "SysModulo.findByDtAtuMod", query = "SELECT s FROM SysModulo s WHERE s.dtAtuMod = :dtAtuMod")})
public class SysModulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SysModuloPK sysModuloPK;
    @Size(max = 150)
    @Column(name = "nm_mod")
    private String nmMod;
    @Size(max = 500)
    @Column(name = "dsc_mod")
    private String dscMod;
    @Column(name = "dt_ins_mod")
    @Temporal(TemporalType.DATE)
    private Date dtInsMod;
    @Column(name = "dt_atu_mod")
    @Temporal(TemporalType.DATE)
    private Date dtAtuMod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sysModulo")
    private List<Processo> processoList;
    @JoinColumns({
        @JoinColumn(name = "cod_sys", referencedColumnName = "cod_sys", insertable = false, updatable = false),
        @JoinColumn(name = "cod_mut", referencedColumnName = "cod_mut", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SysMulte sysMulte;

    public SysModulo() {
    }

    public SysModulo(SysModuloPK sysModuloPK) {
        this.sysModuloPK = sysModuloPK;
    }

    public SysModulo(String codMod, String codSys, String codMut) {
        this.sysModuloPK = new SysModuloPK(codMod, codSys, codMut);
    }

    public SysModuloPK getSysModuloPK() {
        return sysModuloPK;
    }

    public void setSysModuloPK(SysModuloPK sysModuloPK) {
        this.sysModuloPK = sysModuloPK;
    }

    public String getNmMod() {
        return nmMod;
    }

    public void setNmMod(String nmMod) {
        this.nmMod = nmMod;
    }

    public String getDscMod() {
        return dscMod;
    }

    public void setDscMod(String dscMod) {
        this.dscMod = dscMod;
    }

    public Date getDtInsMod() {
        return dtInsMod;
    }

    public void setDtInsMod(Date dtInsMod) {
        this.dtInsMod = dtInsMod;
    }

    public Date getDtAtuMod() {
        return dtAtuMod;
    }

    public void setDtAtuMod(Date dtAtuMod) {
        this.dtAtuMod = dtAtuMod;
    }

    @XmlTransient
    public List<Processo> getProcessoList() {
        return processoList;
    }

    public void setProcessoList(List<Processo> processoList) {
        this.processoList = processoList;
    }

    public SysMulte getSysMulte() {
        return sysMulte;
    }

    public void setSysMulte(SysMulte sysMulte) {
        this.sysMulte = sysMulte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysModuloPK != null ? sysModuloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysModulo)) {
            return false;
        }
        SysModulo other = (SysModulo) object;
        if ((this.sysModuloPK == null && other.sysModuloPK != null) || (this.sysModuloPK != null && !this.sysModuloPK.equals(other.sysModuloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.SysModulo[ sysModuloPK=" + sysModuloPK + " ]";
    }
    
}
