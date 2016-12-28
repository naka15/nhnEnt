<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet"
   href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>
<style>
.center {
   margin-left: auto;
   margin-right: auto;
   width: 40%;
}

.rcolor {
   color: red;
}

.gcolor {
   color: green;
}

.size {
   font-size: 25px
}

.center2 {
   margin-left: auto;
   margin-right: auto;
   width: 10%;
}
</style>



</head>
<body>


   <script type="text/javascript">
      var xhr;

      function idconfirm() {
         xhr = new XMLHttpRequest();
         xhr.onreadystatechange = resultParseId;
         var data = document.getElementById("userId").value;
         data = "userId=" + data;
         //Post방식
         xhr.open("POST", "idcheck.do", true);//POST방식,비동기통신
         xhr.setRequestHeader("content-type",
               "application/x-www-form-urlencoded");
         xhr.send(data);//post방식일때는 요청body에 데이터를 담는다.
      }
      function nickconfirm() {
         xhr = new XMLHttpRequest();
         xhr.onreadystatechange = resultParseNick;
         var data = document.getElementById("userNick").value;
         data = "userNick=" + data;
         //Post방식
         xhr.open("POST", "nickcheck.do", true);//POST방식,비동기통신
         xhr.setRequestHeader("content-type",
               "application/x-www-form-urlencoded");
         xhr.send(data);//post방식일때는 요청body에 데이터를 담는다.

      }
      function emailconfirm() {
         xhr = new XMLHttpRequest();
         xhr.onreadystatechange = resultParseEmail;
         var data = document.getElementById("userEmail").value;
         data = "userEmail=" + data;

         //Post방식
         xhr.open("POST", "emailcheck.do", true);//POST방식,비동기통신
         xhr.setRequestHeader("content-type",
               "application/x-www-form-urlencoded");
         xhr.send(data);//post방식일때는 요청body에 데이터를 담는다.

      }

      function resultParseId() {
         if (xhr.readyState == 4) {//서버에서 전송이 끝남
            if (xhr.status == 200) {//정상종료
               viewDataId(xhr.responseText);//---->XML

            }

         }
      }
      function resultParseNick() {
         if (xhr.readyState == 4) {//서버에서 전송이 끝남
            if (xhr.status == 200) {//정상종료
               viewDataNick(xhr.responseText);//---->XML
            }

         }
      }
      function resultParseEmail() {
         if (xhr.readyState == 4) {//서버에서 전송이 끝남
            if (xhr.status == 200) {//정상종료
               viewDataEmail(xhr.responseText);//---->XML
            }

         }
      }

      function viewDataId(data) {

         document.getElementById("printid").innerHTML = data;
         if (data.indexOf("사용가능한") >= 0)
            document.getElementById("printid").className = "gcolor";
         else
            document.getElementById("printid").className = "rcolor";
      }
      function viewDataNick(data) {

         document.getElementById("printnick").innerHTML = data;

         if (data.indexOf("사용가능한") >= 0)
            document.getElementById("printnick").className = "gcolor";
         else
            document.getElementById("printnick").className = "rcolor";
      }
      function viewDataEmail(data) {

         document.getElementById("printemail").innerHTML = data;
         if (data.indexOf("사용가능한") >= 0)
            document.getElementById("printemail").className = "gcolor";
         else
            document.getElementById("printemail").className = "rcolor";
      }

      function enter(){
         alert("축하축하!!!회원가입 되었습니다");
         enterfrm.action="join.do";
         enterfrm.method="post";
         enterfrm.submit();   
      }
      
   </script>


   <jsp:include page="header.jsp"></jsp:include>
   <jsp:include page="mainmenu_bar.jsp"></jsp:include>


   <br>
   <br>
   <Br>



   <div class="size">
      <div style="background-color: #b0c4de; color: #ffffff; padding: 30px;"
         align="center" class="center">Login Page</div>
      <br>
   </div>

   <form action="main.do" method="post">
      <div class="center">
         <div class="form-group">
            <label for="userId">Userid : </label> 
            <input type="text"
               class="form-control" id="1userId" name="userId">
         </div>
         <div class="form-group">
            <label for="userPwd">Password : </label> 
            <input type="password"
               class="form-control" id="userPwd" name="userPwd">
         </div>
      </div>
      <div class="center2">
         <input type="submit" value="로그인"> 
         <input type="reset" value="취소" onclick="history.back()">
      </div>
   </form>

   <br>
   <br>

   <div class="size">
      <div style="background-color: #b0c4de; color: #ffffff; padding: 30px;"
         align="center" class="center">Enter New Member</div>
      <br>
   </div>
   <form action="join.do" method="post">
      <div class="center">

         <div class="form-group">
            <label for="userName">UserName : </label> <input type="text"
               class="form-control" id="userName" name="userName">
         </div>
         <div class="form-group">
            <label for="userNick">UserNick : </label> <input type="text"
               class="form-control" id="userNick" name="userNick"
               onkeyup="nickconfirm();">
            <div id="printnick" class="a"></div>
         </div>
         <div class="form-group">
            <label for="userId">Userid : </label> <input type="text"
               class="form-control" id="userId" name="userId"
               onkeyup="idconfirm();">
            <div id="printid"></div>
         </div>

         <div class="form-group">
            <label for="userPwd">Password : </label> <input type="password"
               class="form-control" id="userPwd" name="userPwd">
         </div>

         <div class="form-group">
            <label for="userPhone">Phone : </label> <input type="text"
               class="form-control" id="userPhone" name="userPhone">
         </div>

         <div class="form-group">
            <label for="userEmail">Email : </label> <input type="text"
               class="form-control" id="userEmail" name="userEmail"
               onkeyup="emailconfirm();">
            <div id="printemail"></div>
         </div>
      </div>
      <div class="center2">
         <input type="submit" value="회원가입"> 
         <input type="reset" value="취소" onclick="history.back()">

      </div>


   </form>

</body>
</html>