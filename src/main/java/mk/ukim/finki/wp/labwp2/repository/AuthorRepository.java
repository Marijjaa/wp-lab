package mk.ukim.finki.wp.labwp2.repository;

import mk.ukim.finki.wp.labwp2.model.Author;
import mk.ukim.finki.wp.labwp2.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository {
    public List<Author> findAll();

    public Optional<Author> getById(Long id);
    Author save(Author author);
    void delete(Long id);
}
