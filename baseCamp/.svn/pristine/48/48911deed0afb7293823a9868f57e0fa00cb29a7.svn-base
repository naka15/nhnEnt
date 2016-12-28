
<%@page import="javax.swing.text.Document"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String[] selected={"","",""};
String searchopt=request.getParameter("searchopt");
if(searchopt!=null && searchopt.equals("title")){
selected[0]="selected";
}else if(searchopt!=null && searchopt.equals("content")){
   selected[1]="selected";
}else if(searchopt!=null && searchopt.equals("user")){
   selected[2]="selected";
}
%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/*.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>



<title>요청게시판</title>
</head>
<script language="JavaScript">
	
</script>
<style>

/* unvisited link */
a:link {
	color: #000000;
}

/* visited link */
a:visited {
	color: purple;
}

/* mouse over link */
a:hover {
	color: #FF00FF;
}

/* selected link */
a:active {
	color: #0000FF;
}

table {
	border-collapse: collapse;
}

tr.topbottomsolid {
	background: #eeeeee;
	border-bottom: 1px solid #C2C2C2;
	border-top: 1px solid #C2C2C2;
	height: 40px;
}
/* 게시물 밑부분 점선 주기 */
tr.last {
	border-bottom: 0.5px dotted;
}

/* 화면 하단 검색 div css */
#list_search {
	width: 100%;
}

#list_search ul li {
	display: inline;
	font-weight: bold;
}

#list_search li {
	margin-right: 10px;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="mainmenu_bar.jsp"></jsp:include>


    <div align="right">
    <img src="<%=request.getContextPath()%>/resources/img/svgs/fi-pencil.svg" width="30" height="30"
    style="margin-right:20px; margin-bottom: 10px" onclick="location.href='${pageContext.request.contextPath}/requestNotice.do'">

    </div>

	

	<!-- 게시판 테이블 시작 -->
	<table class="table table-hover" >
		<tr class="danger" align="center">
			<th>번호</th> 
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${request}" var="request">
			<tr align="left" >

				<td>${request.rqNo}</td>
				<td><a href="requestRead.do?rqNo=${request.rqNo}" >${request.rqTitle}</a></td>
				<td>${request.userNick}</td>
				<td>${request.rqDate}</td>
				<td>${request.rqCount}</td>
		
			</tr>
		</c:forEach>


	</table>

	<!-- 검색 시작 -->

	<form action="request_notice.do" method="get">
		<div id="list_search" style="display: block;" align="right">

			 <div class="row">
    
     <div class="col-lg-2">
     <select name="searchopt"  class="form-control input-sm" style="margin-left: 10%">
               <option value="title" <%=selected[0]%>>제목</option>
               <option value="content" <%=selected[1] %>>내용</option>
               <option value="user" <%=selected[2] %>>글쓴이</option>
         </select>
         </div>
     <div class="col-lg-4">
    <input type="text" id="search" name="searchtext" class="form-control" placeholder="search keyword.."
            value="" />
     </div>
       <div class="col-lg-2">
         <input type="submit" value="검색" class="btn btn-danger" ></div>

		</div>
		</div>
	</form>
	<br>
	<!-- 검색 끝 -->
	<!-- paging 페이징 시작 -->
	<div align="center">
		<span> <jsp:include page="paging.jsp" flush="true">
				<jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
				<jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
				<jsp:param name="startPageNo" value="${paging.startPageNo}" />
				<jsp:param name="pageNo" value="${paging.pageNo}" />
				<jsp:param name="endPageNo" value="${paging.endPageNo}" />
				<jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
				<jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
				<jsp:param name="searchtext" value="${searchtext}" />
				<jsp:param name="searchtext" value="${searchopt}" />
				<jsp:param name="str" value="${str}"/>
			</jsp:include>

		</span>
	</div>
	<!-- paging 끝 -->
	</div>
</html>