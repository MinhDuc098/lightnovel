<%-- 
    Document   : lightnovel
    Created on : Aug 18, 2022, 10:23:18 PM
    Author     : AS
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


            <div class="content row container" style="padding: 0px;margin-top: 40px; margin-left: auto; margin-right: auto;" >

                <div class="col-md-9 row" style="padding: 0px; background-color: rgba(137, 137, 40, 0.837);margin-right: 10px;" >

                    <div class="col-md-4" >

                        <img src="${lightnovel.img}" alt="" class="img-fluid" style="padding: 15px ;">
                        
                        <div style="padding: 10px; text-align: center;"  >
                            <button class="btn btn-danger text-capitalize" ><a href="${chapter.get(0).file}" style="text-decoration: none; color: white"> first chapter</a> </button>
                            <button class="btn btn-success text-capitalize " > <a href="${chapter.get(chapter.size()-1).file}" style="text-decoration: none;color: white"> last chapter</a> </button>
                            <!-- need fix -->
                            <button class="btn btn-secondary " style="margin-top: 15px"> <a href="saveLightnovel?nid=${lightnovel.nid}" style="color: black; text-decoration: none"> Save this Lightnovel </a> </button>
                        </div>
                     </div>

                     <!-- info -->
                    <div class="col-md-8" >

                        <h2 class="text-capitalize" style="font-weight:bolder;font-size: 40px;"> ${lightnovel.name} </h2>

                        <p class="text-capitalize" style="font-weight: bold;display: inline-block;" >  another name: </p> <p style="display: inline;"> ${lightnovel.otherName} </p>
                        
                        <p class="text-capitalize" style="font-weight: bold;"> last time update: 2 day   </p>


                        <p class="text-capitalize" style="font-weight: bold;"> category: 
                            
                            <c:forEach items="${requestScope.category}" var="cate" end="${category.size()-2}"> 
                                <a href="loadCategory?cid=${cate.cid}" class="text-decoration-none category" style="color: black" > ${cate.cname}</a>, 
                            </c:forEach> 
                                <a href="loadCategory?cid=${category.get(category.size()-1).cid}" class="text-decoration-none category" style="color: black"> ${category.get(category.size()-1).cname} </a> </p> 

                        <p class="text-capitalize" style="font-weight: bold;display: block;"> author: N/A</p>

                        <p class="text-capitalize" style="font-weight: bold;display: block;"> status:  ${lightnovel.status}</p>
                        <!-- description -->
                        <div>
                            <details>
                            <summary class="text-capitalize" style="font-size: 29px;font-weight: 500;">summary</summary>
                           ${lightnovel.des}
                            </details>
                     </div>

                    </div>


                </div>

                <div class="col-md-3 row" style="background-color: rgba(235, 185, 17, 0.614); margin-left: 10px;" >
                    <h4 class="text-capitalize" > categories </h4>
                    <c:forEach items="${requestScope.listc}" var="lc" >
                    <div class="col-md-4">
                        <a href="loadCategory?cid=${lc.cid}" class="text-decoration-none category" style="color: black">
                        ${lc.cname}
                        </a>
                    </div>
                    </c:forEach>
                    
                    
                </div>

               
                <div class="col-md-9 row"  style="padding: 0px; background-color: gray;margin-right: 10px; margin-top: 20px;" >
                <p style="font-size: 25px;"> List chapter </p>
                  
                <table class="table table-hover table-striped">
                    
                    <c:forEach items="${requestScope.chapter}" var="chapter" >
                        <tr>  <td>  <a href="${chapter.file}" class="text-decoration-none" style="color: whitesmoke;">${chapter.chapname}</a>
                                     
                            </td>  <td class="text-end">${chapter.dayUpdate}</td>
                        </tr>
                    </c:forEach>
                    
                </table>
               
              
                    
                </div>

                <div class="col-md-3" style="background-color: rgba(108, 103, 103, 0.574); margin-top: 20px;"  >
                    <p style="font-size: 25px; color: aqua;"> Your Comments </p>

                    <div>
                        <form action="postComment">
                            <input value="${lightnovel.nid}" name="lightnovelId" hidden />
                            <textarea type="text" class="form-control" name="comment"> </textarea>
                        <button class="btn btn-primary " style="margin-top: 10px ;"  type="submit"> Post </button>
                        </form>
                    </div>

                </div>


                <div class="col-md-9 row"  style="padding: 0px; background-color: gray;margin-right: 10px; margin-top: 20px;" >

                    <p style="font-size: 25px; color: aqua;">  Comments </p>

                    <c:forEach items="${requestScope.comment}" var="comment" >
                    <div style=" border: 2px solid white; color: white; margin-bottom: 20px;">
                        <p style="font-weight: bolder; font-size: 20px;color: black;" > ${comment.user.user} :</p>
                        <p> ${comment.comment} </p>
                    </div>
                    </c:forEach>

                </div>

                



                

            </div>





           <jsp:include page="footer.jsp"></jsp:include>

