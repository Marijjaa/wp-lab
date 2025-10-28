package mk.ukim.finki.wp.labwp2.service;

import mk.ukim.finki.wp.labwp2.model.BookReservation;

public interface BookReservationService {
    BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies);
}
