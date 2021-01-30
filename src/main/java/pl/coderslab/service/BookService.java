package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    Optional<Book> getById(long id);

    void update(Book bookToUpdate);

    void create(Book newBook);

    void delete(long id);


}
