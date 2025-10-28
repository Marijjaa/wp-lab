package mk.ukim.finki.wp.labwp2.repository;

import mk.ukim.finki.wp.labwp2.model.BookReservation;

public interface BookReservationRepository {
    BookReservation save(BookReservation reservation);
}