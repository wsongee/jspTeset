<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<%@include file="/WEB-INF/views/layout/commonLib.jsp" %>
<script>
$(document).ready(function(){
	//client side에서는 서버사이드 변수나 값을 사용가능
	memberAjaxPage("${param.userid}");
	
	$("#modifyBtn").on("click",function(){

	})
	$("#profileDownBtn").on("click",function(){
		document.location="/member/profileDownloadView?userid=${param.userid}";
	})
})

function memberAjaxPage(userid){
	$.ajax({ url :"/member/memberAjax",
			data: {userid : userid}, //{자바스크립트필드명, 값}
// 			data: "userid="+userid
			method: "get",
			success : function(data){
			
				$("#profile").attr("src","${cp}/member/profileImg?userid="+userid);
				$("#profileDownBtn").html(data.memberVo.realFilename);
				$("#id").html(data.memberVo.userid);
				$("#name").html(data.memberVo.usernm);
				$("#alias").html(data.memberVo.alias);
				$("#pass").html(data.memberVo.pass);
				$("#addr1").html(data.memberVo.addr1);
				$("#addr2").html(data.memberVo.addr2);
				$("#zipcode").html(data.memberVo.zipcode);
				$("#reg_dt").html(data.memberVo.reg_dt);
			}
	})
}

</script>
</head>

<body>
	<%@include file="/WEB-INF/views/layout/header.jsp" %>
	
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
			
				<%@include file="/WEB-INF/views/layout/left.jsp" %>
				
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form class="form-horizontal" role="form" >

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
<%-- 							<img src="${cp }/profile/${memberVo.filename }"/> --%>
<%-- 							<img src="${cp }/member/profileImg?userid=${memberVo.userid}"/><br> --%>
							<img id="profile" /><br>
							<button id="profileDownBtn" type="button" class="btn btn-default" >다운로드</button>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label id="id" class="control-label"></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label id="name" class="control-label"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label id="alias" class="control-label"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<label  id="pass" class="control-label">*********</label>
						</div>
					</div>
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label  id="addr1" class="control-label"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label id="addr2"  class="control-label"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label id="zipcode" class="control-label"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
						<div class="col-sm-10">
							<label id="reg_dt" class="control-label"><fmt:formatDate value="${memberVo.reg_dt }" pattern ="yyyy-MM-dd"/></label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<a href="${cp }/member/memberUpdateView?userid=${memberVo.userid}"><button type="button" class="btn btn-default" >정보수정</button></a>
							<a href="${cp }/memberDelete?userid=${memberVo.userid}"><button type="button" class="btn btn-default" >삭제하기</button></a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
