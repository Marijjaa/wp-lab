package mk.ukim.finki.wp.labwp2.service.impl;

import mk.ukim.finki.wp.labwp2.model.Author;
import mk.ukim.finki.wp.labwp2.model.Book;
import mk.ukim.finki.wp.labwp2.repository.BookRepository;
import mk.ukim.finki.wp.labwp2.service.AuthorService;
import mk.ukim.finki.wp.labwp2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.getById(id).orElseThrow(() -> new IllegalArgumentException("Book with id " + id + " not found!"));
    }

    @Override
    public Book save(String title, String genre, double averageRating, Long authorId) {
        if (title == null || title.isEmpty() ||
                genre == null || genre.isEmpty() ||
                 averageRating < 0 ||
                authorId == null) {
            throw new IllegalArgumentException();
        }

        Author author = authorService
                .getById(authorId);

        Book book = new Book(title, genre, averageRating, author);
        return bookRepository.save(book);

    }

    @Override
    public Book edit(Long id, String title, String genre, double averageRating, Long authorId) {
        if (title == null || title.isEmpty() ||
                genre == null || genre.isEmpty() ||
                averageRating < 0 ||
                authorId == null) {
            throw new IllegalArgumentException();
        }

        Author author = authorService
                .getById(authorId);

        Book book = getById(id);

        book.setTitle(title);
        book.setGenre(genre);
        book.setAverageRating(averageRating);
        book.setAuthor(author);

        return bookRepository.save(book);
    }


    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
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
