<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">


<title>Jsp</title>
<%@include file="/WEB-INF/views/layout/commonLib.jsp" %>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>



<body>

				<form id="frm" class="form-horizontal" role="form" action="${cp }/member/memberRegist" method="POST" enctype="multipart/form-data">

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
						<input type="file" name="file"/>
						</div>
					</div>

					<div class="form-group">
						<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="userid" name="userid" placeholder="사용자 아이디" value="${memberVo.userid }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="usernm" name="usernm" placeholder="사용자 이름" value="${memberVo.usernm }">
						<!-- path="memberVo.usernm" 의 memberVo는 객체명이아니라 클래스명 앞글자를 소문자로 바꿔서 쓰는것임-->
						<span style="color:red"><form:errors path="memberVo.usernm"/></span>
						<span style="color:red"><form:errors path="jSRMemberVo.usernm"/></span>
						</div>
					</div>
					<div class="form-group">
						<label for="alias" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="alias" name="alias" placeholder="사용자 별명" value="${memberVo.alias }">
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
						<input type="password" class="form-control" id="pass" name="pass" placeholder="사용자 비밀번호" value="${memberVo.pass }">
						</div>
					</div>
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="addr1" name="addr1" placeholder="사용자 주소" READONLY value="${memberVo.addr1 }">
						<button id="zipcodeBtn" type="button"  class="btn btn-default">우편번호찾기</button>
							<label class="control-label">${memberVo.addr1 }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="addr2" name="addr2" placeholder="사용자 상세주소" value="${memberVo.addr2 }">
							<label class="control-label">${memberVo.addr2 }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="사용자 우편번호" value="${memberVo.zipcode }">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="regBtn" type="button" class="btn btn-default">사용자 등록</button>
						</div>
					</div>
				</form>
			
</body>
</html>
