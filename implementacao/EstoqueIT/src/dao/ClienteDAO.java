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
import model.Cliente;

/**
 *
 * @author Roberto Oliveira
 */
public class ClienteDAO {

    public void persist(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void update(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            cliente = em.find(Cliente.class, cliente.getId());
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Cliente findById(final long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }

    public Cliente findByNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        String jpql = "select c from Cliente c where c.nome = :nome";
        Query query = em.createQuery(jpql, Cliente.class);
        query.setParameter("nome", nome);
        Cliente cliente = new Cliente();

        try {
            cliente = (Cliente) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

        return cliente;
    }

    public List<Cliente> getList() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Cliente> lista = null;

        try {
            Query query = em.createQuery("from Cliente");
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        } finally {
            em.close();
        }

        return lista;
    }
}
