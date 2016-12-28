<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- 거래가 완료되었음을 확인하는 modal 창-->
<div class="modal-dialog modal-sm" id="selectTarget">
   <div class="modal-content">
      <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal"
            aria-label="Close">
            <span aria-hidden="true">&times;</span>
         </button>
         <h4 class="modal-title" id="myModalLabel">기부대상 선택</h4>
      </div>
      <div class="modal-body" align="center">
      <form name="formname">
         <c:choose>
         <c:when test="${tradeStatus=='거래중'}">
         책을 받으셨으면 확인을 눌러주세요.
         </c:when>
         <c:when test="${tradeStatus=='거래완료'}">
         이미 완료된 거래입니다.
         </c:when>
         </c:choose>
      
         <input type="hidden" id="noticeNo" value="${noticeNo}">
      </form>
         <button type="button" class="btn btn-default" data-dismiss="modal"
            onclick="change()">확인</button>
         <button type="button" class="btn btn-primary" data-dismiss="modal">취소</button>

      </div>
   </div>
   
</div>
<script>
   function change() {
      
      var noticeNo=$("#noticeNo").val();
      
      
      $.ajax({
         url: 'changeStatus.do',
         
         data : "noticeNo="+noticeNo,
         
         success: function(data){
            alert("성공");
         },
         
         type: 'GET'
      
      });
      
   };
   
</script>