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
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/product/product_Find.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/product/product_List.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/top.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/footer.css">
	
	<!-- js -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/product/product_Find.js"></script>
</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<form class="findMenu_Form">
		<div class="find_bar_area">
			<input class="find_bar_text" type="text" name="searchKeyword" placeholder="메뉴명으로 검색해 주세요." />
			<div class="find_menu_btn_div">
				<input type="button" class="find_menu_btn" value="검색" />
			</div>
		</div>
	</form>

	<div class="menu_list_title_area">
		<div class="menu_list_title">EZ Kit Menu</div>
	</div>

	<div class="menu_list_area">
		<c:if test="${empty allProdList }">
			<div class="not_find_div">
				<div class="not_find_label">검색 결과가 존재하지 않습니다. :(</div>
				<div class="not_find_label">정확한 검색어를 입력하세요.</div>
				<div class="not_find_label">검색 조건 안내</div>

				<ul>
					<li>초성으로 검색한 경우.</li>
					<li>특수 문자를 사용한 경우. ( . / ' ; ( * ~ ) 등...</li>
					<li>일치하는 메뉴가 없을 경우.</li>
					<li>영문으로 검색한 경우.</li>
				</ul>
				<div class="not_find_label">위와 같은 사항으로 인해 검색에 실패할 수 있습니다.</div>
			</div>
		</c:if>

		<c:if test="${not empty allProdList }">
			<c:forEach var="p" items="${allProdList}" varStatus="status">
				<c:set var="rating_point">
					<c:if test="${u.user_rating == 'Silver' }">
		    		0.2%
		    	</c:if>
					<c:if test="${u.user_rating == 'Gold' }">
		    		0.3%
		    	</c:if>
					<c:if test="${u.user_rating == 'Diamond' }">
		    		0.4%
		    	</c:if>
					<c:if test="${u.user_rating == 'VIP' }">
		    		0.5%
		    	</c:if>
				</c:set>
				<div class="menu_area">
					<div class="menu_img_div">
						<a href="${pageContext.request.contextPath }/product/product_detail?product_num=${p.product_num}">
							<img class="menu_img_set" src="${pageContext.request.contextPath}/productImg?fname=${fileList[status.index]}&product_num=${p.product_num}&type=1" />
						</a>
					</div>
					<div class="menu_info_div">
						<div class="menu_title_div">${p.product_name}</div>
						<div class="menu_detail_div">조리 정보 : ${p.product_portion}인분 / ${p.product_time}분</div>
						<div class="menu_quantity_div">판매가 : ${p.product_price}</div>
						<div class="menu_point_div"> EZ Kit 포인트 <span class="point_span">${rating_point }</span> 적립 </div>
						<form class="cart_add_form">
							<c:if test="${sessionScope.user_type == 'user' }">
								<div class="cart_btn_div">
									<input class="prod_list_cart_btn" type="button" value="장바구니 담기" />
								</div>
								<input type="hidden" id="user_id" name="user_id" value="${sessionScope.user_id }" />
								<input type="hidden" id="product_num" class="product_num" name="product_num" value="${p.product_num }" />
							</c:if>

							<c:if test="${empty sessionScope.user_type }">
								<div class="cart_btn_div">
									<input class="prod_list_cart_btn" type="button" value="장바구니 담기" />
								</div>
							</c:if>

							<c:if test="${sessionScope.user_type == 'admin' }">
								<!-- 관리자 버튼 -->
								<div class="admin_btn_area">
									<input class="del_btn" data-product_num="${p.product_num }" type="button" value="상품 삭제" /> 
									<input class="edit_btn" data-product_num="${p.product_num }" type="button" value="상품 수정" />
								</div>
								<input type="hidden" id="user_id" name="user_id" value="${sessionScope.user_id }" />
								<input type="hidden" id="product_num" class="product_num" name="product_num" value="${p.product_num }" />
							</c:if>
						</form>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>

	<!-- footer 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/footer.jsp" />
	<!-- footer 영역 끝 -->
</body>
</html>