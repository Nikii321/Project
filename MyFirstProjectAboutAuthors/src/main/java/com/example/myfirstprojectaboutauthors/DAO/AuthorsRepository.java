package com.example.myfirstprojectaboutauthors.DAO;

import com.example.myfirstprojectaboutauthors.Entity.MyAuthors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorsRepository  extends JpaRepository<MyAuthors,Integer> {
    public List<MyAuthors> findAllByName(String name);
    public MyAuthors findByNameAndSurname(String name, String surname);
}
