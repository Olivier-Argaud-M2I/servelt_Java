
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" scope="request" type="fr.m2i.coursmaven.models.User"/>
<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 26/07/2022
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Profil</title>
<%--        <link rel='stylesheet' type='text/css' href='/coursmaven/resources/styles/style2.css'>--%>

        <link rel='stylesheet' type='text/css' href="<c:url value="/resources/styles/style2.css"/>">
<%--        <link rel='stylesheet' type='text/css' href='../../resources/styles/style2.css'>--%>
        <jsp:include page="fragment/_style.jsp"/>
    </head>
    <body>

        <jsp:include page="fragment/_header.jsp"/>

        <jsp:include page="fragment/_menu.jsp"/>


        <jsp:include page="fragment/_profil.jsp"/>


        <jsp:include page="fragment/_test.jsp">
            <jsp:param name="age" value="${user.age}" />
            <jsp:param name="admin" value="${user.role}" />
        </jsp:include>


        <jsp:include page="fragment/_footer.jsp"/>


        <a href="form" methods="get">Retour</a>

    </body>
</html>
