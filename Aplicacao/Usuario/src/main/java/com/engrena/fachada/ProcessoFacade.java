/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.fachada;

import com.engrena.entidade.Processo;
import com.engrena.entidade.SysModuloPK;
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
public class ProcessoFacade extends AbstractFacade<Processo> {

    @PersistenceContext(unitName = "com.engrena_Seguranca")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcessoFacade() {
        super(Processo.class);
    }

    public Processo findCod(String obj) {
        Processo retorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p FROM Processo p WHERE p.codPco = :codPco");

            System.out.println("sql \n" + sql.toString());
            Query createQuery = em.createQuery(sql.toString());

            createQuery.setParameter("codPco", obj);
           retorno = (Processo) createQuery.getSingleResult();
         
//            if (cod != null && cod != 0) {
//                createQuery.setParameter("idOcorrencia", cod);
//            }

        } catch (Exception e) {
            System.out.println("Erro: verificaCod(); \n");
            e.printStackTrace();
        }

        return retorno;
    }
       public Boolean verificaCod(Processo obj) {
        Boolean retorno = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p FROM Processo p WHERE p.codPco = :codPco");

            System.out.println("sql \n" + sql.toString());
            Query createQuery = em.createQuery(sql.toString());

            createQuery.setParameter("codPco", obj.getCodPco());
            int a = createQuery.getFirstResult();
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

    public List<Processo> list(SysModuloPK obj) {
        List<Processo> retorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p FROM Processo p WHERE p.sysModulo.sysModuloPK = :sysModuloPK");

            System.out.println("sql \n" + sql.toString());
            Query createQuery = em.createQuery(sql.toString());

            createQuery.setParameter("sysModuloPK", obj);

            retorno = createQuery.getResultList();

        } catch (Exception e) {
            System.out.println("Erro: list(); \n");
            e.printStackTrace();
        }

        return retorno;
    }

}
