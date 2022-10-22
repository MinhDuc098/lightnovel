<%-- 
    Document   : home
    Created on : Aug 15, 2022, 5:03:24 PM
    Author     : AS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="main">

    <div class="slide" style="background-color: rgba(137, 137, 40, 0.837);margin-top: 40px;">
                <!-- Carousel -->
                <div id="demo" class="carousel slide" data-bs-ride="carousel">

    <!-- Indicators/dots -->
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
      <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
      <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    </div>
  
    <!-- The slideshow/carousel -->
    <div class="carousel-inner">
        <div class="carousel-item active">
        <img src="img/1196072.jpg" alt="Los Angeles" class="mx-auto d-block img-fluid">
        </div>

        <div class="carousel-item">
        <img src="img/scathath.png" alt="Chicago" class="mx-auto d-block img-fluid">
        </div>
        
        <div class="carousel-item">
        <img src="img/thumb-1920-1196400.jpg" alt="New York" class="mx-auto d-block img-fluid">
        </div>
    </div>
  
    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
      <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
      <span class="carousel-control-next-icon"></span>
    </button>
  </div>
</div>


<!--content-->
<div class="content row container" style="background-color: rgba(137, 137, 40, 0.837);margin-top: 40px; margin-left: auto; margin-right: auto;" >
    <!-- content of page -->
    <div class="col-md-9 row" style="padding: 20px; display: flex; align-items:  stretch;" >
       
        <!-- neu click vao category thi se hien category do + lightnovel neu
             chua click thi hien la new light novel -->
        <h4 class="text-capitalize"> 
            <c:if test="${category == null}"> new </c:if> 
            <c:if test="${category != null}"> ${category.cname} </c:if> 
            Lightnovel
        </h4>
        
        
        <!-- can add du lieu vao database  -->
        <!-- item -->
        <c:forEach items="${requestScope.listll}" var="ll" > 
        <div class="col-md-4" >
        <a href="loadCateForLightnovel?nid=${ll.nid}" class="text-decoration-none" style="color:black ;" data-bs-toggle="tooltip" data-bs-placement="right" title="${ll.des}" >
            <img src="${ll.img}" alt="" class="img-fluid" style="border: 4px solid rgb(5, 0, 0) ;">
            <div class="nameItem text-center">
                <h5> ${ll.name} </h5>

            </div>
        </a>
        </div>
                
                
                
        </c:forEach>


        
        <div class="text-end" style="padding: 0px" >
        <c:forEach begin="1" end="${endPage}" var="e" >
            <button class="btn btn-secondary ${requestScope.tag == e?"actively":""}" > 
            <a href="loadLightnovel?index=${e}" class="text-decoration-none text-center active" style="color: white"> ${e} </a>
            </button>
           
        </c:forEach>
            
        </div>
        
        <div class="text-end" style="margin: 10px" >
        <c:forEach begin="1" end="${end}" var="d" >
            <button class="btn btn-secondary ${requestScope.t == d?"actively":""}" > 
            <a href="loadCategory?index=${d}&cid=${cid}" class="text-decoration-none text-center active" style="color: white"> ${d} </a>
            </button>
           
        </c:forEach>
            
        </div>
    
        
        
    </div>

    <!-- end item -->

    <!-- category of lightnovel -->
    <div class="col-md-3 row" style="padding: 20px; height: max-content; " >

        <h4 class="text-capitalize" > categories </h4>
        
        <c:forEach items="${requestScope.listc}" var="lc">

        <div class="col-md-6 ">
            <a href="loadCategory?cid=${lc.cid}" class="text-decoration-none category" style="color: black">
            ${lc.cname}
            </a>
        </div>
        </c:forEach>
        
    </div>

</div>
      

</div>

<jsp:include page="footer.jsp"></jsp:include>