<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
.border{
    border: 2px solid #a1a1a1;
    padding: 30px 30px; 
    background: #dddddd;
    width: 400px;
    border-radius: 25px;
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




<jsp:include page="header.jsp"></jsp:include>
   <jsp:include page="mainmenu_bar.jsp"></jsp:include>


   <br>
   <br>
   <Br>


<div class="container">

  
  
  <hr style="height:1px;border:none;color:#333;background-color:#333;" />
  

  <div class="row">
  

    <div class="col-md-4">
  <br>
    <div class="list-group" align="center">
                  <div class="glyphicon glyphicon-user"></div><a href="mypage.do" class="list-group-item active">회원 정보</a> 
                  <div class="glyphicon glyphicon-wrench"></div><a href="modifyinfo.do" class="list-group-item">회원 정보 수정</a> 
                     <div class="glyphicon glyphicon-comment"></div><a href="mymessage.do" class="list-group-item">메세지보기</a> 
                     <div class="glyphicon glyphicon-list-alt"></div><a href="mycontent.do" class="list-group-item">내글보기</a> 
                     <div class="glyphicon glyphicon-retweet"></div><a href="tradeinfo.do" class="list-group-item">거래중내역</a> 
                     <div class="glyphicon glyphicon-trash"></div><a href="out.do" class="list-group-item">탈퇴하기</a>
               </div>

    
      </div><!-- column끝 -->
      
      
    
  
    <div class="col-md-5">
      <div class="center1">
    <br>
    
            
            <br>
 
      <div class="border">
                <div class="form-group"><div class="glyphicon glyphicon-user"></div>
               <label for="userId"> User id : 
               </label> ${sessionScope.userDTO.userId}<br>
            </div>

            <div class="form-group"><div class="glyphicon glyphicon-th-large"></div>
               <label for="userPwd"> Password : </label>
               ${sessionScope.userDTO.userPwd}<br>
            </div>
            <div class="form-group"><div class="glyphicon glyphicon-th-list"></div>
               <label for="userName"> User Name : </label>
               ${sessionScope.userDTO.userName}<br>
            </div>
            <div class="form-group"><div class="glyphicon glyphicon-road"></div>
               <label for="userNick"> User NickName : </label>
               ${sessionScope.userDTO.userNick}<br>
            </div>

            <div class="form-group"><div class="glyphicon glyphicon-phone-alt"></div>
               <label for="userPhone"> Phone : </label>
               ${sessionScope.userDTO.userPhone}<br>
            </div>

            <div class="form-group"><div class="glyphicon glyphicon-envelope"></div>
               <label for="userEmail"> Email : </label>
               ${sessionScope.userDTO.userEmail}<br>
            </div>

            <div class="form-group"><div class="glyphicon glyphicon-signal"></div>
               <label for="userPoint"> Point : </label>
               ${sessionScope.userDTO.userPoint}<br>
            </div>
    
    </div><!-- border끝 -->
      </div>
    </div><!-- column끝 -->
   
  
    
    
  </div><!--row끝  -->

</div><!-- container끝 -->
  <hr style="height:1px;border:none;color:#333;background-color:#333;" />
<br><br><br><br><br>
<jsp:include page="tail.jsp"></jsp:include>

</body>
</html>

