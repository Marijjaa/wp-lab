package mk.ukim.finki.wp.labwp2.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.labwp2.model.Author;
import mk.ukim.finki.wp.labwp2.model.Book;
import mk.ukim.finki.wp.labwp2.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    private static long counter=11;

    public static long getCounter() {
        return counter++;
    }

    @PostConstruct
    public void init() {
        Author mac = new Author(1L,"mac", "mac", "MKD", "Najaaca");
        authors.add(mac);

        books.add(new Book(1L,"Bajkite na Marija", "Fiction", 10.0, mac));
        books.add(new Book(2L,"The Silent River", "Mystery", 8.2, mac));
        books.add(new Book(3L, "Echoes of Tomorrow", "Sci-Fi", 9.1, mac));
        books.add(new Book(4L,"The Hidden Truth", "Thriller", 7.9, mac));
        books.add(new Book(5L,"A Taste of Midnight", "Romance", 8.6, mac));
        books.add(new Book(6L,"Broken Symphony", "Drama", 7.5, mac));
        books.add(new Book(7L,"Beyond the Horizon", "Adventure", 9.0, mac));
        books.add(new Book(8L,"Whispers of the Forest", "Fantasy", 8.3, mac));
        books.add(new Book(9L,"Shadows of the Past", "Historical Fiction", 8.8, mac));
        books.add(new Book(10L,"Fragments of Reality", "Philosophical", 9.4, mac));
    }
}
