/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.JPAUtil;
import javax.persistence.EntityManager;
import model.Estoque;

/**
 *
 * @author Roberto Oliveira
 */
public class EstoqueDAO {

    public void persist(Estoque estoque) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(estoque);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(Estoque estoque) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            estoque = em.find(Estoque.class, estoque.getId());
            em.remove(estoque);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Estoque findById(final long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Estoque estoque = em.find(Estoque.class, id);
        em.close();
        return estoque;
    }
}
