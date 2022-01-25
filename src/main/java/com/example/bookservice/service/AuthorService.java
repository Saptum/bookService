package com.example.bookservice.service;

import com.example.bookservice.model.Author;
import com.example.bookservice.model.Book;
import com.example.bookservice.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> saveAuthor(List<Author> authors) {
        return authorRepository.saveAll(authors);
    }

    public Author addBook(Book book, Long authorId) {
        Author author = authorRepository.getById(authorId);
        author.getBooks().add(book);
        return authorRepository.save(author);
    }

    public List<Author> getAuthorsByFirstName(String firstName) {
        return authorRepository.findAllByFirstName(firstName);
    }

    public List<Author> getAuthorsByLastName(String lastName) {
        return authorRepository.findAllByLastName(lastName);
    }

    public List<Author> getAuthorsByFirstNameAndLastName(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Author> getAuthorsByCountry(String country) {
        return authorRepository.findAllByCountry(country);
    }

    public List<Author> getAuthorsBySex(String sex) {
        return authorRepository.findAllBySex(sex);
    }

    public List<Author> getAuthorsByBirth(Date birth) {
        return authorRepository.findAllByDate(birth);
    }

    public Author updateAuthor(Author author) {
        Author updatedAuthor = authorRepository.findById(author.getAuthorId()).orElse(null);
        updatedAuthor.setLastName(author.getLastName());
        updatedAuthor.setFirstName(author.getFirstName());
        updatedAuthor.setCountry(author.getCountry());
        updatedAuthor.setDate(author.getDate());
        updatedAuthor.setSex(author.getSex());
        return authorRepository.save(updatedAuthor);
    }

    public String deleteAuthor(Long id) {
        authorRepository.deleteById(id);
        return "Author " + id + " was deleted!";
    }

    public String getAuthorAndCountryById(Long id) {
        return authorRepository.findAuthorAndCountryById(id);
    }

    public Author getAuthorByEmail(String email){
        return authorRepository.findByEmail(email);
    }
}
