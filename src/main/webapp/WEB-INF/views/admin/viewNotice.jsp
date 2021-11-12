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
		<div class="row justify-content-between">
		    <div class="col-4">
		      <strong>공지사항</strong>
		    </div>
		    <div class="col-2 mt-2">
				<a class="btn btn-outline-primary" href="${contextPath}/admin/goEditNoticeForm.do?notice_num=${list.notice_num}" role="button">수정</a>
				<a class="btn btn-outline-primary" href="${contextPath}/admin/deleteNotice.do?notice_num=${list.notice_num}" role="button"
				onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a>	     
			</div>
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
		<input type = "reset" value = "새로고침">
	 <div class="bt_wrap">
		<a href="${contextPath}/admin/goEditNoticeForm.do?notice_num=${list.notice_num}">수정</a>
		<a href="${contextPath}/admin/adminNoticePage.do" class="on">목록</a>
	 </div>
	</div>
</div>
</body>
</html>