/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.fachada;

import com.engrena.entidade.Evento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi_fpereira
 */
@Stateless
public class EventoFacade extends AbstractFacade<Evento> {

    @PersistenceContext(unitName = "com.engrena_Bilheteria")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventoFacade() {
        super(Evento.class);
    }

    public Integer retornaCodigoMax() {
        Integer retono = null;
        try {

            String sql = "SELECT MAX(e.eventoPK.codEvt) FROM Evento e";

            Query query = getEntityManager().createQuery(sql);

            retono = (Integer) query.getSingleResult();

        } catch (Exception e) {

            System.out.println("erro " + getClass().getName());
            retono = null;
            e.printStackTrace();
        }

        return retono != null ? retono + 1 : null;
    }

    public List<Evento> retornaListaEventosProusuario(Integer codUsuario) {
        List<Evento> retono = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT e FROM Evento e WHERE 1=1 ");

            if (codUsuario != null && codUsuario != 0) {
                sql.append("e.eventoPK.codUsu = :codUsu ");
            }

            Query query = getEntityManager().createQuery(sql.toString());

            if (codUsuario != null && codUsuario != 0) {
                query.setParameter("codUsu", codUsuario);
            }

            retono = query.getResultList();

        } catch (Exception e) {

            System.out.println("erro " + getClass().getName());
            retono = null;
            e.printStackTrace();
        }

        return retono;
    }

}
