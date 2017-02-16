/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.visao;

import com.engrena.achatipicas.entidade.TipoUsuario;
import com.engrena.achatipicas.entidade.Usuario;
import com.engrena.achatipicas.regras.TipoUsuarioR;
import com.engrena.achatipicas.regras.UsuarioR;

import com.engrena.achatipicas.util.Utilitarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "usuarioV")
@SessionScoped
public class UsuarioV implements Serializable {

    @Inject
    UsuarioR objR;
    @Inject
    TipoUsuarioR objR2;

    Utilitarios util = new Utilitarios();
    Usuario frmUsuario;

    String codigoPesquiosa;
    List<Usuario> listarUsuario;
    List<TipoUsuario> gruposslistSelect;
    TipoUsuario selectTipoUsuario;

    String usuarioCod;
    String usuarioNome;
    Boolean usuarioPj = null;
    Boolean usuarioAtivo = null;
    Boolean fone = false;

    public List<TipoUsuario> listarTipoUsuarios() {

        return objR2.findAll();
    }

    public void novo() {

        setFrmUsuario(new Usuario());

    }

    public void salvarTipoUsuario() {

    }

    public void cancelar() {

        setFrmUsuario(null);
        setSelectTipoUsuario(null);

    }

    public void receberUsuario(Usuario item) {

        setFrmUsuario(item);
        System.out.println("item.getUsuarioFone().trim().length()" + item.getUsuarioFone().trim().length());
        setFone(item.getUsuarioFone().trim().length() < 14);

    }

    public void salvar() {

        objR.salvar(getFrmUsuario());

    }

    public void altera() {

        objR.alterar(getFrmUsuario());

    }

    public void desativar(Usuario obj) {
        objR.desativar(obj);
    }

    public void ativar(Usuario obj) {
        objR.ativar(obj);
    }

    public void pesquisar() {
        System.out.println("getCodigoPesquiosa()" + getCodigoPesquiosa());
        setListarUsuario(objR.pesquisaUsuario(getUsuarioCod(), getUsuarioNome(), getUsuarioPj(), getUsuarioAtivo()));

    }

    public void limparPesquisa() {
        setListarUsuario(null);
        setCodigoPesquiosa("");
        setUsuarioAtivo(null);
        setUsuarioPj(null);
        setUsuarioNome(null);
        setUsuarioCod(null);
    }

    public Usuario getFrmUsuario() {
        if (frmUsuario == null) {
            frmUsuario = new Usuario();
        }
        return frmUsuario;
    }

    public void setFrmUsuario(Usuario frmUsuario) {
        this.frmUsuario = frmUsuario;
    }

    public String getCodigoPesquiosa() {
        return codigoPesquiosa;
    }

    public void setCodigoPesquiosa(String codigoPesquiosa) {
        this.codigoPesquiosa = codigoPesquiosa;
    }

    public List<Usuario> getListarUsuario() {
        return listarUsuario;
    }

    public void setListarUsuario(List<Usuario> listarUsuario) {
        this.listarUsuario = listarUsuario;
    }

    public List<TipoUsuario> getTipoUsuarioslistSelect() {

        if (gruposslistSelect == null) {
            gruposslistSelect = new ArrayList<>();
        }

        return gruposslistSelect;
    }

    public void setTipoUsuarioslistSelect(List<TipoUsuario> gruposslistSelect) {
        this.gruposslistSelect = gruposslistSelect;
    }

    public TipoUsuario getSelectTipoUsuario() {
        return selectTipoUsuario;
    }

    public void setSelectTipoUsuario(TipoUsuario selectTipoUsuario) {
        this.selectTipoUsuario = selectTipoUsuario;
    }

    /**
     * Creates a new instance of UsuarioV
     */
    public UsuarioV() {
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

    public Boolean getUsuarioPj() {
        return usuarioPj;
    }

    public void setUsuarioPj(Boolean usuarioPj) {
        this.usuarioPj = usuarioPj;
    }

    public Boolean getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void setUsuarioAtivo(Boolean usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }

    public Boolean getFone() {
        return fone;
    }

    public void setFone(Boolean fone) {
        this.fone = fone;
    }

}
