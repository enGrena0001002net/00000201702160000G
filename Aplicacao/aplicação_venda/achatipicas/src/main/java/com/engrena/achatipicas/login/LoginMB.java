/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.login;

import com.engrena.achatipicas.entidade.Grupo;
import com.engrena.achatipicas.entidade.Regra;
import com.engrena.achatipicas.entidade.Usuario;
import com.engrena.achatipicas.regras.UsuarioR;
import com.engrena.achatipicas.util.Utilitarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    @Inject
    UsuarioR usuarioR;
    Utilitarios utilitarios = new Utilitarios();
    String usuarioEmail, usuarioSenha;
    private Usuario usuarioValido;
    MenuModel model;

    String pagina = "login.xhtml";

    public String validaUsuario() {
        String retorno = "login.xhtml";
        Usuario usuarioTeste = usuarioR.validaUsuario(getUsuarioEmail());

        if (usuarioTeste != null) {
            if (usuarioTeste.getUsuarioSenha().trim().equals(getUsuarioSenha().trim())) {
                setUsuarioValido(usuarioTeste);
                System.out.println("LOGIN valido");
                setPagina("principal.xhtml");
                retorno = "index.xhtml";
                monteMenu();
            } else {

                utilitarios.retornaMessageErro("senha Invalida");
                retorno = "login.xhtml";
            }

        } else {
            utilitarios.retornaMessageErro("Não foi encontrado Usuáriocadastrado com esse e-mail ");
        }
        return retorno;
    }

    public void recebepagina(String pg) {
        setPagina(pg);

    }

    public String sair() {
        setUsuarioValido(null);
        model = null;
        pagina = "login.xhtml";
        usuarioEmail = null;
        usuarioSenha = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        session.invalidate();
        return "login.xhtml";
    }

    public void monteMenu() {
        model = new DefaultMenuModel();
        DefaultMenuItem itemHome = new DefaultMenuItem("HOME");
        itemHome.setIcon("ui-icon-document");
        itemHome.setCommand("#{loginMB.recebepagina(\"principal.xhtml\")}");

        itemHome.setAjax(false);
        model.addElement(itemHome);
        if (getUsuarioValido() != null) {

            for (Grupo grupo : getUsuarioValido().getTpCod().getGrupoList()) {
                Submenu submenu = new DefaultSubMenu(grupo.getGrupoNome());
                for (Regra regra : grupo.getRegraList()) {
                    DefaultMenuItem item = new DefaultMenuItem(regra.getRegrasNome());
                    
                    item.setCommand("#{loginMB.recebepagina('" + regra.getRegrasFrm() + ".xhtml')}");

//                    item.setHref("index.xhtml");
                    item.setAjax(false);
                    submenu.getElements().add(item);
                }
                model.addElement(submenu);

            }
        }
        DefaultMenuItem itemSair = new DefaultMenuItem("SAIR");
        itemSair.setIcon("ui-icon-key");
        itemSair.setCommand("#{loginMB.sair()}");

        itemSair.setAjax(false);
        model.addElement(itemSair);
    }

    public MenuModel getModel() {

        return model;
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

    public Usuario getUsuarioValido() {
        return usuarioValido;
    }

    public void setUsuarioValido(Usuario usuarioValido) {
        this.usuarioValido = usuarioValido;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

}
