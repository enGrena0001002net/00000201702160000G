/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.fachada;

import com.engrena.entidade.Lote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi_fpereira
 */
@Stateless
public class LoteFacade extends AbstractFacade<Lote> {
    @PersistenceContext(unitName = "com.engrena_Bilheteria")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoteFacade() {
        super(Lote.class);
    }
    
}
