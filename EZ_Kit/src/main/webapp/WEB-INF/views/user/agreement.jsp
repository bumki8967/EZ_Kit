<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user/agreement.css">
	
	<!-- js -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/user/agreement.js"></script>

</head>
<body class="agreement_body">

    <div class="top_account">
        <div class="top_account_text"></div><a class="top_account_logo" href="${pageContext.request.contextPath }/">EZ Kit</a> Account
    </div>

    <table class="agreement_table">
        <tr>
            <td><div class="agreement_title">EZ Kit Register</div></td>
        </tr>

        <tr>
            <td>
                <div class="radio_div">
                	<input class="radio_set" id="all_check" type="checkbox" value="1"> 전체 동의
                </div>
                <div class="agreement_all">모든 약관에 동의합니다.</div>

                <div class="radio_div">
                <input class="radio_set" id="required_agree" type="checkbox" value="2"> 이용약관(필수)
                </div>
                <textarea class="agreement_text">
EZ Kit 서비스 이용 약관.

환영합니다.

EZ Kit을 이용해 주셔서 감사합니다.
.
.
.
                </textarea>

                <div class="radio_div">
                	<input class="radio_set" type="checkbox" value="3"> 개인정보 수집 및 허용(선택)
                </div>
                <textarea class="agreement_text">
개인 정보 수집 및 이용 동의서

EZ Kit(은)는 최초 회원 가입 또는 서비스 이용 시
이용자로부터 아래와 같은 개인 정보를 수집하고 있습니다.
이용자는 본 개인 정보 수집, 이용 동의서에 따른 동의 시,
필요한 최소한의 정보 외의 개인 정보 수집 이용에
동의하지 않을 권리가 있습니다.
.
.
.
                </textarea>
            </td>
        </tr>

        <tr>
            <td class="agreement_btn_td">
                <input class="consent_btn" type="button" value="동의" />
                <input class="cancel_btn" type="button" value="취소" />
            </td>
        </tr>
    </table>

    <div class="account_bottom">
        <div class="account_bottom_text_1">EZ Kit Account</div>
        <div class="account_bottom_text_2">Copyright : EZ Kit. All Rights Reserved.</div>
    </div>
</body>
</html>