package com.example.myfirstprojectaboutauthors.Service;

import com.example.myfirstprojectaboutauthors.DAO.AuthorsRepository;
import com.example.myfirstprojectaboutauthors.Entity.MyAuthors;
import com.example.myfirstprojectaboutauthors.Entity.MyBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorsRepository authorsRepository;

    @Override
    public List<MyAuthors> getAllAuthor() {

        return authorsRepository.findAll();
    }

    @Override
    public void saveAuthor(MyAuthors MyAuthors) {
        authorsRepository.save(MyAuthors);
    }

    @Override
    public MyAuthors getAuthor(int id) {
        MyAuthors authors = null;
        Optional<MyAuthors> aut = authorsRepository.findById(id);
        if (aut.isPresent()) {
            authors = aut.get();
        }
        return authors;
    }

    @Override
    public void deleteAuthor(int id) {
        authorsRepository.deleteById(id);

    }

    @Override
    public List<MyAuthors> findAllByName(String name) {

        List<MyAuthors> authors = authorsRepository.findAllByName(name);


        return authors;
    }

    @Override
    public MyAuthors findAllByNameAndSurname(String name, String surname) {
        return authorsRepository.findByNameAndSurname(name, surname);
    }

    @Override
    public MyAuthors changeRatingAuthor(int id) {
        MyAuthors myAuthors = null;
        Optional<MyAuthors> mAr = authorsRepository.findById(id);
        if (mAr.isPresent()) {
            myAuthors = mAr.get();
            if (!myAuthors.getBooks().isEmpty()) {
                double temp = 0;
                Set<MyBook> myBookList = myAuthors.getBooks();
                for (MyBook i : myBookList) {
                    temp += (i.getRating());
                }
                myAuthors.setRating((temp / myAuthors.getBooks().size()));
                authorsRepository.save(myAuthors);
            }

        }

        return null;
    }

}
