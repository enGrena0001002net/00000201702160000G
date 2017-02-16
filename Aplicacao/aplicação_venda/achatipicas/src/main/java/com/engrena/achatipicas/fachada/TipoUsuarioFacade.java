/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.fachada;

import com.engrena.achatipicas.entidade.TipoUsuario;
import com.engrena.achatipicas.entidade.TipoUsuario;
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
public class TipoUsuarioFacade extends AbstractFacade<TipoUsuario> {

    @PersistenceContext(unitName = "com.engrena_achatipicas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoUsuarioFacade() {
        super(TipoUsuario.class);
    }
    public List<TipoUsuario> pesquisaTipoUsuario(String descricao) {
        List<TipoUsuario> retorno = null;
        try {
            System.out.println("descricao"+descricao);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT t FROM TipoUsuario t  ");

            if (descricao != null && !descricao.equals("")) {
                sql.append(" WHERE t.tpNome like :tpNome  ");
            }

            Query createQuery = em.createQuery(sql.toString());
            if (descricao != null && !descricao.equals("")) {
                createQuery.setParameter("tpNome", "%" + descricao + "%");
            }
            retorno = createQuery.getResultList();

        } catch (Exception e) {
            System.out.println("Erro: pesquisaTipoUsuario(" + descricao + "); \n");
            e.printStackTrace();
        }

        return retorno;
    }
}
