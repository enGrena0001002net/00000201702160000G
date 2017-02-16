/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.bilheteria;

import com.engrena.entidade.Evento;
import com.engrena.entidade.EventoPK;
import com.engrena.negocio.EventoN;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;


/**
 *
 * @author cdi_fpereira
 */
@Named(value = "eventoCadastroV")
@SessionScoped
public class EventoCadastroV implements Serializable {

    @Inject
   EventoN eventoN;

    Evento frmEvento;
    EventoPK eventoPK;

    List<Evento> listEvento;

    public void PesquisaEvento() {

     eventoN.retornaEventoPorUsuario(null);

    }

    public void novo() {

        setEventoPK(new EventoPK());
        setFrmEvento(new Evento());
        getEventoPK().setCodUsu(1);

    }

    public void remover() {
        eventoN.remover(getFrmEvento());
    }

    public void salvar() {
        getFrmEvento().setDtInsEvt(new Date());
        
        eventoN.salvar(getFrmEvento(), getEventoPK());

    }

    public void limpar() {

        setListEvento(null);
        setFrmEvento(null);

    }

    public List<Evento> getListEvento() {
        return listEvento;
    }

    public void setListEvento(List<Evento> listEvento) {
        this.listEvento = listEvento;
    }

    /**
     * Creates a new instance of CadastroEventoV
     */
   
    public EventoPK getEventoPK() {
        return eventoPK;
    }

    public void setEventoPK(EventoPK eventoPK) {
        this.eventoPK = eventoPK;
    }

    public Evento getFrmEvento() {
        if (frmEvento == null) {
            frmEvento = new Evento();
        }
        return frmEvento;
    }

    public void setFrmEvento(Evento frmEvento) {
        this.frmEvento = frmEvento;
    }

}
