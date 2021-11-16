<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
	<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
 <div class="board_wrap">
	<div class="row justify-content-between">
	    <div class="col-4">
	      <strong>최신문제</strong>
	    </div>
	    <div class="col-2">
	      <a href="${contextPath}/board/qListBoard.do" >더보기</a>
	    </div>
    </div>	
	<hr>	
	 <div class="board_list">
		<div class = "top">
			<div class="num">번호</div>
			<div class="title">제목</div>
			<div class="date">작성일</div>
			<div class="author">글쓴이</div>
		</div>
		<c:forEach var="blist" items="${board_list}" >
		 <div>
			<div class="num">${blist.board_num}</div>
			<div class="title"><a href="${contextPath}/board/viewBoard.do?board_num=${blist.board_num}">${blist.board_title}</a></div>
			<div class="date"><fmt:formatDate value="${blist.board_date}" pattern="yyyy-MM-dd (hh:mm:ss)"/></div>
			<div class="author">${blist.member_id}</div>
		 </div>
		</c:forEach>
	</div>
	<br/><br/>
	<div class="row justify-content-between">
	    <div class="col-4">
	      <strong>공지사항</strong>
	    </div>
	    <div class="col-2">
	      <a href="${contextPath}/board/noticeList.do" >더보기</a>
	    </div>
    </div>	
	<hr>	
	 <div class="board_list">
		<div class = "top">
			<div class="num">번호</div>
			<div class="title">제목</div>
			<div class="date">작성일</div>
		</div>
		<c:forEach var="nlist" items="${notice_list}" >
		 <div>
			<div class="num">${nlist.notice_num}</div>
			<div class="title"><a href="${contextPath}/board/noticeView.do?notice_num=${nlist.notice_num}">${nlist.notice_title}</a></div>
			<div class="date"><fmt:formatDate value="${nlist.notice_date}" pattern="yyyy-MM-dd (hh:mm:ss)"/></div>			
		 </div>
		</c:forEach>
	</div>
 </div>	
</body>
</html>