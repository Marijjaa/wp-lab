package mk.ukim.finki.wp.labwp2.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.labwp2.model.Book;
import mk.ukim.finki.wp.labwp2.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();

    @PostConstruct
    public void init() {
        books.add(new Book("Bajkite na Marija", "Fiction", 10.0));
        books.add(new Book("The Silent River", "Mystery", 8.2));
        books.add(new Book("Echoes of Tomorrow", "Sci-Fi", 9.1));
        books.add(new Book("The Hidden Truth", "Thriller", 7.9));
        books.add(new Book("A Taste of Midnight", "Romance", 8.6));
        books.add(new Book("Broken Symphony", "Drama", 7.5));
        books.add(new Book("Beyond the Horizon", "Adventure", 9.0));
        books.add(new Book("Whispers of the Forest", "Fantasy", 8.3));
        books.add(new Book("Shadows of the Past", "Historical Fiction", 8.8));
        books.add(new Book("Fragments of Reality", "Philosophical", 9.4));
    }
}
