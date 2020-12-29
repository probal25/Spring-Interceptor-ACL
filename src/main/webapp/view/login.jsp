<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div>
    <h4>LOGIN</h4><br>
    <form action="/login_user" method="post">
        <div>Username<input type="text" name="userName" value=""></div>
        <div>Password<input type="password" name="userPassword" value=""></div>
        <div><input type="submit" value="Login"></div>
        <div><input type="button" value="Register"></div>
    </form>
</div>

</body>
</html>