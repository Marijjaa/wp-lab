package mk.ukim.finki.wp.labwp2.service;

import mk.ukim.finki.wp.labwp2.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public List<Author> findAll();
    public  Author getById(Long id);
}
