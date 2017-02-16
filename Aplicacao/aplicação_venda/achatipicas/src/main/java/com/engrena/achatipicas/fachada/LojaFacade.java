/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.fachada;

import com.engrena.achatipicas.entidade.Loja;
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
public class LojaFacade extends AbstractFacade<Loja> {

    @PersistenceContext(unitName = "com.engrena_achatipicas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LojaFacade() {
        super(Loja.class);
    }

    public List< Loja> pesquisaLoja(String lojaNome, Boolean lojaDeliv, Boolean lojaAtiva, String lojaEndCep) {
        List< Loja> retorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT l FROM Loja l WHERE 1=1 ");

            if (lojaNome != null && !lojaNome.equals("")) {
                sql.append(" and l.lojaNome like :lojaNome ");
            }
            if (lojaDeliv != null) {
                sql.append(" and l.lojaDeliv = :lojaDeliv");
            }
            if (lojaAtiva != null) {
                sql.append(" and   l.lojaAtiva = :lojaAtiva");
            }
            if (lojaEndCep != null && !lojaEndCep.equals("")) {
                sql.append(" and   l.lojaEndCep = :lojaEndCep ");
            }

            Query createQuery = em.createQuery(sql.toString());
            if (lojaNome != null && !lojaNome.equals("")) {
                createQuery.setParameter("lojaNome", "%" + lojaNome + "%");
            }
            if (lojaDeliv != null) {
                createQuery.setParameter("lojaDeliv", lojaDeliv);
            }
            if (lojaAtiva != null) {
                createQuery.setParameter("lojaAtiva", lojaAtiva);
            }
            if (lojaEndCep != null && !lojaEndCep.equals("")) {
                createQuery.setParameter("lojaEndCep", lojaEndCep);
            }

            retorno = createQuery.getResultList();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return retorno;
    }
}
