<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- JQuery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/QnA_SideMenu.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/board/board_View.css">
	
	<!-- JS -->
	<script src="${pageContext.request.contextPath }/assets/js/admin/notice_View.js"></script>

</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<c:if test="${sessionScope.user_type == 'admin' }">
		<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />
	</c:if>
	
	<table class="board_view_table">
		<tr>
			<td class="board_num">글 번호 <span>${n.notice_num }</span></td>
			<td class="board_title">${n.notice_title }</td>
			<td class="board_writer">작성자 <span>Admin</span></td>
			<td class="board_date">${n.notice_date }</td>
			<td class="board_hits">조회수 <span>${n.notice_hits }</span></td>
		</tr>

		<tr>
			<td class="view_content_td" colspan="5">
				<textarea class="board_view_content" name="notice_content" disabled>${n.notice_content}</textarea>
			</td>
		</tr>

		<tr>
			<td class="board_btn_td" colspan="5">
				<span class="footer_text_1">EZ Kit </span> 
				<span class="footer_text_2"> Copyright : EZ Kit. All Rights Reserved.</span>
				<form id="f" method="POST">
					<c:if test="${sessionScope.user_type == 'admin' }">
						<input class="board_del_btn" type="button" value="삭제하기"> 
						<input class="board_edit_btn" type="button" value="수정하기">
					</c:if> 
					<input class="board_list_btn" type="button" value="목록으로">
					<input type="hidden" name="notice_num" value="${n.notice_num }">
				</form>
			</td>
		</tr>
	</table>

</body>
</html>