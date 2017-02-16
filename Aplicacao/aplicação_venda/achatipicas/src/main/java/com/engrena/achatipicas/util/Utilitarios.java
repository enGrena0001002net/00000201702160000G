/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author cdi_fpereira
 */
@Named(value = "utilitarios")
@RequestScoped
public class Utilitarios implements Serializable {

    FacesMessage.Severity msgTypErro = FacesMessage.SEVERITY_WARN;
    FacesMessage.Severity msgTypInfo = FacesMessage.SEVERITY_INFO;

    public String retornaSimNao(Boolean b) {
        return b ? "Sim" : "Não";
    }

    public void retornaMessageErro(String messag) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypErro, "Informa:", messag));
    }

    public void retornaMessage(String messag) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgTypInfo, "Informa:", messag));
    }

}
