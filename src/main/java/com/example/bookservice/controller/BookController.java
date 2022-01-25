package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PostMapping("/saveBooks")
    public List<Book> saveBooks(@RequestBody List<Book> books) {
        return bookService.saveBooks(books);
    }

    @GetMapping("/getBooks")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/getBooksByName/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByName(name);
    }

    @GetMapping("/getBooksByDate/{date}")
    public List<Book> getBooksByCreationDate(@PathVariable Date date){
        return bookService.getBooksByCreationDate(date);
    }

    @GetMapping("/getBooksByPages/{pages}")
    public List<Book> getBooksByPages(@PathVariable int pages) {
        return bookService.getBooksByPages(pages);
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @PutMapping("book/{book_id}/author/{author_id}")
    public Book assignBookToAuthor(@PathVariable Long book_id, @PathVariable Long author_id) {
        return bookService .addBookToAuthor(author_id, book_id);
    }

    @PutMapping("book/{book_id}/publisher/{publisher_id}")
    public Book assignBookToPublisher(@PathVariable Long book_id, @PathVariable Long publisher_id) {
        return bookService.addBookToPublisher(publisher_id, book_id);
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/getAllBooksByName/{name}")
    public List<Book> getAllBooksByName(@PathVariable String name){
        return bookService.getAllBooksByName(name);
    }
}
