package mk.ukim.finki.wp.labwp2.service.impl;

import mk.ukim.finki.wp.labwp2.bootstrap.DataHolder;
import mk.ukim.finki.wp.labwp2.model.Author;
import mk.ukim.finki.wp.labwp2.model.Book;
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

    @Override
    public Author save(String name, String surname, String country, String biography) {
        if (name == null || name.isEmpty() ||
                surname == null || surname.isEmpty() ||
                country == null || country.isEmpty() ||
                biography == null || biography.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Author author = new Author(DataHolder.getCounter(), name, surname, country, biography);
        return authorRepository.save(author);
    }

    @Override
    public Author edit(Long id, String name, String surname, String country, String biography) {
        if (name == null || name.isEmpty() ||
                surname == null || surname.isEmpty() ||
                country == null || country.isEmpty() ||
                biography == null || biography.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Author author = getById(id);

        author.setName(name);
        author.setBiography(biography);
        author.setCountry(country);

        return authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.delete(id);
    }
}
