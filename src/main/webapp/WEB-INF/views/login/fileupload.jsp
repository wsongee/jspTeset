<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- client form method : post
				 encType : multipart/form-data
	 server - servlet @MultipartConfig
	 		- spring Frameworkd multipartResolver -->
	 		
<form action="${cp}/fileupload/process" method="POST" enctype="multipart/form-data">
	<input type="file" name="file"><br>
	<input type="text" name ="userid" value="브라운"><br>
	<input type="submit" value="전송">
</form>

</body>
</html>