<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
</head>
<body>	
 <div class="board_wrap">	
 	<strong>회원관리 - 카테고리</strong>&nbsp;
 	<select onchange="location.href=this.value">
 		<option selected>회원관리</option>
 		<option value="${contextPath}/admin/adminNoticePage.do">공지사항</option>
 	</select>
 	<p>
	<div class="board_list_wrap">
	 <div class="board_list">
		<div class = "top">
			<div class="num">회원번호</div>
			<div class="id">아이디</div>
			<div class="email">이메일</div>
			<div class="join_date">가입일</div>
			<div class="member_yn">탈퇴여부</div>
		</div>
	
		
		<c:forEach var="list" items="${list}">
		 <div>
			<div class="num">${list.member_num}</div>
			<div class="id">${list.member_id}</div>
			<div class="email">${list.member_email}</div>
			<div class="join_date">${list.member_join_date}</div>
			<div class="member_yn">${list.member_member_yn}</div>
			<div class="edit_btn">
			<a href="${contextPath}/admin/goEditMemberForm.do?member_num=${list.member_num}">수정</a>
			</div>
		 </div>
		</c:forEach>
		</div>
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
	</div>

</body>
</html>