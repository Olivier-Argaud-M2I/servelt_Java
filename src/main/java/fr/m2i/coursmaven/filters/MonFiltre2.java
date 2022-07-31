package fr.m2i.coursmaven.filters;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
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
//            if(response instanceof HttpServletResponse){
//                ((HttpServletRequest) request).sen
//            }
        }

    }
}
