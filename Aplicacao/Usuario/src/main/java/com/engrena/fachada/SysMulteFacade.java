/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.fachada;

import com.engrena.entidade.Processo;
import com.engrena.entidade.SysMulte;
import com.engrena.entidade.SysMultePK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi_fpereira
 */
@Stateless
public class SysMulteFacade extends AbstractFacade<SysMulte> {

    @PersistenceContext(unitName = "com.engrena_Seguranca")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SysMulteFacade() {
        super(SysMulte.class);
    }

    public Boolean verificaCod(SysMultePK obj) {
        Boolean retorno = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT s FROM SysMulte s WHERE s.sysMultePK.codMut = :codMut");

            System.out.println("sql \n" + sql.toString());
            Query createQuery = em.createQuery(sql.toString());

            createQuery.setParameter("codMut", obj.getCodMut());
            int a = createQuery.getFirstResult();
            System.out.println("##### " + a);
            retorno = a > 0 ? false : true;

        } catch (Exception e) {
            System.out.println("Erro: verificaCod(); \n");
            e.printStackTrace();
        }

        return retorno;
    }

    public SysMulte findCod(String obj) {
        SysMulte retorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT s FROM SysMulte s WHERE s.sysMultePK.codMut = :codMut");

            System.out.println("sql \n" + sql.toString());
            Query createQuery = em.createQuery(sql.toString());

            createQuery.setParameter("codMut", obj);
            retorno = (SysMulte) createQuery.getSingleResult();

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
