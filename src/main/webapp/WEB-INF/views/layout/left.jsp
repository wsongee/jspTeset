<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<ul class="nav nav-sidebar">
	<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="${cp}/member/memberPageList">사용자</a></li>
	<li class="active"><a href="${pageContext.request.contextPath}/member/listAjaxPage">사용자(ajax)</a></li>
	<li class="active"><a href="${pageContext.request.contextPath}/getJobServlet">jobs</a></li>
</ul>