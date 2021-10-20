<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inquiry/inquiry_UserView.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/QnA_SideMenu.css">
	
	<!-- JQuery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- js -->
	<script src="${pageContext.request.contextPath }/assets/js/inc/QnA_SideMenu.js"></script>
</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<div class="QnA_side_menu">
		<div class="label_area">
			<div class="logo_label">EZ Kit</div>
			<div class="QnA_label">Q&A</div>
		</div>

		<div class="QnA_link_btn_area">
			<ul class="side_menu_ul">
				<c:forEach var="q" items="${qnaOptionList }">
					<li>
						<a href="${pageContext.request.contextPath }/qna_option/QnAList?qna_option=${q.qna_option_name}">
							<button class="QnA_link_btn">${q.qna_option_name }</button>
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>

		<div class="QnA_writing_div">
			<button class="QnA_writing_btn">문의 작성하기</button>
		</div>
	</div>
	
	<input type="hidden" id="user_id" value="${sessionScope.user_id }" />

	<div class="QnA_admin_view_user_area">
		<div class="in_query_user_label">※ 내가 작성한 내용</div>
		<div class="view_title_div">
			<div class="num_div">${num }</div>
			<div class="title_div">${i.inquiry_title }</div>
			<div class="user_id_div">${user_nick }</div>
			<div class="date_div">${i.inquiry_date }</div>
		</div>

		<div class="user_content_div">
			<textarea class="in_query_content" disabled>${i.inquiry_content }</textarea>
		</div>
	</div>

	<form>
		<div class="QnA_admin_view_admin_area">
			<div class="in_query_label">※ 운영자 답변내용</div>
			<div class="in_query_div">
				<c:if test="${i.inquiry_reply == null }">
					<textarea class="in_query_content" disabled>등록된 답변이 없습니다.</textarea>
				</c:if>
				<textarea class="in_query_content" disabled>${i.inquiry_reply }</textarea>
			</div>
		</div>
	</form>
</body>
</html>