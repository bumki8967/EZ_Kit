<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>장바구니 페이지</title>
    
    <!-- Jquery -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

   	<!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/order/cart.css">
   	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/top.css">
   	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/footer.css">    
    
    <!-- js -->
    <script src="${pageContext.request.contextPath }/assets/js/order/cart.js"></script>
    <script type="text/javascript" src="${pageConext.request.contextPath }/assets/js/ezkit_stamp.js"></script>
    
</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<!-- 사이드 메뉴 영역 -->
	<form id="cart_form" action="/order/payment">
		<div class="order_side_menu_area">
			<div class="ez_kit_logo">
				<a class="side_menu_link" href="#logo">EZ Kit</a>
			</div>
			<div class="order_side_menu_label">주문 리스트</div>

			<div class="side_menu_product_info_area">
				<div class="side_menu_label">상품명</div>
				<div class="product_name_list_area"></div>

				<div class="side_menu_label">결제예정금액</div>
				<div class="used_point_div">
					<span class="point_span used_point" data-used_point="">사용한   : 0 p</span> 
					<input type="hidden" id="used_point" name="used_point" value="0"> 
					<input type="hidden" id="user_id" name="user_id" value="${sessionScope.user_id }"> 
					<input type="hidden" name="user_rating" value="${u.user_rating }">
				</div>
				<div class="side_menu_price_result">0 원</div>
			</div>

			<div class="side_menu_btn_area">
				<input class="order_btn" type="button" value="주문하기">
			</div>
		</div>
	</form>

	<!-- 유저 포인트 영역 -->
	<div class="user_point_area">
		<div class="point_label">
			${u.user_nick }님 사용 가능한 포인트는 <span class="point_span user_point" data-user_point="${u.user_point}">${u.user_point} P</span> 입니다.
		</div>

		<div class="point_text_div">
			<input class="point_textBox" type="text" placeholder="포인트 입력" numberOnly />
			<button class="point_btn" id="total_use">전액 사용</button>
			<button class="point_btn" id="use_cancel">취소</button>
			<button class="point_btn" id="use_btn">사용</button>
		</div>
	</div>

	<!-- 상품 리스트 영역 -->
	<div class="order_product_list_area">

		<!-- 타이틀 영역 -->
		<div class="list_label">장바구니</div>

		<div class="util_area">
			<input class="all_check_btn" type="button" value="전체선택" /> 
			<input class="all_check_cancel_btn" type="button" value="선택취소" /> 
			<input class="select_del_btn" type="button" value="선택삭제" />
		</div>

		<table class="product_list_table">
			<tr>
				<th class="check_th">선택</th>
				<th class="name_th">상품명</th>
				<th class="price_th">금액</th>
				<th class="quantity_th">수량</th>
				<th class="del_th">삭제</th>
			</tr>

			<c:forEach var="i" items="${myCartList }" varStatus="status">
				<tr>
					<td class="check_td">
						<input class="checkbox" data-product_num="${i.product_num }" id="checkbox" type="checkbox">
					</td>
					<td class="name_td">
						<a class="product_link" data-product_num="${i.product_num }" href="${pageContext.request.contextPath }/product/product_detail?product_num=${i.product_num }">
							${i.product_name }
						</a>
					</td>
					<td class="price_td">${i.product_price }</td>
					<td class="quantity_td">
						<button class="quantity_minus_btn quantity_btn">-</button>
						<button class="quantity_result" data-quantity="${i.product_quantity }">${cartList[status.index].product_quantity}</button>
						<button class="quantity_plus_btn quantity_btn">+</button>
					</td>
					<td class="del_td">
						<button class="cancel_btn">X</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<!-- footer 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/footer.jsp" />
	<!-- footer 영역 끝 -->
</body>
</html>