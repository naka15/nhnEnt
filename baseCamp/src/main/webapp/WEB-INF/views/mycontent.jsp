<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet"
   href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
   
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  
  
  
  
<script
	src="<%=request.getContextPath()%>/resources/js/ie8-responsive-file-warning.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/ie-emulation-modes-warning.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/*"></script>

<script
	src="<%=request.getContextPath()%>/resources/js/ie10-viewport-bug-workaround.js"></script>
	
	
	
	
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
	type="text/css">

<style type="text/css">

table, td, th {
    border: 1px solid black;
}

table {
    width: 100%;
}

th {
    height: 50px;
}
.width {
   width: 90%;
   font-size: 17px;
}

.fontsize {
   font-size: 25px;
   font-family: "sans-serif";
}

.center1 {
   margin-left: auto;
   margin-right: auto;
   width: 80%;
}

.center2 {
   margin-left: auto;
   margin-right: auto;
   width: 10%;
}

.center3 {
   width:100%;
    margin-left: auto;
   margin-right: auto; 
}


</style>


</head>
<body>

   <jsp:include page="header.jsp"></jsp:include>
   <jsp:include page="mainmenu_bar.jsp"></jsp:include>


   <br>
   <br>
   <Br>


   <div class="container">
      <div class="fontsize">
         <div
            style="background-color: #b0c4de; color: #ffffff; padding: 30px;"
            align="center" class="center1">내 글 보기</div>
      </div>
      <br>

<div class="center1">
      <div class="row">

         <div class="col-md-3">

            <div class="center3">
               <br>
               <div class="list-group" align="center">
                  <a href="mypage.do" class="list-group-item">회원 정보</a> <a
                     href="modifyinfo.do" class="list-group-item">회원 정보 수정</a> <a
                     href="mypoint.do" class="list-group-item">포인트</a> <a
                     href="mycontent.do" class="list-group-item active">내글보기</a> <a
                     href="tradeinfo.do" class="list-group-item">거래중내역</a> <a
                     href="out.do" class="list-group-item">탈퇴하기</a>
               </div>

            </div>
         </div>


         <div class="col-md-9">

      <br>
      
      <div
            style="background-color: #b0c4de; color: #ffffff; padding: 5px;"
            align="center" class="fontsize">나의 기부내역</div>
            
            <br>
      
      
   <!-- 게시판 테이블 시작 -->
   <table style="font-size: 12px;" width="50%" cellpadding="0"
      cellspacing="0">

      <tr class="topbottomsolid">
         <th width="5%">번호</th>
         <th width="10%">이미지</th>
         <th width="10%">장르</th>
         <th width="35%">제목</th>
         <th width="10%">기부방법</th>
         <th width="10%">작성일</th>
         <th width="5%">조회수</th>
         <th> 기부대상 </th>
      </tr>
      <c:forEach items="${noticelist}" var="notice">
         <tr height="25" align="center" class="last">

            <td align="center">${notice.noticeNo}</td>

            <td align="center"><img
               src="<%=request.getContextPath()%>/imgs/mainslide1.jpg" width="80"
               height="100"> <!-- {$book.bookimg}  --></td>

            <td align="center">
               ${notice.bookGenre}
            </td>


            <td align="left">
              <a href="boardRead.do?noticeNo=${notice.noticeNo}" >${notice.noticeTitle}</a>
            </td>


            <td align="center">${notice.noticeMethod}</td>

            <td align="center">
               ${notice.noticeDate}
            </td>
            <td align="center">
               ${notice.noticeCount}
            </td>
  <%--           <td align="center">${notice.noticeLocation}</td> --%>
            <!-- 기부대상자(작성자 게시물에 찜한사람) 선택 버튼 modal-->
                        <td>
                           <button  class="btn btn-primary btn-lg"
                              data-toggle="modal" data-target="#myModal" onclick="callSelectTarget(${notice.noticeNo})"></button> <!-- Modal -->
                           
                           <div class="modal fade" id="myModal" tabindex="-1"
                              role="dialog" aria-labelledby="myModalLabel"
                              aria-hidden="true">
                              
                              <div id="aa">
                                 
                                 
                                 
                              </div>
                              
                           </div>
                           
                              
                        </td>
            
         </tr>
      </c:forEach>
      <tr height="1" bgcolor="#eeeeee">
         <td colspan="8"></td>
      </tr>

   </table>
   <!-- 나의 기부내역 paging -->
   <div align="center" >
      <div class="paginatation-sm">
    <a href="/givook/mycontent.do?pageNo=${paging.prevPageNo}&requestpageNo=${requestpaging.pageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-previous.svg" width=18; height="18" ></a>
    <span>
        <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
           <a href="/givook/mycontent.do?pageNo=${i}&requestpageNo=${requestpaging.pageNo}" >${i}</a>
        </c:forEach>
    </span>
    <a href="/givook/mycontent.do?pageNo=${paging.nextPageNo}&requestpageNo=${requestpaging.pageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-next.svg" width=18; height= 18; border="0"></a>
   
</div>
   </div>
   
   
   
   <br>
   
      <div
            style="background-color: #b0c4de; color: #ffffff; padding: 5px;"
            align="center" class="fontsize">요청게시판 내역</div>
            
            <br>
            
      <table style="font-size: 12px;" width="50%" cellpadding="0"
      cellspacing="0">

      <tr class="topbottomsolid">
         <th width="5%">번호</th>
         <th width="35%">제목</th>
         <th width="5%">지역</th>
         <th width="10%">작성일</th>
         <th width="5%">조회수</th>
         
      </tr>
      <c:forEach items="${requestlist}" var="req">
         <tr height="25" align="center" class="last">

            <td align="center">${req.rqNo}</td>

            <td align="left">
               <a href="board22.do"
               >${req.rqTitle}</a>
            </td>
               <td align="center">
            ${req.rqLocation }
            </td>

            <td align="center">
               ${req.rqDate}
            </td>
            <td align="center">
               ${req.rqCount}
            </td>
         </tr>
      </c:forEach>
      <tr height="1" bgcolor="#eeeeee">
         <td colspan="8"></td>
      </tr>

   </table>
   
   <!-- 요청게시판 내 paging역 -->
   <div align="center" >
      <div class="paginatation-sm">
    <a href="/givook/mycontent.do?pageNo=${paging.pageNo}&requestpageNo=${requestpaging.prevPageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-previous.svg" width=18; height="18" ></a>
    <span>
        <c:forEach var="i" begin="${requestpaging.startPageNo}" end="${requestpaging.endPageNo}" step="1">
           <a href="/givook/mycontent.do?pageNo=${paging.pageNo}&requestpageNo=${i}" >${i}</a>
        </c:forEach>
    </span>
    <a href="/givook/mycontent.do?pageNo=${paging.pageNo}&requestpageNo=${requestpaging.nextPageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-next.svg" width=18; height= 18; border="0"></a>
   
</div>
   </div>
   
   
         </div><!-- column끝 -->

      </div>
      <!--row끝  -->
</div> 

   </div>
   <!-- container끝 -->
   
   
   <br>
   <br>
   <script>
function callSelectTarget(noticeNo) {
   
    $.ajax({
         url: 'selectTarget.do',
         
         data : "noticeNo=" + noticeNo,
         
         
         success: function(data) {
            $("#aa").html('thanks'+data);
            /* tradeStart($("#bb").text()); */
         },
         type: 'GET'
      });
}
</script>

</body>
</html>