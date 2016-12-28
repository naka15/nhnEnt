<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Calendar"%>

<%
	String date = String.format("%tF", Calendar.getInstance());
%>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/*.css"
	type="text/css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Ubuntu'
	rel='stylesheet' type='text/css'>
<style type="text/css">
.center {
	margin-left: auto%;
	margin-right: auto%;
	width: 70%;
}

.center2 {
	margin-left: auto;
	margin-right: auto;
	width: 10%;
}
</style>
<title>기부게시판 글쓰기</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="mainmenu_bar.jsp"></jsp:include>

	<br>
	<br>



	<div class="container">

		<form action="boardWrite.do" method="post" class="form-horizontal"
			enctype="multipart/form-data">

			<div class="form-group">
				<label class="control-label col-sm-1"> 제목</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="1" id="noticeTitle"
						name="noticeTitle"></textarea>
				</div>
			</div>

			<div class="form-group">

				<label class="control-label col-sm-1"> 책제목</label>
				<div class="col-sm-3">
					<input type="text" id="bookSubject" name="bookSubject"
						class="form-control">
				</div>
				<label for="noticeTitle" class="control-label col-sm-1"> 작성일</label>
				<div class="col-sm-3">

					<fieldset disabled>
						<input type="date" readonly="readonly" id="noticeDate"
							name="noticeDate" class="form-control" value="<%=date%>">
					</fieldset>
				</div>

				<label class="control-label col-sm-1">작성자</label>
				<div class="col-sm-2">


					<input type="text" readonly="readonly" id="userId" name="userId"
						class="form-control"
						value="${empty sessionScope.MemberDTO.userNick?guest:sessionScope.userDTO.userNick}">


				</div>

			</div>

			<div class="form-group">

				<label class="control-label col-sm-1">기부방법</label>
				<div class="col-sm-3">
					<select id="noticeMethod" name="noticeMethod" class="form-control">
						<option value="기부방법">기부방법선택</option>
						<option value="착불택배">착불택배</option>
						<option value="직거래">직거래</option>
					</select>
				</div>
				<label class="control-label col-sm-1">기부지역</label>
				<div class="col-sm-3">

					<select id="noticeLocation" name="noticeLocation"
						class="form-control">
						<option value="없음">지역선택</option>
						<option value="서울">서울</option>
						<option value="인천">인천</option>
					</select>
				</div>

				<label class="control-label col-sm-1">책수량</label>
				<div class="col-sm-2">

					<input type="text" id="bookNum" name="bookNum" class="form-control">
				</div>

			</div>



			<div class="form-group">



				<label class="control-label col-sm-1">장르</label>
				<div class="col-sm-3">
					<select id="bookGenre" name="bookGenre" class="form-control">
						<option>장르선택</option>
						<option value="문학">문학</option>
						<option value="인문사회/경영">인문사회/경영</option>
						<option value="IT/과학">IT/과학</option>
						<option value="자기개발서/참고서">자기개발서/참고서</option>
						<option value="어린이">어린이</option>
						<option value="만화/라이트노벨">만화/라이트노벨</option>
						<option value="해외서적">해외서적</option>
						<option value="기타">기타</option>
					</select>
				</div>
				<label class="control-label col-sm-1">가격</label>
				<div class="col-sm-3">

					<input type="text" id="bookPrice" name="bookPrice"
						class="form-control">
				</div>

				<label class="control-label col-sm-1">책상태</label>
				<div class="col-sm-2">

					<select id="bookQty" name="bookQty" class="form-control">
						<option value="체크안함">책상태체크</option>
						<option value="상">상</option>
						<option value="중">중</option>
						<option value="하">하</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-1">사진첨부</label>
				<div class="col-sm-10">
					<input type="file" name="pic" class="form-control">
				</div>
			</div>






			<div class="form-group">
				<div class="col-sm-11">
					<textarea class="form-control" rows="40" id="noticeContent"
						name="noticeContent"></textarea>
				</div>
			</div>

			<div align="right" style="margin-right: 10%">
				<div class="row">
					<div class="col-lg-12">
						<input type="submit" value="submit" class="btn btn-danger btn-sg">
						<input type="reset" class="btn btn-danger btn-mg" value="cancel">
					</div>
				</div>

			</div>
		</form>

	</div>



	<br>
	<br>

</body>
</html>