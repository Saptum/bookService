package com.example.bookservice.repository;

import com.example.bookservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;


public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByFirstName(String name);

    List<Author> findAllByLastName(String lastName);

    List<Author> findByFirstNameAndLastName(String firstName, String lastName);

    List<Author> findAllByCountry(String country);

    List<Author> findAllBySex(String sex);

    List<Author> findAllByDate(Date birth);

    @Query("select a from Author a where a.email = ?1")
    Author findByEmail(String email);

    @Query (value = "SELECT a.firstName, a.lastName, a.country" +
            " FROM Author a WHERE a.authorId = ?1")
    String findAuthorAndCountryById ( Long id);

}
