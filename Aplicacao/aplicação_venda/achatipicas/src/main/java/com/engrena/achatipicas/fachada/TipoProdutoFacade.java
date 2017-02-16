/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.fachada;

import com.engrena.achatipicas.entidade.TipoProduto;
import com.engrena.achatipicas.entidade.TipoProduto;
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
public class TipoProdutoFacade extends AbstractFacade<TipoProduto> {

    @PersistenceContext(unitName = "com.engrena_achatipicas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProdutoFacade() {
        super(TipoProduto.class);
    }

    public List<TipoProduto> pesquisaTipoProduto(String produtoTpNome, String produtoTpUf) {
        List<TipoProduto> retorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT t FROM TipoProduto t WHERE 1=1 ");

            if (produtoTpNome != null && !produtoTpNome.equals("")) {
                sql.append(" and t.produtoTpNome like :produtoTpNome ");
            }
            if (produtoTpUf != null && !produtoTpUf.equals("")) {
                sql.append(" and t.produtoTpUf =:produtoTpUf ");
            }

            Query createQuery = em.createQuery(sql.toString());
            if (produtoTpNome != null && !produtoTpNome.equals("")) {
                createQuery.setParameter("produtoTpNome", "%" + produtoTpNome + "%");
            }
            if (produtoTpUf != null && !produtoTpUf.equals("")) {
                createQuery.setParameter("produtoTpUf", produtoTpUf);
            }
            retorno = createQuery.getResultList();

        } catch (Exception e) {
           
            e.printStackTrace();
        }

        return retorno;
    }
}
