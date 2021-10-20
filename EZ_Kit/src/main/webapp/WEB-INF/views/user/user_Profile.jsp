<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <!-- Jquery -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

   	<!-- CSS -->
   	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user/user_Profile.css">
   
   	<!-- js -->
   	<script src="${pageContext.request.contextPath }/assets/js/user/userProfile.js"></script>
   	
</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<!-- 메뉴바 -->
	<div class="profile_menu_bar_area">
		<div class="menu_bar_logo">
			<a class="menu_bar_link" href="${pageContext.request.contextPath }/">EZ Kit</a>
		</div>
		<div class="menu_bar_hello_1">안녕하세요.</div>
		<div class="menu_bar_hello_2">${u.user_nick }님</div>

		<div class="menu_bar_label">나의 정보</div>
		<div class="menu_bar_link_div">
			<a class="menu_bar_link" href="${pageContext.request.contextPath }/user/userEdit">정보변경</a>
		</div>
		
		<div class="menu_bar_link_div">
			<a class="menu_bar_link" href="${pageContext.request.contextPath }/inquiry/inquiry_UserList?user_id=${sessionScope.user_id }">문의내역</a>
		</div>
		
		<div class="menu_bar_link_div">
			<a class="menu_bar_link" id="del" href="${pageContext.request.contextPath }/user/userDelete">회원탈퇴</a>
		</div>

		<div class="menu_bar_label">구매 정보</div>
		<div class="menu_bar_link_div">
			<a class="menu_bar_link" href="#user_link">구매한 상품</a>
		</div>
		
		<div class="menu_bar_link_div">
			<a class="menu_bar_link" href="#user_link">포인트 내역</a>
		</div>
	</div>

	<div class="profile_area">
		<!-- 회원정보 영역 -->
		<div class="user_info_area">
			<div class="user_info">
				<span class="user_id">${u.user_nick }님</span> 
					<a class="user_info_link" href="${pageContext.request.contextPath }/user/userEdit">회원정보 > </a> 
					<span class="user_id_span">아이디 : ${u.user_id }</span>
			</div>
			<div class="user_addr_info">
				<a class="user_info_link" href="#user_Edit">누적 포인트 > </a> 
				<span class="user_point_span">${u.user_point }P</span>
			</div>
		</div>

		<!-- 회원 등급 영역 -->
		<div class="user_rating_area">
			<div class="rating_view_div">
				<button class="Silver">Silver</button>
				<button class="Gold">Gold</button>
				<button class="Diamond">Diamond</button>
				<button class="VIP">VIP</button>
				<div class="rating_text" data-monthly_count_order="${countOrderMonth }">
					고객님의 등급은 <span class="rating_span">${updatedUserRating }</span> 입니다.
				</div>
			</div>

			<div class="rating_info_div">
				<div class="rating_info_title">등급별 포인트 적립</div>
				<div class="rating_info_content">
					<div class="Silver_info">
						Silver
						<div>0.2% 적립</div>
					</div>
					
					<div class="Gold_info">
						Gold
						<div>0.3% 적립</div>
					</div>
					
					<div class="Diamond_info">
						Diamond
						<div>0.4% 적립</div>
					</div>
					
					<div class="VIP_info">
						VIP
						<div>0.5% 적립</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 상품 상태 영역 -->
		<div class="product_result_area">
			<div class="result_1">
				<div class="result_in_set">
					<div class="result_count">${status_1 }</div>
					<div class="result_text">결제완료</div>
				</div>
			</div>

			<div class="result_2">
				<div class="result_in_set">
					<div class="result_count">${status_2 }</div>
					<div class="result_text">재료준비</div>
				</div>
			</div>

			<div class="result_3">
				<div class="result_in_set">
					<div class="result_count">${status_3 }</div>
					<div class="result_text">배송준비</div>
				</div>
			</div>

			<div class="result_4">
				<div class="result_in_set">
					<div class="result_count">${status_4 }</div>
					<div class="result_text">배송중</div>
				</div>
			</div>

			<div class="result_5">
				<div class="result_in_set">
					<div class="result_count">${status_5 }</div>
					<div class="result_text">배송완료</div>
				</div>
			</div>
		</div>
		
		<!-- product_result_area 뒤에 선 추가 -->
		<div class="hr_div"></div>

		<!-- 구매한 상품 리스트 -->
		<div class="my_product_list_area">
			<!-- 타이틀 -->
			<div class="classification_area">
				<div class="my_product_label">구매한 상품</div>
				<div class="classification_div">
					<div class="select_classification">
						<button class="select_classification_btn">분류방법 ▼</button>
					</div>
					<form method="POST" id="f">
						<div>
							<button class="classification_btn">전체보기</button>
						</div>
						
						<div>
							<button class="classification_btn" name="status" value="1">결제완료</button>
						</div>
						
						<div>
							<button class="classification_btn" name="status" value="2">재료준비</button>
						</div>
						
						<div>
							<button class="classification_btn" name="status" value="3">배송준비</button>
						</div>
						
						<div>
							<button class="classification_btn" name="status" value="4">배송중</button>
						</div>
						
						<div>
							<button class="classification_btn" name="status" value="5">배송완료</button>
						</div>
						
						<input type="hidden" name="user_id" value="${sessionScope.user_id }" />
					</form>
				</div>
			</div>

			<div class="my_product_title_area">
				<div class="title_name">상품명</div>
				<div class="title_price">금액</div>
				<div class="title_quantity">수량</div>
				<div class="title_date">구매일</div>
				<div class="title_result">상태</div>
			</div>

			<!-- 상품 상세 영역 ▼ -->
			<c:forEach var="op" items="${OrderProduct_list }" varStatus="status">
				<div class="my_product_detail_area">
					<div class="product_name">
						<a class="product_name_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${op.product_num}">${op.product_name }</a>
					</div>
					<div class="product_price">${op.product_price }원</div>
					<div class="product_quantity">${op.product_quantity }</div>
					<div class="product_date">${currentOrderStatusDate[status.index] }</div>
					<div class="product_result">${op.order_status }</div>
				</div>
			</c:forEach>
			<!-- 상품 상세 영역 ▲ -->
		</div>
	</div>
</body>
</html>