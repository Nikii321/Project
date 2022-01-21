package com.example.myfirstprojectaboutauthors.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "my_book")
public class MyBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private double rating;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Column
    private String name;
    @Column
    private int number_grade;
    @Column
    private double summa_grade;

    @Column
    private String name_and_surname_author;

    public String getName_and_surname_author() {
        return name_and_surname_author;
    }

    public void setName_and_surname_author(String name_and_surname_author) {
        this.name_and_surname_author = name_and_surname_author;
    }

    public int getNumber_grade() {
        return number_grade;
    }

    public void setNumber_grade(int number_grade) {
        this.number_grade = number_grade;
    }

    public double getSumma_grade() {
        return summa_grade;
    }

    public void setSumma_grade(double summa_grade) {
        this.summa_grade = summa_grade;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id",nullable = false)
    private MyAuthors authors;

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

    private MyAuthors getAuthors() {
        return authors;
    }

    public void setAuthors(MyAuthors authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "MyBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number_grade=" + number_grade +
                ", summa_grade=" + summa_grade +
                ", authors=" + authors +
                '}';
    }
}
