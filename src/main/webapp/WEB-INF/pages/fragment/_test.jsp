<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 27/07/2022
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!-- c:if n'autorise pas le else -->
<div>
<c:if test="${param['age'] lt 18}">
    Vous êtes mineur !
</c:if>
<c:if test="${param['age'] ge 18}">
    Vous êtes majeur !
</c:if>
</div>
<!-- c:choose permet de spécifier autant de c:when que l'on souhaite -->
<div>
<c:choose>
    <c:when test="${param['age'] lt 18}">
        Vous êtes mineur !
    </c:when>
    <c:otherwise>
        Vous êtes majeur !
    </c:otherwise>
</c:choose>
</div>
<div>
<c:choose>
    <c:when test="${param['admin'] == 'admin'}">
        Vous êtes admin !
    </c:when>
    <c:otherwise>
        Vous n'êtes pas admin !
    </c:otherwise>
</c:choose>
</div>
<fmt:formatNumber value="${1024 * 1024}"/>
