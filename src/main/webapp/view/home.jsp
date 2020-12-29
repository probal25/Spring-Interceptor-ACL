<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>HOME</title>
</head>
<body>
<h3>HOME PAGE</h3>
<%--<button><a href="<c:url value="/" />">Home</a></button>--%>
<button><a href="<c:url value="/admin" />">Admin</a></button>
<button><a href="<c:url value="/user" />">User</a></button>
<c:if test="${not empty message}">
    <h1>${message}</h1>
</c:if>
<button><a href="<c:url value="/logout" />">Logout</a></button>
</body>
</html>