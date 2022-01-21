package com.example.myfirstprojectaboutauthors.Service;

import com.example.myfirstprojectaboutauthors.Entity.MyBook;

import java.util.List;

public interface BookService {
    public List<MyBook> getAllBooks();
    public MyBook getBook(int id);
    public void saveBook(MyBook myBook);
    public void deleteBook(int id);
    public MyBook findByName(String name);
    public MyBook changeRatingBook(int id,double grade);
}
