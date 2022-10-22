<%-- 
    Document   : header
    Created on : Aug 16, 2022, 12:32:33 AM
    Author     : AS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

  <script src="javascript.js" ></script>
</head>

<style>
    .category:hover{
       opacity: 0.4;
       
    }
    .btn-secondary:hover{
        opacity: 0.4;
        color: white;
    }
    .actively{
        background-color: red;
    }
    
    
</style>

    <body style="background-color: black ;">
    
    

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

            <div class="container">
                <a class="navbar-brand" href="loadLightnovel" style="font-weight:bolder;"> <h1> MangaD</h1> </a>


                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>


                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        
                        <li class="nav-item dropdown" style="padding: 20px;" >
                            <a class="nav-link dropdown-toggle" data-bs-toggle ="dropdown" href="#">Category</a> 
                            
                            <ul class="dropdown-menu">
      
    
                            <c:forEach items="${requestScope.listc}" var="lc">
                                
                                <li style="background-color: black;" ><a class="dropdown-item " href="loadCategory?cid=${lc.cid}" style="color: greenyellow; ">${lc.cname}</a></li>
                               
                                
                            </c:forEach>
                            </ul>
                        </li>
                         
                        
                        <c:if test="${sessionScope.user == null}">
                        <li class="nav-item" style="padding: 20px;"><a class="nav-link" href="login.jsp"> Login </a></li>
                        </c:if>
                        
                        
                        
                        <c:if test="${sessionScope.user != null}">
                        <li class="nav-item"  style="padding: 20px;"><a  class="nav-link" href="loadMyAccount">  My Account</a></li>
                        <li class="nav-item" style="padding: 20px;"><a  class="nav-link" href="logout"> Log out</a></li>
              
                        <c:if test="${sessionScope.user.isAdmin == 1}">
                        <li class="nav-item" style="padding: 20px;"><a  class="nav-link" href="manageLightnovel"> manage lightnovel</a></li>
                        <li class="nav-item" style="padding: 20px;"><a  class="nav-link" href="manageAccount"> manage Account</a></li>
                       
                        </c:if>
                        
                        </c:if>
                    </ul>


                    <form class="d-flex"action="search"method="post" >
                        <!-- 
                        <select name="" id="" class="form-control">search by
                            <option value="author"> author </option>
                            <option value="name"> name </option>
                            <option value="year"> year of publish </option>
                         </select>
                        -->

                        <input class="form-control me-2" type="text" name="name" placeholder="Search" id="search">
                   
                        <button class="btn btn-danger" type="submit">Search</button>
                    </form>


                </div>

            </div>

            </nav>
