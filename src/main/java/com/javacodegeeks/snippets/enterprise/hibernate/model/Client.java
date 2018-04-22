package com.javacodegeeks.snippets.enterprise.hibernate.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name",length = 45)
    private String name;

    @Column(name= "age",length =11)
    private Integer age;

    @OneToMany(mappedBy = "clientById")
    private Set<Card> cardById;

    public Client(){}

    public Client(Integer id,String name,Integer age){
        this.id=id;
        this.age=age;
        this.name=name;
    }
    public Client(String name,Integer age){
        this.age=age;
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCardById(Set<Card> cardById) {
        this.cardById = cardById;
    }

    public Set<Card> getCardById() {
        return cardById;
    }

    @Override
    public String toString() {
        return "Client: " + this.id + ", " + this.name + ", " + this.age;
    }

}
