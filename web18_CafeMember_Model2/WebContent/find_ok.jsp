<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
검색하신 회원 정보입니다.  ::
<%=request.getAttribute("mvo") %>
<P>
무얼 하고 싶으신가요 ? <br>
<a href="index.jsp">홈으로 가기</a><br>
<a href="find.jsp">다시 검색 하기 </a>

</body>
</html>