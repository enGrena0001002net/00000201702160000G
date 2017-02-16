/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.fachada;

import com.engrena.entidade.QrIngresso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi_fpereira
 */
@Stateless
public class QrIngressoFacade extends AbstractFacade<QrIngresso> {
    @PersistenceContext(unitName = "com.engrena_Bilheteria")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QrIngressoFacade() {
        super(QrIngresso.class);
    }
    
}
