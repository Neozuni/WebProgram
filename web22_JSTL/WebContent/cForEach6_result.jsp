<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>오늘의 점심메뉴입니다...</h2><p>
1. EL ::<BR>
${MENU[0]},${MENU[1]},${MENU[2]},${MENU[3]}<br>
<hr>
2. 	JSTL ::<BR>
<UL>
	<c:forEach var="dish" items="${MENU}">
		<li> ${dish}</li>
	</c:forEach>
</UL>

</body>
</html>









