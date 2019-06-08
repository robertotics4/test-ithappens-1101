/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.connection.JPAUtil;
import br.com.model.ItensPedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Roberto Oliveira
 */
public class ItensPedidoDAO {

    public void persist(ItensPedido itensPedido) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(itensPedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(ItensPedido itensPedido) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            itensPedido = em.find(ItensPedido.class, itensPedido.getId());
            em.remove(itensPedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public ItensPedido findById(final long id) {
        EntityManager em = JPAUtil.getEntityManager();
        ItensPedido itensPedido = em.find(ItensPedido.class, id);
        em.close();
        return itensPedido;
    }

    public List<ItensPedido> getList() {
        EntityManager em = JPAUtil.getEntityManager();
        List<ItensPedido> lista = null;

        try {
            Query query = em.createQuery("from ItensPedido");
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        } finally {
            em.close();
        }

        return lista;
    }
}
