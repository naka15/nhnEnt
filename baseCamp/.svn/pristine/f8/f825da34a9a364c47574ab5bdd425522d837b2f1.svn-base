<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="paginatation-sm">
    <a href="/givook/${param.str}.do?pageNo=${param.firstPageNo}&searchopt=${param.searchopt}&searchtext=${param.searchtext}&genre=${param.genre}" >Pre page</a>
    <a href="/givook/${param.str}.do?pageNo=${param.prevPageNo}&searchopt=${param.searchopt}&searchtext=${param.searchtext}&genre=${param.genre}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-previous.svg" width=18; height="18" ></a>
    <span>
        <c:forEach var="i" begin="${param.startPageNo}" end="${param.endPageNo}" step="1">
           <a href="/givook/${param.str}.do?pageNo=${i}&searchopt=${param.searchopt}&searchtext=${param.searchtext}&genre=${param.genre}" >${i}</a>
        </c:forEach>
    </span>
    <a href="/givook/${param.str}.do?pageNo=${param.nextPageNo}&searchopt=${param.searchopt}&searchtext=${param.searchtext}&genre=${param.genre}"><img src="<%=request.getContextPath()%>/resources/img/svgs/fi-next.svg" width=18; height= 18; border="0"></a>
    <a href="/givook/${param.str}.do?pageNo=${param.finalPageNo}&searchopt=${param.searchopt}&searchtext=${param.searchtext}&genre=${param.genre}" >Last page</a>
</div>
<br><br><br>
