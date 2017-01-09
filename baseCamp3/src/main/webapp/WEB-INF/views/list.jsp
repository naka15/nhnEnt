<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>Visitor book</title>
</head>

<script type="text/javascript">
$(document).ready(function() {
	
/* 	//get data
 	$.ajax({      
        type:"POST",  
        url:"getList.do",      
        data: null,      
        success:function(data){   
            debugger;      
        },   
        error:function(e){  
            alert(e.responseText);  
        },
        async:false
    });  */
/* 	$("#edit").click(function(){
		  var col = $(this).parent().children().index($(this));
		  var row = $(this).parent().parent().children().index($(this).parent());
		  alert('Row: ' + row + ', Column: ' + col);
		  var tr = document.getElementsByTagName("tr")[row];
		  debugger;
		}); */
		
/* 	    var a = document.getElementsByClassName('editButton');

		for (var i = 0; i<a.length;i++) {
		    a[i].addEventListener('click',function(){

		     var b = this.parentNode.parentNode.cells[2].textContent;
		    });
		} */
		
});

function edit(pwd, email, detail, obj){
		debugger;
/* 	debugger;
	  var col = obj.parent().children().index(obj);
	  var row = obj.parent().parent().children().index(obj.parent());
	  alert('Row: ' + row + ', Column: ' + col); */
	var inputPwd = obj.parentNode.parentNode.cells[2].children[0].value;
	  if(pwd!=inputPwd){
		  alert("wrong password");
		  return;
	  }

	  location.href = '/baseCamp3/add.do?email='+email+"&detail="+detail;

}

</script>

<body>
<div>	<input type="button" value="add"  onclick="location.href='/baseCamp3/add.do?email= &detail= '"/>
</div>
<div>
 <table  class="table table-hover" style="font-size: 15px; text-align:justify; "  cellpadding="0" align="center"
      cellspacing="0">
	 <tr class="danger">
         <th align="center">email</th>
         <th>detail</th>
         <th>pwd</th>
         <th>edit</th>
      </tr>
      <c:forEach items="${list}" var="list">
         <tr >
            <td>${list.email}
            </td>
            <td>
               ${list.detail}
        	</td>
        	<td class="pwd">
        		<input type="text"/ maxlength="100">
        	</td>
        	<td >
        		<button  onclick="edit( '${list.pwd}', '${list.email}', '${list.detail}', this);">수정</button>
        	</td>
         </tr>
      </c:forEach>
</table>
</div>
<FORM>
<input type="hidden" name="name" value="value" />
</FORM>
</body>
</html>