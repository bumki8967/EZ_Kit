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
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inquiry/inquiry_UserList.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/QnA_SideMenu.css">
	
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

	<div class="inquiry_user_list_area">
		<div class="inquiry_user_list_label">※ 내가 작성한 문의</div>
		<table class="inquiry_user_list_table">
			<tr>
				<th class="num_th">번호</th>
				<th class="title_th">제목</th>
				<th class="date_th">작성일</th>
			</tr>

			<c:forEach var="i" items="${inquiryList }" varStatus="status">
				<tr>
					<td class="num_td">${status.count }</td>
					<td class="title_td">
						<a class="title_link" href="${pageContext.request.contextPath }/inquiry/inquiry_UserView?inquiry_num=${i.inquiry_num}&num=${status.count}">${i.inquiry_title}</a>
					</td>
					<td class="date_td">${i.inquiry_date }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>