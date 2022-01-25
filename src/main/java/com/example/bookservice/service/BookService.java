package com.example.bookservice.service;

import com.example.bookservice.model.Author;
import com.example.bookservice.model.Book;
import com.example.bookservice.model.Publisher;
import com.example.bookservice.repository.AuthorRepository;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> saveBooks(List<Book> books) {
        return bookRepository.saveAll(books);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getBooksByName(String name) {
        return bookRepository.findAllByName(name);
    }

    public List<Book> getBooksByCreationDate(Date date) {
        return bookRepository.findAllByCreationDate(date);
    }

    public List<Book> getBooksByPages(int pages) {
        return bookRepository.findAllByPages(pages);
    }

    public Book updateBook(Book book) {
        Book updatedBook = bookRepository.getById(book.getId());
        updatedBook.setPages(book.getPages());
        updatedBook.setName(book.getName());
        updatedBook.setCreationDate(book.getCreationDate());
        updatedBook.setAuthor(book.getAuthor());
        return bookRepository.save(book);
    }

    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "Book " + id + " was deleted!";
    }

    public Book addBookToAuthor(Long author_id, Long book_id) {
        Book book = bookRepository.findById(book_id).orElse(null);
        Author author = authorRepository.findById(author_id).orElse(null);
        book.assignAuthor(author);
        return bookRepository.save(book);
    }

    public Book addBookToPublisher(Long publisher_id, Long book_id) {
        Book book = bookRepository.findById(book_id).orElse(null);
        Publisher publisher = publisherRepository.findById(publisher_id).orElse(null);
        book.assignPublisher(publisher);
        return bookRepository.save(book);
    }

    public  List<Book> getAllBooksByName(String name){
        return bookRepository.findAllBooksByName(name);
    }
}
