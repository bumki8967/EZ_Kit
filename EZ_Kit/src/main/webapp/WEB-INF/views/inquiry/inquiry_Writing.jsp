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
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/board/board.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/QnA_SideMenu.css">
	
	<!-- js -->
	<script src="${pageContext.request.contextPath }/assets/js/inc/QnA_SideMenu.js"></script>
</head>

<body class="writing_body">

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

	<form method="POST" action="/inquiry/inquiry_Writing">
		<table class="writing_table">
			<tr>
				<td class="writing_title_td">
					<input class="writing_title_text" type="text" name="inquiry_title" placeholder="글 제목을 입력하세요.">
				</td>
			</tr>

			<tr>
				<td class="writing_content_td" colspan="2">
					<textarea class="writing_content_text" name="inquiry_content" placeholder="글 내용을 입력하세요."></textarea>
				</td>
			</tr>

			<tr>
				<td class="board_btn_td">
					<span class="footer_text_1">EZ Kit </span> 
					<span class="footer_text_2"> Copyright : EZ Kit. All Rights Reserved.</span> 
					<input class="board_Cancel_btn" type="button" value="작성 취소" onClick="history.back();"> 
					<input class="board_writing_btn" type="submit" value="작성 완료">
				</td>
			</tr>
		</table>
		<input type="hidden" name="user_id" value="${sessionScope.user_id }" />
		<input type="hidden" name="inquiry_reply" />
	</form>
</body>
</html>