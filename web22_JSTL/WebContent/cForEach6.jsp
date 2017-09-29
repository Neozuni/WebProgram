<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String [ ] arr = {"삼계탕","샌드위치","곰탕","된장찌개"};
	request.setAttribute("MENU", arr);	
%>
<jsp:forward page="cForEach6_result.jsp"/>
</body>
</html>