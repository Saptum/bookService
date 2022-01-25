package com.example.bookservice.repository;

import com.example.bookservice.model.Author;
import com.example.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Date;
import java.util.List;

public interface BookRepository  extends JpaRepository<Book,Long> {
    List<Book> findAllByName(String name);

    List<Book> findAllByCreationDate(Date date);

    List<Book> findAllByPages(int pages);

    @Query("select b from Book b order by b.name")
    List<Book> findAllBooksByName(String name);
}
