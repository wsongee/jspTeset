<%@page import="kr.or.ddit.member.model.JobVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/layout/commonLib.jsp" %>
</head>

<body>
<%@ include file="/layout/header.jsp" %>

<div class="container-fluid">
		<div class="row">
		
			<div class="col-sm-3 col-md-2 sidebar">
			
			<%@ include file="/layout/left.jsp"%>
			
			</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">잡스</h2>
		<div class="table-responsive">
			<table class="table table-striped">


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