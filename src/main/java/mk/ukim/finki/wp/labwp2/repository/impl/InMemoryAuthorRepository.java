package mk.ukim.finki.wp.labwp2.repository.impl;

import mk.ukim.finki.wp.labwp2.bootstrap.DataHolder;
import mk.ukim.finki.wp.labwp2.model.Author;
import mk.ukim.finki.wp.labwp2.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryAuthorRepository implements AuthorRepository {
    @Override
    public List<Author> findAll() {
        return DataHolder.authors;
    }

    @Override
    public Optional<Author> getById(Long id) {
        return DataHolder.authors.stream().filter(a -> a.getId().equals(id)).findFirst();
    }
}
