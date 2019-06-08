/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.connection.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import br.com.model.Produto;

/**
 *
 * @author 068943091112
 */
public class ProdutoDAO {

    public void persist(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            produto = em.find(Produto.class, produto.getId());
            em.remove(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Produto findById(final long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        return produto;
    }

    public Produto findByDescricao(String descricao) {
        EntityManager em = JPAUtil.getEntityManager();
        String jpql = "select p from Produto p where p.descricao = :descricao";
        Query query = em.createQuery(jpql, Produto.class);
        query.setParameter("descricao", descricao);
        Produto produto = new Produto();

        try {
            produto = (Produto) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

        return produto;
    }

    public Produto findByCodBarras(String codBarras) {
        EntityManager em = JPAUtil.getEntityManager();
        String jpql = "select p from Produto p where p.codBarras = :codBarras";
        Query query = em.createQuery(jpql, Produto.class);
        query.setParameter("codBarras", codBarras);
        Produto produto = new Produto();

        try {
            produto = (Produto) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

        return produto;
    }

    public List<Produto> getList() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Produto> lista = null;

        try {
            Query query = em.createQuery("from Produto");
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        } finally {
            em.close();
        }

        return lista;
    }
}
