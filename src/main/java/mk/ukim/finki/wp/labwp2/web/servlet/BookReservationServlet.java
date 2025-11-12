package mk.ukim.finki.wp.labwp2.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.labwp2.service.BookReservationService;
import mk.ukim.finki.wp.labwp2.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "BookReservationServlet", urlPatterns = "/servlet/bookReservation")
public class BookReservationServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final BookReservationService bookReservationService;

    public BookReservationServlet(SpringTemplateEngine springTemplateEngine, BookReservationService bookReservationService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookReservationService = bookReservationService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String bookTitle = req.getSession().getAttribute("bookTitle").toString();
        String name = req.getSession().getAttribute("readerName").toString();
        String address = req.getSession().getAttribute("readerAddress").toString();
        int nOfCopies = (int) req.getSession().getAttribute("numCopies");


        context.setVariable("bookTitle", bookTitle);
        context.setVariable("readerName", name);
        context.setVariable("readerAddress", address);
        context.setVariable("numCopies", nOfCopies);

        context.setVariable("ipAddress", req.getRemoteAddr());

        springTemplateEngine.process("reservationConfirmation.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookTitle = req.getParameter("bookTitle");
        String name = req.getParameter("readerName");
        String address = req.getParameter("readerAddress");
        int nOfCopies = Integer.parseInt(req.getParameter("numCopies"));

        try {
            bookReservationService.placeReservation(bookTitle, name, address, nOfCopies);
        }catch (IllegalArgumentException e) {
            resp.sendRedirect("/servlet/category?errorMessage=Invalid input for category");
            return;
        }

        req.getSession().setAttribute("bookTitle", bookTitle);
        req.getSession().setAttribute("readerName", name);
        req.getSession().setAttribute("readerAddress", address);
        req.getSession().setAttribute("numCopies", nOfCopies);

        resp.sendRedirect("/bookReservation");
    }
}
