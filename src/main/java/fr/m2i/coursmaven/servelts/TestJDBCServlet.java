package fr.m2i.coursmaven.servelts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "TestJDBCServlet", value = "/JDBC")
public class TestJDBCServlet extends HttpServlet {
    private static final String PAGE = "/WEB-INF/pages/page5.jsp";
//    private static final String BDD = "jdbc:mysql://localhost:3306/M2I?serverTimezone=UTC";
    private static final String BDD = "jdbc:mysql://localhost:3306/sakila";
    private static final String LOGIN = "admin";
    private static final String MDP = "admin";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // chargement driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            // connection DBB
            Connection connection = DriverManager.getConnection(BDD,LOGIN,MDP);

            Statement statement = connection.createStatement();

//            statement.execute("requeteSQL");// renvoi true ou false
//            statement.executeQuery("");// rend un resultset
//            statement.executeUpdate("");// pour insert update et delete

            ResultSet resultSet =  statement.executeQuery("select first_name,last_name from actor");

            while(resultSet.next()){
                System.out.println(resultSet.getString("first_name")+" "+resultSet.getString("last_name"));
            }

            statement.close();

            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }
}
