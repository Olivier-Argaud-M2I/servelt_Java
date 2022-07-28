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
    <title>Formulaire</title>
    <link rel='stylesheet' type='text/css' href='/coursmaven/resources/styles/style.css'>
</head>
    <body>

        <jsp:include page="fragment/_header.jsp"/>

        <fieldset>
            <legend>Mon formulaire</legend>
            <form action="form" method="post">
                <input type="text" placeholder="Nom" name="nom" >
                <input type="text" placeholder="Prenom" name="prenom" >
                <input type="text" placeholder="Mail" name="mail" >
                <input type="number" placeholder="Age" name="age" >
                <input type="text" placeholder="Role" name="role" >
                <input type="submit" value="Envoyer">
            </form>
        </fieldset>

        <jsp:include page="fragment/_footer.jsp"/>

    </body>
</html>
