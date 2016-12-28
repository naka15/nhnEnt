<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	rel='stylesheet' type='text/css'>--%>


<% String cp = request.getContextPath(); 
	System.out.println(cp);%>

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
			
			<c:forEach var="item" items="${listCmt}">
 <div class="border">
 <h4>${item.userId} : ${item.replyContent} </h4>
  <h5 ${item.replyContent}>${item.replyDate}</h5>
  <c:if test="${sessionScope.userDTO.userId==item.userId}">
  <div align="right">
						     <input type="button" id="deleteBtn" value="삭제"
						      onclick="doDeleteCmt(${item.replyNo});"  class="btn btn-danger sm">
							<input type="hidden" id="writeReplyNo" value="${item.replyNo}">
							<input type="hidden" id="writeNoticeNo" value="${item.noticeNo}">
							<input type="hidden" id="writeuserId" value="${item.userId}"></div>
						</c:if>
 
 
 </div>			
			
			<br>
			</c:forEach>
			
			
			
			</div>
			
			</div>

			
			
			<br>
			<br>