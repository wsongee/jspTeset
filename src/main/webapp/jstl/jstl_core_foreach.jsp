<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@page import="kr.or.ddit.member.service.MemberService"%>
<%@page import="kr.or.ddit.member.service.MemberServiceI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Insert title here</title>
</head>
<body>
	users 테이블의 모든 데이터를 화면에출력
	MemberService 객체를 통해 db에서 데이터를 조회하고
	request객체 memberList 라는 이름으로 저장
	
	<% MemberServiceI memberservice = new MemberService(); 
		request.setAttribute("memberList", memberservice.getAllMember());
		
	%>
	
	<table>
		<tr>
			<th>사용자 아이디</th>
			<th>비밀번호</th>
		</tr>
		<c:forEach items="${memberList }" var="member">
			<tr>
				<td>${member.userid }</td>
				<td>${member.pass }</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<h3>위의 로직을 스크립틀릿과 표현식을 통해 재작성</h3>
	<table>
		<tr>
			<th>사용자 아이디</th>
			<th>비밀번호</th>
		</tr>
		<%
		
			for(MemberVo member : (List<MemberVo>)request.getAttribute("memberList")){
		%>
		<tr>
			<td><%= member.getUserid()%></td>
			<td><%= member.getPass()%></td>
		</tr>
		<%} %>
	</table>
	<hr>
	<h3>forEach 태그의 일반 for문</h3>
	<!-- for(int i=0; i<=10; i++ )-->
	<c:forEach var="i" begin="0" end="10" step="1" varStatus="status">
		i : ${i } / ${status.index }, ${status.count }<br>
	</c:forEach>
	<hr>
	<h3>forEach를 통해 map에 담긴 데이터도 출력 가능</h3>
	<% 	Map<String, String> map = new HashMap<String, String>(); 
		map.put("name","브라운");
		map.put("id", "brown");
		map.put("alias","곰");
		request.setAttribute("map", map);
		
		Set<String> keys = map.keySet();
		Iterator<String> iterator= keys.iterator();
		
		while(iterator.hasNext()){
			String key= iterator.next();
			out.print(key+"<br>");
		}
	%>
	
	<br><br>
	<c:forEach items="${map }" var ="m">
		${m.key }/${m.value } <!-- hashmap이라 정렬에대한 보장은 안됨 -->
		<br>
	</c:forEach>
	
	
	

</body>
</html>