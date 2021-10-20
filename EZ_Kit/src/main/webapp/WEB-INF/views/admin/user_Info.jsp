<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ko">

	<!-- JQuery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/user_Info.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/QnA_SideMenu.css">
	
	<!-- js -->
	<script src="${pageContext.request.contextPath }/assets/js/admin/user_Info.js"></script>

</head>

<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />

	<form method="POST" id="out_form">
		<div class="user_out_div">
			<button class="user_out_btn">탈퇴 처리</button>
		</div>
		<input type="hidden" id="user_id" name="user_id" value="${u.user_id }" />
	</form>

	<form id="search_form" method="POST">
		<div class="user_find_area">
			<div>
				<input class="user_find_text" id="search_id" name="user_id" type="text" placeholder="검색할 회원을 입력하세요.">
			</div>
			<div class="find_btn_div">
				<button class="find_btn">검색</button>
			</div>
		</div>
	</form>

	<div class="user_id_area">
		<div class="user_id_div">
			<div>아이디 : ${u.user_id }</div>
			<div>닉네임 : ${u.user_nick }</div>
			<div>등급 : <span id="user_rating">${u.user_rating }</span></div>
		</div>

		<div class="rating_btn_div">
			<div>등급변경 :</div>
			<button class="rating_btn" value="Silver">Silver</button>
			<button class="rating_btn" value="Gold">Gold</button>
			<button class="rating_btn" value="Diamond">Diamond</button>
			<button class="rating_btn" value="VIP">VIP</button>
		</div>
	</div>

	<div class="user_point_area">
		<div class="point_div">
			보유 포인트 : <input class="point_text_box" type="text" id="user_point" value="${u.user_point}">P
			<button class="point_del_btn">포인트 회수</button>
			<button class="point_edit_btn">포인트 수정</button>
		</div>

		<div class="point_btn_area">
			포인트 추가 :
			<button class="point_btn" value="100">100P</button>
			<button class="point_btn" value="300">300P</button>
			<button class="point_btn" value="500">500P</button>
			<button class="point_btn" value="1000">1,000P</button>
		</div>

		<div class="point_btn_area">
			포인트 차감 :
			<button class="point_btn" value="-100">- 100P</button>
			<button class="point_btn" value="-300">- 300P</button>
			<button class="point_btn" value="-500">- 500P</button>
			<button class="point_btn" value="-1000">- 1,000P</button>
		</div>
	</div>

	<div class="user_info_area">
		<table class="user_info_table">
			<tr>
				<th class="user_info_th">전화번호</th>
				<td class="user_info_td">${u.user_tel }</td>
			</tr>

			<tr>
				<th class="user_info_th">우편번호</th>
				<td class="user_info_td">${u.user_postcode }</td>
			</tr>

			<tr>
				<th class="user_info_th">주소</th>
				<td class="user_info_td">${u.user_addr1 }</td>
			</tr>

			<tr>
				<th class="user_info_th">상세주소</th>
				<td class="user_info_td">${u.user_addr2 }</td>
			</tr>

			<tr>
				<th class="user_info_th">계정 생성일</th>
				<td class="user_info_td">${u.user_regdate }</td>
			</tr>
		</table>
	</div>
</body>
</html>