<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width">
  
   
</head>
<body>
 	<div id="outer_wrap">
		<div id="wrap">
			<header>
				   <tiles:insertAttribute name="header" />
			</header>
			
				<div class="clear"></div>
			
			<article>
			 	<tiles:insertAttribute name="body" />
			</article>
			
				<div class="clear"></div>
			
			<footer>
        		<tiles:insertAttribute name="footer" />
        	</footer>
        	
		</div>
		
		 
		 	
		 
		 
				
    </div>   
</body>
</html>