
<%@page import="javax.swing.text.Document"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/jh_bootstrap.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board2-1</title>
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

	<div id="logo" >
		<table width="90%" border="0">
		<tr>
		<td><h1>My favorite</h1></td>
		</tr>
		</table>
	</div>

	<!-- 게시판 테이블 시작 -->
	<table style="font-size: 12px;" width="90%" cellpadding="0" align="center"
		cellspacing="0">

		<tr class="topbottomsolid">
			<th width="5%">번호</th>
			<th width="10%">이미지</th>
			<th width="10%">장르</th>
			<th width="35%">제목</th>
			<th width="10%">작성자</th>
			<th width="10%">기부방법</th>
			<th width="10%">작성일</th>
			<th width="5%">조회수</th>
			<th width="5%">지역</th>
		</tr>
		<c:forEach items="${myfavorite}" var="myfavorite">
			<tr height="25" align="center" class="last" >
				<td align="center">${myfavorite.noticeNo}</td>
				
				<td align="center"><img
					src="<%=request.getContextPath()%>/resources/img/im.jpg" width="80"
					height="100"> <!-- {$book.bookimg}  --></td>

				<td align="center">
					${myfavorite.book.bookGenre}
				</td>


				<td align="left">
					<a href="board22.do"
					target="_blank">${myfavorite.noticeTitle}</a>
				</td>

				<td align="center">
					${myfavorite.userNick}
				</td>

				<td align="center">${myfavorite.noticeMethod}</td>

				<td align="center">
					${myfavorite.noticeDate}
				</td>
				<td align="center">
					${myfavorite.noticeCount}
				</td>
				<td align="center">${myfavorite.noticeLocation }</td>
				<td>&nbsp;</td>
			</tr>
		</c:forEach>
		<tr height="1" bgcolor="#eeeeee">
			<td colspan="8"></td>
		</tr>

	</table>

	<!-- paging 페이징 부분 -->

	<div align="center" >
		 <span>  
    		<a href="/givook/myfavorite.do?pageNo=${paging.prevPageNo}&uesrId=${userId}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-previous.svg" border="0" width=18; height= 18;></a>
   			<span>
        		<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
           			<a href="/givook/myfavorite.do?pageNo=${i}&uesrId=${userId}" class="choice">${i}</a>
        		</c:forEach>
    		</span>
    		<a href="/givook/myfavorite.do?pageNo=${paging.nextPageNo}&uesrId=${userId}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-next.svg" border="0" width=18; height= 18;></a>
		</span> 
	</div>

</html>