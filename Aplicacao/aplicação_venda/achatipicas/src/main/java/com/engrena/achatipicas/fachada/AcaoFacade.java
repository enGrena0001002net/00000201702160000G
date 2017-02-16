/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.fachada;

import com.engrena.achatipicas.entidade.Acao;
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
public class AcaoFacade extends AbstractFacade<Acao> {

    @PersistenceContext(unitName = "com.engrena_achatipicas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcaoFacade() {
        super(Acao.class);
    }

    public List<Acao> pesquisaAcao(String acao) {
        List<Acao> retorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT a FROM Acao a ");

            if (acao != null && !acao.equals("")) {
                sql.append("WHERE a.acaoNome  like :acaoNome");
            }

            Query createQuery = em.createQuery(sql.toString());
            if (acao != null && !acao.equals("")) {
                createQuery.setParameter("acaoNome", "%" + acao + "%");
            }
            retorno = createQuery.getResultList();

        } catch (Exception e) {
            System.out.println("Erro: pesquisaAcao(" + acao + "); \n");
            e.printStackTrace();
        }

        return retorno;
    }
}
