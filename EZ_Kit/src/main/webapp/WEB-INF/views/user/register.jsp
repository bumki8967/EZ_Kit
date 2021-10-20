<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- Jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user/register.css">

	<!-- js -->
	<script src="${pageContext.request.contextPath }/assets/js/user/register.js"></script>

	<!-- 다음 우편번호 검색 스크립트 -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/daumPostCode.js"></script>

</head>
<body class="register_body">
    
    <div class="top_account">
        <div class="top_account_text"></div> 
        <a class="top_account_logo" href="${pageContext.request.contextPath }/">EZ Kit</a> Account
    </div>
    
    <form method="POST" id="register_form">
        <table class="register_table">
            <tr>
                <td><div class="register_title">EZ Kit Register</div></td>
            </tr>

            <tr>
                <td class="register_td">
                    <div class="register_div_text">아이디 (이메일) 
                    	<span class="id_caps_check"></span>
                    </div>
                    <input class="register_id_text" type="text" name="user_id" id="user_id" placeholder="아이디 (이메일)을 입력하세요" required />
                    <select class="selectEmail" id="selectEmail">
                        <option value="0">직접 입력</option>
                        <option value="@naver.com">@naver.com</option>
                        <option value="@gmail.com">@gmail.com</option>
                    </select>

                    <div class="register_div_text"> 비밀번호  
                    	<span class="pw_caps_check"></span>
                    </div>
                    <input class="register_text" type="password" name="user_pw" id="user_pw" placeholder="비밀번호를 입력하세요" required />

                    <div class="register_div_text">이름</div>
                    <input class="register_text" type="text" name="user_name" placeholder="이름을 입력하세요" required />
                    
                    <div class="register_div_text">닉네임</div>
                    <input class="register_text" type="text" name="user_nick" id="user_nick" placeholder="닉네임을 입력하세요" required />

                    <div class="register_div_text">전화번호</div>
                    <input class="register_text" type="text" name="user_tel" placeholder="전화번호 입력하세요" required />

                    <div class="register_div_text">우편번호</div>
                    <input class="register_postcode_text" type="text" name="user_postcode" id="postcode" placeholder="우편번호를 입력하세요" required />
                    <input class="postcode_btn" type="button" id="postcode_btn" onClick='execDaumPostcode("postcode", "addr1", "addr2")' value="우편번호 검색" />

                    <div class="register_div_text">주소</div>
                    <input class="register_text" type="text" name="user_addr1" id="addr1" placeholder="주소를 입력하세요" required />
                    
                    <div class="register_div_text">상세주소</div>
                    <input class="register_text" type="text" name="user_addr2" id="addr2" placeholder="상세주소를 입력하세요" required />
                </td>
            </tr>

            <tr>
                <td class="register_btn_td">
                    <input class="register_btn" type="button" value="가입 완료" />
                    <input class="register_cancel_btn" type="button" value="가입 취소" />
                </td>
            </tr>
        </table>

        <input type="hidden" name="user_type" value="user">

    </form>
    <div class="account_bottom">
        <div class="account_bottom_text_1">EZ Kit Account</div>
        <div class="account_bottom_text_2">Copyright : EZ Kit. All Rights Reserved.</div>
    </div>
</body>
</html>