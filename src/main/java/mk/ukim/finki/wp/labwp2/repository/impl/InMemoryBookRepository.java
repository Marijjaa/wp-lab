package mk.ukim.finki.wp.labwp2.repository.impl;

import mk.ukim.finki.wp.labwp2.bootstrap.DataHolder;
import mk.ukim.finki.wp.labwp2.model.Book;
import mk.ukim.finki.wp.labwp2.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public Optional<Book> getById(Long id) {
        return DataHolder.books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();

    }

    @Override
    public Book save(Book book) {
        delete(book.getId());
        DataHolder.books.add(book);
        return book;

    }

    @Override
    public void delete(Long id) {
        DataHolder.books.removeIf(m -> m.getId().equals(id));
    }


    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books
                .stream()
                .filter(b -> b.getTitle().contains(text) || b.getAverageRating() >= rating)
                .toList();
    }

    @Override
    public List<Book> searchBooksByTitle(String text) {
        return DataHolder.books
                .stream()
                .filter(b -> b.getTitle().contains(text))
                .toList();
    }
    @Override
    public List<Book> searchBooksByRating(double rating) {
        return DataHolder.books
                .stream()
                .filter(b -> b.getAverageRating() >= rating)
                .toList();
    }
}
