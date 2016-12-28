<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<style type="text/css">

table, td, th {
    border: 1px solid black;
}

table {
    width: 100%;
}

th {
    height: 50px;
}
.width {
   width: 90%;
   font-size: 17px;
}

.center1 {
   margin-left: auto;
   margin-right: auto;
   width: 80%;
}

.center2 {
   margin-left: auto;
   margin-right: auto;
   width: 10%;
}

.center3 {
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
       <div
      style="background-color: #b0c4de; color: #ffffff; padding: 30px; font-size:30px;
      border-radius: 25px; border: 2px solid #a1a1a1; border-width: 5px; font-family: Arial, Helvetica, sans-serif;"
      align="center" class="center1">메시지 내역</div>

      <br>

<div class="center1">
      <div class="row">

         <div class="col-md-3">

            <div class="center3">
               <br>
               <div class="list-group" align="center">
                  <div class="glyphicon glyphicon-user"></div><a href="mypage.do" class="list-group-item">회원 정보</a> 
                  <div class="glyphicon glyphicon-wrench"></div><a href="modifyinfo.do" class="list-group-item">회원 정보 수정</a> 
                     <div class="glyphicon glyphicon-comment"></div><a href="mymessage.do" class="list-group-item active">메세지보기</a> 
                     <div class="glyphicon glyphicon-list-alt"></div><a href="mycontent.do" class="list-group-item">내글보기</a> 
                     <div class="glyphicon glyphicon-retweet"></div><a href="tradeinfo.do" class="list-group-item">거래중내역</a> 
                     <div class="glyphicon glyphicon-trash"></div><a href="out.do" class="list-group-item">탈퇴하기</a>
               </div>

            </div>
         </div>


         <div class="col-md-9">

      <br>
      
       <div
      style="background-color: #f2dede; color: #ffffff; padding: 10px; font-size:25px;
      border-radius: 25px; border: 2px solid #a1a1a1; border-width: 5px; font-family: Arial, Helvetica, sans-serif;"
      align="center">보낸 메시지 내역</div>
            
            <br>
            
      <table style="font-size: 12px;" width="50%" cellpadding="0"
      cellspacing="0">

      <tr class="topbottomsolid">
         <th width="10%">보낸 사람</th>
         <th width="10%">받는 사람</th>
         <th width="25%">제목</th>
         <th width="35%">내용</th>
         <th width="20%">작성일</th>
         
         
      </tr>
      <c:forEach items="${messagelist}" var="message">
         <tr height="25" align="center" class="last">

            <td align="center">${message.fromUserId}</td>

            <td align="center">
              ${message.userId}
            </td>
               <td align="center">
            ${message.messageTitle}
            </td>

            <td align="center">
               ${message.messageContent}
            </td>
            <td align="center">
               ${message.messageDate}
            </td>
         </tr>
      </c:forEach>
      <tr height="1" bgcolor="#eeeeee">
         <td colspan="8"></td>
      </tr>

   </table>
   <!-- 보낸 메세지 내역 paging -->
    <div align="center" >
      <div class="paginatation-sm">
    <a href="/givook/mymessage.do?pageNo=${paging.prevPageNo}&recvpageNo=${recvpaging.pageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-previous.svg" width=18; height="18" ></a>
    <span>
        <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
           <a href="/givook/mymessage.do?pageNo=${i}&recvpageNo=${recvpaging.pageNo}" >${i}</a>
        </c:forEach>
    </span>
    <a href="/givook/mymessage.do?pageNo=${paging.nextPageNo}&recvpageNo=${recvpaging.pageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-next.svg" width=18; height= 18; border="0"></a>
   
</div>
   </div>
   
    <br>
      
       <div
      style="background-color: #f2dede; color: #ffffff; padding: 10px; font-size:25px;
      border-radius: 25px; border: 2px solid #a1a1a1; border-width: 5px; font-family: Arial, Helvetica, sans-serif;"
      align="center">받은 메시지 내역</div>
            
            <br>
            
      <table style="font-size: 12px;" width="50%" cellpadding="0"
      cellspacing="0">

      <tr class="topbottomsolid">
         <th width="10%">보낸 사람</th>
         <th width="10%">받는 사람</th>
         <th width="25%">제목</th>
         <th width="35%">내용</th>
         <th width="10%">작성일</th>
         <th width="10%">보내기</th>
         
         
      </tr>
      <c:forEach items="${receivemessagelist}" var="remessage">
         <tr height="25" align="center" class="last">

            <td align="center">${remessage.fromUserId}</td>

            <td align="center">
              ${remessage.userId}
            </td>
               <td align="center">
            ${remessage.messageTitle}
            </td>

            <td align="center">
               ${remessage.messageContent}
            </td>
            <td align="center">
               ${remessage.messageDate}
            </td>
            
            <td align="center">
            
            
            <button type="button" class="btn btn-primary" data-toggle="modal"
            data-target="#exampleModal">${remessage.fromUserId}님에게쪽지 보내기</button>

         <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="toUserId" aria-hidden="true">
            <div class="modal-dialog">
               <div class="modal-content">
                  <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                     </button>
                     <h4 class="modal-title" id="title">
                        기부  쪽지보내기</h4>
                  </div>
                  <div class="modal-body">
                     <form action="mySendMessage.do" method="post">
                     
                        <div class="form-group">
                           <label for="toUserId" class="control-label">받는 사람:</label>
                           <input type="text" class="form-control" id="toUserId" readonly="readonly"
                              name="toUserId" value="${remessage.fromUserId}">
                        </div>
                        <div class="form-group">
                           <label for="messageTitle" class="control-label">title:</label>
                           <input type="text" class="form-control" id="messageTitle"
                              name="messageTitle">
                        </div>
                        <div class="form-group">
                           <label for="message-text" class="control-label">Message:</label>
                           <textarea class="form-control" id="messageContent"
                              name="messageContent"></textarea>
                        </div>
                        <div align="right">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                     <button type="submit" class="btn btn-primary">Send message</button>
                     </div>
                     </form>
                  </div>
                  
               </div>
            </div>
         </div>
         
         
         
            </td>
            
         </tr>
      </c:forEach>
      <tr height="1" bgcolor="#eeeeee">
         <td colspan="8"></td>
      </tr>

   </table>
     
   
   <div align="center" >
      <div class="paginatation-sm">
    <a href="/givook/mymessage.do?pageNo=${paging.pageNo}&recvpageNo=${recvpaging.prevPageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-previous.svg" width=18; height="18" ></a>
    <span>
        <c:forEach var="i" begin="${recvpaging.startPageNo}" end="${recvpaging.endPageNo}" step="1">
           <a href="/givook/mymessage.do?pageNo=${paging.pageNo}&recvpageNo=${i}" >${i}</a>
        </c:forEach>
    </span>
    <a href="/givook/mymessage.do?pageNo=${paging.pageNo}&recvpageNo=${recvpaging.nextPageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-next.svg" width=18; height= 18; border="0"></a>
   
</div>
   </div>
   
         </div><!-- column끝 -->
	

      </div>
      <!--row끝  -->
</div> 

   </div>
   <!-- container끝 -->
   
   
   <br>
   <br>


</body>
</html>