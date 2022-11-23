<%-- 
    Document   : updateChapter
    Created on : Aug 26, 2022, 12:32:32 AM
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
        <div>
            <div style="display: inline-block">
            <img src="${lightnovel.img}" alt="alt" width="400px" height="400px"/>
            <p style="font-size: 26px; font-weight: bold; margin-left: 40px" > ${lightnovel.name} </p>
            </div>
            <table class="table">
            <c:forEach items="${requestScope.chapter}" var="chapter">
                <tr>
                    <td> ${chapter.chapname} </td>
                    <td> <a href="deleteChapter?chapID=${chapter.chapId}&nid=${lightnovel.nid}" style="text-decoration: none;"> <button> delete chapter</button></a> </td>
                </tr>
            
            </c:forEach>
            </table>
            <form style="margin-top: 40px;  " action="addChapter" method="post" enctype="multipart/form-data">
                <h2 style="font-weight: bold; font-size: 30px" > ADD NEW CHAPTER</h2>
                <input value="${lightnovel.nid}" name="nid" hidden />
                 <br>
                 name of chapter <input type="text" name="name"  />
                 <br><!-- comment -->
                 file of chapter <input name="file" type="file"/>
                 <br>
                 <input type="submit" value="post new Chapter"/>
            </form>
        </div>
                 
                 <button style="width: 80%;height: 100px;margin: 100px"> <a href="manageLightnovel" style="text-decoration: none;color: black;font-size: 40px"> back to manage Lightnovel </a> </button>
                 
    </body>
</html>
