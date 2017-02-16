/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.regras;

import com.engrena.achatipicas.entidade.Acao;
import com.engrena.achatipicas.fachada.AcaoFacade;
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
public class AcaoR implements Serializable {

    @EJB
    AcaoFacade facade;
    Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    Severity msgTypInfo = FacesMessage.SEVERITY_INFO;

    public void salvar(Acao obj) {
        try {

            if (obj.getAcaoCod() == null) {
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

    public void remover(Acao obj) {

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

    public List<Acao> findAll() {

        return facade.findAll();
    }

    public List<Acao> pesquisaAcao(String acao) {

        return facade.pesquisaAcao(acao);
    }
}
