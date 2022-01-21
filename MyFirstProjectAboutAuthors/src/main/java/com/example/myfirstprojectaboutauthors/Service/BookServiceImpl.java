package com.example.myfirstprojectaboutauthors.Service;

import com.example.myfirstprojectaboutauthors.DAO.BookRepository;
import com.example.myfirstprojectaboutauthors.Entity.MyBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;



    @Override
    public List<MyBook> getAllBooks() {
        List<MyBook> books=  bookRepository.findAll();
        return  books;
    }

    @Override
    public void saveBook(MyBook myBook) {
        bookRepository.save(myBook);
    }

    @Override
    public MyBook getBook(int id) {
        MyBook myBook = null;
        Optional<MyBook> mbk = bookRepository.findById(id);
        if(mbk.isPresent()){
            myBook =mbk.get();
        }
        return myBook;
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public MyBook findByName(String name) {

        return bookRepository.findByName(name);
    }
    @Override
    public MyBook changeRatingBook(int id, double grade) {
        MyBook myBook = null;
        Optional<MyBook> mBk = bookRepository.findById(id);
        if(mBk.isPresent()){
            myBook = mBk.get();
            myBook.setSumma_grade(myBook.getSumma_grade()+grade);
            myBook.setNumber_grade(myBook.getNumber_grade()+1);
            myBook.setRating(myBook.getSumma_grade()/myBook.getNumber_grade());
            bookRepository.save(myBook);
        }

        return myBook;
    }


}
