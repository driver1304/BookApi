package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaBookService implements BookService {
    BookRepository br;

    @Autowired
    public JpaBookService(BookRepository br) {
        this.br = br;
    }

    @Override
    public List<Book> getAll() {
        return br.findAll();
    }

    @Override
    public Optional<Book> getById(long id) {
        return br.findById(id);
    }

    @Override
    public void update(Book bookToUpdate) {
        br.save(bookToUpdate);
    }

    @Override
    public void create(Book newBook) {
        br.save(newBook);
    }

    @Override
    public void delete(long id) {
        br.deleteById(id);
    }
}
