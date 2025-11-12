package mk.ukim.finki.wp.labwp2.service.impl;

import mk.ukim.finki.wp.labwp2.model.Author;
import mk.ukim.finki.wp.labwp2.repository.AuthorRepository;
import mk.ukim.finki.wp.labwp2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.getById(id).orElseThrow(() -> new IllegalArgumentException("Author with id " + id + " not found!"));
    }
}
