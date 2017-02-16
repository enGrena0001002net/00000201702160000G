/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.fachada;

import com.engrena.entidade.SysModulo;
import com.engrena.entidade.SysModuloPK;
import com.engrena.entidade.SysMulte;
import com.engrena.entidade.SysMultePK;
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
public class SysModuloFacade extends AbstractFacade<SysModulo> {

    @PersistenceContext(unitName = "com.engrena_Seguranca")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SysModuloFacade() {
        super(SysModulo.class);
    }

    public Boolean verificaCod(SysModuloPK obj) {
        Boolean retorno = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT s FROM SysModulo s WHERE s.sysModuloPK.codMod = :codMod");

            System.out.println("sql \n" + sql.toString());
            Query createQuery = em.createQuery(sql.toString());

            createQuery.setParameter("codMod", obj.getCodMod());
            int a = createQuery.getFirstResult();
            System.out.println("##### " + a);
            retorno = a > 0 ? false : true;

        } catch (Exception e) {
            System.out.println("Erro: verificaCod(); \n");
            e.printStackTrace();
        }

        return retorno;
    }

    public List<SysModulo> list(SysMultePK obj) {
        List<SysModulo> retorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT s FROM SysModulo s WHERE s.sysModuloPK.codSys = :codSys and s.sysModuloPK.codMut = :codMut");

            System.out.println("sql \n" + sql.toString());
            Query createQuery = em.createQuery(sql.toString());

            createQuery.setParameter("codSys", obj.getCodSys());
            createQuery.setParameter("codMut", obj.getCodMut());
            retorno = createQuery.getResultList();

        } catch (Exception e) {
            System.out.println("Erro: list(); \n");
            e.printStackTrace();
        }

        return retorno;
    }
     public SysModulo findCod(String obj) {
        SysModulo retorno = null;
        try {
//            StringBuilder sql = new StringBuilder();
//            sql.append("SELECT s FROM SysMulte s WHERE s.sysMultePK.codMut = :codMut");
//
//            System.out.println("sql \n" + sql.toString());
            
            Query createQuery = em.createNamedQuery("SysModulo.findByCodMod");

            createQuery.setParameter("codMod", obj);
            retorno = (SysModulo) createQuery.getSingleResult();

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
