package mk.ukim.finki.wp.labwp2.service.impl;

import mk.ukim.finki.wp.labwp2.model.Book;
import mk.ukim.finki.wp.labwp2.repository.BookRepository;
import mk.ukim.finki.wp.labwp2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.searchBooks(text, rating);
    }

    @Override
    public List<Book> searchBooksByTitle(String text) {
        return bookRepository.searchBooksByTitle(text);
    }

    @Override
    public List<Book> searchBooksByRating(double rating) {
        return bookRepository.searchBooksByRating(rating);
    }
}
