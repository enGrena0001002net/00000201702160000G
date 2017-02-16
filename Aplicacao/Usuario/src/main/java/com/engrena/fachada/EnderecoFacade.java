/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.fachada;

import com.engrena.entidade.Endereco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi_fpereira
 */
@Stateless
public class EnderecoFacade extends AbstractFacade<Endereco> {
    @PersistenceContext(unitName = "com.engrena_Seguranca")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnderecoFacade() {
        super(Endereco.class);
    }
    
}
