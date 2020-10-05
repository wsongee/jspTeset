<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
out.jsp
<%
List<String> rangers = (List<String>) request.getAttribute("rangers");	

	for(String name : rangers){
		out.write(name);
	}
	
%>

</body>
</html>