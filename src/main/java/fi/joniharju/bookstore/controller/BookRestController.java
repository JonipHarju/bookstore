package fi.joniharju.bookstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fi.joniharju.bookstore.model.Book;
import fi.joniharju.bookstore.model.BookRepository;

@RestController
public class BookRestController {

    private BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/rest/books")
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/rest/books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).get();
    }

}