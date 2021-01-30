package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {
    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("books")
    public Collection<Book> books() {
        return bookService.getAll();
    }

    @GetMapping("/all")
    public String showBooks() {
        return "/books/all";

    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "/books/add-form";
    }

    @PostMapping("/add")
    public String addBookPost(@ModelAttribute("book") @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/add-form";
        }
        bookService.create(book);
        return "redirect:all";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getById(id).get());
        return "/books/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String editBookPost(@ModelAttribute("book") @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit-form";
        }
        bookService.update(book);
        return "redirect:../all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {

        model.addAttribute("book", bookService.getById(id).get());
        return "/books/verification";
    }

    @PostMapping("/delete/{id}")
    public String deleteBookPost(@RequestParam boolean decision, @PathVariable Long id) {
        if (decision) bookService.delete(id);
        return "redirect:../all";
    }

    @GetMapping("/show/{id}")
    public String showBookById(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getById(id).orElseThrow(EntityNotFoundException::new));
        return "books/show";
    }

}
