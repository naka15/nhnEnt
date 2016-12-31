<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<script type="text/javascript">
$(document).ready(function() {
});

function save(){
	alert("save");
	
	var obj = {email : $("#email").val(), pwd : $("#pwd").val(), detail : $("#detail").val()}
/* 	var data = JSON.stringify(obj);
	debugger;
	$.ajax({
		type : "POST"
		,url : "http://localhost:8088/save.do/"
		,data : data
		,dataType : "json"
		,contentType : "application/json"
		,success : function(result) {
			RtnMsg(result);
		}
	});
 */	//$.post("http://localhost:8088/save.do/",data);

}

/* function deleteVal(id){
	$("#"+id).val("");
} */ 
</script>
<body>
<div style="width:70%;">
	<form action="/save.do" method="post">
	<label class="col-xs-1" >email</label>	
	<input class="col-xs-3" name="email" type="text"  value=""  maxlength="100"/>
	<label class="col-xs-1" >password</label> 
	<input class="col-xs-3" name="pwd" type="password"  value="" maxlength="100"/>
	<label class="col-xs-3"></label>
	<input class="col-xs-1" id="save" type="submit" value="save"/>
	<br>
	<input class = "col-xs-12" name="detail" type="text"  style="height:300px;" maxlength="1000"/>
	</form>
</div>
</body>
</html>