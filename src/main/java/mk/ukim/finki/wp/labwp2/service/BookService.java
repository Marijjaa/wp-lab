package mk.ukim.finki.wp.labwp2.service;

import mk.ukim.finki.wp.labwp2.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
    List<Book> searchBooksByTitle(String text);
    List<Book> searchBooksByRating(double rating);
}