package com.javacodegeeks.snippets.enterprise.hibernate.service;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.Dao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Client;

import java.util.LinkedList;
import java.util.List;

public class ClientService {

    private static Dao dao;

    public ClientService() {
        dao = new Dao(Client.class);
    }

    public void persist(Client entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(Client entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public Client findById(Integer id) {
        dao.openCurrentSession();
        Client client = (Client)dao.findById(id);
        dao.closeCurrentSession();
        return client;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Client client = (Client) dao.findById(id);
        dao.delete(client);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<Client> findAll() {
        dao.openCurrentSession();
        List<Object> entities = dao.findAll();
        List<Client> clients = new LinkedList<Client>();
        for (Object entity: entities) {
            clients.add((Client) entity);
        }
        dao.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

}
