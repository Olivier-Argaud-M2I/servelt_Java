package fr.m2i.coursmaven.listerners;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

    public Listener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("DEMARAGE DE L APPLICATION");
        sce.getServletContext().log("DEMARAGE DE L APPLICATION");
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ARRET DE L APPLICATION");
        sce.getServletContext().log("ARRET DE L APPLICATION");
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("AJOUT d'un attribut de session");
        sbe.getSession().getServletContext().log("AJOUT d'un attribut de session " +sbe.getName() + " dont la valeur est : "+ sbe.getValue().toString());
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }


    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        if(srae.getName().equals("filtre")){
            srae.getServletContext().log("passage par le filtre");
        }
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {

    }
}
