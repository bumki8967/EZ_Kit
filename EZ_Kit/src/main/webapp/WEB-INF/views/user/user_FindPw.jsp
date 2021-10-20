<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- Jquery -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user/user_FindPw.css">

    <!-- js -->
	<script type="text/javascript" src="${pageConext.request.contextPath }/assets/js/user/userFindPw.js"></script>
</head>
<body>

	<div class="top_account">
		<div class="top_account_text"></div>
			<a class="top_account_logo" href="${pageContext.request.contextPath }/">EZ Kit</a> Account
	</div>

	<form method="POST" class="find_pw_form">
		<div class="find_pw_area">
			<div class="find_pw_div">
				<div class="find_pw_text_div">
					<input class="find_pw_text" type="text" name="user_id" id="user_id" placeholder="아이디를 입력하세요. (이메일 형식)" />
				</div>
				<div class="find_pw_btn_div">
					<input type="button" class="find_pw_btn" value="임시 비밀번호 발급" />
				</div>
			</div>

			<div class="find_pw_info_div">
				<div class="find_pw_info_label">※ 임시 비밀번호 발급시 주의사항</div>
				<ul class="find_pw_info_ul">
					<li class="find_pw_info_li">회원 가입시 입력한 이메일과 동일한 이메일을 입력하세요.</li>
					<li class="find_pw_info_li">임시 비밀번호 발급후 반드시 비밀번호를 변경해야 합니다.</li>
					<li class="find_pw_info_li">존재하지 않는 메일은 임시 비밀번호가 전송되지 않습니다.</li>
				</ul>
			</div>
		</div>
	</form>

	<div class="account_bottom">
		<div class="account_bottom_text_1">EZ Kit Account</div>
		<div class="account_bottom_text_2">Copyright : EZ Kit. All Rights Reserved.</div>
	</div>
</body>

</html>