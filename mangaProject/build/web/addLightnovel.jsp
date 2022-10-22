<%-- 
    Document   : addLightnovel
    Created on : Aug 21, 2022, 10:13:38 PM
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
        <form action="addLightnovel" method="post">
            
            enter name: <input name="name" required />
            <br>
            otherName: <input name="othername" />
            <br><!-- comment -->
            image: <input name="img" required/>
            <br><!-- comment -->
            describle: <textarea name="des">  </textarea>
            <br><!-- comment -->
            status: 
            <select name="status" >
                <option value="done" > done </option>
                <option value="not done" > not done </option>
            </select>
            <br><!-- comment -->
            <c:forEach items="${requestScope.listc}" var="lc">
                <input type="checkbox" value="${lc.cid}"  name="category" > ${lc.cname}
                <br>
            </c:forEach>
                <input type="submit" value="submit"/>
        </form>
    </body>
</html>
