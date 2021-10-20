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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/board/board_List.css">

</head>
<body class="board_list_body">

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->
	
	<c:if test="${sessionScope.user_type == 'admin' }">
		<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />
	</c:if>
	
	<table class="board_list_table">
		<tr>
			<th class="num_th">번호</th>
			<th class="title_th">제목</th>
			<th class="writer_th">작성자</th>
			<th class="date_th">작성일</th>
			<th class="hits_th">조회수</th>
		</tr>

		<c:forEach var="n" items="${noticeList }">
			<tr>
				<td class="num_td">${n.notice_num }</td>
				<td class="title_td">
					<a class="title_link" href="${pageContext.request.contextPath }/admin/notice_View?notice_num=${n.notice_num}">${n.notice_title }</a>
				</td>
				<td class="writer_td">Admin</td>
				<td class="date_td">${n.notice_date }</td>
				<td class="hits_td">${n.notice_hits }</td>
			</tr>
		</c:forEach>

		<tr>
			<td class="list_btn_td" colspan="5">
				<span class="footer_text_1">EZ Kit </span> 
				<span class="footer_text_2"> Copyright : EZ Kit. All Rights Reserved.</span> 
				<c:if test="${sessionScope.user_type == 'admin' }">
					<form method="POST" action="/admin/notice_WritingForm">
						<input class="board_writing_btn" type="submit" value="게시글 작성">
					</form>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>