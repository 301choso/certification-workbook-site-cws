<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet"/>
	<link rel="stylesheet" href="${contextPath}/resources/css/css.css" type="text/css"/>
<script type="text/javascript">
function checkAll(){
	var id = document.getElementById("member_id");
	var pw = document.getElementById("member_pw");
	
	if(!id.value) {
		alert("아이디를 입력하세요");
		id.focus();
		return false;
	};
	
	if(!pw.value) {
		alert("비밀번호를 입력하세요");
		pw.focus();
		return false;
	};
	
	document.login_form.submit();
}
</script>
</head>
<body>
<div class="wrap">
	<div class="login">
		<form name="login_form" action="${contextPath}/member/login.do" method="post">
	    <h2>로그인</h2>
	   
	    <div class="login_id">
	        <h4>아이디</h4>
	        <input type="text" name="member_id" id="member_id" placeholder="아이디 입력">
	    </div>
	    <div class="login_pw">
	        <h4>비밀번호</h4>
	        <input type="password" name="member_pw" id="member_pw" placeholder="비밀번호 입력">
	    </div>
	    <div class="login_etc">
	        <div class="checkbox">
	        <input type="checkbox" name="" id=""> 로그인 상태유지&emsp;|&emsp;
	        </div>
	        <div class="forgot_pw">
	        <a href="">비밀번호 찾기</a>
	    	</div>
	    </div>
	    <div class="submit">
	        <input type="button" value="로그인" onclick="return checkAll()">	
	    </div>
	    </form>
	</div>
 </div>	
</body>
</html>