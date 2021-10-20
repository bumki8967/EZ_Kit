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
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/top.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/admin/classification_EditPage.css">
	
	<!-- js -->
	<script src="${pageContext.request.contextPath }/assets/js/admin/classification_EditPage.js"></script>
</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />


	<div class="classification_area">
		<div class="classification_list_area">
			<div class="classification_list_label">분류 목록</div>
			<div class="classification_list_btn_area">
				<c:forEach var="c" items="${classificationList }">
					<button class="classification_btn" value="${c.classification_name }">${c.classification_name }</button>
					<input type="hidden" Class="classification_num" value="${c.classification_num }" />
				</c:forEach>
			</div>
		</div>

		<div class="classification_edit_area">
			<div class="classification_edit_label">분류 관리</div>

			<form method="POST" action="/admin/insertClassification">
				<div>분류추가</div>
				<div class="classification_add_div">
					<div>
						<input class="classification_edit_textBox" name="classification_name" type="text">
					</div>
					<div>
						<button class="classification_add_btn" id="classification_add_btn">추가</button>
					</div>
				</div>
			</form>

			<form id="f" method="POST">
				<div>수정 / 삭제</div>
				<div class="classification_edit_div">
					<div>
						<input class="classification_edit_textBox" id="edit_classification" name="classification_name" type="text">
					</div>
					<div>
						<button class="classification_edit_btn" id="classification_del_btn">삭제</button>
					</div>
					<div>
						<button class="classification_edit_btn" id="classification_edit_btn">수정</button>
					</div> 
				</div>
				<input type="hidden" id="classification_num" name="classification_num" />
			</form>
		</div>
	</div>
</body>
</html>