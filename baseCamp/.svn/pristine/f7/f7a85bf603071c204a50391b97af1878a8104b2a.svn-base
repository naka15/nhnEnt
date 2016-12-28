<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="modal-dialog modal-sm" id="selectTarget">
   <div class="modal-content" >
      <div id="abc">
      <div class="modal-header" >
         <button type="button" class="close" data-dismiss="modal"
            aria-label="Close">
            <span aria-hidden="true">&times;</span>
         </button>
         <h4 class="modal-title" id="myModalLabel">기부대상 선택</h4>
      </div>
      <div class="modal-body" align="center">
      <form name="formname">
         <table>
            <tr align="center">
               <th>기부대상자</th>
               <th>선택</th>
            </tr>
            <tr>
               <td>선택 안함</td>
               <td><input type="radio" name="target" value="null"></td>
            </tr>
            <c:forEach items="${users}" var="users">
               <tr align="center">
                  <td>${users.userNick}</td>
                  <td><input type="radio" name="target" value="${users.userId}">

                  </td>
               </tr>
            </c:forEach>
            
         </table>
         <input type="hidden" id="noticeNo" value="${noticeNo}">
      </form>
      
      </div>
      
      <div class="modal-footer">
         <button type="button" class="btn btn-default" id="btnclose"
            onclick="RadioCheck()">확인</button>
         <button type="button" class="btn btn-primary" onclick="RadioCheck()">Save changes</button>

      </div>  
      </div>      <!-- ajax #abc 끝 -->
   
   </div>
     
</div>
<script>
   function RadioCheck() {
      
      var noticeNo=$("#noticeNo").val();
      var userId;
   
      var size=document.formname.elements["target"].length;
      alert(noticeNo);

      for (var i = 0; i < size; i++) {
         if (document.formname.elements["target"][i].checked) {
            userId = document.formname.elements['target'][i].value;
            $("#bb").html(document.formname.elements['target'][i].value);
            break;
         }
      }
      /* if(userId==("null")){
            $.ajax({
               url:'tradStart.do',
               
               data:"noticeNo="+noticeNo,
               success:fucntion(data){
                  
                  alert("delete");
               }
               
               type: 'GET'
            }) */
            
         
      
      alert("유저---"+userId);
      
      $.ajax({
         url: 'tradeStart.do',
         
         data : "userId=" + userId+"&noticeNo="+noticeNo,
         
         success: function(data){
              // $(".modal-footer").css("display","none");
               //$("#btnclose").attr("data-dismiss","modal2");
               $("#abc").html(data);
         
         },
         
         type: 'GET'
      
      });
      
   };
   
</script>