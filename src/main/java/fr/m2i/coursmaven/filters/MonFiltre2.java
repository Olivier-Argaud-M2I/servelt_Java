package fr.m2i.coursmaven.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter({"/Servlet3","/Servlet4"})
public class MonFiltre2 implements Filter {

    private static final String PAGE = "/WEB-INF/pages/form.jsp";

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        if(request instanceof HttpServletRequest && ((HttpServletRequest) request).getSession().getAttribute("loggeduser")!=null){
            chain.doFilter(request, response);
        }
        else{
            request.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
        }

    }
}
