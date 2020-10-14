<%@page import="kr.or.ddit.member.model.JobVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="/layout/commonLib.jsp" %>
</head>
<body>
	<%@ include file="/layout/header.jsp" %>

	<div class="container-fluid">
		<div class="row">
			
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp" %>
			</div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">Jops</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>jop Id</th>
					<th>jop Title</th>
				</tr>
			<%
				List<JobVo> joblist = (List<JobVo>)request.getAttribute("joblist");
	
				for(int i =0; i< joblist.size(); i++){
			%>
				<tr>
					<td><%=joblist.get(i).getJob_id() %></td>
					<td><%=joblist.get(i).getJob_title() %></td>
				</tr>

		<%	} %>
		
			</table>
		</div>
					<a class="btn btn-default pull-right">사용자 등록</a>
			
					<div class="text-center">
						<ul class="pagination">
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



</body>
</html>