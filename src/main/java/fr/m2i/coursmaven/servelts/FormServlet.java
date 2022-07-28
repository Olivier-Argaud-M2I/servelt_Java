package fr.m2i.coursmaven.servelts;

import fr.m2i.coursmaven.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FormServlet", value = "/form")
public class FormServlet extends HttpServlet {

    private static final String PAGE_FORM = "/WEB-INF/pages/form.jsp";
    private static final String PAGE_PROFIL = "/WEB-INF/pages/profil.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("coucou get");

        this.getServletContext().getRequestDispatcher(PAGE_FORM).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("coucou post");

        User user = new User(
                request.getParameter("nom"),
                request.getParameter("prenom"),
                request.getParameter("mail"),
                Integer.valueOf(request.getParameter("age")),
                request.getParameter("role"));

        request.setAttribute("user",user);

        request.getHeaderNames().asIterator().forEachRemaining((h)->{
            System.out.println("header name : "+h);
            System.out.println("header value : "+request.getHeader(h));
        });

        String nav = request.getHeader("user-agent");
        request.setAttribute("nav",nav);

        this.getServletContext().getRequestDispatcher(PAGE_PROFIL).forward(request, response);

    }
}
