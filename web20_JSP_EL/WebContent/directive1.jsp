<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
1. 지시에로 사용되는 include file="index.jsp"
는 정적인 문서만 include 되어 진다.

2. 동적인 문서를 include하는 방법도 있다
이건 컴파일 시점에 포함되지 않겠지...


 -->
<body>
<h2>Directi Element....include test</h2>
<hr>
<%@ include file="index.jsp"  %>
<P>
<HR>
<%@ include file="idcheck.jsp" %>
<P>
<HR>
<jsp:include page="idcheck.jsp"></jsp:include>	
</body>
</html>
