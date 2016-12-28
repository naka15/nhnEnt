
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
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<%-- <script src="<%=request.getContextPath()%>/resources/js/*"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/*"
	type="text/css">
<script
	src="<%=request.getContextPath()%>/resources/js/ie8-responsive-file-warning.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/ie-emulation-modes-warning.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/*"></script>


	
	
	
	
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	type="text/css">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css.map"
	type="text/css">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	type="text/css">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.css"
	type="text/css">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.css.map"
	type="text/css">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.min.css.map"
	type="text/css"> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board2-1</title>
</head>

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
   <br><br>


   <!-- 글쓰기 버튼 부분 테이블 -->
   
    <div align="right">
    <img src="<%=request.getContextPath()%>/resources/img/svgs/fi-pencil.svg" width="30" height="30"
    style="margin-right:20px; margin-bottom: 10px" onclick="location.href='${pageContext.request.contextPath}/boardWrite.do';"></div>
   
   
   <!-- 게시판 테이블 시작 -->
   <table  class="table table-hover" style="font-size: 15px; text-align:justify; "  cellpadding="0" align="center"
      cellspacing="0">

      <tr class="danger">
         <th align="center">번호</th>
         <th>이미지</th>
         <th>장르</th>
         <th>제목</th>
         <th>작성자</th>
         <th>기부방법</th>
         <th>작성일</th>
         <th>조회수</th>
         <th>지역</th>
      </tr>
      <c:forEach items="${notice}" var="notice">
         <tr bgcolor="${notice.noticeStatus=='1'?'#ffffff':notice.noticeStatus=='2'?'#f5f5f5':'#e0e0e0'}">
            <td>${notice.noticeNo}</td>
            
            <td><img
               src="<%=request.getContextPath()%>/resources/bookImg/${notice.bookPic}" width="80"
               height="100"> <!-- {$book.bookimg}  --></td>

            <td>
               ${notice.bookGenre}
            </td>


            <td>
               <a href="boardRead.do?noticeNo=${notice.noticeNo}">
               ${notice.noticeTitle}</a>
            </td>

            <td>
               ${notice.userNick}
            </td>

            <td>${notice.noticeMethod}</td>

            <td>
               ${notice.noticeDate}
            </td>
            <td>
               ${notice.noticeCount}
            </td>
            <td>${notice.noticeLocation }</td>
         
         </tr>
      </c:forEach>
      <tr height="1" bgcolor="#eeeeee">
         <td colspan="8"></td>
      </tr>

   </table>

<!-- 검색, 상세검색 부분 -->

<form action="board2-1.do" method="get" >
     <div class="col-lg-8">
   <div id="list_search" style="display: block;" align="right">
       <input type="hidden" name="genre" value="${genre}">
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
     <!--     <li><input type="button" 
            onclick="document.getElementById('detailSearch').style.display = 'block';"
            value="상세검색▼"></li> -->

      
   </div>
   </div>
   </div>
</form>

   <br>
<br><br>
   <!-- paging 페이징 부분 -->

   <div align="center" >
       <span> <jsp:include page="paging.jsp"
            flush="true">
            <jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
            <jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
            <jsp:param name="startPageNo" value="${paging.startPageNo}" />
            <jsp:param name="pageNo" value="${paging.pageNo}" />
            <jsp:param name="endPageNo" value="${paging.endPageNo}" />
            <jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
            <jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
            <jsp:param name="searchtext" value="${searchtext}"/>
            <jsp:param name="searchtext" value="${searchopt}"/>
            <jsp:param name="genre" value="${genre}"/>
            <jsp:param name="str" value="${str}"/>
         </jsp:include>

      </span> 
   </div>

   <!-- 상세 검색 -->

   <!-- <div id="detailSearch" style="display: none;" align="right">
      <table style="font-size: 12px;" class="table table-condensed"
         width="600px" summary="">
         <tr align="left">
            <th width="20%">게시물 제목</th>
            <td colspan="3" width="80%"><input style="width: 95%;"
               type="text" name=""></td>
         </tr>
         <tr align="left">
            <th width="20%">책 제목</th>
            <td width="40%"><input style="width: 95%;" id="search"
               type="text" name=""></td>
            <th width="15%">작성자</th>
            <td width="25%"><input style="width: 84%;" id="search"
               type="text" name=""></td>
         </tr>
         <tr align="left">
            <th width="20%">등록일자</th>
            <td width="40%"><input style="width: 42%;" type="text" name="">
               ~ <input style="width: 42%;" type="text" name=""></td>
            <th width="15%">장르</th>
            <td width="25%"><input style="width: 84%;" id="search"
               type="text" name=""></td>
         </tr>
         <tr align="left">
            <th width="20%">기부 방법</th>
            <td width="40%"><input style="width: 95%;" type="text" name=""></td>
            <th width="15%">기부 지역</th>
            <td width="25%"><input style="width: 84%;" type="text" name=""></td>
         </tr>
         <tr align="left">
            <td colspan="4" align="right"><input type="button"
               class="button1" value="검색"> <input type="button"
               class="button1" align="top"
               onclick="document.getElementById('detailSearch').style.display = 'none';"
               value="닫기"></td>
         </tr>
      </table>
      <div class="closeButton_table"></div>
   </div> -->
</html>