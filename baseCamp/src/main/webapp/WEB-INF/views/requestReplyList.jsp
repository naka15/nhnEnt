<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap.css"
	type="text/css">
<link href='http://fonts.googleapis.com/css?family=Ubuntu'
	rel='stylesheet' type='text/css'> --%>
	<style type="text/css">


.border{
    border: 0px solid #a1a1a1;
    padding: 30px 30px; 
    background: #f2dede;
   
    border-radius: 0px;
}
</style>

	<div class="row">
			
			    <div class="col-lg-12" id="cmtTarget">
			
			<c:forEach var="item" items="${rqrplist}">
 <div class="border">
 <h4>${item.userId} : ${item.rqrp_content}</h4>
  <h5 ${item.rqrp_content}>${item.rqrp_date}</h5>
  <c:if test="${sessionScope.userDTO.userId==item.userId}">
  <div align="right">
						     <input type="button" id="deleteBtn" value="삭제"
						        onclick="doDeleteCmt(${item.rqrp_no})"  class="btn btn-danger sm">
						<input type="hidden" id="writerRqrp_no" value="${item.rqrp_no}">
							<input type="hidden" id="writeRqNo" value="${item.rqNo}">
							<input type="hidden" id="writeRuserId" value="${item.userId}"></div>
						</c:if>
 
 
 </div>			
			
			<br>
			</c:forEach>
			
			
			
			</div>
			
			</div>
	
	

	<%-- <div id="cmtTarget">
	<c:if test="${rqrplist!=null}"> 
				<c:forEach var="item" items="${rqrplist}">
				
				<li class="commentlist">
						
						
						<span>작성자 : </span> 
					 	<span><label>${item.userId}</label></span> 
						<span>날짜 : </span> 
						<span><label>${item.rqrp_date}</label></span>
					
						<div style="float: right">
						<c:if test="${sessionScope.userDTO.userId==item.userId}">
						      <input type="button" id="deleteBtn" value="삭제"
						      onclick="doDeleteCmt(${item.rqrp_no})"/> 
							<input type="hidden" id="writerRqrp_no" value="${item.rqrp_no}">
							<input type="hidden" id="writeRqNo" value="${item.rqNo}">
							<input type="hidden" id="writeRuserId" value="${item.userId}">
						</c:if>
						</div>
							
							<p class="table_font">${item.rqrp_content}</p>
							<div class="hr_tag"></div>
							
					</li>
		 	 
				</c:forEach>
				</c:if>
			</div> --%>
		 

			<br>
			<br>
