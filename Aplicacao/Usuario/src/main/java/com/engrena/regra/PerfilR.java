/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.regra;

import com.engrena.entidade.Perfil;
import com.engrena.fachada.PerfilFacade;
import java.io.Serializable;
import java.util.Date;
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
public class PerfilR implements Serializable {

    @EJB
    PerfilFacade facade;
    Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    Severity msgTypInfo = FacesMessage.SEVERITY_INFO;

    public void salvar(Perfil obj) {
        try {
            if (obj.getDtInsPfl() == null) {

                if (facade.verificaCod(obj)) {
                    facade.create(obj);
                    obj.setDtInsPfl(new Date());
                    obj.setDtAtuPfl(new Date());

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Salvos "));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Codigo já exite"));
                }
            } else {
                obj.setDtAtuPfl(new Date());
                facade.edit(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Alterados"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Persistir Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public void remover(Perfil obj) {

        try {
            if (obj.getPerfilProcessoList().isEmpty()) {
                facade.remove(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Removidos"));
            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao remover dados existe objetos associados"));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Remover Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public List<Perfil> findAll() {

        return facade.findAll();
    }

}
