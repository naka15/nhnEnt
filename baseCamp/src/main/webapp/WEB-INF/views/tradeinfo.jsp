<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>

<style type="text/css">
.width {
   width: 90%;
   font-size: 17px;
}

.rcolor {
   color: red;
}

.gcolor {
   color: green;
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
   width: 100%;
   margin-left: auto;
   margin-right: auto;
}
</style>


<body>

   <jsp:include page="header.jsp"></jsp:include>
   <jsp:include page="mainmenu_bar.jsp"></jsp:include>


   <br>
   <br>
   <Br>


   <div class="container">
      <div class="fontsize">
         <div
            style="background-color: #b0c4de; color: #ffffff; padding: 30px;"
            align="center" class="center1">내 정보 수정</div>
      </div>
      <br>

      <div class="center1">
         <div class="row">

            <div class="col-md-3">

               <div class="center3">
                  <br>
                  <div class="list-group" align="center">
                     <a href="mypage.do" class="list-group-item">회원 정보</a> <a
                        href="modifyinfo.do" class="list-group-item">회원 정보 수정</a>
                     <a href="mypoint.do" class="list-group-item">포인트</a> <a
                        href="mycontent.do" class="list-group-item">내글보기</a> <a
                        href="tradeinfo.do" class="list-group-item active">거래중내역</a> <a
                        href="out.do" class="list-group-item">탈퇴하기</a>
                  </div>

               </div>
               </div>

               <div class="col-md-9">

                  <br>

                  <h1>기부 상황</h1>
                  <table>
                     <tr>
                        <th>기부대상자</th>
                        <th>게시물번호</th>
                        <th>게시물제목</th>
                        <th>거래시작날짜</th>
                        <th>진행현황</th>
                     </tr>
                     <c:forEach items="${trade}" var="trade">
                        <tr>
                           <td>${trade.receiverUserNick}</td>
                           <td>${trade.noticeNo}</td>
                           <td>${trade.notice.noticeTitle}</td>
                           <td>${trade.tradeDate}</td>
                           <td>${trade.tradeStatus}</td>
                        </tr>
                     </c:forEach>
                  </table>
                  
                  <div align="center" >
      <div class="paginatation-sm">
    <a href="/givook/tradeinfo.do?pageNo=${paging.prevPageNo}&pageNo2=${paging2.pageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-previous.svg" width=18; height="18" ></a>
    <span>
        <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
           <a href="/givook/tradeinfo.do?pageNo=${i}&pageNo2=${paging2.pageNo}" >${i}</a>
        </c:forEach>
    </span>
    <a href="/givook/tradeinfo.do?pageNo=${paging.nextPageNo}&pageNo2=${paging2.pageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-next.svg" width=18; height= 18; border="0"></a>
   
</div>
   </div>
                  <br>
                  
                  <h1>받는 거래 상황</h1>
                     <table>
                     <tr>
                        <th>기부자</th>
                        <th>게시물번호</th>
                        <th>게시물제목</th>
                        <th>거래시작날짜</th>
                        <th>진행현황</th>
                        <th>수령확인</th>
                     </tr>
                  <c:forEach items="${gettrade}" var="gettrade">
                     <tr>
                     <td>${gettrade.senderUserNick}</td>
                     <td>${gettrade.noticeNo}</td>
                     <td>${gettrade.notice.noticeTitle}</td>
                     <td>${gettrade.tradeDate}</td>
                     <td>${gettrade.tradeStatus}</td>
                     <td>
                        <button  class="btn btn-primary btn-lg"
                              data-toggle="modal" data-target="#myModal" onclick="callmodalajax(${gettrade.noticeNo},'${gettrade.tradeStatus}')"></button> <!-- Modal -->
                           <div class="modal fade" id="myModal" tabindex="-1"
                              role="dialog" aria-labelledby="myModalLabel"
                              aria-hidden="true">
                              <div id="aa">
                                 
                                 
                                 
                              </div>
                           </div>
                     </td>
                     <td></td>
                     </tr>
                  </c:forEach>
                     </table>
                     <div align="center" >
      <div class="paginatation-sm">
    <a href="/givook/tradeinfo.do?pageNo=${paging.pageNo}&pageNo2=${paging2.prevPageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-previous.svg" width=18; height="18" ></a>
    <span>
        <c:forEach var="i" begin="${paging2.startPageNo}" end="${paging2.endPageNo}" step="1">
           <a href="/givook/tradeinfo.do?pageNo=${paging.pageNo}&pageNo2=${i}" >${i}</a>
        </c:forEach>
    </span>
    <a href="/givook/tradeinfo.do?pageNo=${paging.pageNo}&pageNo2=${paging2.nextPageNo}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-next.svg" width=18; height= 18; border="0"></a>
   
</div>
   </div>
                     
                     
               </div>
               
               
            </div>
         </div>
      </div>
      
<script type="text/javascript">
       function callmodalajax(noticeNo,tradeStatus){
          alert(tradeStatus);
   $.ajax({
         url: 'changeStatus.do',
         
         data : "noticeNo=" + noticeNo + "&tradeStatus="+encodeURI(tradeStatus, "UTF-8"),
         
         
         success: function(data) {
            $("#aa").html(data);
         },
         type: 'GET'
      });
}
</script>
</body>
</html>