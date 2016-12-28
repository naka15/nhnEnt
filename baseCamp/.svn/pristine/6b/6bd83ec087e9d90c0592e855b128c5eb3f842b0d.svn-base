<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>

  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
.width {
   width: 90%;
   font-size: 17px;
}

.fontsize {
   font-size: 25px;
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

.center3 {
   /* width: 600px; */
   width:100%;
   margin-left: auto;
   margin-right: auto;
}

</style>



</head>
<body>

<script type="text/javascript">

function f(){
   alert("완료되었습니다.");
    location.href="bye.do";
   
}

</script>


   <jsp:include page="header.jsp"></jsp:include>
   <jsp:include page="mainmenu_bar.jsp"></jsp:include>


   <br>
   <br>
   <Br>



   <div class="container">

      <br>

<div class="center1">
      <div class="row">

         <div class="col-md-5">

            <div class="center3">
            
               <br>
               <div class="list-group" align="center">
                  <div class="glyphicon glyphicon-user"></div><a href="mypage.do" class="list-group-item">회원 정보</a> 
                  <div class="glyphicon glyphicon-wrench"></div><a href="modifyinfo.do" class="list-group-item">회원 정보 수정</a> 
                     <div class="glyphicon glyphicon-comment"></div><a href="mymessage.do" class="list-group-item">메세지보기</a> 
                     <div class="glyphicon glyphicon-list-alt"></div><a href="mycontent.do" class="list-group-item">내글보기</a> 
                     <div class="glyphicon glyphicon-retweet"></div><a href="tradeinfo.do" class="list-group-item">거래중내역</a> 
                     <div class="glyphicon glyphicon-trash"></div><a href="out.do" class="list-group-item active">탈퇴하기</a>
               </div>

            </div>
         </div>
         <!-- column끝 -->


         <div class="col-md-7">

            <br>
            
            
               <h1>탈퇴하시겠습니까?</h1>

            <br>
            
            <!-- 모달팝업시작 -->

            <button type="button" class="btn btn-danger" data-toggle="modal"
               data-target=".out-modal"><h4>탈퇴하기</h4></button>

         
            <div class="modal fade out-modal" tabindex="-1" role="dialog"
               aria-labelledby="myLargeModalLabel" aria-hidden="true">
               <div class="modal-dialog modal-sm">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                           <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title">정말로 탈퇴하시겠습니까?</h4>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" onclick="f();">탈퇴 하기
                        </button>
                        
                        <button type="button" class="btn btn-default"
                           data-dismiss="modal">탈퇴 취소</button>
                     </div>


                  </div>
               </div>
            </div><!--모달 팝업끝 -->

         </div>
         <!-- column끝 -->

      </div>
      <!--row끝  -->
</div>

   </div>
   <!-- container끝 -->
  <hr style="height:1px;border:none;color:#333;background-color:#333;" />
<br><br><br><br><br>
<jsp:include page="tail.jsp"></jsp:include>
</body>
</html>