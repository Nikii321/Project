package com.example.myfirstprojectaboutauthors.DAO;

import com.example.myfirstprojectaboutauthors.Entity.MyAuthors;
import com.example.myfirstprojectaboutauthors.Entity.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<MyBook, Integer> {
    public MyBook findByName(String name);

}
