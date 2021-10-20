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
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/admin/QnA_EditPage.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/QnA_SideMenu.css">
	
	<!-- js -->
	<script src="${pageContext.request.contextPath }/assets/js/admin/QnA_EditPage.js"></script>

</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<c:if test="${sessionScope.user_type == 'admin }">
		<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />
	</c:if>
	
	<div class="QnA_area">
		<div class="QnA_list_area">
			<div class="QnA_list_label">QnA 목록</div>
			<div class="QnA_list_btn_area">
				<c:forEach var="q" items="${q }">
					<button class="QnA_title_btn" value="${q.qna_option_name }">${q.qna_option_name }</button>
					<input type="hidden" Class="QnA_title_num" value="${q.qna_option_num }" />
				</c:forEach>
			</div>
		</div>

		<div class="QnA_edit_area">
			<div class="QnA_edit_label">QnA 관리</div>

			<form method="POST" action="/admin/QnA_WritingForm">
				<div>선택한 항목</div>
				<div class="select_text_div">
					<input class="QnA_select_textBox" id="selected_QnA_option" name="qna_option_name" type="text" readonly>
					<div>
						<button class="writing_btn" id="QnA_writing_btn">QnA작성</button>
					</div>
				</div>
			</form>

			<form method="POST" action="/admin/insertQnAOption">
				<div>목록추가</div>
				<div class="QnA_add_div">
					<div>
						<input class="QnA_edit_textBox" name="qna_option_name" type="text">
					</div>
					<div>
						<button class="QnA_add_btn" id="QnA_add_btn">추가</button>
					</div>
				</div>
			</form>

			<form method="POST" id="f">
				<div>수정 / 삭제</div>
				<div class="QnA_edit_div">
					<div>
						<input class="QnA_edit_textBox" id="edit_QnA_option" name="qna_option_name" type="text">
					</div>
					<div>
						<button class="QnA_edit_btn" id="QnA_del_btn">삭제</button>
					</div>
					<div>
						<button class="QnA_edit_btn" id="QnA_edit_btn">수정</button>
					</div>
					<input type="hidden" id="qna_option_num" name="qna_option_num" value="" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>