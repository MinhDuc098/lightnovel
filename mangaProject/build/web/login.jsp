<%-- 
    Document   : login
    Created on : Aug 15, 2022, 5:09:11 PM
    Author     : AS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


<body style="background-color: rgba(15, 236, 15, 0.896) ;">
    




    <div style="background-color: rgb(255, 247, 247); border-right: 20px solid black; margin: 10% 30%; padding: 40px;" id="login" >
    <h1 class="text-center"> Login </h1>
    
    <!-- mess when username and password is incorrect  -->
    
    <p class="text-center text-uppercase" style="color: red" >  ${mess} </p>
    
    <form action="login" style="width: 70%; margin-left: auto; margin-right: auto;">

        <div style="padding-top: 10px;">
        <label for="username" class="text-capitalize"> username </label>
        <input type="text" id="username" name="user" class="form-control" style="margin-top: 10px ;" >
        </div>

        <div style="padding-top: 10px;">
        <label for="password" class="text-capitalize"> password </label>
        <input type="password" id="password" name="pass" class="form-control" style="margin-top: 10px;">
        </div>
        

        <div class="text-end " style="padding-top: 10px;">
        <a href="forgot.jsp" class="text-decoration-none"> Forgot Password?  </a>
        </div>


        <div class="d-grid" style="padding-top: 20px;">
        <button type="submit" class=" btn btn-secondary btn-block text-uppercase"  > login </button>
        </div>

        
    </form>
            <div class="d-grid" style="padding-top: 10px; width: 70%; margin-left: auto; margin-right: auto;">
            <button  class=" btn btn-info btn-block text-uppercase" onclick="register()"  > Register </button>
            </div>
            <div class="d-grid" style="margin-top: 10px; width: 70%; margin-left: auto; margin-right: auto;">   
                <button type="button" class="btn btn-primary btn-block text-uppercase"  > <a href="loadLightnovel" style="text-decoration: none;color: black"> Access without login </a></button>
            </div>
    </div>
    



    <div style="background-color: rgb(255, 247, 247); border-right: 20px solid black; margin: 10% 30%; padding: 40px; display: none;" id="signup">
        <h1 class="text-center"> Sign up </h1>
        
        
        
        <form action="signup" style="width: 70%; margin-left: auto; margin-right: auto;">

                 <div style="padding-top: 10px;">
                <label for="email" class="text-capitalize"> Email </label>
                <input type="email" id="email" name="email" required class="form-control" style="margin-top: 10px ;"  >
                </div>

                <div style="padding-top: 10px;">
                <label for="username" class="text-capitalize"> username </label>
                <input type="text" id="username" name="user" class="form-control" style="margin-top: 10px ;"  >
                </div>
        
                <div style="padding-top: 10px;">
                <label for="password" class="text-capitalize"> password </label>
                <input type="password" id="password" name="pass" class="form-control" style="margin-top: 10px;" >
                </div>
                
        
                
        
        
                <div class="d-grid" style="padding-top: 20px;">
                <button type="submit" class=" btn btn-secondary btn-block text-uppercase"  > Sign up </button>
                </div>
            <div class="d-grid" style="margin-top: 10px">   
                <button type="button" class="btn btn-primary btn-block text-uppercase"  > <a href="login.jsp" style="text-decoration: none;color: black"> Back to login </a></button>
            </div>
               


        </form>

    </div>


    <!-- js make login form disappear and signup form appear -->
    <script>

        function register(){
            document.getElementById("login").style.display = "none";
            document.getElementById("signup").style.display = "block";
        }

    </script>
</body>
</html>