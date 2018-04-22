package com.javacodegeeks.snippets.enterprise.hibernate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Column(name= "book_id", nullable = false)
    private Integer bookId ;

    @Column(name= "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id",updatable=false,insertable = false, nullable = false)
    private Client clientById;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id",updatable=false,insertable = false, nullable = false)
    private Book bookById;

    public Card(){}

    public Card(Integer id,Integer clientId,Integer bookId,Date date){
        this.id=id;
        this.clientId= clientId;
        this.bookId=bookId;
        this.date=date;
    }

    public Card(Integer clientId,Integer bookId,Date date){
        this.clientId= clientId;
        this.bookId=bookId;
        this.date=date;
    }

    public Card(Date date){
        this.date=date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBookById() {
        return bookById;
    }

    public void setBookById(Book bookById) {
        this.bookById = bookById;
    }

    public Client getClientById() {
        return clientById;
    }

    public void setClientById(Client clientById) {
        this.clientById = clientById;
    }

    @Override
    public String toString() {
        return "Card: " + this.id+ ", " + this.clientId+ ", " + this.bookId+ ", " + this.date;
    }
}
