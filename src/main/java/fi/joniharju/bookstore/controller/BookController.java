package fi.joniharju.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.joniharju.bookstore.model.BookRepository;

@Controller
public class BookController {
    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/index")
    public String indexPage(Model model) {
        return "bookstore";
    }

    @GetMapping("/booklist")
    public String getBookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

}
