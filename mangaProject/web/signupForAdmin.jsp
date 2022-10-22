<%-- 
    Document   : signupForAdmin
    Created on : Aug 21, 2022, 5:13:36 PM
    Author     : AS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sign Up For Admin</h1>
        <h3> ${mess} </h3>
        <form action="signupForAdmin">
            username: <input name="user"/>
            <br><!-- comment -->
            password: <input name="pass"/>
            <br>
            email: <input name="email" type="email" />
            <br>
            <input type="submit" value="signup"/>
  `      </form>
    </body>
</html>
