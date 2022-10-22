<%-- 
    Document   : forgot
    Created on : Aug 17, 2022, 12:41:05 PM
    Author     : AS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="forgot" style="font-size: 20px; text-align: center">
            <button style="font-size: 20px; margin-bottom: 10px; background-color: black" >   <a href="login.jsp"style="text-decoration: none; color: greenyellow; text-transform:  uppercase"> back to login </a></button>
            <br>
            Enter your email : <input type="text" name="email" required >
            <br/>
            <input type="submit" value="find password" style="font-size: 20px; margin-top: 10px; background-color: green;color: white; text-transform: uppercase "/>
            <p style="font-size: 20px" > ${error}  </p>
            <p style="font-size: 20px" > ${mess}  </p>
        </form>
    </body>
</html>
