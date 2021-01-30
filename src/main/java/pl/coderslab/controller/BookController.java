package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService mbs;

    @Autowired
    public BookController(BookService mbs) {
        this.mbs = mbs;
    }

    @GetMapping("")
    public List<Book> allBooks() {
        return mbs.getAll();
    }

    @GetMapping("/{id}")
    public Book singleBook(@PathVariable Long id) {
        return this.mbs.getById(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        mbs.update(book);
    }

    @PostMapping("")
    public void createBook(@RequestBody Book book) {
        mbs.create(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        mbs.delete(id);
    }
}
