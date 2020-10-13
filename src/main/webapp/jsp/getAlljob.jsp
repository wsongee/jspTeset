<%@page import="kr.or.ddit.member.model.JobVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

		<table border="1">
			<tr>
				<td>jobID</td>
				<td>jobTitle</td>
			</tr>
			
<%
	List<JobVo> joblist = (List<JobVo>)request.getAttribute("joblist");

	for(int i =0; i< joblist.size(); i++){
%>
			
			<tr>
				<td><%=joblist.get(i).getJob_id() %></td>
				<td><%=joblist.get(i).getJob_title() %></td>
			</tr>

	<%
		}
	
	%>
		
		
		</table>



</body>
</html>