<%-- 
    Document   : myAccount
    Created on : Aug 28, 2022, 11:02:57 AM
    Author     : AS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
    
<div class="container row"  style="background-color: rgba(137, 137, 40, 0.837);margin-left: auto; margin-right: auto; margin-top: 20px;padding-left: 0px;padding-right: 0px;" >
    <div  class="col-md-3" style="padding: 20px;" >
    <c:if test="${sessionScope.user.img == '' }">
            <img src="img/Lancer.(Fate.Grand.Order).full.2352882.jpg" alt="" class="img-fluid rounded-circle" >

    </c:if>
    <c:if test="${sessionScope.user.img != ''}">
        <img src="${sessionScope.user.img}" class="img-fluid rounded-circle" />
    </c:if>
    
     <form action="uploadImg" enctype="multipart/form-data" method="post" id="avatar">
        <input value="${user.uID}" hidden/>
    <input style="" class="form-control" type="file" name="UserImg" onchange="changeImg()" /> 
    </form>
        <script>
            function changeImg(){
                document.getElementById("avatar").submit();
            }
            
        </script>
    </div>

    <div class="col-md-9">
      <table class="table table-hover table-striped" style="margin-top: 32px;">
        <tr> <th> User Name:  </th> <th> ${user.user} </th> </tr>
        <tr> <th> Password:  </th> <th> ${user.pass} </th> </tr>
        <tr> <th> Email:  </th> <th> ${user.email} </th> </tr>
        <tr> <th> Role:  </th> <th> ${user.isAdmin == 1 ? "Admin":"User"} </th> </tr>

      </table>
    </div  >

    <button class="btn btn-danger text-capitalize col-md-6 " > <a href="loadSaved?uID=${user.uID}" class="text-decoration-none" style="color: white;" > Saved Lightnovel </a></button>
    <button class="btn btn-success text-capitalize col-md-6" > <a href="loadMyAccount" class="text-decoration-none" style="color: white;"> History </a></button>





  </div>   


  <div class="container row"  style="background-color: rgba(137, 137, 40, 0.837);margin-left: auto; margin-right: auto; margin-top: 20px;padding-left: 0px;padding-right: 0px;" >
  <h2 style="margin-bottom: 40px;" > ${mess} </h2>

  <!-- item -->
  <c:forEach items="${requestScope.history}" var="lh">
<div class="col-md-3" >
    <a href="loadCateForLightnovel?nid=${lh.nid}" class="text-decoration-none" style="color:black ;" data-bs-toggle="tooltip" data-bs-placement="right" title="${lh.des}"  >
    <img src="${lh.img}" alt="" class="img-fluid" style="border: 4px solid rgb(5, 0, 0) ;">
    <div class="nameItem text-center">
        <h5> ${lh.name}</h5>

    </div>
    </a>
        <c:if test="${requestScope.delete!=null}">
    <div class="text-center"style="margin-bottom: 10px">
        <a href="deleteSaved?nid=${lh.nid}" class="text-decoration-none" style="color: white" >  <button class="btn btn-danger" > ${delete} </button></a>
    </div>
        </c:if>
</div>
</c:forEach>











</div>
    
    
<jsp:include page="footer.jsp"></jsp:include>