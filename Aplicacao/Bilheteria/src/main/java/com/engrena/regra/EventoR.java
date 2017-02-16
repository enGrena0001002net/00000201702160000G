/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.regra;

import com.engrena.entidade.Evento;

import com.engrena.fachada.EventoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;


/**
 *
 * @author cdi_fpereira
 */
@Dependent
public class EventoR implements  Serializable{

    @EJB
    EventoFacade facade;
    
    

    public List<Evento> retornaEventoPorUsuario(Integer usuario) {

        return facade.retornaListaEventosProusuario(usuario);

    }
    
      public  void remover( Evento obj){
    
          if (obj.getLoteList().isEmpty()) {
              facade.remove(obj);
          }else{
              System.out.println("Há Lostes Associados ao Evento");
          }
    
    }

}
