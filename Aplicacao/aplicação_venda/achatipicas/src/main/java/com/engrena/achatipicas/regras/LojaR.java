/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.regras;

import com.engrena.achatipicas.entidade.Loja;
import com.engrena.achatipicas.entidade.Usuario;
import com.engrena.achatipicas.fachada.LojaFacade;
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
public class LojaR implements Serializable {

    @EJB
    LojaFacade facade;
    Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    Severity msgTypInfo = FacesMessage.SEVERITY_INFO;

    public void salvar(Loja obj) {
        try {

            if (obj.getLojaCod() == null) {
                facade.create(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Salvos "));
            } else {

                facade.edit(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Alterados"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Persistir Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public void remover(Loja obj) {

        try {

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Remover Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public List<Loja> findAll() {

        return facade.findAll();
    }

    public List<Loja> pesquisaLoja(String lojaNome, Boolean lojaDeliv, Boolean lojaAtiva, String lojaEndCep) {

        return facade.pesquisaLoja(lojaNome, lojaDeliv, lojaAtiva, lojaEndCep);
    }
    public void desativar(Loja obj) {

        try {
            obj.setLojaAtiva(false);
            salvar(obj);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Usuário Desativado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Desativar Usuário"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public void ativar(Loja obj) {

        try {
            obj.setLojaAtiva(true);
            salvar(obj);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Usuário Ativado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Ativar Usuário"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }
}
