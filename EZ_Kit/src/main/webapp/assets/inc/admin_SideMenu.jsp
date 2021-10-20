<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/admin_SideMenu.css">

</head>
<body>
	<!-- Side Menu -->
	<div class="side_menu_area">

		<div class="side_menu_logo_div">
			<div class="side_menu_logo">EZ Kit</div>
		</div>
		<div class="logo_label">Admin Page</div>

		<div class="menu_link_area">
			<div class="side_menu_label">주문</div>
			<div class="side_menu_link_div">
				<a class="side_menu_link" href="${pageContext.request.contextPath }/admin/order_Info?order_status=1">주문관리</a>
			</div>

			<div class="side_menu_label">회원</div>
			<div class="side_menu_link_div">
				<a class="side_menu_link" href="${pageContext.request.contextPath }/admin/user_Info">회원관리</a>
			</div>

			<div class="side_menu_label">문의</div>
			<div class="side_menu_link_div">
				<a class="side_menu_link" href="${pageContext.request.contextPath }/admin/inquiry_AdminList?inquiry_result=1">미답변 문의</a>
			</div>
			<div class="side_menu_link_div">
				<a class="side_menu_link" href="${pageContext.request.contextPath }/admin/inquiry_AdminList?inquiry_result=2">처리완료</a>
			</div>

			<div class="side_menu_label">사이트 옵션</div>
			<div class="side_menu_link_div">
				<a class="side_menu_link" href="${pageContext.request.contextPath }/admin/event_Banner">배너</a>
			</div>
			<div class="side_menu_link_div">
				<a class="side_menu_link" href="${pageContext.request.contextPath }/admin/classification_EditPage">상품분류</a>
			</div>
			<div class="side_menu_link_div">
				<a class="side_menu_link" href="${pageContext.request.contextPath }/admin/QnA_EditPage">Q&A</a>
			</div>
			<div class="side_menu_link_div">
				<a class="side_menu_link" href="${pageContext.request.contextPath }/admin/notice_List">공지사항</a>
			</div>
		</div>
	</div>
</body>
</html>