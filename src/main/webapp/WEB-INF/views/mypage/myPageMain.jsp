<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
	<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${contextPath}/resources/css/css.css" type="text/css"/>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
 <div class="board_wrap">
	    <div>
	      <strong>마이페이지</strong>
	    </div>
	<hr>	
	 <div class="board_list">
		<div class = "top">
			<div class="num">문제번호</div>
			<div class="date">담은 날짜</div>
		</div>
		<c:forEach var="qlist" items="${qlist}">
		<div>
			<div class="num"><a href="${contextPath}/board/viewBoard.do?board_num=${qlist.board_num}">${qlist.board_num}</a></div>
			<div class="date"><fmt:formatDate value="${qlist.mypage_date}" pattern="yyyy-MM-dd (hh:mm:ss)"/></div>
			<div><a href="${contextPath}/mypage/deleteMypage.do?mypage_num=${qlist.mypage_num}" onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a></div>
		</div>
		</c:forEach>
	</div>
	<br/><br/>
	    <div>
	      <strong>내가 작성한 게시물</strong>
	    </div>	    
	<hr>	
	 <div class="board_list">
		<div class = "top">
			<div class="num">번호</div>
			<div class="title">제목</div>
			<div class="date">작성일</div>
		</div>
		<c:forEach var="blist" items="${blist}">
			<c:if test="${blist !=null and blist !=''}">		
			<div>
				<div class="num">${blist.board_num}</div>
				<div class="title"><a href="${contextPath}/board/viewBoard.do?board_num=${blist.board_num}">${blist.board_title}</a></div>
				<div class="date"><fmt:formatDate value="${blist.board_date}" pattern="yyyy-MM-dd (hh:mm:ss)"/></div>
			</div>
			</c:if>
		</c:forEach>		
	</div>
 </div>	
</body>
</html>