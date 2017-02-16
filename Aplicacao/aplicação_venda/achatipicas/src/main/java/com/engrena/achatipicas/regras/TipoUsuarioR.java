/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.regras;

import com.engrena.achatipicas.entidade.TipoUsuario;
import com.engrena.achatipicas.fachada.TipoUsuarioFacade;
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
public class TipoUsuarioR implements Serializable {

    @EJB
   TipoUsuarioFacade facade;
    Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    Severity msgTypInfo = FacesMessage.SEVERITY_INFO;

    public void salvar(TipoUsuario obj) {
        try {

            if (obj.getTpCodigo()== null) {
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

    public void remover(TipoUsuario obj) {

        try {

//                facade.remove(obj);
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", " Dados Removidos"));
//            }else{
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", " Não é possível remover Pois existe Perfil associado"));
//            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", "Erro ao Remover Dados"));
            System.out.println("erro:" + getClass().getName());
            e.printStackTrace();
        }

    }

    public List<TipoUsuario> findAll() {

        return facade.findAll();
    }

    public List<TipoUsuario> pesquisaTipoUsuario(String acao) {

        return facade.pesquisaTipoUsuario(acao);
    }
}
