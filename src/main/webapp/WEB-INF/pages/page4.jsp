<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 29/07/2022
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Page 4</title>
    </head>
    <body>
        Page 4

        <main>

            <form action="<c:url value="/api/User"/>" method="POST">
<%--            <form action="/coursmaven/api/User" method="PUT">--%>
                <input type="text" name="nom">
                <input type="text" name="prenom">
                <input type="submit" value="envoyer">
            </form>


        </main>


    </body>
</html>
