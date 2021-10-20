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
   <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/admin/inquiry_AdminList.css">

</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />

	<div class="admin_qna_area">
		<table class="qna_table">
			<tr>
				<th class="num_th">번호</th>
				<th class="title_th">제목</th>
				<th class="nick_th">작성자</th>
				<th class="date_th">작성일</th>
			</tr>
		</table>

		<div class="qna_content_div">
			<table class="qna_table">
				<c:forEach var="i" items="${i }" varStatus="status">
					<tr>
						<td class="num_td">${i.inquiry_num }</td>
						<c:if test="${i.inquiry_result==1 }">
							<td class="title_td">
								<a class="qna_link" href="${pageContext.request.contextPath }/admin/inquiry_AdminWritingForm?inquiry_num=${i.inquiry_num}">${i.inquiry_title }</a>
							</td>
							<td class="nick_td">
								<a class="qna_link" href="${pageContext.request.contextPath }/admin/inquiry_AdminWritingForm?inquiry_num=${i.inquiry_num}">${u[status.index] }</a>
							</td>
						</c:if>
						<c:if test="${i.inquiry_result==2 }">
							<td class="title_td">
								<a class="qna_link" href="${pageContext.request.contextPath }/admin/inquiry_AdminView?inquiry_num=${i.inquiry_num}">${i.inquiry_title }</a>
							</td>
							<td class="nick_td">
								<a class="qna_link" href="${pageContext.request.contextPath }/admin/inquiry_AdminView?inquiry_num=${i.inquiry_num}">${u[status.index] }</a>
							</td>
						</c:if>
						<td class="date_td">${i.inquiry_date }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>