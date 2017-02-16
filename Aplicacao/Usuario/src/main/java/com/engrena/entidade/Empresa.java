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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByCodEmp", query = "SELECT e FROM Empresa e WHERE e.codEmp = :codEmp"),
    @NamedQuery(name = "Empresa.findByNmRzSocialEmp", query = "SELECT e FROM Empresa e WHERE e.nmRzSocialEmp = :nmRzSocialEmp"),
    @NamedQuery(name = "Empresa.findByNmFanEmp", query = "SELECT e FROM Empresa e WHERE e.nmFanEmp = :nmFanEmp"),
    @NamedQuery(name = "Empresa.findByNrCnpjEmp", query = "SELECT e FROM Empresa e WHERE e.nrCnpjEmp = :nrCnpjEmp"),
    @NamedQuery(name = "Empresa.findByDscEmp", query = "SELECT e FROM Empresa e WHERE e.dscEmp = :dscEmp"),
    @NamedQuery(name = "Empresa.findByCodUsu", query = "SELECT e FROM Empresa e WHERE e.codUsu = :codUsu"),
    @NamedQuery(name = "Empresa.findByDtAtuUsu", query = "SELECT e FROM Empresa e WHERE e.dtAtuUsu = :dtAtuUsu"),
    @NamedQuery(name = "Empresa.findByDtInsUsu", query = "SELECT e FROM Empresa e WHERE e.dtInsUsu = :dtInsUsu")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
    @Column(name = "cod_emp")
    private Integer codEmp;
    @Basic(optional = false)
    
    @Size(min = 1, max = 255)
    @Column(name = "nm_rz_social_emp")
    private String nmRzSocialEmp;
    @Size(max = 255)
    @Column(name = "nm_fan_emp")
    private String nmFanEmp;
    @Size(max = 18)
    @Column(name = "nr_cnpj_emp")
    private String nrCnpjEmp;
    @Size(max = 500)
    @Column(name = "dsc_emp")
    private String dscEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usu")
    private int codUsu;
    @Column(name = "dt_atu_usu")
    @Temporal(TemporalType.DATE)
    private Date dtAtuUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_ins_usu")
    @Temporal(TemporalType.DATE)
    private Date dtInsUsu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEmp")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "cod_end", referencedColumnName = "cod_end")
    @ManyToOne(optional = false)
    private Endereco codEnd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEmp")
    private List<Funcionario> funcionarioList;

    public Empresa() {
    }

    public Empresa(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public Empresa(Integer codEmp, String nmRzSocialEmp, int codUsu, Date dtInsUsu) {
        this.codEmp = codEmp;
        this.nmRzSocialEmp = nmRzSocialEmp;
        this.codUsu = codUsu;
        this.dtInsUsu = dtInsUsu;
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public String getNmRzSocialEmp() {
        return nmRzSocialEmp;
    }

    public void setNmRzSocialEmp(String nmRzSocialEmp) {
        this.nmRzSocialEmp = nmRzSocialEmp;
    }

    public String getNmFanEmp() {
        return nmFanEmp;
    }

    public void setNmFanEmp(String nmFanEmp) {
        this.nmFanEmp = nmFanEmp;
    }

    public String getNrCnpjEmp() {
        return nrCnpjEmp;
    }

    public void setNrCnpjEmp(String nrCnpjEmp) {
        this.nrCnpjEmp = nrCnpjEmp;
    }

    public String getDscEmp() {
        return dscEmp;
    }

    public void setDscEmp(String dscEmp) {
        this.dscEmp = dscEmp;
    }

    public int getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(int codUsu) {
        this.codUsu = codUsu;
    }

    public Date getDtAtuUsu() {
        return dtAtuUsu;
    }

    public void setDtAtuUsu(Date dtAtuUsu) {
        this.dtAtuUsu = dtAtuUsu;
    }

    public Date getDtInsUsu() {
        return dtInsUsu;
    }

    public void setDtInsUsu(Date dtInsUsu) {
        this.dtInsUsu = dtInsUsu;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Endereco getCodEnd() {
        return codEnd;
    }

    public void setCodEnd(Endereco codEnd) {
        this.codEnd = codEnd;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmp != null ? codEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.codEmp == null && other.codEmp != null) || (this.codEmp != null && !this.codEmp.equals(other.codEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.Empresa[ codEmp=" + codEmp + " ]";
    }

}
