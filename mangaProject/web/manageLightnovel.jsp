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
<style>
    .actively{
                background-color: red;

    }
</style>


<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">MANAGER LIGHTNOVEL</h1>
     </div>
</section>


    
    


<div class="container mb-4">
    
    
    
    <div class="text-right">
        <a href="loadCate">    <button class="btn btn-lg btn-success ">ADD NEW LIGHTNOVEL  </button></a>
</div>
    
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"> id </th>
                            <th scope="col">image</th>
                            <th scope="col">Name</th>
                            <th scope="col">Status</th>
                            
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                            <c:forEach items="${requestScope.listll}" var="d">
                        <tr>
                            <td> ${d.nid} </td>
                            <td><img src="${d.img}" style="width: 100%;height: 230px" /> </td>
                            <td>${d.name}</td>
                            <td>${d.status}</td>
                          
                            <td class="text-right"> <a href="deleteLightnovel?nid=${d.nid}"> <button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i>  Delete </button></a> </td>
                            <td class="text-right"> <a href="updateLightnovel?nid=${d.nid}"> <button class="btn btn-sm btn-danger"><i class="fa fa-pencil"></i> update  </button></a> </td>
                            <td class="text-right"> <a href="updateChapter?nid=${d.nid}"> <button class="btn btn-sm btn-danger"><i class="fa fa-pencil"></i> update chapter  </button></a> </td>
                        </tr>
                        
                                               
                            </c:forEach>
                       
                        
                    </tbody>
                </table>
            </div>
        </div>
        
    </div>
    
        <div class="text-right" style="margin-bottom:10px;display: block" >
        <c:forEach begin="1" end="${endPage}" var="e" >
            <button class="btn btn-secondary ${requestScope.tag == e?"actively":""}" > 
            <a href="manageLightnovel?index=${e}" class="text-decoration-none text-center active" style="color: white"> ${e} </a>
            </button>
           
        </c:forEach>
            
        </div>
        
        <div class="col mb-12">
            <div class="row">
                <div class="col-sm-12  col-md-12" style="padding: 0px">
                    <a href="loadLightnovel">    <button class="btn btn-lg btn-block btn-success text-uppercase"> back to home</button></a>
                </div>
                
            </div>
        </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>


