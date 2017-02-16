/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.regra;

import com.engrena.entidade.Endereco;
import com.engrena.fachada.EnderecoFacade;
import java.io.Serializable;
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
public class EnderecoR implements Serializable {

    @EJB
    EnderecoFacade enderecoFacade;
    Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    Severity msgTypInfo = FacesMessage.SEVERITY_INFO;
    

    public void salvar(Endereco obj) {
        try {

            if (obj.getCodEnd() == null) {
                enderecoFacade.create(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Salvos "));
            } else {

                enderecoFacade.edit(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Alterados"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Persistir Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public void remover(Endereco obj) {

        try {
            enderecoFacade.remove(obj);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Removidos"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Remover Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

}
