<%@page import="com.twoyears.model.dto.NoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<link rel="stylesheet"
   href="<%=request.getContextPath()%>/resources/css/*"
   type="text/css"><link rel="stylesheet"
   href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.css"
   type="text/css"><link rel="stylesheet"
   href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.min.css"
   type="text/css">

<style type="text/css">
.hr_class{
width: 10%}

.size{
width:70%
}

.border{
    border: 0px solid #a1a1a1;
    padding: 10% 10%; 
    background: #E0F2F7;
   width:140%;
    border-radius: 0px;
}


</style>

<div class="contatiner">
<div class="row">

   <div class=col-lg-12>
    <h2 style="margin-left: 120px">&nbsp;&nbsp;New Donation Books!</h2>
          <h3 style="margin-left: 120px">&nbsp;&nbsp;Click on each image to view!</h3>
          <div class="size">
   <table class="table table-hover" style="margin-left: 10%; margin-right:10%;" >
   <tr class="danger">
    <td colspan="6"></td> 
   </tr>
   <tr>
     <c:forEach items="${boardmainlist}" var="boardmainlist">
   <td>
    <img src="<%=request.getContextPath()%>/resources/bookImg/${boardmainlist.bookPic}.jpg" width="200" height="150" ></img>
        <p align="center" style="text-align: ;"><a href='boardRead.do?noticeNo=${boardmainlist.noticeNo}'> ${boardmainlist.bookSubject}</a></p>
   
   
   </td>
   </c:forEach>
   </tr>
   
   
   </table>
   
   </div>
   

   
   </div>
</div> <!-- row끝 -->

<div class="row"></div>



</div>
<%-- <div class="border">
<div class="container">
<div class="row">
<div class="col-lg-12">
     
   <c:forEach items="${boardmainlist}" var="boardmainlist">
    <div class="col-lg-4" style="margin-left: 20px;">
      
       <img src="<%=request.getContextPath()%>/resources/bookImg/${boardmainlist.bookPic}.jpg" width="200" height="150" ></img>
   <div align="center" style="margin-left: 0px; margin-right: 10px">
        <p align="center" style="text-align: ;"><a href='boardRead.do?noticeNo=${boardmainlist.noticeNo}' style="margin-left: 60px; margin-top: 800px;
                   margin-bottom: 10px;"> ${boardmainlist.bookSubject}</a></p>
      
     </div> 
     
  </div><!-- column끝 -->
   </c:forEach>
    
      <h4><a href="board2-1.do">&nbsp;&nbsp;Read More »</a></h4>
      
      
    
    
</div>
   </div>  <!-- row끝 -->  


</div>

</div> --%>
<%-- 
   <div class="container">
<div class="row">

<div class="col-lg-12">
        <div class="col-lg-4" style="margin-left: 20px;">
        
        
          <h2>&nbsp;&nbsp;New Donation Books!</h2>
          <h3>&nbsp;&nbsp;Click on each image to view!</h3>
          
     

   <c:forEach items="${boardmainlist}" var="boardmainlist">
   <div class="border">
      <div class="col-sm-8"> 
      
    <div class="thumbnail">
       <img src="<%=request.getContextPath()%>/resources/bookImg/${boardmainlist.bookPic}.jpg" width="400" height="300" ></img>
   <div align="center" style="margin-left: 0px; margin-right: 10px">
        <p align="center" style="text-align: ;"><a href='boardRead.do?noticeNo=${boardmainlist.noticeNo}' style="margin-left: 60px; margin-top: 800px;
                   margin-bottom: 10px;"> ${boardmainlist.bookSubject}</a></p>
      
     </div> 
    </div>
</div>
</div>   </c:forEach>
    
      <h4><a href="board2-1.do">&nbsp;&nbsp;Read More »</a></h4>
  </div>

         
    
    
    
           
   </div>  
   
   
   
   
   
   </div>  <!-- row끝 -->  
   </div>       --%>
           
          
        <%-- 
                 <c:forEach items="${boardmainlist}" var="boardmainlist">
                   <div class="row">
                      <div class="col-sm-2">
                         <img src="<%=request.getContextPath()%>/resources/bookImg/${boardmainlist.bookPic}.jpg" 
                               width="100" height="100" style="margin-left: 20px;"></img>
                      </div>
                      <div><br><br>
                   <h5 ><a href='boardRead.do?noticeNo=${boardmainlist.noticeNo}' style="margin-left: 60px; margin-top: 800px;
                   margin-bottom: 10px;"> ${boardmainlist.bookSubject}</a></h5>
                    </div>
                   
                 </div>   
                  
                <hr/>
                 </c:forEach>
          <hr>
          
       
          
   
          
  <hr class="hr_class">       
          
          </div>
          
          
           <div class="col-lg-4">
          
                  <img src=""
                  alt="slide image" width="300" height="465">
          
          </div>
          
          
          
          
          <div class="col-lg-3">
          
                    <h2>New Donation Books!</h2>
          <h3>Click on each image to view!</h3>
          
          <c:forEach items="${ranklist}" var="ranklist">
                   <!-- <div class="row">
                      <div class="col-sm-2"> -->
                        <h4>닉네임 :  ${ranklist.userNick}</h4> 
            <!--           </div> -->
        <!--               <div> -->
                   <h4>얻은 포인트 : ${ranklist.userPoint}</h4>
           <!--          </div> -->
                   
           <!--       </div>  -->  
                  
                <hr/>
                 </c:forEach>
          <hr>
          
          </div>


<!-- 
   </div>
 -->
 --%>