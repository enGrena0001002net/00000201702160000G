/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.fachada;

import com.engrena.entidade.Systema;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi_fpereira
 */
@Stateless
public class SystemaFacade extends AbstractFacade<Systema> {

    @PersistenceContext(unitName = "com.engrena_Seguranca")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SystemaFacade() {
        super(Systema.class);
    }

    public Boolean verificaCod(Systema obj) {
        Boolean retorno = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT s FROM Systema s WHERE s.codSys = :codSys");

            System.out.println("sql \n" + sql.toString());
            Query createQuery = em.createQuery(sql.toString());

            createQuery.setParameter("codSys", obj.getCodSys());
            int a=createQuery.getFirstResult();
            System.out.println("##### "+a);
            retorno = a > 0 ?false:true;
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
