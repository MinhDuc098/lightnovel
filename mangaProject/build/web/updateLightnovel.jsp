<%-- 
    Document   : updateLightnovel
    Created on : Aug 23, 2022, 6:23:33 PM
    Author     : AS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="display: flex; align-content: center;justify-content: center"  >
            <form action="updateLightnovel" method="post">
            lightnovel ID: <input readonly value="${lightnovel.nid}" style="width: 300px" name="id" />
            <br>
            lightnovel name: <input value="${lightnovel.name}" style="width: 300px" name="name" />
            <br>
            otherName: <input name="othername"  value="${lightnovel.otherName}" style="width: 300px" />
            <br><!-- comment -->
            image: <input name="img" value="${lightnovel.img}" required/>
            <br><!-- comment -->
            describle: <textarea name="des" style="width: 300px;height: 100px"> ${lightnovel.des}  </textarea>
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
            <button type="submit" class="btn btn-danger" > Update  </button>
            <br>
        </form>
             <a href="manageLightnovel" style="text-decoration: none; color: black"> <button>cancel</button></a>  

        </div>
    </body>
</html>
