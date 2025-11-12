package mk.ukim.finki.wp.labwp2.web.controller;

import mk.ukim.finki.wp.labwp2.model.Author;
import mk.ukim.finki.wp.labwp2.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        List<Author> authors = authorService.findAll();

        model.addAttribute("authors", authors);
        return "listAuthors";
    }

    @GetMapping("/author-form")
    public String addAuthorForm(Model model) {
        return "author-form";
    }

    @PostMapping
    public String saveBook(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String country,
                           @RequestParam String biography) {
        this.authorService.save(name, surname, country, biography);
        return "redirect:/authors";
    }

    @GetMapping("/author-form/{authorId}")
    public String editAuthorForm(@PathVariable Long authorId, Model model) {
        try {
            Author author = authorService.getById(authorId);
            model.addAttribute("author", author);
            return "author-form";
        } catch (RuntimeException e) {
            return "redirect:/author?error=" + e.getMessage();
        }
    }

    @PostMapping("/{authorId}")
    public String editBook(@PathVariable Long authorId,
                            @RequestParam String name,
                            @RequestParam String surname,
                            @RequestParam String country,
                            @RequestParam String biography) {
        this.authorService.edit(authorId, name, surname, country, biography);
        return "redirect:/authors";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        this.authorService.delete(id);
        return "redirect:/authors";
    }
}
