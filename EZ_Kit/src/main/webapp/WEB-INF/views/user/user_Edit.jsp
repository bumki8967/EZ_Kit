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
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user/register.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/top.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/footer.css">
	
	<!-- 다음 우편번호 검색 스크립트 -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/daumPostCode.js"></script>	

	<!-- js -->
	<script type="text/javascript" src="${pageConext.request.contextPath }/assets/js/user/userEdit.js"></script>

</head>
<body class="register_body">

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

    <form method="POSt" id="edit_form">
        <table class="register_table">
            <tr>
                <td>
                	<div class="register_title">EZ Kit Register</div>
                </td>
            </tr>

            <tr>
                <td class="register_td">
                    <div class="register_div_text">${u.user_id } <span class="id_caps_check"></span></div>
                    <input class="register_id_text" type="text" name="user_id" id="user_id" value="${u.user_id}" disabled />
                    <select class="selectEmail" id="selectEmail">
                        <option value="0">직접 입력</option>
                        <option value="@naver.com">@naver.com</option>
                        <option value="@gmail.com">@gmail.com</option>
                    </select>

                    <div class="register_div_text">비밀번호  <span class="pw_caps_check"></span></div>
                    <input class="register_text" type="password" name="user_pw" id="user_pw" value="${u.user_pw }" />

                    <div class="register_div_text">이름</div>
                    <input class="register_text" type="text" name="user_name" value="${u.user_name}" />
                    
                    <div class="register_div_text">닉네임</div>
                    <input class="register_text" type="text" name="user_nick" value="${u.user_nick}" />

                    <div class="register_div_text">전화번호</div>
                    <input class="register_text" type="text" name="user_tel" value="${u.user_tel}" />

                    <div class="register_div_text">우편번호</div>
                    <input class="register_postcode_text" type="text" name="user_postcode" id="postcode" value="${u.user_postcode}" />
                    <input class="postcode_btn" type="button" id="postcode_btn" onClick='execDaumPostcode("postcode", "addr1", "addr2")' value="우편번호 검색" />

                    <div class="register_div_text">주소</div>
                    <input class="register_text" type="text" name="user_addr1" id="addr1" value="${u.user_addr1}" />
                    
                    <div class="register_div_text">상세주소</div>
                    <input class="register_text" type="text" name="user_addr2" id="addr2" value="${u.user_addr2}" />
                </td>
            </tr>

            <tr>
                <td class="register_btn_td">
                    <input class="register_btn" type="button" value="수정 완료" />
                    <input class="register_cancel_btn" type="button" value="수정 취소" />
                </td>
            </tr>
        </table>

        <input type="hidden" name="user_type" value="user" />
        <input type="hidden" name="user_id" value="${u.user_id }" />
    </form>
    
    <div class="account_bottom">
        <div class="account_bottom_text_1">EZ Kit Account</div>
        <div class="account_bottom_text_2">Copyright : EZ Kit. All Rights Reserved.</div>
    </div>

 	<!-- footer 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/footer.jsp" />
	<!-- footer 영역 끝 -->
    
</body>
</html>