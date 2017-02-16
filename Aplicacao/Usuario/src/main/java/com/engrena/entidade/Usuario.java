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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodUsu", query = "SELECT u FROM Usuario u WHERE u.codUsu = :codUsu"),
    @NamedQuery(name = "Usuario.findByNmUsu", query = "SELECT u FROM Usuario u WHERE u.nmUsu = :nmUsu"),
    @NamedQuery(name = "Usuario.findByLoginUsu", query = "SELECT u FROM Usuario u WHERE u.loginUsu = :loginUsu"),
    @NamedQuery(name = "Usuario.findBySenhaUsu", query = "SELECT u FROM Usuario u WHERE u.senhaUsu = :senhaUsu"),
    @NamedQuery(name = "Usuario.findByEmailUsu", query = "SELECT u FROM Usuario u WHERE u.emailUsu = :emailUsu"),
    @NamedQuery(name = "Usuario.findByDtInsUsu", query = "SELECT u FROM Usuario u WHERE u.dtInsUsu = :dtInsUsu"),
    @NamedQuery(name = "Usuario.findByDtAtuUsu", query = "SELECT u FROM Usuario u WHERE u.dtAtuUsu = :dtAtuUsu"),
    @NamedQuery(name = "Usuario.findByTipUsu", query = "SELECT u FROM Usuario u WHERE u.tipUsu = :tipUsu"),
    @NamedQuery(name = "Usuario.findByCpfUsu", query = "SELECT u FROM Usuario u WHERE u.cpfUsu = :cpfUsu"),
    @NamedQuery(name = "Usuario.findByCnpjUsu", query = "SELECT u FROM Usuario u WHERE u.cnpjUsu = :cnpjUsu")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
   
    @Column(name = "cod_usu")
    private Integer codUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "nm_usu")
    private String nmUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "login_usu")
    private String loginUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "senha_usu")
    private String senhaUsu;
    @Size(max = 150)
    @Column(name = "email_usu")
    private String emailUsu;
    @Column(name = "dt_ins_usu")
    @Temporal(TemporalType.DATE)
    private Date dtInsUsu;
    @Column(name = "dt_atu_usu")
    @Temporal(TemporalType.DATE)
    private Date dtAtuUsu;
    @Column(name = "tip_usu")
    private Character tipUsu;
    @Size(max = 11)
    @Column(name = "cpf_usu")
    private String cpfUsu;
    @Size(max = 18)
    @Column(name = "cnpj_usu")
    private String cnpjUsu;
    @JoinColumn(name = "cod_end", referencedColumnName = "cod_end")
    @ManyToOne(optional = false)
    private Endereco codEnd;
    @JoinColumn(name = "cod_emp", referencedColumnName = "cod_emp")
    @ManyToOne(optional = false)
    private Empresa codEmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<PerfilUsuario> perfilUsuarioList;

    public Usuario() {
    }

    public Usuario(Integer codUsu) {
        this.codUsu = codUsu;
    }

    public Usuario(Integer codUsu, String nmUsu, String loginUsu, String senhaUsu) {
        this.codUsu = codUsu;
        this.nmUsu = nmUsu;
        this.loginUsu = loginUsu;
        this.senhaUsu = senhaUsu;
    }

    public Integer getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(Integer codUsu) {
        this.codUsu = codUsu;
    }

    public String getNmUsu() {
        return nmUsu;
    }

    public void setNmUsu(String nmUsu) {
        this.nmUsu = nmUsu;
    }

    public String getLoginUsu() {
        return loginUsu;
    }

    public void setLoginUsu(String loginUsu) {
        this.loginUsu = loginUsu;
    }

    public String getSenhaUsu() {
        return senhaUsu;
    }

    public void setSenhaUsu(String senhaUsu) {
        this.senhaUsu = senhaUsu;
    }

    public String getEmailUsu() {
        return emailUsu;
    }

    public void setEmailUsu(String emailUsu) {
        this.emailUsu = emailUsu;
    }

    public Date getDtInsUsu() {
        return dtInsUsu;
    }

    public void setDtInsUsu(Date dtInsUsu) {
        this.dtInsUsu = dtInsUsu;
    }

    public Date getDtAtuUsu() {
        return dtAtuUsu;
    }

    public void setDtAtuUsu(Date dtAtuUsu) {
        this.dtAtuUsu = dtAtuUsu;
    }

    public Character getTipUsu() {
        return tipUsu;
    }

    public void setTipUsu(Character tipUsu) {
        this.tipUsu = tipUsu;
    }

    public String getCpfUsu() {
        return cpfUsu;
    }

    public void setCpfUsu(String cpfUsu) {
        this.cpfUsu = cpfUsu;
    }

    public String getCnpjUsu() {
        return cnpjUsu;
    }

    public void setCnpjUsu(String cnpjUsu) {
        this.cnpjUsu = cnpjUsu;
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

    @XmlTransient
    public List<PerfilUsuario> getPerfilUsuarioList() {
        return perfilUsuarioList;
    }

    public void setPerfilUsuarioList(List<PerfilUsuario> perfilUsuarioList) {
        this.perfilUsuarioList = perfilUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsu != null ? codUsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsu == null && other.codUsu != null) || (this.codUsu != null && !this.codUsu.equals(other.codUsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.entidade.Usuario[ codUsu=" + codUsu + " ]";
    }
    
}
