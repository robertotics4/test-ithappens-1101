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
import model.FormaPagamento;

/**
 *
 * @author Roberto Oliveira
 */
public class FormaPagamentoDAO {

    public void persist(FormaPagamento formaPagamento) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(formaPagamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(FormaPagamento formaPagamento) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        try {
            em.merge(formaPagamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(FormaPagamento formaPagamento) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            formaPagamento = em.find(FormaPagamento.class, formaPagamento.getId());
            em.remove(formaPagamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public FormaPagamento findById(final long id) {
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamento formaPagamento = em.find(FormaPagamento.class, id);
        em.close();
        return formaPagamento;
    }

    public FormaPagamento findByDescricao(String descricao) {
        EntityManager em = JPAUtil.getEntityManager();
        String jpql = "select f from FormaPagamento f where f.descricao = :descricao";
        Query query = em.createQuery(jpql, FormaPagamento.class);
        query.setParameter("descricao", descricao);
        FormaPagamento formaPagamento = new FormaPagamento();

        try {
            formaPagamento = (FormaPagamento) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

        return formaPagamento;
    }

    public List<FormaPagamento> getList() {
        EntityManager em = JPAUtil.getEntityManager();
        List<FormaPagamento> lista = null;

        try {
            Query query = em.createQuery("from FormaPagamento");
            lista = query.getResultList();
        } catch (Exception e) {
            lista = null;
        } finally {
            em.close();
        }

        return lista;
    }
}
