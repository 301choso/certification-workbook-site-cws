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
<form name="post" action="${contextPath}/admin/addNotice.do" method="post"> 
<div class="board_wrap">
	<div class="board_title">
	 	<strong>게시판</strong>
	 	<p>게시물을 입력하세요</p>
	</div>

	<div class="board_write_wrap">
		<div class="board_write">
		<div class = "title">
			<dl>
				<dt>제목</dt>
				<dd><input type="text" name="notice_title" placeholder="제목 입력"></dd>
			</dl>
		</div>
		<div class="cont">
			<textarea name = "notice_content" placeholder="내용 입력"></textarea>	
		</div>
		</div>
		<input type = "reset" value = "새로고침">
	 <div class="bt_wrap">
		<a href="javascript:post.submit();">등록</a>
		<a href="${contextPath}/main/main.do" class="on">목록</a>
	 </div>
	</div>
</div>
</form>
</body>
</html>