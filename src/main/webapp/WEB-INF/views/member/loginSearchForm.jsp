<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<script type="text/javascript">
function check() {
	var email = document.getElementById("member_email1");
	
	if(email.value == ""){
		alert("값을 입력하세요");
	}
	
	document.loginSearch_form.submit();
}
</script>
</head>
<body>
<div class="wrap">
	<div class="login">
		<form name="loginSearch_form" action="${contextPath}/member/loginSearch.do" method="post">
	    <h2>이메일을 입력하세요</h2>
	   <div class="login_email1">
	        <h4>이메일</h4>
	        <input type="text" name="member_email1" id="member_email1" placeholder="이메일 입력"> @	
	    </div>
	    <div class="login_email2">
            <select name="member_email2" id="member_email2" title="직접입력">
                   <option value="non">직접입력</option>
                   <option value="hanmail.net">hanmail.net</option>
                   <option value="naver.com">naver.com</option>
                   <option value="nate.com">nate.com</option>
                   <option value="google.com">google.com</option>
                   <option value="gmail.com">gmail.com</option>
                   <option value="empal.com">empal.com</option>
                   <option value="korea.com">korea.com</option>
                   <option value="freechal.com">freechal.com</option>
             </select><br> <br> 
	    </div>
	    <div class="submit">
	        <input type="button" value="찾기" onclick="check()">	
	    </div>
	    </form>
	</div>
 </div>	
</body>
</html>