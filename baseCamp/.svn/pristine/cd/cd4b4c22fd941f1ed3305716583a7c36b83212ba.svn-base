<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap.css"
	type="text/css">
<link href='http://fonts.googleapis.com/css?family=Ubuntu'
	rel='stylesheet' type='text/css'> --%>


<% String cp = request.getContextPath(); 
	System.out.println(cp);%>

<style type="text/css">
hr {
	display: block;
	margin-top: 0.5em;
	margin-bottom: 0.5em;
	margin-left: auto;
	margin-right: auto;
	border-style: inset;
	border-width: 1px;
}

.center {
	margin-left: 15%;
	margin-right: 15%;
	width: 70%;
}

.table_font {
	font-family: 'Ubuntu', sans-serif;
}

.td_bottom_style {
	border-bottom-style: dashed;
	border-width: 1px;
	border-color: red;
}

.center2 {
	margin-left: auto;
	margin-right: auto;
	width: 10%;
}

.commentlist {
	background-color: #eeeeee;
	font-family: 'Ubuntu', sans-serif;
}

.hr_tag {
	display: #eeeeee;
	margin-top: 0.5em;
	margin-bottom: 0.5em;
	margin-left: auto;
	margin-right: auto;
	border-style: inset;
	border-width: 1px;
}
.right_align{
	
}
.imageButton_align {
	
}
</style>



<div class="row">
<div class="col-lg-12">

<div class="form-group">
	<label>Comment:</label>
	<textarea class="form-control" placeholder="댓글을 남겨주세요." id="comment" style="height: 70px;"></textarea>
</div>

	<input type="hidden" id="noticeNo" value="${noticeAll.noticeNo}" />
	 <input type="button" value="확인" align="right" id="createbtn" class="btn btn-danger sm" 
		onclick="doCreateRe();" />
		
 <input type="hidden" id="userid" 
		value="${sessionScope.userDTO.userId}" />


</div>
</div>



<br>
<br>
<br>
<br>
<br>
<br>
