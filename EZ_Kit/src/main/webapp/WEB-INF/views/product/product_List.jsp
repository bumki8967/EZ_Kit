<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <!-- JQuery -->
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>

	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/product/product_List.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/top.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/footer.css">
    
    <!-- js -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/product/product_List.js"></script>

</head>
<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<div class="menu_list_title_area">
		<div class="menu_list_title">EZ Kit Menu</div>
		<div class="menu_list_btn_div">
			<form method="POST" id="c_form" action="${pageContext.request.contextPath }/product/product_list_classification">
				<input class="menu_list_btn" type="button" name="0" value="전체" />
				<c:forEach var="c" items="${classificationList }" varStatus="status">
					<input class="menu_list_btn" type="button" name="${status.count }" value="${c.classification_name }" />
				</c:forEach>
				<input type="hidden" name="type1" value="" /> 
				<input type="hidden" name="classification_name" value="" />
			</form>
			<input type="hidden" name="type2" value="${type2 }" />
		</div>
	</div>



	<div class="menu_list_area">
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
					<div class="menu_quantity_div"> 판매가 : <span class="productPrice"> ${p.product_price} </span> </div>
					<div class="menu_point_div"> EZ Kit 포인트 <span class="point_span">${rating_point }</span> 적립 </div>
					
					<form class="cart_add_form">
						<c:if test="${sessionScope.user_type == 'user' }">
							<div class="cart_btn_div">
								<input class="prod_list_cart_btn" type="button" value="장바구니 담기" />
							</div>
							<input type="hidden" id="user_id" name="user_id" value="${sessionScope.user_id }" />
							<input type="hidden" id="product_num" name="product_num" value="${p.product_num }" />
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
							<input type="hidden" id="product_num" name="product_num" value="${p.product_num }" />
						</c:if>
					</form>
				</div>
			</div>
		</c:forEach>
	</div>

	<!-- footer 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/footer.jsp" />
	<!-- footer 영역 끝 -->
</body>

</html>