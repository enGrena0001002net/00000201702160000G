/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.fachada;

import com.engrena.achatipicas.entidade.Grupo;
import com.engrena.achatipicas.entidade.Grupo;
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
public class GrupoFacade extends AbstractFacade<Grupo> {

    @PersistenceContext(unitName = "com.engrena_achatipicas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoFacade() {
        super(Grupo.class);
    }
    public List<Grupo> pesquisaGrupo(String descricao) {
        List<Grupo> retorno = null;
        try {
            System.out.println("descricao"+descricao);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT g FROM Grupo g ");

            if (descricao != null && !descricao.equals("")) {
                sql.append(" WHERE g.grupoNome like :grupoNome  ");
            }

            Query createQuery = em.createQuery(sql.toString());
            if (descricao != null && !descricao.equals("")) {
                createQuery.setParameter("grupoNome", "%" + descricao + "%");
            }
            retorno = createQuery.getResultList();

        } catch (Exception e) {
            System.out.println("Erro: pesquisaGrupo(" + descricao + "); \n");
            e.printStackTrace();
        }

        return retorno;
    }
}
