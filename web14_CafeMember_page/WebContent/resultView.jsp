<!- 내장객체 (무조건소문)
request, reponse , out
page,session,
application,exception
-->

<!-- Directive Element (지시어) :: 컴파일 시점에 컨테이너 에게 알려주는 내용  -->
<%@page import="context.model.MemberVO,java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- jsp comment :: Scriplet Element 자바 코드만 들어간다 . --%>

<%
	MemberVO vo = (MemberVO)request.getAttribute("vo");
	out.println(vo);

%>

<hr>
<jsp:include page="include.jsp"/>

<h2>당신의 정보를 출력합니다. ... </h2>

<!-- html :: comment Expression Element -->
ID :<%= vo.getId() %><br>
NAME :<%= vo.getName() %><br>
ADDRESS :<%= vo.getAddress() %><br>

</body>
</html>