/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ProdutoEstoque;

/**
 *
 * @author Roberto Oliveira
 */
public class ProdutoEstoqueDAO {

    public void persist(ProdutoEstoque produtoEstoque) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(produtoEstoque);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(ProdutoEstoque produtoEstoque) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            produtoEstoque = em.find(ProdutoEstoque.class, produtoEstoque.getId());
            em.remove(produtoEstoque);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public ProdutoEstoque findById(final long id) {
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoEstoque produtoEstoque = em.find(ProdutoEstoque.class, id);
        em.close();
        return produtoEstoque;
    }

    public List<ProdutoEstoque> getList() {
        EntityManager em = JPAUtil.getEntityManager();
        List<ProdutoEstoque> lista = null;

        try {
            Query query = em.createQuery("from ProdutoEstoque");
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        } finally {
            em.close();
        }

        return lista;
    }
}
