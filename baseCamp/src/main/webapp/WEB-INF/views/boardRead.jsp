<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<%-- 
	
	
	
	
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

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Ubuntu'
   rel='stylesheet' type='text/css'> --%>
   
   

<% String cp = request.getContextPath(); 
	%>
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

.imageButton_align {
	
}
</style>
<script type="text/javascript">

function doCreateRe(){

	//댓글 내용 검사
	 if($('#comment').val() == '') {
            alert("한줄 댓글의 내용은 필수 입력입니다.");
            $('#comment').focus(); return;
      }
	   $('#createbtn').attr('disabled', 'disabled');

	      $.post('<%=cp%>/createReply.do',
	    		  
	                 {userId:$('#userid').val(),
	    	 		 replyContent:$('#comment').val(),
	                  noticeNo:$('#noticeNo').val()
	            
	                  }
	                  ,
	                  function(data){
	                         $('#comment').val(''); // 내용 비우기
	                         // 다시 클릭이 가능하게끔
	                         $('#createbtn').attr("disabled", false);
	                         // 입력이 완료가 됐으므로 다시 리스트 불러오기
	                         cmtList(data);
	                  });
}
<%--  $(function(){
    // id가 cmt인 텍스트에서 엔터를 쳤을 경우
    // 바로 데이터 입력이 되도록 작성
    $('#comment').keyup(function(e){
          if(e.keyCode == 13) doCreateCmt();
    });
    // 처음 읽기 화면 들어왔을때 바로 리스트를 가져와서 보여줌
    /* cmtList(); */
    var noticeNo = $('#noticeNo').val();
    $('#cmtTarget').load("<%=cp%>/boardRead.do?noticeNo="+ noticeNo);
});  --%>

//댓글 리스트 가져오는 메소드
function cmtList(data) {
	  <%--  $('#cmtTarget').load("<%=cp%>/listCmtAjax.do?noticeNo="+ noticeNo); --%>
	 $('#cmtTarget').html(data);

}
  function doDeleteCmt(replyNo) {
	  alert($('#writeNoticeNo').val());
	  alert($('#writeuserId').val());
      $.post('<%=cp%>/deleteReply.do',
                  {noticeNo:$('#writeNoticeNo').val(),
    	  			userId:$('#writeuserId').val(),
    	  			replyNo:replyNo
    	  			}, 
                  function(data) {cmtList(data);});
      
}  
  



</script>

<script type="text/javascript">
var xhr;
function dofavorite(){
	  alert("함수안");
	  document.getElementById("dofavorite").src=$('#hiddenPath').val()+"/images/star_full.png";
	  alert("별모양 바뀜!");
	  xhr = new XMLHttpRequest();
	  xhr.onreadystatechange = resultParsefavorite;
	  var userid = "userId=" + document.getElementById("hiddenuserID").value;
	  var noticeno = "noticeNo=" + document.getElementById("hiddennoticeNo").value;
	  var data = userid + "&" + noticeno;
	  xhr.open("POST", "insertFavorite.do", true);
	  xhr.setRequestHeader("content-type",
       "application/x-www-form-urlencoded");
 		xhr.send(data);//post방식일때는 요청body에 데이터를 담는다.

  }
  
function resultParsefavorite() {
    if (xhr.readyState == 4) {//서버에서 전송이 끝남
       if (xhr.status == 200) {//정상종료
          viewDatafavorite(xhr.responseText);//---->XML

       }

    }
 }
	 
	 function viewDatafavorite(data){
		 alert(data);
		/*  return false; */
	 }


</script>




<title>Insert title here</title>

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

.imageButton_align {
	
}
</style>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="mainmenu_bar.jsp"></jsp:include>
	<br>
	<br>


	<div class="container">

			<form action="/boardRead.do" class="form-horizontal"
				enctype="multipart/form-data">

				<table class="table table-hover">
					<tr>
						<td colspan="4">${noticeAll.noticeTitle }</td>
						<td><label class="table_font">조회수</label></td>
						<td>${noticeAll.noticeCount}</td>
					</tr>
					<tr>
						<td width="80"><label class="table_font">책제목</label></td>
						<td width="159">${bookAll.bookSubject}</td>
						<td width="100"><label class="table_font">작성날짜</label></td>
						<td width="217">${noticeAll.noticeDate }</td>
						<td width="78"><label class="table_font">작성자</label></td>
						<td width="211">${userAll.userNick} &nbsp;&nbsp; &nbsp; &nbsp;<button type="button" class="btn btn-danger btn-sg" data-toggle="modal"data-target="#exampleModal11"> send message </button>	</td>
					</tr>
					<tr>
						<td><label class="table_font">기부방법</label></td>
						<td>${noticeAll.noticeMethod}</td>
						<td><label class="table_font">거래지역</label></td>
						<td>${noticeAll.noticeLocation}</td>
						<td><label class="table_font">수량</label></td>
						<td>${bookAll.bookNum}</td>
					</tr>
					<tr>
						<td><label class="table_font">장르</label></td>
						<td>${bookAll.bookGenre}</td>
						<td><label class="table_font">가격</label></td>
						<td>${bookAll.bookPrice}</td>
						<td><label class="table_font">관심등록</label></td>
						<td>
						  <input type="image" id="dofavorite" name="dofavorite" width="20" height="20" style="cursor: hand;" 
						  src="${pageContext.request.contextPath}/images/star_empty.png"
				  		onclick="dofavorite();return false;"/>
				  		
				  		
				  		
				  		<input type="hidden" id="hiddenuserID" value="${sessionScope.userDTO.userId}"/>  
				  			<input type="hidden" id="hiddennoticeNo" value="${bookAll.noticeNo}"/> 
						<c:set var="path" value="${pageContext.request.contextPath}"/>
						<input type="hidden" id="hiddenPath" value="${path}">
				 		<%-- <img id="dofavorite" name="dofavorite"
				src="${pageContext.request.contextPath}/images/star_empty.png"
				width="20" height="20" style="cursor: hand;" onclick="dofavorite()">  --%>
				</td>
					</tr>
					<tr class="td_bottom_style">
						<td colspan="6" height="600">
							<p>${noticeAll.noticeContent}</p>
						</td>
					</tr>
					<tr>
					
					
					<td colspan="6">	
	<c:if test="${sessionScope.userDTO.userId==userAll.userId}">
					<img id="deleteBtn" src="<%=request.getContextPath()%>/resources/img/svgs/fi-page-delete.svg" 
				width="30" height="30" align="right"
				 onclick="location.href='deleteNotice.do?noticeNo='+${noticeAll.noticeNo}"/></c:if></td>
					
					
					</tr>
					

				</table>

			</form>
			<%-- 	${pageContext.request.contextPath} **** <BR>
			<%=request.getContextPath() %> --%>
			
				<img id="home_button"
				src="<%=request.getContextPath()%>/resources/img/svgs/fi-list-bullet.svg"
				width="30" height="30" style="cursor: hand;"
				onclick="location.href='${pageContext.request.contextPath}/board2-1.do';">
			
			<img id="up_button"
				src="${pageContext.request.contextPath}/images/up_icon.png"
				width="40" height="40" style="cursor: hand;"
				onclick="location.href='/nextNotice.do';" align="right"> <img
				id="down_button"
				src="${pageContext.request.contextPath}/images/down_icon.png"
				width="40" height="40" style="cursor: hand;"
				onclick="location.href='/boardWirte.do';" align="right">
				

		</div>
		<br> <br>

		<div class="center">

			<jsp:include page="listCmtAjax.jsp"></jsp:include>
			<jsp:include page="listCmt.jsp"></jsp:include>
		</div>



	<div class="modal fade" id="exampleModal11" tabindex="-1" role="dialog"
		aria-labelledby="toUserId" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="title">GIVOOK 쪽지보내기</h4>
				</div>
				<div class="modal-body">
					<form action="sendMessage.do" method="post">

						<div class="form-group">
							<label for="toUserNick" class="control-label">받는 사람:</label> <input
								type="text" class="form-control" id="toUserNick"
								readonly="readonly" name="toUserNick"
								value="${userAll.userNick}">
						</div>
						<div class="form-group">
							<label for="messageTitle" class="control-label">title:</label>
							<input type="text" class="form-control" id="messageTitle" name="messageTitle">
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">Message:</label>
							<textarea class="form-control" id="messageContent" name="messageContent"></textarea>
						</div>
						<div align="right">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Send message</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

</body>
</html>