<%@page import="javax.naming.NamingException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Connection Pooling Test</h2><p>
<%
/* 
1. Naming service�� ���� ��ü�� ���� ����
2. lookup�� ã�ƿ�...DataSource
3. DataSource�� getConnection()�� �̿��ؼ�  Connection �� ��Ʈ��
*/
	try{
	Context ic = new InitialContext(); // ��ü���� 
	DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
	
	out.println("<b>DataSource ... lookup ... </b><p>");
	
	Connection conn = ds.getConnection();
		out.println("<h2>Connection Rent SUCCESS!!!</h2><p>");
	
	}catch(NamingException e){
		out.println("<h2>Connection Rent FAIL!!!</h2><p>");
	}

	

%>
</body>
</html>














