<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${mvo!=null}">
		<b>${mvo.name} 님, 까페입장을 환영합니다.</b><br>
		<a href="index.jsp">index 페이지로 가기</a>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("로그인 하셔야 까페입장 하실수 있습니다..");
			location.href="login.jsp";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>



















