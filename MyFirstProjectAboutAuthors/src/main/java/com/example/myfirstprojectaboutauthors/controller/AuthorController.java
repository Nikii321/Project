package com.example.myfirstprojectaboutauthors.controller;



import com.example.myfirstprojectaboutauthors.Entity.MyAuthors;
import com.example.myfirstprojectaboutauthors.Entity.MyBook;
import com.example.myfirstprojectaboutauthors.Service.AuthorService;
import com.example.myfirstprojectaboutauthors.Service.AuthorServiceImpl;
import com.example.myfirstprojectaboutauthors.Service.BookService;
import com.example.myfirstprojectaboutauthors.exception.NoSuchAuthorOrBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;


    @GetMapping("/authors")
    public List<MyAuthors> getAllAuthors() {
        List<MyAuthors>  myAuthorsList = authorService.getAllAuthor();
        myAuthorsList.sort(Comparator.comparing(MyAuthors::getRating).reversed());
        return myAuthorsList;
    }
    @GetMapping("/authors/{id}")
    public MyAuthors getAuthor(@PathVariable int id){
        MyAuthors myAuthors= authorService.getAuthor(id);
        if(myAuthors == null){
            throw new NoSuchAuthorOrBookException("no author with such an id");
        }
        return myAuthors;
    }
    @GetMapping("/authors/name/{name}/{surname}")
    public MyAuthors getAllAuthorsByName(@PathVariable String name,@PathVariable String surname){
        MyAuthors Author = authorService.findAllByNameAndSurname(name, surname);
        return Author;
    }
    @PostMapping("/authors")
    public MyAuthors saveAuthor(@RequestBody MyAuthors authors){
        authorService.saveAuthor(authors);
        return authors;
    }

    @PutMapping("/authors")
    public MyAuthors updateAuthor(@RequestBody MyAuthors author){
        authorService.saveAuthor(author);
        return author;
    }
    @DeleteMapping("/authors/{id}")
    public String authors(@PathVariable int id){
        MyAuthors authors = authorService.getAuthor(id);
        if(authors == null){
            throw new NoSuchAuthorOrBookException("no author with such an id");
        }
        Set<MyBook> books = authors.getBooks();
        for(MyBook kk:books){
            bookService.deleteBook(kk.getId());
        }

        authorService.deleteAuthor(id);
        return "Employee with id = "+id+" Successful deleted";
    }



}
