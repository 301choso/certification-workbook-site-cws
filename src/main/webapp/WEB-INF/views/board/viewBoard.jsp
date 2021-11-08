<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
<script>
function add_mypage(board_num) {
    $.ajax({
       type : "post",
       async : false, //false인 경우 동기식으로 처리한다.
       url : "${contextPath}/mypage/addMypage.do",
       data : {board_num : board_num},
       success : function(data, textStatus) {
          //alert(data);
       //   $('#message').append(data);
          if(data.trim()=='add_success'){
             imagePopup('open', '.layer01');   
          }else if(data.trim()=='already_existed'){
             alert("이미 관심목록에 있는 글입니다.");   
          }
          
       },
       error : function(data, textStatus) {
          alert("에러가 발생했습니다."+data);
       },
       complete : function(data, textStatus) {
          //alert("작업을완료 했습니다");
       }
    });   
 }

 function imagePopup(type) {
    if (type == 'open') {
       // 팝업창을 연다.
       jQuery('#layer').attr('style', 'visibility:visible');

       // 페이지를 가리기위한 레이어 영역의 높이를 페이지 전체의 높이와 같게 한다.
       jQuery('#layer').height(jQuery(document).height());
    }

    else if (type == 'close') {

       // 팝업창을 닫는다.
       jQuery('#layer').attr('style', 'visibility:hidden');
    }
 }
 function show_answer(){
	 jQuery('#answer').attr('style', 'visibility:visible');
 }
</script>
</head>
<body>
 <div class="board_wrap">
 	<p>카테고리 _ ${list.board_category}</p>
	<div class="board_title">
		<div class="row justify-content-between">
		    <div class="col-4">
		    </div>
		    <div class="col-2 mt-2">
		    <c:if test="${memberInfo.member_num == list.member_num }">
				<a class="btn btn-outline-primary" href="${contextPath}/board/goEditBoardForm.do?board_num=${list.board_num}" role="button">수정</a>
			    <a class="btn btn-outline-primary" href="${contextPath}/board/deleteBoard.do?board_num=${list.board_num}" role="button">삭제</a>	     
		    </c:if>
		    </div>
	    </div>		
	</div>
	<div class="board_view_wrap">
	<div class="board_view"><div class="title row justify-content-between">
		<div class="col-md-8">
				${list.board_title} 
			</div>
			<div class ="col-6 col-md-4">
			<c:if test="${memberInfo.member_num !='' and memberInfo.member_num !=null }">
			
			<div align="right">	
				<div id="wrap">
  					<button onclick="add_mypage('${list.board_num}');"><font size="3">관심목록에 추가</font></button>
				</div>
			</div>
			</c:if>
		 </div>
		</div>
		<div class = "info">
			<dl>
				<dt>번호</dt>
				<dd>${list.board_num}</dd>
			</dl>
			<dl>
				<dt>작성일</dt>
				<dd><fmt:formatDate value="${list.board_date}" pattern="yyyy-MM-dd (hh:mm:ss)"/></dd>
			</dl>
			<dl>
				<dt>글쓴이</dt>
				<dd>${list.member_num}</dd>
			</dl>
		</div>
		
		 <div class = "cont">
			${list.board_content}
		 <div>
		 <br>
	 	<button onclick="show_answer()">정답보기</button>
	 	<div id="answer" style="visibility:hidden">
	 		답 : ${list.board_answer}
	 	</div>
		 </div>
		 </div>
	</div>	
	<div class="bt_wrap">
		<a href="${contextPath}/main/main.do" class="on">목록</a>
	</div>
	</div>
 </div> 
 <div id="layer" style="visibility:hidden">
	  <div id="popup">
	 	<div id="contents">    
			관심목록에 추가되었습니다.<br> 마이페이지로 이동할까요?			
	   	</div>
	  	
	    <a href="javascript:;" onclick="javascript:imagePopup('close','.layer01');" 
	    id="close" ><button>계속 보기</button></a>&emsp;   	    	    
	    <a href="${contextPath}/mypage/myPageMain.do"><button>관심목록 보기</button></a>
 </div>
</div>
</body>
</html>