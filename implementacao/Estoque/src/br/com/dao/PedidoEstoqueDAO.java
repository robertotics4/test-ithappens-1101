/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.connection.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.model.PedidoEstoque;

/**
 *
 * @author 068943091112
 */
public class PedidoEstoqueDAO {

    public void persist(PedidoEstoque pedidoEstoque) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(pedidoEstoque);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(PedidoEstoque pedidoEstoque) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.merge(pedidoEstoque);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(PedidoEstoque pedidoEstoque) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            pedidoEstoque = em.find(PedidoEstoque.class, pedidoEstoque.getId());
            em.remove(pedidoEstoque);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public PedidoEstoque findById(final long id) {
        EntityManager em = JPAUtil.getEntityManager();
        PedidoEstoque pedidoEstoque = em.find(PedidoEstoque.class, id);
        em.close();
        return pedidoEstoque;
    }

    public List<PedidoEstoque> getList() {
        EntityManager em = JPAUtil.getEntityManager();
        List<PedidoEstoque> lista = null;

        try {
            Query query = em.createQuery("from PedidoEstoque");
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        } finally {
            em.close();
        }

        return lista;
    }
}
