package com.javacodegeeks.snippets.enterprise.hibernate;

import java.util.List;
import java.util.Date;

import com.javacodegeeks.snippets.enterprise.hibernate.model.*;
import com.javacodegeeks.snippets.enterprise.hibernate.service.*;

public class App {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		ClientService clientService = new ClientService();
		CardService cardService = new CardService();
		Date date = new Date();
		/*Book book1 = new Book("Dracula", "Bram Stoker");
		bookService.persist(book1);
		List<Book> books1 = bookService.findAll();
		System.out.println("Books Persisted are :");
		for (Book b : books1) {
			System.out.println("-" + b.toString());
		}

		Client client1 = new Client("Ilya",20);
		clientService.persist(client1);
		List<Client> clients1 = clientService.findAll();
		System.out.println("Clients Persisted are :");
		for (Client c : clients1) {
			System.out.println("-" + c.toString());
		}
			Card card1 = new Card(1,10, date);
			cardService.persist(card1);
			List<Card> cards1 = cardService.findAll();
			System.out.println("Cards Persisted are :");
			for (Card c : cards1) {
				System.out.println("-" + c.toString());
			}*/
		/*List<Client> clients1 = clientService.findAll();
		System.out.println("Clients Persisted are :");
		for (Client cl : clients1) {
			System.out.println("-" + cl.toString());
		}*/
		/*List<Book> books1 = bookService.findAll();
		System.out.println("Books with expired date :");
		for (Book b : books1) {
			System.out.println("-" + b.toString());
		}*/
			for(Card c: cardService.findAll()){
				if(c.getDate()==null)cardService.findAll().listIterator();
					else {
						if(c.getDate().compareTo(date)<0){
						System.out.println("Books with expired date: " + c.toString());
					}
				}
			}

		for (Card c : cardService.findAll()) {
			if(c.getDate()==null)cardService.findAll().listIterator();
			else{
				if (c.getDate().compareTo(date)>=0) {
					System.out.println("Didn't expire a book: " + c.getClientById().getName());
					System.out.println(c.getBookById().getTitle());
				}
			}

		}
		System.exit(0);

	}
}
