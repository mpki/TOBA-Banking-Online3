/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Beans.Account;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Matt
 */
public class AccountDB {
     public static void insert(Account account) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("tobapu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(account);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Account account) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("tobapu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(account);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }   
}
