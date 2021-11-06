<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/css.css" type="text/css"/>
<title>게시물 입력</title>
</head>
<body>
<form name="post" action="${contextPath}/board/updateBoard.do" method="post"> 
<div class="board_wrap">
	<div class="board_title">
	 	<strong>게시판</strong>
	 	<p>게시물을 입력하세요</p>
	</div>
	<div class="board_write_wrap">
		<div class="board_write">
		<div class = "title">
		<input type="hidden" name="board_num" value="${list.board_num}">
			<dl>
				<dt>제목</dt>
				<dd><input type="text" name="board_title"  value="${list.board_title}"></dd>
			</dl>
		</div>
		<div class="info">
			<dl>
				<dt>카테고리</dt>
				<dd>
					<select name = "board_category">
					<option selected="selected">기출문제</option>
					<option>요약정리</option>
					</select> 
				</dd>
			</dl>
			<dl>
				<dt>글쓴이</dt>
				<dd><input type = "text" name = "member_num" value="${list.member_num}"></dd>
			</dl>
		</div>
		<div class="cont">
			<textarea name = "board_content" >${list.board_content}</textarea>
			<textarea name = "board_answer" >${list.board_answer}</textarea>		
		</div>
		</div>
		<input type = "reset" value = "새로고침">
	 <div class="bt_wrap">
			<a href="javascript:post.submit();">등록</a>
		<a href="/sh/main/main.do" class="on">목록</a>
	 </div>
	</div>	
</div>
</form>
</body>
</html>