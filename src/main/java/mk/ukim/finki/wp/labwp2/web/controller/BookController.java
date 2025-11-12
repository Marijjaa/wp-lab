package mk.ukim.finki.wp.labwp2.web.controller;

import mk.ukim.finki.wp.labwp2.model.Author;
import mk.ukim.finki.wp.labwp2.model.Book;
import mk.ukim.finki.wp.labwp2.service.AuthorService;
import mk.ukim.finki.wp.labwp2.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        List<Book> books = bookService.listAll();

        model.addAttribute("books", books);
        return "listBooks";
    }

    @GetMapping("/book-form")
    public String addBookForm(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "book-form";
    }

    @PostMapping
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        this.bookService.save(title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @GetMapping("/book-form/{bookId}")
    public String editBookForm(@PathVariable Long bookId, Model model) {
        try {
            Book book = bookService.getById(bookId);
            List<Author> authors = authorService.findAll();
            model.addAttribute("book", book);
            model.addAttribute("authors", authors);
            return "book-form";
        } catch (RuntimeException e) {
            return "redirect:/books?error=" + e.getMessage();
        }
    }

    @PostMapping("/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        this.bookService.edit(bookId, title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        this.bookService.delete(id);
        return "redirect:/books";
    }
}
