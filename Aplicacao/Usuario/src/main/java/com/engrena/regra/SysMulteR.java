/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.regra;

import com.engrena.entidade.SysMulte;
import com.engrena.entidade.SysMultePK;
import com.engrena.fachada.SysMulteFacade;
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
public class SysMulteR implements Serializable {

    @EJB
    SysMulteFacade facede;
    FacesMessage.Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    FacesMessage.Severity msgTypInfo = FacesMessage.SEVERITY_INFO;

    public void salvar(SysMulte obj, SysMultePK pK) {
        try {

            if (obj.getDtInsMut() == null) {
                if (facede.verificaCod(pK)) {
                    obj.setDtInsMut(new Date());
                    obj.setDtAtuMut(new Date());
                    obj.setSysMultePK(pK);
                    facede.create(obj);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Salvos "));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro Codigo já exite"));
                }

            } else {
                obj.setDtAtuMut(new Date());
                facede.edit(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Alterados"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Persistir Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public void remover(SysMulte obj) {

        try {
            if (obj.getSysModuloList().isEmpty() && obj.getSystema() == null) {

                facede.remove(obj);

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

    public List<SysMulte> findAll() {

        return facede.findAll();
    }

}
