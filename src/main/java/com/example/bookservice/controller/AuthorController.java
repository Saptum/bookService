package com.example.bookservice.controller;

import com.example.bookservice.model.Author;
import com.example.bookservice.model.Book;
import com.example.bookservice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/saveAuthor")
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }
    
    @PostMapping("/saveAuthors")
    public List<Author> saveAuthor(@RequestBody List<Author> authors){
        return authorService.saveAuthor(authors);
    }

    @PostMapping("/addBook/{id}")
    public Author addBook(@PathVariable Long id, @RequestBody Book book) {
        return authorService.addBook(book, id);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/authorById/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @GetMapping("/authorByFirstName/{firstName}")
    public List<Author> getAuthorsByFirstName(@PathVariable String firstName) {
        return authorService.getAuthorsByFirstName(firstName);
    }

    @GetMapping("/authorByLastName/{lastName}")
    public List<Author> getAuthorsByLastName(@PathVariable String lastName) {
        return authorService.getAuthorsByLastName(lastName);
    }

    @GetMapping("/authorByCountry/{country}")
    public List<Author> getAuthorsByCountry(@PathVariable String country) {
        return authorService.getAuthorsByCountry(country);
    }

    @GetMapping("/authorBySex/{sex}")
    public List<Author> getAuthorsBySex(@PathVariable String sex) {
        return authorService.getAuthorsBySex(sex);
    }

    @GetMapping("/authorByBirth/{birth}")
    public List<Author> getAuthorsByBirth(@PathVariable Date birth) {
        return authorService.getAuthorsByBirth(birth);
    }

    @PutMapping("/updateAuthor")
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        return authorService.deleteAuthor(id);
    }
}
