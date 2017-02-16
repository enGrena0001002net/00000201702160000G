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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByCodEvt", query = "SELECT e FROM Evento e WHERE e.eventoPK.codEvt = :codEvt"),
    @NamedQuery(name = "Evento.findByCodUsu", query = "SELECT e FROM Evento e WHERE e.eventoPK.codUsu = :codUsu"),
    @NamedQuery(name = "Evento.findByNmEvt", query = "SELECT e FROM Evento e WHERE e.nmEvt = :nmEvt"),
    @NamedQuery(name = "Evento.findByDscEvt", query = "SELECT e FROM Evento e WHERE e.dscEvt = :dscEvt"),
    @NamedQuery(name = "Evento.findByDtInsEvt", query = "SELECT e FROM Evento e WHERE e.dtInsEvt = :dtInsEvt"),
    @NamedQuery(name = "Evento.findByDtAtuEvt", query = "SELECT e FROM Evento e WHERE e.dtAtuEvt = :dtAtuEvt")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventoPK eventoPK;
    @Basic(optional = false)
    
    @Size(min = 1, max = 500)
    @Column(name = "nm_evt")
    private String nmEvt;
    @Size(max = 1000)
    @Column(name = "dsc_evt")
    private String dscEvt;
    @Column(name = "dt_ins_evt")
    @Temporal(TemporalType.DATE)
    private Date dtInsEvt;
    @Column(name = "dt_atu_evt")
    @Temporal(TemporalType.DATE)
    private Date dtAtuEvt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private List<Lote> loteList;
//    @JoinColumn(name = "cod_usu", referencedColumnName = "cod_usu", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Usuario usuario;

    public Evento() {
    }

    public Evento(EventoPK eventoPK) {
        this.eventoPK = eventoPK;
    }

    public Evento(EventoPK eventoPK, String nmEvt) {
        this.eventoPK = eventoPK;
        this.nmEvt = nmEvt;
    }

    public Evento(int codEvt, int codUsu) {
        this.eventoPK = new EventoPK(codEvt, codUsu);
    }

    public EventoPK getEventoPK() {
        return eventoPK;
    }

    public void setEventoPK(EventoPK eventoPK) {
        this.eventoPK = eventoPK;
    }

    public String getNmEvt() {
        return nmEvt;
    }

    public void setNmEvt(String nmEvt) {
        this.nmEvt = nmEvt;
    }

    public String getDscEvt() {
        return dscEvt;
    }

    public void setDscEvt(String dscEvt) {
        this.dscEvt = dscEvt;
    }

    public Date getDtInsEvt() {
        return dtInsEvt;
    }

    public void setDtInsEvt(Date dtInsEvt) {
        this.dtInsEvt = dtInsEvt;
    }

    public Date getDtAtuEvt() {
        return dtAtuEvt;
    }

    public void setDtAtuEvt(Date dtAtuEvt) {
        this.dtAtuEvt = dtAtuEvt;
    }

    @XmlTransient
    public List<Lote> getLoteList() {
        return loteList;
    }

    public void setLoteList(List<Lote> loteList) {
        this.loteList = loteList;
    }

//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventoPK != null ? eventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.eventoPK == null && other.eventoPK != null) || (this.eventoPK != null && !this.eventoPK.equals(other.eventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.bilheteria.Evento[ eventoPK=" + eventoPK + " ]";
    }
    
}
