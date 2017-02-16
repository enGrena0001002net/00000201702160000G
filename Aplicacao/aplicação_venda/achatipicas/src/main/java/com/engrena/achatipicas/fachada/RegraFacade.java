/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.fachada;

import com.engrena.achatipicas.entidade.Regra;
import com.engrena.achatipicas.entidade.Regra;
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
public class RegraFacade extends AbstractFacade<Regra> {

    @PersistenceContext(unitName = "com.engrena_achatipicas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegraFacade() {
        super(Regra.class);
    }

    public List<Regra> pesquisaRegra(String descricao) {
        List<Regra> retorno = null;
        try {
            System.out.println("descricao"+descricao);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT r FROM Regra r ");

            if (descricao != null && !descricao.equals("")) {
                sql.append(" WHERE r.regrasNome like :regrasNome ");
            }

            Query createQuery = em.createQuery(sql.toString());
            if (descricao != null && !descricao.equals("")) {
                createQuery.setParameter("regrasNome", "%" + descricao + "%");
            }
            retorno = createQuery.getResultList();

        } catch (Exception e) {
            System.out.println("Erro: pesquisaRegra(" + descricao + "); \n");
            e.printStackTrace();
        }

        return retorno;
    }

}
