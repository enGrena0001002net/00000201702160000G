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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l"),
    @NamedQuery(name = "Lote.findByCodLte", query = "SELECT l FROM Lote l WHERE l.codLte = :codLte"),
    @NamedQuery(name = "Lote.findByNmLte", query = "SELECT l FROM Lote l WHERE l.nmLte = :nmLte"),
    @NamedQuery(name = "Lote.findByDtInsLte", query = "SELECT l FROM Lote l WHERE l.dtInsLte = :dtInsLte"),
    @NamedQuery(name = "Lote.findByDtAltLte", query = "SELECT l FROM Lote l WHERE l.dtAltLte = :dtAltLte")})
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)

    @Column(name = "cod_lte")
    private Integer codLte;
    @Size(max = 500)
    @Column(name = "nm_lte")
    private String nmLte;
    @Column(name = "dt_ins_lte")
    @Temporal(TemporalType.DATE)
    private Date dtInsLte;
    @Column(name = "dt_alt_lte")
    @Temporal(TemporalType.DATE)
    private Date dtAltLte;
    @JoinColumns({
        @JoinColumn(name = "cod_evt", referencedColumnName = "cod_evt"),
        @JoinColumn(name = "cod_usu", referencedColumnName = "cod_usu")})
    @ManyToOne(optional = false)
    private Evento evento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLte")
    private List<QrIngresso> qrIngressoList;

    public Lote() {
    }

    public Lote(Integer codLte) {
        this.codLte = codLte;
    }

    public Integer getCodLte() {
        return codLte;
    }

    public void setCodLte(Integer codLte) {
        this.codLte = codLte;
    }

    public String getNmLte() {
        return nmLte;
    }

    public void setNmLte(String nmLte) {
        this.nmLte = nmLte;
    }

    public Date getDtInsLte() {
        return dtInsLte;
    }

    public void setDtInsLte(Date dtInsLte) {
        this.dtInsLte = dtInsLte;
    }

    public Date getDtAltLte() {
        return dtAltLte;
    }

    public void setDtAltLte(Date dtAltLte) {
        this.dtAltLte = dtAltLte;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @XmlTransient
    public List<QrIngresso> getQrIngressoList() {
        return qrIngressoList;
    }

    public void setQrIngressoList(List<QrIngresso> qrIngressoList) {
        this.qrIngressoList = qrIngressoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLte != null ? codLte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.codLte == null && other.codLte != null) || (this.codLte != null && !this.codLte.equals(other.codLte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.bilheteria.Lote[ codLte=" + codLte + " ]";
    }

}
