package fr.m2i.coursmaven.filters;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/form")
public class MonFiltre implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        if(request instanceof HttpServletRequest && ((HttpServletRequest) request).getMethod().equals("POST")){
            request.setAttribute("filtre","passage par le filtre");
        }

        chain.doFilter(request, response);
    }
}
