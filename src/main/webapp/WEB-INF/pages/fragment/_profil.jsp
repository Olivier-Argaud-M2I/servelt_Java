
<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 27/07/2022
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    Bienvenue ${user.prenom} ${user.nom}
</div>
<div>
    Votre mail est : ${user.mail}
</div>

<div>
    Adresse du serveur : <%= request.getHeader("origin") %>
</div>

<div>
    Informations sur notre navigateur : ${ nav }
</div>