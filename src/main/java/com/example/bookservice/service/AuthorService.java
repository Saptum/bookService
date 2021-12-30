package com.example.bookservice.service;

import com.example.bookservice.model.Author;
import com.example.bookservice.model.Book;
import com.example.bookservice.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author findById(Long id){
        return authorRepository.findById(id).orElse(null);
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Author saveAuthor (Author author){
        return authorRepository.save(author);
    }

    public void deleteById(Long id){
        authorRepository.deleteById(id);
    }

    public  List<Author> saveAuthor (List<Author> authors){
        return authorRepository.saveAll(authors);
    }

    public Author addBook(Book book,Long authorId ){
        Author author = authorRepository.getById(authorId);
        author.getBooks().add(book);
        return authorRepository.save(author);

    }


}
