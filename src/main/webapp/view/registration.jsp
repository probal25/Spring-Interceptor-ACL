<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Registration Page</title>
<body>
<h4>Registration Page</h4>
<div>
    <form action="/save_user" method="post">
        <div>Full Name<input type="text" name="fullName" value=""></div>
        <div>Username<input type="text" name="userName" value=""></div>
        <div>Password<input type="password" name="userPassword" value=""></div>
        <div>Password(Repeat)<input type="password" name="userPasswordRepeat" value=""></div>
        <div><input type="submit" value="Register"></div>
        <div><input type="button" value="Login"></div>
    </form>
</div>

</body>
</html>