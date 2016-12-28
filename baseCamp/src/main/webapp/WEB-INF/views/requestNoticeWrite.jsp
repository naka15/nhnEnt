<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요청게시판 글쓰기</title>

 <link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/*.css"
	type="text/css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="mainmenu_bar.jsp"></jsp:include>
	<br><br>

	<div class="container">
	
	<form action="requestNotice.do" method="post" class="form-horizontal">
	
				<div class="form-group">
				<label class="control-label col-sm-1">제목</label>
				<div class="col-sm-6">
					<textarea class="form-control" rows="1" id="rqTitle"
						name="rqTitle"></textarea>
				</div>
				<label class="control-label col-sm-1">작성자</label>
				<div class="col-sm-2">


					<input type="text" readonly="readonly" id="userId" name="userId"
						class="form-control"
						value="${empty sessionScope.userDTO.userNick?guest:sessionScope.userDTO.userNick}">


				</div>
			</div>



			<div class="form-group">
				<div class="col-sm-11">
					<textarea class="form-control" rows="40" id="rqContent"
						name="rqContent"></textarea>
				</div>
			</div>
		<br>

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
	
<br><br>


</body>
</html>