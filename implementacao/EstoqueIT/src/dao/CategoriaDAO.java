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
import model.Categoria;

/**
 *
 * @author 068943091112
 */
public class CategoriaDAO {

    public void persist(Categoria categoria) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(categoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(Categoria categoria) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            categoria = em.find(Categoria.class, categoria.getId());
            em.remove(categoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Categoria findById(final long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Categoria categoria = em.find(Categoria.class, id);
        em.close();
        return categoria;
    }

    public Categoria findByDescricao(String descricao) {
        EntityManager em = JPAUtil.getEntityManager();
        String jpql = "select c from Categoria c where u.descricao = :descricao";
        Query query = em.createQuery(jpql, Categoria.class);
        query.setParameter("descricao", descricao);
        Categoria categoria = new Categoria();

        try {
            categoria = (Categoria) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

        return categoria;
    }

    public List<Categoria> getList() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Categoria> lista = null;

        try {
            Query query = em.createQuery("from Categoria");
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        } finally {
            em.close();
        }

        return lista;
    }
}
