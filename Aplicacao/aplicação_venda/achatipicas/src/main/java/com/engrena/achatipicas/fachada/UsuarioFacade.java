/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engrena.achatipicas.fachada;

import com.engrena.achatipicas.entidade.Usuario;
import com.engrena.achatipicas.entidade.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "com.engrena_achatipicas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public List<Usuario> pesquisaUsuario(String usuarioCod, String usuarioNome, Boolean usuarioPj, Boolean usuarioAtivo) {
        List<Usuario> retorno = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT u FROM Usuario u WHERE 1=1  ");

            if (usuarioCod != null && !usuarioCod.equals("")) {
                sql.append(" and u.usuarioCod = :usuarioCod  ");
            }
            if (usuarioNome != null && !usuarioNome.equals("")) {
                sql.append(" and u.usuarioNome like :usuarioNome  ");
            }
            if (usuarioAtivo != null) {
                sql.append(" and u.usuarioAtivo = :usuarioAtivo  ");
            }
            if (usuarioPj != null) {
                sql.append(" and u.usuarioPj = :usuarioPj  ");
            }

            Query createQuery = em.createQuery(sql.toString());
            if (usuarioCod != null && !usuarioCod.equals("")) {
                createQuery.setParameter("usuarioCod", usuarioCod);
            }
            if (usuarioNome != null && !usuarioNome.equals("")) {
                createQuery.setParameter("usuarioNome", "%" + usuarioNome + "%");
            }
            if (usuarioPj != null) {
                createQuery.setParameter("usuarioPj", usuarioPj);
            }
            if (usuarioAtivo != null) {
                createQuery.setParameter("usuarioAtivo", usuarioAtivo);
            }
            retorno = createQuery.getResultList();

        } catch (Exception e) {
//            System.out.println("Erro: pesquisaUsuario(" + descricao + "); \n");
            e.printStackTrace();
        }

        return retorno;
    }

    public Usuario verificaEMail(String usuarioEmail) {
        Usuario retorno = null;
        try {
            Query createQuery = em.createNamedQuery("Usuario.findByUsuarioEmail");
            createQuery.setParameter("usuarioEmail", usuarioEmail);
            retorno = (Usuario) createQuery.getSingleResult();
        } catch (Exception e) {

            System.out.println("erro:verificaEMail ");
            e.printStackTrace();
            retorno = null;
        }

        return retorno;
    }

    public Usuario verificaCodigo(String usuarioCod) {
        Usuario retorno = null;
        try {
            Query createQuery = em.createNamedQuery("Usuario.findByUsuarioCod");
            createQuery.setParameter("usuarioCod", usuarioCod);
            retorno = (Usuario) createQuery.getSingleResult();
        } catch (Exception e) {

            System.out.println("erro:verificaCodigo ");
            e.printStackTrace();
            retorno = null;
        }

        return retorno;
    }

}
