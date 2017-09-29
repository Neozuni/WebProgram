<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!--  default scope가 존재....page가 된다.
	forward 할때는 반드시 scope를 request로 지정해 줘야 한다.
-->
<c:set var="CODE" value="1004" scope="request"/>
<c:set var="NAME" value="KOSTA"/>
<c:set var="PRICE" value="120000"/>

<jsp:forward page="cset3_result.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<B>상품 코드 :: ${CODE}</B>
</body>
</html>



<!--   cChoose4.jsp-->










