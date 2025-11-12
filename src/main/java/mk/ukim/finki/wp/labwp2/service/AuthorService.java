package mk.ukim.finki.wp.labwp2.service;

import mk.ukim.finki.wp.labwp2.model.Author;
import mk.ukim.finki.wp.labwp2.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public List<Author> findAll();
    public  Author getById(Long id);
    Author save(String name, String surname, String country, String biography);
    Author edit(Long id, String name, String surname, String country, String biography);
    void delete(Long id);
}
