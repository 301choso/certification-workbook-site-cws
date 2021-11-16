<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html lang="ko">
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<link rel="stylesheet" href="${contextPath}/resources/css/css.css" type="text/css"/>
	<script src="https://kit.fontawesome.com/0d7b38dd4a.js" crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-light px-4 my-3 py-3">
		<div class="navbar_logo display-5">
			<i class="fas fa-book"></i>
			<a href="${contextPath}/main/main.do">정처기 Book</a>
		</div>
	 <ul class="navbar-nav col-md-4 ms-auto"> 
		<li class="nav-item"> 
			<a class="nav-link" href="${contextPath}/board/qListBoard.do">문제</a> 
		</li> 
	  <c:choose>
		<c:when test="${isLogOn==true and not empty memberInfo}">
			<c:choose>
			<c:when test="${memberInfo.member_id == 'admin'}">
			<li class="nav-item">
				<a class="nav-link" href="${contextPath}/member/logOut.do">로그아웃</a> 
			</li>
			<li class="nav-item"> 
				<a class="nav-link" href="${contextPath}/admin/adminNoticePage.do">관리페이지</a> 
			</li>
			</c:when>
			<c:otherwise>
			<li class="nav-item">
				<a class="nav-link" href="${contextPath}/member/logOut.do">로그아웃</a> 
			</li>
			<li class="nav-item"> 
				<a class="nav-link" href="${contextPath}/mypage/myPageMain.do">마이페이지</a> 
			</li>
			</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<li class="nav-item">
				<a class="nav-link" href="${contextPath}/member/loginForm.do">로그인</a> 
			</li>
			<li class="nav-item"> 
				<a class="nav-link" href="${contextPath}/member/joinForm.do">회원가입</a> 
			</li> 
		</c:otherwise>
	  </c:choose>
	 </ul>
	</nav>
</body>
</html>