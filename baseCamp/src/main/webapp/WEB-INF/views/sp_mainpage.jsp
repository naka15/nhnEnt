<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>


<script src="<%=request.getContextPath()%>/resources/js/*"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/*"
	type="text/css">
	
	
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  
  
  
  
<script
	src="<%=request.getContextPath()%>/resources/js/ie8-responsive-file-warning.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/ie-emulation-modes-warning.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

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
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

 <jsp:include page="mainmenu_bar.jsp"></jsp:include>
<jsp:include page="mainview.jsp"></jsp:include>
<br><br><br><br>
<jsp:include page="boardMain.jsp"></jsp:include>
<jsp:include page="tail.jsp"></jsp:include>

</body>
</html>