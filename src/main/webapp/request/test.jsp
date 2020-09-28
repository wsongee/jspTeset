<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- jsp 스크립트: 서버에서 실행됨
		<% %> , <%= %>
	 --%>
	<% String str="message"; %> <%--서버에서 실행이 되었기 때문에 test라는 텍스트를 message라는 변수에 담게된다. --%>
	<% String str2 = ""; %> <%--str2에는 아무것도 넣지 않았기 때문에 = 'test' 에러발생  --%>
	<% String str3 = "hello"; %>
<script>

	/*서버사이드 변수에 클라이언트 사이드 값을 대입하는 경우(X) 
	  서버사이드 스크립트가 먼저 실행되므로 논리적으로 말이안된다. */
	  
	<%= str %> = 'test';
	//<%= str2 %> = 'test'; <%-- 스크립트 주석은 실행이된다.--%>
	<%--<%= str2 %> = 'test';--%> <%-- jsp주석은 서버에서 실행이 되지 않는다. --%>

	/* 클라이언트 사이드 변수에 서버 사이드 변수값을 대입
	  서버사이드 스크립트가 먼저 실행되므로 논리적으로 말이된다. */
	var msg = '<%= str3 %>'; <%-- '' 로 묶어주면 문자열로 전달이 된다. 묶어주지 않았을 때, 에러 --%>

	<%-- 결과만 클라이언트에게 전달된다는 점을 기억하기 --%>
	
</script>
</body>
</html>