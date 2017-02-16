/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cdi_fpereira
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuarioCod", query = "SELECT u FROM Usuario u WHERE u.usuarioCod = :usuarioCod"),
    @NamedQuery(name = "Usuario.findByUsuarioNome", query = "SELECT u FROM Usuario u WHERE u.usuarioNome = :usuarioNome"),
    @NamedQuery(name = "Usuario.findByUsuarioFone", query = "SELECT u FROM Usuario u WHERE u.usuarioFone = :usuarioFone"),
    @NamedQuery(name = "Usuario.findByUsuarioEmail", query = "SELECT u FROM Usuario u WHERE u.usuarioEmail = :usuarioEmail"),
    @NamedQuery(name = "Usuario.findByUsuarioSenha", query = "SELECT u FROM Usuario u WHERE u.usuarioSenha = :usuarioSenha"),
    @NamedQuery(name = "Usuario.findByUsuarioPj", query = "SELECT u FROM Usuario u WHERE u.usuarioPj = :usuarioPj"),
    @NamedQuery(name = "Usuario.findByUsuarioAtivo", query = "SELECT u FROM Usuario u WHERE u.usuarioAtivo = :usuarioAtivo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "USUARIO_COD")
    private String usuarioCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USUARIO_NOME")
    private String usuarioNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "USUARIO_FONE")
    private String usuarioFone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "USUARIO_EMAIL")
    private String usuarioEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "USUARIO_SENHA")
    private String usuarioSenha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_PJ")
    private boolean usuarioPj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ATIVO")
    private boolean usuarioAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioCodigo")
    private List<Loja> lojaList;
    @JoinColumn(name = "TP_COD", referencedColumnName = "TP_CODIGO")
    @ManyToOne(optional = false)
    private TipoUsuario tpCod;

    public Usuario() {
    }

    public Usuario(String usuarioCod) {
        this.usuarioCod = usuarioCod;
    }

    public Usuario(String usuarioCod, String usuarioNome, String usuarioFone, String usuarioEmail, String usuarioSenha, boolean usuarioPj, boolean usuarioAtivo) {
        this.usuarioCod = usuarioCod;
        this.usuarioNome = usuarioNome;
        this.usuarioFone = usuarioFone;
        this.usuarioEmail = usuarioEmail;
        this.usuarioSenha = usuarioSenha;
        this.usuarioPj = usuarioPj;
        this.usuarioAtivo = usuarioAtivo;
    }

    public String getUsuarioCod() {
        return usuarioCod;
    }

    public void setUsuarioCod(String usuarioCod) {
        this.usuarioCod = usuarioCod;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioFone() {
        return usuarioFone;
    }

    public void setUsuarioFone(String usuarioFone) {
        this.usuarioFone = usuarioFone;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }

    public boolean getUsuarioPj() {
        return usuarioPj;
    }

    public void setUsuarioPj(boolean usuarioPj) {
        this.usuarioPj = usuarioPj;
    }

    public boolean getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void setUsuarioAtivo(boolean usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }

    @XmlTransient
    public List<Loja> getLojaList() {
        return lojaList;
    }

    public void setLojaList(List<Loja> lojaList) {
        this.lojaList = lojaList;
    }

    public TipoUsuario getTpCod() {
        return tpCod;
    }

    public void setTpCod(TipoUsuario tpCod) {
        this.tpCod = tpCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioCod != null ? usuarioCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioCod == null && other.usuarioCod != null) || (this.usuarioCod != null && !this.usuarioCod.equals(other.usuarioCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.engrena.achatipicas.entidade.Usuario[ usuarioCod=" + usuarioCod + " ]";
    }
    
}
