/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.regras;

import com.engrena.achatipicas.entidade.Usuario;
import com.engrena.achatipicas.fachada.UsuarioFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class UsuarioR implements Serializable {

    @EJB
    UsuarioFacade facade;
    Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    Severity msgTypInfo = FacesMessage.SEVERITY_INFO;

    public void salvar(Usuario obj) {
        try {

            if (facade.verificaCodigo(obj.getUsuarioCod()) == null) {
                facade.create(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Salvos "));
            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informa:", " CPF ou CNPJ já cadastrado"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Persistir Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public void alterar(Usuario obj) {
        try {

            facade.edit(obj);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Alterados"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Persistir Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public Boolean validarSenha(String senha1, String senha2) {
        Boolean returno = false;
        if (senha1.equals(senha2)) {
            returno = true;

        } else {
            returno = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Informa:", "senhas são diferentes"));
        }

        return returno;
    }

    public void desativar(Usuario obj) {

        try {
            obj.setUsuarioAtivo(false);
            alterar(obj);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Usuário Desativado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Desativar Usuário"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public void ativar(Usuario obj) {

        try {
            obj.setUsuarioAtivo(true);
            alterar(obj);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Usuário Ativado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Ativar Usuário"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public List<Usuario> findAll() {

        return facade.findAll();
    }

    public List<Usuario> pesquisaUsuario(String usuarioCod, String usuarioNome, Boolean usuarioPj, Boolean usuarioAtivo) {

        return facade.pesquisaUsuario(usuarioCod, usuarioNome, usuarioPj, usuarioAtivo);
    }

    public Usuario validaUsuario(String email) {

        return facade.verificaEMail(email);

    }
}
