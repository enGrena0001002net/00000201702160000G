/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.regra;

import com.engrena.entidade.Empresa;
import com.engrena.fachada.EmpresaFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class EmpresaR implements Serializable {

    @EJB
    EmpresaFacade facede;
    FacesMessage.Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    FacesMessage.Severity msgTypInfo = FacesMessage.SEVERITY_INFO;

    public void salvar(Empresa obj) {
        try {

            if (obj.getCodEnd() == null) {
                obj.setDtInsUsu(new Date());
                obj.setDtAtuUsu(new Date());
                facede.create(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Salvos "));
            } else {
                obj.setDtAtuUsu(new Date());
                facede.edit(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Alterados"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Persistir Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public void remover(Empresa obj) {

        try {
            facede.remove(obj);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Removidos"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Remover Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public List<Empresa> findAll() {

        return facede.findAll();
    }

    public Empresa find(Empresa obj) {

        return facede.find(obj.getCodEmp());
    }

}
