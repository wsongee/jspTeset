<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action ="<%=request.getContextPath()%>/mulCalculationServlet" method="POST">
	param1 : <input type="text" name="param1" value="2"><br>
	param2 : <input type="text" name="param2" value="4"><br>
	<input type="submit" value="전송">
</form>

</body>
</html>