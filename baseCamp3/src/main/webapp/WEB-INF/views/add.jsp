<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.regex.*" %>
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
	var msg = '${msg}';
	if(msg!=null||msg!=""){w
		alert("email 형식 안 맞음 (server check)")
	}
});

function formChk(){
	
	var str = $('#email').val();
	if(str.length==0)
		return false;
	var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	debugger;
 	if (!str.match(regExp)) {
		   alert("email 형식이 안 맞음");
		   return false;
	} 
		 document.joinForm1.submit(); 
	alert("저장됨");
		 return true;
}

/* function deleteVal(id){
	$("#"+id).val("");
} */ 
</script>
<body>
<div style="width:70%;">
	<form name="joinForm1"  action="/baseCamp3/save.do" method="post" onSubmit="formChk();return false">
	<label class="col-xs-1" >email</label>	
	<input class="col-xs-3" id="email" name="email" type="text"  value="${visit.email}"  maxlength="100"/>
	<label class="col-xs-1" >password</label> 
	<input class="col-xs-3" name="pwd" type="password"  value="" maxlength="100"/>
	<label class="col-xs-3"></label>
	<input class="col-xs-1" id="save" type="submit" value="save"/>
	<br>
	<input class = "col-xs-12" name="detail" type="text"  value="${visit.detail}"style="height:300px;" maxlength="1000"/>
	</form>
</div>
</body>
</html>