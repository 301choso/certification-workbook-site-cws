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
<form name="post" action="${contextPath}/board/addBoard.do" method="post"> 
<div class="board_wrap">
	<div class="board_title">
	 	<strong>게시판</strong>
	 	<p>게시물을 입력하세요</p>
	</div>

	<div class="board_write_wrap">
		<div class="board_write">
		<div class = "title">
		<input type = "hidden" name = "member_num" value="${memberInfo.member_num}"> 
			<dl>
				<dt>제목</dt>
				<dd><input type="text" name="board_title" placeholder="제목 입력"></dd>
			</dl>
		</div>
		<div class="info">
			<dl>
				<dt>카테고리</dt>
				<dd>
					<select name = "board_category">
					<option selected="selected" value="기출문제">기출문제</option>
					<option>요약정리</option>
					</select> 
				</dd>
			</dl>
		</div>
		<div class="cont">
			<textarea name = "board_content" placeholder="내용 입력"></textarea>
			<textarea name = "board_answer" placeholder="정답 입력"></textarea>		
		</div>
		</div>
		<input type = "reset" value = "새로고침">
	 <div class="bt_wrap">
		<a href="javascript:post.submit();">등록</a>
		<a href="${contextPath}/main/main.do" class="on" 
		onclick="return confirm('작성중인 내용이 사라집니다. 목록으로 이동하시겠습니까?')">목록</a>
	 </div>
	</div>
</div>
</form>
</body>
</html>