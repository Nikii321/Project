package com.example.myfirstprojectaboutauthors.Service;

import com.example.myfirstprojectaboutauthors.Entity.MyAuthors;

import java.util.List;

public interface AuthorService {
    public List<MyAuthors> getAllAuthor();
    public void saveAuthor(MyAuthors MyAuthors);
    public MyAuthors getAuthor(int id);
    public void deleteAuthor(int id);
    public List<MyAuthors> findAllByName(String name);
    public MyAuthors findAllByNameAndSurname(String name, String surname);
    public MyAuthors changeRatingAuthor(int id);
}

