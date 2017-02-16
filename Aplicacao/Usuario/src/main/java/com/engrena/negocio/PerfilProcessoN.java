/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.negocio;

import com.engrena.entidade.PerfilProcesso;
import com.engrena.entidade.PerfilProcessoPK;
import com.engrena.fachada.PerfilProcessoFacade;
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
public class PerfilProcessoN implements Serializable {

    @EJB
    PerfilProcessoFacade facade;
    Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    Severity msgTypInfo = FacesMessage.SEVERITY_INFO;

    public void salvar(PerfilProcesso obj, PerfilProcessoPK pK) {
        try {

            if (obj.getPerfilProcessoPK() == null) {
                pK.setCodPco(obj.getProcesso().getCodPco());

                if (facade.verificaCod(pK)) {
                    obj.setPerfilProcessoPK(pK);
                    facade.create(obj);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Salvos "));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro Codigo já exite"));

                }
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

    public void remover(PerfilProcesso obj) {

        try {
            if (obj.getAcaoList().isEmpty()) {
                facade.remove(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Removidos"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Remover Dados exite Ações associadas"));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Remover Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public List<PerfilProcesso> findAll() {

        return facade.findAll();
    }

}
