<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- Jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user/login.css">
	
   	<!-- js -->
   	<script src="${pageContext.request.contextPath }/assets/js/user/login.js"></script>

</head>
<body class="login_body">

    <div class="top_account">
        <div class="top_account_text"></div><a class="top_account_logo" href="${pageContext.request.contextPath }/">EZ Kit</a> Account
    </div>

    <form method="POST" id="login_form">
        <table class="login_table">
            <tr>
                <td class="login_title">EZ Kit Login</td>
            </tr>
            
            <tr>
                <td>
                    <div class="id_div">아이디</div>
                    <input class="id_text" type="text" name="user_id" id="user_id" placeholder="아이디를 입력하세요" />
                    <div class="pw_div">비밀번호</div>
                    <input class="pw_text" type="password" name="user_pw" id="user_pw" placeholder="비밀번호를 입력하세요" />
                </td>
            </tr>
    
            <tr>
                <td>
                    <input class="login_btn" type="button" value="로그인" />
                    <input class="reg_btn" type="button" value="회원가입" />
                	<div class="find_pw_div">
                		<a class="find_pw" href="${pageContext.request.contextPath }/user/user_FindPw">비밀번호 찾기</a>
                	</div>
                </td>
            </tr>
        </table>
    </form>

    <div class="account_bottom">
        <div class="account_bottom_text_1">EZ Kit Account</div>
        <div class="account_bottom_text_2">Copyright : EZ Kit. All Rights Reserved.</div>
    </div>
</body>
</html>