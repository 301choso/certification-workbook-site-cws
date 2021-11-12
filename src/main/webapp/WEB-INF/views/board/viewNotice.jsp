<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<div class="board_wrap">
 	<p>카테고리</p>
	<div class="board_title">
	    <div class="col-4">
	      <strong>공지사항</strong>
	    </div>
	</div>
	
	<div class="board_view_wrap">
		<div class="board_view">
		<div class = "title">
			${list.notice_title}
		</div>
		<div class="cont">
			${list.notice_content}
		</div>
		</div>
		
	 <div class="bt_wrap">
		<a href="${contextPath}/board/noticeList.do" class="on">목록</a>
	 </div>
	</div>
</div>
</body>
</html>