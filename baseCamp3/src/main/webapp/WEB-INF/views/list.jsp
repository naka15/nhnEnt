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
<body>
<div>
 <table  class="table table-hover" style="font-size: 15px; text-align:justify; "  cellpadding="0" align="center"
      cellspacing="0">
	 <tr class="danger">
         <th align="center">email</th>
         <th>detail</th>
      </tr>
      <c:forEach items="${list}" var="list">
         <tr >
            <td>${list.email}
            </td>
            <td>
               ${list.detail}
        	</td>
         </tr>
      </c:forEach>
</table>
</div>
</body>
</html>