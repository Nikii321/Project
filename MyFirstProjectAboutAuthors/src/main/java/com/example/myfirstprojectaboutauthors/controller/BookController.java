package com.example.myfirstprojectaboutauthors.controller;


import com.example.myfirstprojectaboutauthors.Entity.MyAuthors;
import com.example.myfirstprojectaboutauthors.Entity.MyBook;
import com.example.myfirstprojectaboutauthors.Service.AuthorService;
import com.example.myfirstprojectaboutauthors.Service.BookService;
import com.example.myfirstprojectaboutauthors.exception.NoSuchAuthorOrBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;


    @PostMapping("/books")
    public MyBook saveBook(@RequestBody MyBook book){
        int id = authorService.findAllByNameAndSurname(book.getName_and_surname_author().split(" ")[0], book.getName_and_surname_author().split(" ")[1]).getId();
        MyAuthors authors = authorService.getAuthor(id);
        book.setAuthors(authors);
        authors.addBook(book);
        authorService.saveAuthor(authors);
        return book;
    }
    @GetMapping("/books")
    public List<MyBook> getAllBook(){
        List<MyBook> myBookList =bookService.getAllBooks();
        myBookList.sort(Comparator.comparing(MyBook::getRating).reversed());
        return myBookList;

    }
    @GetMapping("/books/{id}")
    public MyBook getBookById(@PathVariable int id){
        MyBook book = bookService.getBook(id);
        if(book == null){
            throw new NoSuchAuthorOrBookException("no book with such an id");
        }
        return book;
    }

    @GetMapping("/books/name/{name}")
    public  MyBook getBookByName(@PathVariable String name){
        return bookService.findByName(name);
    }
    @PutMapping("/books")
    public MyBook updateBook(@RequestBody MyBook book){
        int id = authorService.findAllByNameAndSurname(book.getName_and_surname_author().split(" ")[0], book.getName_and_surname_author().split(" ")[1]).getId();
        MyAuthors authors = authorService.getAuthor(id);
        book.setAuthors(authors);
        bookService.saveBook(book);
        return book;
    }

    @GetMapping("/books/rating/{id}/{grade}")
    public String PassGrade(@PathVariable int id,@PathVariable double grade){


        MyBook book = bookService.getBook(id);
        if(book == null){
            throw new NoSuchAuthorOrBookException("no book with such an id");
        }
        bookService.changeRatingBook(id,grade);
        int id_author = authorService.findAllByNameAndSurname(book.getName_and_surname_author().split(" ")[0], book.getName_and_surname_author().split(" ")[1]).getId();
        authorService.changeRatingAuthor(id_author);
        return "Thanks for grade";
    }
    @DeleteMapping("books/{id}")
    public String deleteBook(@PathVariable int id){
        MyBook book = bookService.getBook(id);
        if(book == null){
            throw new NoSuchAuthorOrBookException("no book with such an id");
        }
        bookService.deleteBook(id);
        return "Delete successful";
    }



}
