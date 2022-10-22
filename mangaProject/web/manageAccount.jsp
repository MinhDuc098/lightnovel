<%-- 
    Document   : manager
    Created on : Jun 9, 2022, 2:37:58 PM
    Author     : AS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">



<section class="jumbotron text-center"style="background-color: rgba(137, 137, 40, 0.837)">
    <div class="container" >
        <h1 class="jumbotron-heading">MANAGER ACCOUNT</h1>
     </div>
</section>

<div class="container mb-4">
    <h3 style="color: red"> Banned Account </h3>
    <table class="table table-hover">
        <thead>
            <tr>
                <th> id </th>
                <th> user name </th>
                <th> email </th>
                <th> password </th>
                <th> isAdmin </th>
                <th> isUser </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.listBan}" var="d">
            <tr>
                            <td> ${d.uID} </td>
                            <td>${d.user} </td>
                            <td> ${d.pass} </td>
                            <td>${d.email}</td>
                            <td> ${d.isAdmin==1?"true":"false"} </td>
                          
                            <td> ${d.isUser==1?"true":"false"} </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
   
    <h3 style="margin-top: 60px; color: green"> All Account:  </h3>
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col"> id </th>
                            <th scope="col">user name</th>
                            <th scope="col">email</th>
                            <th scope="col">password</th>
                            <th scope="col">isAdmin</th>
                            <th scope="col" class="text-right">isUser</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                            <c:forEach items="${requestScope.account}" var="d">
                        <tr>
                            <td> ${d.uID} </td>
                            <td>${d.user} </td>
                            <td> ${d.pass} </td>
                            <td>${d.email}</td>
                            <td> ${d.isAdmin==1?"true":"false"} </td>
                          
                            <td class="text-right"> ${d.isUser==1?"true":"false"} </td>
                            <td class="text-right"> <a href="banAccount?uID=${d.uID}" > <button class="btn btn-sm btn-danger" > Ban This Account </button></a> </td>
                            <td class="text-right"> <a href="removeBan?uID=${d.uID}" > <button class="btn btn-sm btn-primary" > Remove ban </button></a> </td>
                           
                        </tr>
                        
                       
                            </c:forEach>
                        
                        
                        
                                               
                       
                        
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-12">
                    <a href="signupForAdmin.jsp" >    <button class="btn btn-lg btn-block btn-success text-uppercase" style="margin-bottom: 10px" > create new Admin Account</button></a>
                    <a href="loadLightnovel">    <button class="btn btn-lg btn-block btn-success text-uppercase"> back to home</button></a>
                </div>
                
            </div>
        </div>
    </div>
    
</div>


    
<jsp:include page="footer.jsp"></jsp:include>


