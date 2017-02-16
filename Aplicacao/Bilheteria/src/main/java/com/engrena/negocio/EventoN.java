/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.negocio;

import com.engrena.entidade.Evento;
import com.engrena.entidade.EventoPK;

import com.engrena.regra.EventoR;
import com.engrena.fachada.EventoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class EventoN implements Serializable {

    @EJB
    EventoFacade facade;
    @Inject
    EventoR eventoR;

    public List<Evento> retornaEventoPorUsuario(Integer usuario) {

        return eventoR.retornaEventoPorUsuario(usuario);

    }

    public void salvar(Evento obj, EventoPK pK) {
        try {

            if (obj.getEventoPK() == null) {
                pK.setCodEvt(facade.retornaCodigoMax());
                obj.setEventoPK(pK);
                facade.create(obj);

            } else {

                facade.edit(obj);

            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar " + getClass().getSimpleName());
            e.printStackTrace();
        }

    }

    public void remover(Evento obj) {

    }

}
