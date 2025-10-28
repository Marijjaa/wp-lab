package mk.ukim.finki.wp.labwp2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String genre;
    private double averageRating;
}
