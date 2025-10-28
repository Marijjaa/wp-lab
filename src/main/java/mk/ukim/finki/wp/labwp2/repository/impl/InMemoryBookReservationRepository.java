package mk.ukim.finki.wp.labwp2.repository.impl;

import mk.ukim.finki.wp.labwp2.bootstrap.DataHolder;
import mk.ukim.finki.wp.labwp2.model.BookReservation;
import mk.ukim.finki.wp.labwp2.repository.BookReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookReservationRepository implements BookReservationRepository {
    @Override
    public BookReservation save(BookReservation reservation) {
        DataHolder.reservations.add(reservation);
        return reservation;
    }
}
