<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- Custom styles for this template -->


<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<script
	src="<%=request.getContextPath()%>/resources/js/ie8-responsive-file-warning.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/ie-emulation-modes-warning.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/*"></script>

<script
	src="<%=request.getContextPath()%>/resources/js/ie10-viewport-bug-workaround.js"></script>


<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">

			<a class="navbar-brand" href="main.do">GIVOOK</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">${empty sessionScope.userDTO.userNick?"Guest":sessionScope.userDTO.userNick}</a></li>



				<li><button type="button" class="btn btn-danger btn-mg"
						style="margin-top: 8px;" data-toggle="modal"
						data-target="#exampleModal">${empty sessionScope.userDTO.userNick?"LOGIN":"LOGOUT"}</button></li>

				<%--   <li class="active"><a href="login.do">${empty sessionScope.userDTO.userNick?"LOGIN":"LOGOUT"}</a></li> --%>
				<li><button type="button" class="btn btn-danger btn-mg"
						style="margin-top: 8px;" onclick="location.href='login.do'">NEW MEMBER</button></li>
				<li><button type="button" class="btn btn-danger btn-mg"
						style="margin-top: 8px;" onclick="location.href='mypage.do'">MY PAGE</button></li>


			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
<div class="jumbotron">
	<h1 align="center" style="margin-top: 40px; margin-bottom: 5px;">GIVOOK
		START!</h1>
	<p class="lead" align="center" style="margin-bottom: 0px;">Pleas
		Donate your BooooooooKs!</p>

</div>




<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="toUserId" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="title">로그인 하기</h4>
			</div>
			<div class="modal-body">
				<form action="main.do" method="post">

					<div class="form-group">
						<label for="userId" class="control-label">UserId:</label> <input
							type="text" class="form-control" id="userId" name="userId">
					</div>

					<div class="form-group">
						<label for="userPwd" class="control-label">PassWord:</label> <input
							type="password" class="form-control" id="userPwd" name="userPwd">
					</div>
					<div align="right">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">log-in</button>
					</div>
				</form>
			</div>

		</div>
	</div>
</div>



<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/*"></script>

<script
	src="<%=request.getContextPath()%>/resources/js/ie10-viewport-bug-workaround.js"></script>