<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>





<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  
  <style type="text/css">
  
  .width{
   width:90%;

   font-size: 17px;
   
  }
  
  .rcolor{
    color: red;
}
.gcolor{
    color:green;
}
  
  
  .fontsize{
  font-size:25px;
  
  }
  .center1 {
    margin-left: auto;
    margin-right: auto;
    width: 60%;
}
  
  .center2 {
    margin-left: auto;
    margin-right: auto;
    width: 10%;
}

 .center3{
   /* width: 600px; */
   width:100%;
    margin-left: auto;
    margin-right: auto;
 
 }

  </style>
  
  
</head>
<body>

<script type="text/javascript"> 
  var xhr;
  
   function nickconfirm(){
     xhr= new XMLHttpRequest();
     xhr.onreadystatechange = resultParseNick;
     var data = document.getElementById("userNick").value;
      data ="userNick="+data;
     //Post방식
     xhr.open("POST", "nickcheck.do", true);//POST방식,비동기통신
     xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
     xhr.send(data);//post방식일때는 요청body에 데이터를 담는다.


  }
  function emailconfirm(){
     xhr= new XMLHttpRequest();
     xhr.onreadystatechange = resultParseEmail;
     var data = document.getElementById("userEmail").value;
      data ="userEmail="+data;

     //Post방식
     xhr.open("POST", "emailcheck.do", true);//POST방식,비동기통신
     xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
     xhr.send(data);//post방식일때는 요청body에 데이터를 담는다.

  } 

  function resultParseNick(){
     if(xhr.readyState==4){//서버에서 전송이 끝남
        if(xhr.status==200){//정상종료
        viewDataNick(xhr.responseText);//---->XML
        }
        
     }
  }
  function resultParseEmail(){
     if(xhr.readyState==4){//서버에서 전송이 끝남
        if(xhr.status==200){//정상종료
        viewDataEmail(xhr.responseText);//---->XML
        }
        
     }
  }
  
    function viewDataNick(data) {

      document.getElementById("printnick").innerHTML = data;
      
      if(data.indexOf("사용가능한")>=0)
           document.getElementById("printnick").className="gcolor";
      else
          document.getElementById("printnick").className="rcolor";
   }
   function viewDataEmail(data) {

      document.getElementById("printemail").innerHTML = data;
      
      if(data.indexOf("사용가능한")>=0)
           document.getElementById("printemail").className="gcolor";
      else
          document.getElementById("printemail").className="rcolor";
   } 
</script>


<jsp:include page="header.jsp"></jsp:include>
   <jsp:include page="mainmenu_bar.jsp"></jsp:include>


   <br>
   <br>
   <Br>


<div class="container">
      <div
      style="background-color: #b0c4de; color: #ffffff; padding: 30px; font-size:30px;
      border-radius: 25px; border: 2px solid #a1a1a1; border-width: 5px; font-family: Arial, Helvetica, sans-serif;"
      align="center" class="center1">내 정보 수정</div>
  <br>

<div class="center1">
  <div class="row">
  
  <div class="col-md-5">

  <div class="center3">
  <br>
    <div class="list-group" align="center">
                  <div class="glyphicon glyphicon-user"></div><a href="mypage.do" class="list-group-item">회원 정보</a> 
                  <div class="glyphicon glyphicon-wrench"></div><a href="modifyinfo.do" class="list-group-item active">회원 정보 수정</a> 
                     <div class="glyphicon glyphicon-comment"></div><a href="mymessage.do" class="list-group-item">메세지보기</a> 
                     <div class="glyphicon glyphicon-list-alt"></div><a href="mycontent.do" class="list-group-item">내글보기</a> 
                     <div class="glyphicon glyphicon-retweet"></div><a href="tradeinfo.do" class="list-group-item">거래중내역</a> 
                     <div class="glyphicon glyphicon-trash"></div><a href="out.do" class="list-group-item">탈퇴하기</a>
               </div>

            </div>
      </div><!-- column끝 -->
      
      
    
    
    <div class="col-md-7">
 
      <br>
       <form action="modifyinfo.do" method="post">
    
        <div class="form-group">
         <label for="userId">User id : </label>
         <input readonly="readonly" type="text" class="form-control" id="userId" name="userId" value="${sessionScope.userDTO.userId}">
         <br>
      </div>

      <div class="form-group">
         <label for="userPwd">Password : </label>
         <input type="text" class="form-control" id="userPwd" name="userPwd" value="${sessionScope.userDTO.userPwd}"> 
         <br>
      </div>
        <div class="form-group">
         <label for="userName">User Name : </label> 
         <input type="text" class="form-control" id="userName" name="userName" value="${sessionScope.userDTO.userName}">
          <br>
      </div>
      
        <div class="form-group">
         <label for="userNick">User NickName : </label> 
         <input type="text" class="form-control" onkeyup="nickconfirm();" id="userNick" name="userNick" value="${sessionScope.userDTO.userNick}" > 
          <div id="printnick"></div>
          <br>
      </div>

      <div class="form-group">
         <label for="userPhone">Phone : </label>
          <input type="text" class="form-control" id="userPhone" name="userPhone" value="${sessionScope.userDTO.userPhone}"> 
         <br>
      </div>

      <div class="form-group">
         <label for="userEmail">Email : </label>
         <input type="text" class="form-control" id="userEmail" name="userEmail" value="${sessionScope.userDTO.userEmail}" onkeyup="emailconfirm();">
         <div id="printemail"></div>
         <br> 
      </div>
      
      <div class="form-group">
         <label for="userPoint">Point : </label>
         <input readonly="readonly" type="text" class="form-control" id="userPoint" name="userPoint" value="${sessionScope.userDTO.userPoint}">
         <br> 
      </div>
      
    <input type="submit" value="완료"> 
      <input type="reset" value="취소">
      
    </form>
    
    </div><!-- column끝 -->
    
    
    
    
  </div><!--row끝  -->
</div>

</div><!-- container끝 -->




</body>
</html>

