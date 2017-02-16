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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByCodFun", query = "SELECT f FROM Funcionario f WHERE f.codFun = :codFun"),
    @NamedQuery(name = "Funcionario.findByNmFun", query = "SELECT f FROM Funcionario f WHERE f.nmFun = :nmFun"),
    @NamedQuery(name = "Funcionario.findByCpfFun", query = "SELECT f FROM Funcionario f WHERE f.cpfFun = :cpfFun"),
    @NamedQuery(name = "Funcionario.findByDtInsFun", query = "SELECT f FROM Funcionario f WHERE f.dtInsFun = :dtInsFun"),
    @NamedQuery(name = "Funcionario.findByDtAltFun", query = "SELECT f FROM Funcionario f WHERE f.dtAltFun = :dtAltFun")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
   
    @Column(name = "cod_fun")
    private Integer codFun;
    @Size(max = 500)
    @Column(name = "nm_fun")
    private String nmFun;
    @Size(max = 18)
    @Column(name = "cpf_fun")
    private String cpfFun;
    @Column(name = "dt_ins_fun")
    @Temporal(TemporalType.DATE)
    private Date dtInsFun;
    @Column(name = "dt_alt_fun")
    @Temporal(TemporalType.DATE)
    private Date dtAltFun;
    @JoinColumn(name = "cod_end", referencedColumnName = "cod_end")
    @ManyToOne(optional = true)
    private Endereco codEnd;
    @JoinColumn(name = "cod_emp", referencedColumnName = "cod_emp")
    @ManyToOne(optional = false)
    private Empresa codEmp;

    public Funcionario() {
    }

    public Funcionario(Integer codFun) {
        this.codFun = codFun;
    }

    public Integer getCodFun() {
        return codFun;
    }

    public void setCodFun(Integer codFun) {
        this.codFun = codFun;
    }

    public String getNmFun() {
        return nmFun;
    }

    public void setNmFun(String nmFun) {
        this.nmFun = nmFun;
    }

    public String getCpfFun() {
        return cpfFun;
    }

    public void setCpfFun(String cpfFun) {
        this.cpfFun = cpfFun;
    }

    public Date getDtInsFun() {
        return dtInsFun;
    }

    public void setDtInsFun(Date dtInsFun) {
        this.dtInsFun = dtInsFun;
    }

    public Date getDtAltFun() {
        return dtAltFun;
    }

    public void setDtAltFun(Date dtAltFun) {
        this.dtAltFun = dtAltFun;
    }

    public Endereco getCodEnd() {
        return codEnd;
    }

    public void setCodEnd(Endereco codEnd) {
        this.codEnd = codEnd;
    }

    public Empresa getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Empresa codEmp) {
        this.codEmp = codEmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFun != null ? codFun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codFun == null && other.codFun != null) || (this.codFun != null && !this.codFun.equals(other.codFun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.Funcionario[ codFun=" + codFun + " ]";
    }
    
}
