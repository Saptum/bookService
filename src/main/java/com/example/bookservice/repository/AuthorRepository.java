package com.example.bookservice.repository;

import com.example.bookservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findAllByFirstName(String name);

    List<Author> findAllByLastName(String lastName);

    List<Author> findAllByCountry(String country);

    List<Author> findAllBySex(String sex);

    List<Author> findAllByDate(Date birth);
}
