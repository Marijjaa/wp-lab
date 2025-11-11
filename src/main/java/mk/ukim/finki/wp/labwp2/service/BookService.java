package mk.ukim.finki.wp.labwp2.service;

import mk.ukim.finki.wp.labwp2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    Book getById(Long id);
    Book save(String title, String genre, double averageRating, Long authorId);
    Book edit(Long id, String title, String genre, double averageRating, Long authorId);
    void delete(Long id);
    List<Book> searchBooks(String text, Double rating);
    List<Book> searchBooksByTitle(String text);
    List<Book> searchBooksByRating(double rating);
}