/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "qr_ingresso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrIngresso.findAll", query = "SELECT q FROM QrIngresso q"),
    @NamedQuery(name = "QrIngresso.findByCodQri", query = "SELECT q FROM QrIngresso q WHERE q.codQri = :codQri"),
    @NamedQuery(name = "QrIngresso.findByNrQri", query = "SELECT q FROM QrIngresso q WHERE q.nrQri = :nrQri"),
    @NamedQuery(name = "QrIngresso.findByDtInsQri", query = "SELECT q FROM QrIngresso q WHERE q.dtInsQri = :dtInsQri"),
    @NamedQuery(name = "QrIngresso.findByDtChkQri", query = "SELECT q FROM QrIngresso q WHERE q.dtChkQri = :dtChkQri"),
    @NamedQuery(name = "QrIngresso.findByAtvQri", query = "SELECT q FROM QrIngresso q WHERE q.atvQri = :atvQri")})
public class QrIngresso implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)

    @Column(name = "cod_qri")
    private Integer codQri;
    @Size(max = 20)
    @Column(name = "nr_qri")
    private String nrQri;
    @Column(name = "dt_ins_qri")
    @Temporal(TemporalType.DATE)
    private Date dtInsQri;
    @Column(name = "dt_chk_qri")
    @Temporal(TemporalType.DATE)
    private Date dtChkQri;
    @Column(name = "atv_qri")
    private Boolean atvQri;
    @JoinColumn(name = "cod_lte", referencedColumnName = "cod_lte")
    @ManyToOne(optional = false)
    private Lote codLte;
//    @JoinColumn(name = "cod_fun", referencedColumnName = "cod_fun")
//    @ManyToOne
//    private Funcionario codFun;

    public QrIngresso() {
    }

    public QrIngresso(Integer codQri) {
        this.codQri = codQri;
    }

    public Integer getCodQri() {
        return codQri;
    }

    public void setCodQri(Integer codQri) {
        this.codQri = codQri;
    }

    public String getNrQri() {
        return nrQri;
    }

    public void setNrQri(String nrQri) {
        this.nrQri = nrQri;
    }

    public Date getDtInsQri() {
        return dtInsQri;
    }

    public void setDtInsQri(Date dtInsQri) {
        this.dtInsQri = dtInsQri;
    }

    public Date getDtChkQri() {
        return dtChkQri;
    }

    public void setDtChkQri(Date dtChkQri) {
        this.dtChkQri = dtChkQri;
    }

    public Boolean getAtvQri() {
        return atvQri;
    }

    public void setAtvQri(Boolean atvQri) {
        this.atvQri = atvQri;
    }

    public Lote getCodLte() {
        return codLte;
    }

    public void setCodLte(Lote codLte) {
        this.codLte = codLte;
    }

//    public Funcionario getCodFun() {
//        return codFun;
//    }
//
//    public void setCodFun(Funcionario codFun) {
//        this.codFun = codFun;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codQri != null ? codQri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrIngresso)) {
            return false;
        }
        QrIngresso other = (QrIngresso) object;
        if ((this.codQri == null && other.codQri != null) || (this.codQri != null && !this.codQri.equals(other.codQri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.bilheteria.QrIngresso[ codQri=" + codQri + " ]";
    }

}
