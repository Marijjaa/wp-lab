package mk.ukim.finki.wp.labwp2.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebFilter
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String bookTitle = req.getParameter("bookTitle");

        String sessionBookTitle = null;

        if (req.getSession().getAttribute("bookTitle") != null) {
            sessionBookTitle = req.getSession().getAttribute("bookTitle").toString();
        }

        String path = req.getServletPath();

        if (bookTitle == null && sessionBookTitle == null && req.getServletPath().startsWith("/bookReservation")) {
            resp.sendRedirect("/servlet/books");
        } else {
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
