<%--
  Created by IntelliJ IDEA.
  User: probal
  Date: 20-Dec-20
  Time: 12:31 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>USER</title>
</head>
<body>
<h3>USER PAGE</h3>
<button><a href="<c:url value="/" />">Home</a></button>
<button><a href="<c:url value="/admin" />">Admin</a></button>
<c:if test="${not empty message}">
    <h1>${message}</h1>
</c:if>
<button><a href="<c:url value="/logout" />">Logout</a></button>
</body>
</html>