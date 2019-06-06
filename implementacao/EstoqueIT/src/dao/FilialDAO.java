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
import model.Filial;

/**
 *
 * @author 068943091112
 */
public class FilialDAO {

    public void persist(Filial filial) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(filial);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(Filial filial) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.merge(filial);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(Filial filial) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            filial = em.find(Filial.class, filial.getId());
            em.remove(filial);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Filial findById(final long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Filial filial = em.find(Filial.class, id);
        em.close();
        return filial;
    }

    public Filial findByNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        String jpql = "select f from Filial f where f.nome = :nome";
        Query query = em.createQuery(jpql, Filial.class);
        query.setParameter("nome", nome);
        Filial filial = new Filial();

        try {
            filial = (Filial) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

        return filial;
    }

    public List<Filial> getList() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Filial> lista = null;

        try {
            Query query = em.createQuery("from Filial");
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        } finally {
            em.close();
        }

        return lista;
    }
}
