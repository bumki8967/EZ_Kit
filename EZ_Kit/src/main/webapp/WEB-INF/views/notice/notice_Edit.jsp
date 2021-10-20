<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

   <!-- JQuery -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    
   <!-- CSS -->
   <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/QnA_SideMenu.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/board/board.css">
   
</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />

	<form method="POST" action="/admin/notice_Edit">
		<table class="writing_table">
			<tr>
				<td class="writing_title_td">
					<input class="writing_title_text" type="text" name="notice_title" value="${n.notice_title}">
				</td>
			</tr>

			<tr>
				<td class="writing_content_td">
					<textarea class="writing_content_text" name="notice_content">${n.notice_content}</textarea>
				</td>
			</tr>

			<tr>
				<td class="board_btn_td">
					<span class="footer_text_1">EZ Kit </span> 
					<span class="footer_text_2"> Copyright : EZ Kit. All Rights Reserved.</span> 
					<input class="board_Cancel_btn" type="button" value="수정 취소" onClick="history.back()"> 
					<input class="board_writing_btn" type="submit" value="수정 완료">
				</td>
			</tr>
		</table>
		<input type="hidden" name="notice_num" value="${n.notice_num }" /> 
		<input type="hidden" name="notice_hits" value="${n.notice_hits }" />
	</form>
</body>
</html>