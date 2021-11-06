<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet"/>	
	<link rel="stylesheet" href="${contextPath}/resources/css/css.css" type="text/css"/>	
<script type="text/javascript">
function checkAll(){
	
	var pw = document.getElementById("member_pw");
	var pw2 = document.getElementById("member_pw2");
	var email = document.getElementById("member_email1");	 
	
	if(pw.value == "") {
		alert("비밀번호를 입력하세요");
		id.focus();
		return false;
	};
	
	<!--비밀번호 영문자+숫자+특수조합(6~20자리 입력) 정규식-->
	var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,20}$/;
	
	if(!pwdCheck.test(pw.value)) {
		alert("비밀번호는 영문자+숫자+특수문자 조합으로 6~20자리 사용해야 합니다.");
		pw.focus();
		return false;
	}
	
	if(pw2.value == "") {
		alert("비밀번호 확인란을 입력하세요");
		id.focus();
		return false;
	};
	
	if(pw.value != pw2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	};
	
	if(!document.getElementById("email_yn").checked){
		document.getElementById('member_email_yn').value="N";	
	};
	
	document.edit_form.submit();
}
function idCheck(){
	var id = $("#member_id").val();
	
	if(id.replace(/\s/g,'') == "") {
		alert("아이디를 입력하세요");
		$("#member_id").focus();
		return false;
	};
	
	if(id.length < 5 || id.length > 12) {
		alert("아이디는 5~12자 이내로 입력해야 합니다.");
		$("#member_id").focus();
		return false;
	}
	
	var special_pattern =/[`~!@#$%^&*|\\\'\";:\/?]/gi;

	if(special_pattern.test(id) == true) {
		
		alert("공백 혹은 특수문자는 입력할 수 없습니다.");
	 	return false;
	}
	
	if(id.search(/\s/) != -1) {
		alert("공백은 입력할 수 없습니다.");
	 	return false;
	}
	
	$.ajax({
		type : 'get',
		async:false,
		url : "${contextPath}/member/idCheck.do?member_id="+id,
		dataType:"text",
		success : function(data) {
			console.log("1 = 중복 0 / 0 = 중복없음 : "+data);
			
			if(data == 1) {
				$("#id_check").text("사용중인 아이디 입니다");
				$("#id_check").css("color", "red");
				$("#reg_submit").attr("disabled",true);
			}else{
				if(member_id ==" ") {
					$("#id_check").text("아이디를 입력해주세요");
					$("#id_check").css("color", "red");
					$("#reg_submit").attr("disabled",true);
				}else{
					$("#id_check").text("사용가능한 아이디입니다");
					$("#id_check").css("color", "red");
					$("#reg_submit").attr("disabled", false);
				}
				
			}
		}, error : function(){
			console.error();
		}
		
	});
};
</script>
</head>
<div class="wrap">
	<div class="login">
		<form name="edit_form" action="${contextPath}/admin/updateMember.do" method="post" onSubmit="return checkAll(this)">
	    <h2>회원 정보 수정</h2>
	   <input type="hidden" name="member_num" id="member_num" value="${list.member_num}">
	    <div class="login_id">
	        <h4>아이디</h4>
	        <input type="text" name="member_id" id="member_id" value="${list.member_id}" required>
	        <input type="button"  id="btnOverlapped" value="아이디 중복 확인" onClick="idCheck()" >
	   		<div class="check_font" id="id_check" ></div>
	    </div>
	    <div class="login_pw">
	        <h4>비밀번호</h4>
	        <input type="password" name="member_pw" id="member_pw" value="${list.member_pw}">
	    </div>
	    <div class="login_pw">
	        <h4>비밀번호 확인</h4>
	        <input type="password" name="member_pw2" id="member_pw2" value="${list.member_pw}">
	    </div>
	    <div class="login_email1">
	        <h4>이메일</h4>
	        <c:set var="member_email1" value="${fn:substringBefore(list.member_email,'@')}" />
	        <input type="text" name="member_email1" id="member_email1" value="${member_email1}"> @	
	    </div>
	    <div class="login_email2">
	    <c:set var="member_email2" value="${fn:substringAfter(list.member_email,'@')}" />
            <select name="member_email2" id="member_email2" >
                   <option value="${member_email2}">${member_email2}</option>
                   <option value="hanmail.net">hanmail.net</option>
                   <option value="naver.com">naver.com</option>
                   <option value="nate.com">nate.com</option>
                   <option value="google.com">google.com</option>
                   <option value="gmail.com">gmail.com</option>
                   <option value="empal.com">empal.com</option>
                   <option value="korea.com">korea.com</option>
                   <option value="freechal.com">freechal.com</option>
             </select><br> <br> 
             <input type="hidden" id="member_email_yn" name="member_email_yn" value="Y" /> 
             <input type="checkbox" id="email_yn" name="email_yn" checked="checked"/> 
             대회 안내/강의 안내/채용 안내/기타 안내 및 광고 이메일 받기 
	    </div>
	    <div class="submit">
	        <input type="submit" value="수정하기" id="reg_submit">
	    </div>
	    </form>
	</div>
 </div>		
</body>
</html>