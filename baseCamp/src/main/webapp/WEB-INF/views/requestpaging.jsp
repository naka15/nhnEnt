<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
function goPage(pageNo){
	return "/givook/board2-1.do?pageNo="+pageNo;
}

</script>

<div class="paginate">
    <a href="/givook/board2-1.do?pageNo=${param.firstPageNo}" class="first">처음 페이지</a>
    <a href="/givook/board2-1.do?pageNo=${param.prevPageNo}"><img src="<%=request.getContextPath()%>/resources/img/prev.gif" border="0"></a>
    <span>
        <c:forEach var="i" begin="${param.startPageNo}" end="${param.endPageNo}" step="1">
           <a href="/givook/request_notice.do?pageNo=${i}&searchopt=${param.searchopt}&searchtext=${param.searchtext}" class="choice">${i}</a>
        </c:forEach>
    </span>
    <a href="/givook/board2-1.do?pageNo=${param.nextPageNo}"><img src="<%=request.getContextPath()%>/resources/img/next.gif" border="0"></a>
    <a href="/givook/board2-1.do?pageNo=${param.finalPageNo}" class="last">마지막 페이지</a>
</div>
