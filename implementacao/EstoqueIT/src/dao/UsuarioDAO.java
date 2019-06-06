/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author Roberto Oliveira
 */
public class UsuarioDAO {

    public void persist(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            usuario = em.find(Usuario.class, usuario.getId());
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Usuario findById(final long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }

    public Usuario findByNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        String jpql = "select u from Usuario u where u.nome = :nome";
        Query query = em.createQuery(jpql, Usuario.class);
        query.setParameter("nome", nome);
        Usuario usuario = new Usuario();

        try {
            usuario = (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

        return usuario;
    }

    public List<Usuario> getList() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Usuario> lista = null;

        try {
            Query query = em.createQuery("from Usuario");
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        } finally {
            em.close();
        }

        return lista;
    }
}
