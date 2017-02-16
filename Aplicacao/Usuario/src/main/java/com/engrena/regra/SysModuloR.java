/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.regra;

import com.engrena.entidade.SysModulo;
import com.engrena.entidade.SysModuloPK;
import com.engrena.entidade.SysMultePK;
import com.engrena.fachada.SysModuloFacade;
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
public class SysModuloR implements Serializable {

    @EJB
    SysModuloFacade facede;
    FacesMessage.Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    FacesMessage.Severity msgTypInfo = FacesMessage.SEVERITY_INFO;

    public void salvar(SysModulo obj, SysModuloPK pK) {
        try {

            if (obj.getDtInsMod() == null) {
                if (facede.verificaCod(pK)) {

                    obj.setDtInsMod(new Date());
                    obj.setDtAtuMod(new Date());
                    obj.setSysModuloPK(pK);
                    facede.create(obj);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Salvos "));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro Codigo já exite"));
                }
            } else {
                obj.setDtAtuMod(new Date());
                facede.edit(obj);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Alterados"));

            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Persistir Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public void remover(SysModulo obj) {

        try {
            
            facede.remove(obj);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Removidos"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Remover Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public List<SysModulo> findAll(SysMultePK obj) {

        return facede.list(obj);
    }

}
