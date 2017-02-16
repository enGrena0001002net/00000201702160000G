/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.fachada;

import com.engrena.entidade.Acao;
import com.engrena.entidade.Processo;
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
    @PersistenceContext(unitName = "com.engrena_Seguranca")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcaoFacade() {
        super(Acao.class);
    }
    public Boolean verificaCod(Acao obj) {
        Boolean retorno = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT a FROM Acao a WHERE a.codAco = :codAco");

            System.out.println("sql \n" + sql.toString());
            Query createQuery = em.createQuery(sql.toString());

            createQuery.setParameter("codAco", obj.getCodAco());
            int a = createQuery.getResultList().size();
            System.out.println("##### " + a);
            retorno = a > 0 ? false : true;
//            if (cod != null && cod != 0) {
//                createQuery.setParameter("idOcorrencia", cod);
//            }

        } catch (Exception e) {
            System.out.println("Erro: verificaCod(); \n");
            e.printStackTrace();
        }

        return retorno;
    }
}
