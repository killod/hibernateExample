package com.javacodegeeks.snippets.enterprise.hibernate.service;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.Dao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Card;

import java.util.LinkedList;
import java.util.List;

public class CardService {
    private static Dao dao;

    public CardService() {
        dao = new Dao(Card.class);
    }

    public void persist(Card entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(Card entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public Card findById(Integer id) {
        dao.openCurrentSession();
        Card card = (Card) dao.findById(id);
        dao.closeCurrentSession();
        return card;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Card card = (Card) dao.findById(id);
        dao.delete(card);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<Card> findAll() {
        dao.openCurrentSession();
        List<Object> entities = dao.findAll();
        List<Card> cards = new LinkedList<Card>();
        for (Object entity: entities) {
            cards.add((Card) entity);
        }
        dao.closeCurrentSession();
        return cards;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }
}
