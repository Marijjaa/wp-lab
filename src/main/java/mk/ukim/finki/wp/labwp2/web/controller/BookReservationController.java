package mk.ukim.finki.wp.labwp2.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.labwp2.model.BookReservation;
import mk.ukim.finki.wp.labwp2.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bookReservation")
public class BookReservationController {
    private final BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @PostMapping
    public String placeReservation(@RequestParam String bookTitle,
                                   @RequestParam String readerName,
                                   @RequestParam int numCopies,
                                   HttpServletRequest req,
                                   Model model) {
        String readerAddress = req.getRemoteAddr();
        BookReservation reservation = this.bookReservationService.placeReservation(bookTitle, readerName, readerAddress, numCopies);

        model.addAttribute("bookReservation", reservation);
        return "reservationConfirmation";
    }
}