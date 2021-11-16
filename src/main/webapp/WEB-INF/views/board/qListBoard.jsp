<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<script type="text/javascript">
function checkSession(memberInfo){
	
	if(memberInfo == null || memberInfo == '') {
		alert("로그인이 필요합니다.");
		return;
	}else{
		location.href="${contextPath}/board/goAddBoardForm.do";
	}	
}	
</script>
</head>
<body>	
 <div class="board_wrap">	
 	<strong>문제목록 - 카테고리</strong>&nbsp;
 	<select>
 		<option value="">기출문제</option>
 		<option>요약정리</option>
 	</select>
 	<p>
	<div class="board_list_wrap">
	 <div class="board_list">
		<div class = "top">
			<div class="num">번호</div>
			<div class="title">제목</div>
			<div class="date">작성일</div>
			<div class="author">글쓴이</div>
		</div>
		
		<c:forEach var="list" items="${list}">
		 <div>
			<div class="num">${list.board_num}</div>
			<div class="title"><a href="${contextPath}/board/viewBoard.do?board_num=${list.board_num}">${list.board_title}</a></div>
			<div class="date"><fmt:formatDate value="${list.board_date}" pattern="yyyy-MM-dd (hh:mm:ss)"/></div>
			<div class="author">${list.member_id}</div>
		 </div>
		</c:forEach>
	</div>
	<div class="board_page">
		
		    <c:if test="${pageMaker.prev}">
		    	<a href="${pageMaker.makeQuery(pageMaker.startPage - 1)}"> << 이전 </a>
		    </c:if> 
		
		    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		    	<c:choose>
		    		<c:when test="${pageMaker.cri.page==idx}">
		    		
		    			 <a href="${pageMaker.makeQuery(idx)}">${idx}</a>
		    			
		    		</c:when>
		    		<c:otherwise>
		    			 <a href="${pageMaker.makeQuery(idx)}">${idx}</a>
		    		</c:otherwise>
		    	</c:choose>
		    </c:forEach>
		
		    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		    	<a href="${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음 >></a>
		    </c:if> 
	</div>

	<div class="bt_wrap">
		<a class="on" onclick="checkSession('${memberInfo.member_id}')">입력</a>
	</div>
	</div>
 </div>
</body>
</html>