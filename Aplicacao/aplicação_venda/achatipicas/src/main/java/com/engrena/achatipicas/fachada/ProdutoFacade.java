/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.fachada;

import com.engrena.achatipicas.entidade.Loja;
import com.engrena.achatipicas.entidade.Produto;
import com.engrena.achatipicas.entidade.Produto;
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
public class ProdutoFacade extends AbstractFacade<Produto> {

    @PersistenceContext(unitName = "com.engrena_achatipicas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoFacade() {
        super(Produto.class);
    }

    public List< Produto> pesquisaProduto(String produtoNome, Boolean produtoAtivo, Loja lojaCod, TipoProduto produtoTpCod) {
        List< Produto> retorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT t FROM  Produto t WHERE 1=1 ");

            if (produtoNome != null && !produtoNome.equals("")) {
                sql.append(" and t.produtoNome like :produtoNome ");
            }
            if (produtoAtivo != null) {
                sql.append(" and t.produtoAtivo =:produtoAtivo ");
            }
            if (lojaCod != null) {
                sql.append(" and   t.produtoPK.lojaCod = :lojaCod ");
            }
            if (produtoTpCod != null) {
                sql.append(" and  t.produtoTpCod.produtoTpCod = :produtoTpCod ");
            }

            Query createQuery = em.createQuery(sql.toString());
            if (produtoNome != null && !produtoNome.equals("")) {
                createQuery.setParameter("produtoNome", "%" + produtoNome + "%");
            }
            if (produtoAtivo != null && !produtoAtivo.equals("")) {
                createQuery.setParameter("produtoAtivo", produtoAtivo);
            }
            if (lojaCod != null) {
                createQuery.setParameter("lojaCod", lojaCod.getLojaCod());
            }
            if (produtoTpCod != null) {
                createQuery.setParameter("produtoTpCod", produtoTpCod.getProdutoTpCod());
            }

            retorno = createQuery.getResultList();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return retorno;
    }

    public Integer retornaCodProd(Integer lojaCod) {
        Integer retorno = null;
        try {
            Integer cod = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT max(p.produtoPK.produtoCod) FROM  Produto p WHERE 1=1 ");

            if (lojaCod != null) {
                sql.append(" and   p.produtoPK.lojaCod = :lojaCod ");
            }

            Query createQuery = em.createQuery(sql.toString());

            if (lojaCod != null && lojaCod!=0) {
                createQuery.setParameter("lojaCod", lojaCod);
            }

            cod = (Integer) createQuery.getSingleResult();
            retorno = cod == null ? 1 : cod + 1;

        } catch (Exception e) {
            retorno = 1;
            e.printStackTrace();
        }

        return retorno;
    }

}
