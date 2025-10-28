package mk.ukim.finki.wp.labwp2.repository;

import mk.ukim.finki.wp.labwp2.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
    List<Book> searchBooksByTitle(String text);
    List<Book> searchBooksByRating(double rating);
}
