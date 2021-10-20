<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">

    <!-- Jquery -->
   	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
   	
	<!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/order/order_Result.css">
    
    <!-- js -->
   	<script src="${pageContext.request.contextPath }/assets/js/order/order_Result.js"></script>
   	<script src="${pageContext.request.contextPath }/assets/js/ezkit_stamp.js"></script>

</head>
<body>

    <!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<div class="order_result_area">
		<div class="punch_hole_area">
			<button class="punch_hole">&nbsp;</button>
			<button class="punch_hole">&nbsp;</button>
			<button class="punch_hole">&nbsp;</button>
			<button class="punch_hole">&nbsp;</button>
			<button class="punch_hole">&nbsp;</button>
		</div>

		<div class="logo_area">
			<div class="order_result_logo">EZ Kit</div>
			<div class="logo_label">전자 영수증</div>
		</div>

		<div class="result_date"></div>

		<div class="product_title_area">
			<div class="product_name_title">상품명</div>
			<div class="product_quantity_title">수량</div>
			<div class="product_price_title">가격</div>
		</div>

		<div class="product_area">
			<c:forEach var="p" items="${orderProduct_list}" varStatus="status">
				<!-- 상품 한개 영역 -->
				<div class="product_div">
					<div class="product_name">${p.product_name }</div>
					<div class="product_quantity">${p.product_quantity }</div>
					<div class="product_price">${p.product_price }원</div>
				</div>
			</c:forEach>
		</div>

		<div class="all_price_area">
			<div class="point_div">
				<div class="use_point_div">
					사용한 포인트 : <span class="use_point_span">${used_point } P</span>
				</div>
				<div class="add_point_div">
					적립된 포인트 : <span class="add_point_span">${save_point } P</span>
				</div>
			</div>

			<div class="all_price_label">
				총결제금액 : <span class="all_price">${order.order_payment_price }</span> 원
			</div>

		</div>
	</div>
</body>
</html>