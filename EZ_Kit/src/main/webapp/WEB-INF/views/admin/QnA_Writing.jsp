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

</head>

<body class="writing_body">

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />

	<form method="POST" action="/admin/QnA_Writing">
		<table class="writing_table">
			<tr>
				<td class="writing_title_td"><input class="writing_title_text" type="text" name="qna_title" placeholder="글 제목을 입력하세요."></td>
			</tr>

			<tr>
				<td class="writing_content_td" colspan="2">
					<textarea class="writing_content_text" name="qna_content" placeholder="글 내용을 입력하세요."></textarea>
				</td>
			</tr>

			<tr>
				<td class="board_btn_td"><span class="footer_text_1">EZ Kit </span> 
					<span class="footer_text_2"> Copyright : EZ Kit. All Rights Reserved.</span> 
					<input class="board_Cancel_btn" type="button" value="작성 취소" onClick="history.back();"> 
					<input class="board_writing_btn" type="submit" value="작성 완료">
				</td>
			</tr>
		</table>
		<input type="hidden" name="qna_option" value="${qna_option_name }" />
	</form>
</body>
</html>