<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/js.cookie-2.2.1.min.js"></script>

	<script>
	
		//쿠키 값 조회하기
		function getCookieValue(cookieName) {

			var cookie1 = document.cookie.split("; ");
			for (var i = 0; i < cookie1.length; i++) {
				var cookie = cookie1[i];
				var cookieArr = cookie.split("=");
				/*cookieArr[0] cookie name
				  cookieArr[1] cookie value
				 */
				if (cookieName == cookieArr[0]) {
					//String value = cookie2[i];
					return cookieArr[1];
				}
			}
			return ""; //원하는쿠키가없는경우
		}

		//쿠키 값 설정하기
		function setCookie(cookieName, cookieValue, expires) {
// 			"USERNM=brown; path=/; expires=Wed, 01 Oct 2020 00:38:25 GMT;"
			var today = new Date();

			//현재날짜에서 미래로 + expires 만큼 한 날짜 구하기
			today.setDate(today.getDate() + expires);
			document.cookie = cookieName + "=" + cookieValue+ "; path=/; expires=" + today.toGMTString();
			console.log(document.cookie);
		}

		//쿠키 값 삭제하기
		//해당쿠키의 expires 속성을 과거날짜로 변경
		function deleteCookie(cookieName){ //어떤쿠키를 삭제할것인지 인자로 받기
			setCookie(cookieName, "", -1); //유효기간을 -1로 설정
		}

		$(function(){
			// 쿠키 읽기
			getCookieValue("REMEMBERME");
// 			cookies.get("REMEMBERME");
			//만약 REMEMBERME에 값이 Y로 설정되어있다면?
			//Remember ME 체크박스를 체크상태로 변경
			//USERNM 쿠키값을 확인하여 input 태그 중 inputemail 아이디 값을 가진 input태그에 쿠기값 설정
			//조건 미충족시 별도처리없음
			if(getCookieValue("REMEMBERME")=='Y'){
				$("#checkbox").prop("checked",true);
				$("#inputEmail").val(getCookieValue("USERNM"));
			}			
		});

		$(function(){
			//signin 버튼이 클릭 되었을 떄
			//Remember Me 체크박스가 체크되어있으면 
			//REMEMBERME 쿠키를 Y로 설정
			//USERNM 쿠키를 inputMail input 태그에 입력된 값으로 설정
			//form 태그에 대한 submit 처리(이부분은 추후 진행)
			//Remember Me 체크박스가 체크 되어있지 않으면
			//REMEMBERME, USERNM 쿠키 삭제

             $("button").on("click",function(){      

        	  if($("input[type=checkbox]").prop("checked")==true) {                	  
            	  Cookies.set("REMEMBERME","Y");
            	  Cookies.set("USERNM",$("#inputEmail").val());
              }else{
            	  Cookies.remove("REMEMBERME");
            	  Cookies.remove("USERNM");
              }

              //submit
              $("form").submit();

             
          })

		})
			
		
	</script>
	
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail"  class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="userId" class="form-control" placeholder="Email address" required autofocus value="brown">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required value="brownPass">
        <div class="checkbox">
          <label>
            <input type="checkbox" id="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="loginfo">Sign in</button>
      </form>

     


    </div> <!-- /container -->

  </body>
</html>
