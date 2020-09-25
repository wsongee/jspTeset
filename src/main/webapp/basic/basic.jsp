<%@page import="java.util.Date"%>
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
		//스크립틀릿 : 자바 로직을 작성하는 공간
		//특정메소드 안에서 구현하는 자바로직(지역변수처럼 생각하면 된다)
		Date date = new Date();
	
		//서버에서 실행(시작)이되고 html로 응답
	%>
	
	<!-- expression : 화면에 출력을 해준다. 
		writer.print()
	-->
	현재시간 : <%=date %>
</body>
</html>