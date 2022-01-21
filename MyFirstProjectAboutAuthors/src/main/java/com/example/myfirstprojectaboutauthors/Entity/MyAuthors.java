package com.example.myfirstprojectaboutauthors.Entity;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "my_authors")
public class MyAuthors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private double rating;

    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private Set<MyBook> books= new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Set<MyBook> getBooks() {
        return books;
    }

    public void setBooks(Set<MyBook> books) {
        this.books = books;
    }
    public  void addBook(MyBook book){
        books.add(book);
    }

    @Override
    public String toString() {
        return "MyAuthors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", rating=" + rating +
                ", books=" + books +
                '}';
    }
}
