package com.javacodegeeks.snippets.enterprise.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Dao {
    private Session currentSession;
    private Transaction currentTransaction;

    private Class clas;

    public Class getClas() {
        return clas;
    }

    public Dao(Class clas){
        this.clas=clas;
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Object entity) {
        getCurrentSession().save(entity);
    }

    public void update(Object entity) {
        getCurrentSession().update(entity);
    }

    public Object findById(Integer id) {
        Object entity = getCurrentSession().get(getClas(), id);
        return entity;
    }

    public void delete(Object entity) {
        getCurrentSession().delete(entity);
    }

    public List<Object> findAll() {
        List<Object> entities = getCurrentSession().createQuery("from " + clas.getName()).list();
        return entities;
    }

    public void deleteAll() {
        List<Object> entityList = findAll();
        for (Object entity : entityList) {
            delete(entity);
        }
    }
}
