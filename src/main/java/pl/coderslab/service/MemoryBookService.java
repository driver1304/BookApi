package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService {
    private List<Book> books;
    private static Long nextId = 4L;

    public MemoryBookService() {
        this.books = new ArrayList<>();
        this.books.add(new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming"));
        this.books.add(new Book(2L, "4687324631766", "Python",
                "Mark Luiz", "Helion", "programming"));
        this.books.add(new Book(3L, "6943324631766", "Język C++",
                "Stephen Prata", "Helion", "programming"));

    }

    public List<Book> getAll() {
        return this.books;
    }

    public Optional<Book> getById(long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    public void update(Book bookToUpdate) {
        if (this.getById(bookToUpdate.getId()).isPresent()) {
            int indexOf = this.books.indexOf(this.getById(bookToUpdate.getId()).get());
            this.books.set(indexOf, bookToUpdate);
        }
    }

    public void create(Book newBook) {
        newBook.setId(nextId++);
        this.books.add(newBook);
    }


    public void delete(long id) {
        if (getById(id).isPresent()) {
            books.remove(getById(id).get());
        }
    }

}

