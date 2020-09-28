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
	dispatcherView.jsp
	
	<%
		List<String> rangers = (List<String>) request.getAttribute("rangers");
	
		for(int i =0; i< rangers.size(); i++){
			
	%>
	<table>
		<tr>
			<th>이름<th>
			<th><%=	rangers %></th>
		</tr>
	</table>
	
	
	<%} %>
	
</body>
</html>