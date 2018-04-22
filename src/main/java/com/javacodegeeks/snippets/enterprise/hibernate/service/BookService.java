package com.javacodegeeks.snippets.enterprise.hibernate.service;

import java.util.LinkedList;
import java.util.List;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.Dao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Book;

public class BookService {

	private static Dao dao;

	public BookService() {
		dao = new Dao(Book.class);
	}

	public void persist(Book entity) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public void update(Book entity) {
		dao.openCurrentSessionwithTransaction();
		dao.update(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public Book findById(Integer id) {
		dao.openCurrentSession();
		Book book = (Book)dao.findById(id);
		dao.closeCurrentSession();
		return book;
	}

	public void delete(Integer id) {
		dao.openCurrentSessionwithTransaction();
		Book book = (Book)dao.findById(id);
		dao.delete(book);
		dao.closeCurrentSessionwithTransaction();
	}

	public List<Book> findAll() {
		dao.openCurrentSession();
		List<Object> entities = dao.findAll();
		List<Book> books = new LinkedList<Book>();
		for (Object entity: entities) {
			books.add((Book)entity);
		}
		dao.closeCurrentSession();
		return books;
	}

	public void deleteAll() {
		dao.openCurrentSessionwithTransaction();
		dao.deleteAll();
		dao.closeCurrentSessionwithTransaction();
	}

}
