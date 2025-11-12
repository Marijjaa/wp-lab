package mk.ukim.finki.wp.labwp2.repository;

import mk.ukim.finki.wp.labwp2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();
    Optional<Book> getById(Long id);
    Book save(Book book);
    void delete(Long id);
    List<Book> searchBooks(String text, Double rating);
    List<Book> searchBooksByTitle(String text);
    List<Book> searchBooksByRating(double rating);
}
