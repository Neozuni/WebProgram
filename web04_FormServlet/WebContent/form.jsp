<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- java code를 입력 :: doGet()/doPost()
		 jsp에서 request, response 객체를 이미 생성해놓고 제공하고 있다.
		 내장객체
	-->
	<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	
	String name = request.getParameter("name");
	String addr = request.getParameter("address");

	%>
	
	<ul><li> 당신의 이름 :: <%= name %> </li><br>
	<li> 당신의 주소 :: <%= addr %></li></ul><br>
	
</body>
</html>