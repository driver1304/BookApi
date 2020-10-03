package pl.coderslab.model;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAll();

    public Optional<Book> getById(long id);

    public void update(Book bookToUpdate);

    public void create(Book newBook);

    public void delete(long id);


}
