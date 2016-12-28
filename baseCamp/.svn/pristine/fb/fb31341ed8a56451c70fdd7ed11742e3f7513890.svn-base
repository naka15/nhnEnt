<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/*.css"
	type="text/css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Ubuntu'
	rel='stylesheet' type='text/css'>
	
	<% String path = request.getContextPath(); 
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
<!-- 스크립트 -->
<script type="text/javascript">
function doCreateReply(){
alert('함수안');
	//댓글 내용 검사
	 if($('#comment').val() == '') {
            alert("한줄 댓글의 내용은 필수 입력입니다.");
            $('#comment').focus(); return;
      }
	   $('#createbtn').attr('disabled', 'disabled');

	      $.post('<%=path%>/requestReplyCmt.do',
	    		  
	                 {userId:$('#userid').val(),
	    	  		rqrp_content:$('#comment').val(),
	                  rqNo:$('#rqNo').val()
	            
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
  <%-- $(function(){
    // id가 cmt인 텍스트에서 엔터를 쳤을 경우
    // 바로 데이터 입력이 되도록 작성
    $('#comment').keyup(function(e){
          if(e.keyCode == 13) doCreateCmt();
    });
    // 처음 읽기 화면 들어왔을때 바로 리스트를 가져와서 보여줌
    /* cmtList(); */
    var noticeNo = $('#noticeNo').val();
    $('#cmtTarget').load("<%=path%>/requestReplyList.do?rqNo="+ rqNo);
} );  --%>

//댓글 리스트 가져오는 메소드
function cmtList(data) {
	  <%--  $('#cmtTarget').load("<%=cp%>/listCmtAjax.do?noticeNo="+ noticeNo); --%>
	 $('#cmtTarget').html(data);

}
   function doDeleteCmt(rqrp_no) {


      $.post('<%=path%>/deleteRqrpCmt.do',
                  {rqNo:$('#writeRqNo').val(),
    	  			userId:$('#writeRuserId').val(),
    	  			rqrp_no:rqrp_no
    	  			}, 
                  function(data) {cmtList(data);});
      
}   


</script>

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="mainmenu_bar.jsp"></jsp:include>
	<br>
	<br>
	
	
	
<div class="container">

			<form action="/requestRead.do" class="form-horizontal"
				enctype="multipart/form-data">
			

				<table class="table table-hover">
					<tr>
						<th width="60%" align="center">${requestCo.rqTitle}</th>
						<th width="10%">조회수</th>
						<th width="10%">${requestCo.rqCount}</th>
						<th width="10%"><label>작성자</label></th>
						<th width="10%">${requestCo.userNick}</th>
					</tr>
					
					<tr class="td_bottom_style">
						<td colspan="10" height="600">
						<br><br>
							<p>${requestCo.rqContent}</p>
						</td>
					</tr>
					
					<tr>
					<td colspan="6">	
	<c:if test="${sessionScope.userDTO.userId==userAll.userId}">
					<img id="deleteBtn" src="<%=request.getContextPath()%>/resources/img/svgs/fi-page-delete.svg" 
				width="30" height="30" align="right"
				 onclick="location.href='deleteRequest.do?rqNo='+${requestCo.rqNo}"/></c:if></td>
					
					</tr>

				</table>

			</form>

<jsp:include page="requestReplyList.jsp"></jsp:include>
	<jsp:include page="requestReplyCmt.jsp"></jsp:include>

	</div>
	<br><br><br>
</body>
</html>