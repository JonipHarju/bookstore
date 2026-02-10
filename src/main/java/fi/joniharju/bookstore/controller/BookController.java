package fi.joniharju.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.joniharju.bookstore.model.Book;
import fi.joniharju.bookstore.model.BookRepository;
import fi.joniharju.bookstore.model.CategoryRepository;

@Controller
public class BookController {
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/index")
    public String indexPage(Model model) {
        return "bookstore";
    }

    @GetMapping("/booklist")
    public String getBookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        System.out.println(model + "model log");
        return "booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addBook";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());

        return "editbook";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {

        bookRepository.save(book);
        return "redirect:/booklist";
    }

}
