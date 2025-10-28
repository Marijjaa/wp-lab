package mk.ukim.finki.wp.labwp2.service.impl;

import mk.ukim.finki.wp.labwp2.model.BookReservation;
import mk.ukim.finki.wp.labwp2.repository.BookReservationRepository;
import mk.ukim.finki.wp.labwp2.service.BookReservationService;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {
    private final BookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        return bookReservationRepository.save(new BookReservation(bookTitle, readerName, readerAddress, (long)numberOfCopies));
    }
}
