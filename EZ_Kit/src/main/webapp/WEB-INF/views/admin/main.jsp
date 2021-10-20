<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/top.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/admin/admin.css">
</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />

	<div class="admin_main_area">
		<div class="user_info_area">
			<table class="order_state_table">
				<tr>
					<th>신규 주문</th>
					<td>0</td>
				</tr>
			</table>

			<table class="user_info_table">
				<tr>
					<th>회원가입</th>
					<td>0명</td>
					<th>회원탈퇴</th>
					<td>0명</td>
					<th>총 회원</th>
					<td>0명</td>
				</tr>
			</table>
		</div>

		<div class="sales_area">
			<table class="sales_table">
				<tr>
					<th>결제완료</th>
					<td class="sales_table_td">0건</td>
				</tr>

				<tr>
					<th>배송완료</th>
					<td class="sales_table_td">0건</td>
				</tr>

				<tr>
					<th>총 매출</th>
					<td class="sales_table_td">0원</td>
				</tr>
			</table>

			<table class="product_table">
				<tr>
					<th>판매중인 상품</th>
					<td class="product_table_td">0건</td>
				</tr>

				<tr>
					<th>판매 완료한 상품</th>
					<td class="product_table_td">0건</td>
				</tr>

				<tr>
					<th>등록한 모든 상품</th>
					<td class="product_table_td">0원</td>
				</tr>
			</table>
		</div>

		<div class="qna_area">
			<table class="qna_table">
				<tr>
					<th>미답변 문의</th>
				</tr>

				<tr>
					<td class="qna_content_td">
						<div class="qna_content_area">
							<c:forEach var="i" items="${inquiryList }">
								<div class="qna_title_div">${i.inquiry_title }</div>
							</c:forEach>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>