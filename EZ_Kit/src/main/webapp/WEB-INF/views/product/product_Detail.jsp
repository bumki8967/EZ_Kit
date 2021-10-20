<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">

	<!-- Jquery -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    
	<!-- CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/css/lightbox.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/product/product_Detail.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/top.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/footer.css">    

    <!-- 사진 확대 라이브러리 : lightbox -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.1/js/lightbox.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/product/product_Detail.js"></script>

</head>

<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<div class="warp_btn">
		<div>
			<input class="top_warp_btn" type="button" value="▲">
		</div>
		<div>
			<input class="bottom_warp_btn" type="button" value="▼">
		</div>
	</div>
	
	<table class="product_detail_table">
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
		
		<tr>
			<td class="detail_img_td">
				<a class="detail_img_set_a" data-lightbox="img_sizeup" href="${pageContext.request.contextPath }/productImg?fname=${filesname[0] }&product_num=${p.product_num }&type=1">
					<img class="detail_img_set" data-lightbox="img_sizeup" src="${pageContext.request.contextPath }/productImg?fname=${filesname[0] }&product_num=${p.product_num }&type=1" />
				</a>
				<div class="detail_sub_img_div">
					<c:forEach var="i" items="${filesname }">
						<img class="detail_sub_img_set" src="${pageContext.request.contextPath }/productImg?fname=${i }&product_num=${p.product_num }&type=1" />
					</c:forEach>
				</div>
			</td>

			<td class="detail_info_td">
				<div class="detail_title_div">${p.product_name }</div>

				<div class="cooking_info_div">
					조리 정보 : <span class="cooking_info_span">${p.product_portion }인분 / ${p.product_time }분</span>
				</div>

				<div class="price_div">
					판매가 : <span class="price_span"> ${p.product_price }원</span>
				</div>

				<div class="point_div">
					포인트 적립 : <span class="point_span">EZ Kit 포인트 ${rating_point } 적립</span>
				</div>

				<div class="quantity_btn_div">
					수량 : 	<span class="quantity_btn_span"> 
								<input class="quantity_minus_btn quantityBtn" type="button" value="-" />
								<input class="quantity_result" data-max-quantity="${p.product_quantity }" id="quantity_result" type="button" value="1" /> 
								<input class="quantity_plus_btn quantityBtn" type="button" value="+" />
							</span> 
							<span class="quantity_result_span"></span>
				</div>

				<div class="cart_btn_div">
					<form id="cart_add_form">
						<c:if test="${sessionScope.user_type == 'user' }">
							<input class="recipe_btn" type="button" value="조리방법 보기" />
							<input class="cart_btn" type="button" value="장바구니 담기" />
						</c:if>

						<c:if test="${empty sessionScope.user_type }">
							<input class="recipe_btn" type="button" value="조리방법 보기" />
							<input class="cart_btn" type="button" value="장바구니 담기" />
						</c:if>

						<c:if test="${sessionScope.user_type == 'admin' }">
							<input class="edit_btn" type="button" id="edit_btn" value="상품 수정하기" />
							<input class="del_btn" type="button" id="del_btn" value="상품 삭제하기" />
						</c:if>
						<input type="hidden" name="user_id" id="user_id" value="${sessionScope.user_id }" /> 
						<input type="hidden" name="product_num" id="product_num" value="${p.product_num }" />
					</form>
				</div>
			</td>
		</tr>

		<!-- 상세 이미지, 상세내용 영역 -->
		<tr>
			<td colspan="2">
				<div class="info_img_div">
					<img class="info_img_set" src="${pageContext.request.contextPath }/productImg?fname=${detailImg }&product_num=${p.product_num }&type=2" />
				</div>

				<div class="info_text_div">
					<textarea class="info_text" name="product_info" disabled>${p.product_info }</textarea>
				</div>
			</td>
		</tr>
	</table>

	<!-- 리뷰 영역 -->
	<form method="POST" class="insert_review_form">
		<table class="review_table">
			<tr>
				<td class="review_writing_td">
					<textarea class="review_writing_text" name="review_content" id="review_content" placeholder="리뷰를 작성해보세요!"></textarea>
				</td>
				<td class="review_writing_btn_td">
					<input class="review_writing_btn" type="button" value="리뷰 작성" />
				</td>
			</tr>
		</table>
		
		<c:if test="${sessionScope.user_type == 'user' }">
			<input type="hidden" id="user_nick" value="${sessionScope.user_nick }" />
		</c:if>
		
		<c:if test="${sessionScope.user_type == 'admin' }">
			<input type="hidden" id="user_nick" value="EZKit" />
		</c:if>
		
		<input type="hidden" id="product_num" value="${p.product_num }" /> 
		<input type="hidden" name="user_type" id="user_type" value="${sessionScope.user_type }" />
	</form>

	<table class="review_content_table" id="review_content_table">
		<c:if test="${not empty list2 }">
			<c:forEach var="r" items="${list2 }">
				<c:set var="writeonly">
					<c:choose>
						<c:when test="${sessionScope.user_nick != r.user_nick && sessionScope.user_type != 'admin' }">
							disabled
						</c:when>
						
						<c:when test="${empty sessionScope.user_type }">
							disabled
						</c:when>
					</c:choose>
				</c:set>
				
				<tr>
					<td class="order_review_td">
						<textarea class="order_review_text" id="${r.review_num }" ${ writeonly}>${r.review_content }</textarea>
					</td>
					
					<td class="order_review_info">
						<form method="POST">
							<c:if test="${r.user_nick == 'EZKit' }">
								<div class="seller_nick">
									작성자 : <span class="seller_nick_span">EZ Kit</span>
								</div>
							</c:if>
							
							<c:if test="${r.user_nick != 'EZKit' }">
								<div class="order_nick">
									작성자 :<input class="order_nick_btn" type="button" value="${r.user_nick }" />
								</div>
							</c:if>
							
							<div class="order_review_date">작성일 : ${r.review_date }</div>
							<div class="order_review_btn_div">
								<c:if test="${sessionScope.user_nick == r.user_nick || sessionScope.user_type == 'admin' }">
									<input class="order_review_del_btn" type="button" value="삭제" onClick="$.fn.review_del(this.form);" />
									<input class="order_review_edit_btn" type="button" value="수정" onClick="$.fn.review_edit(this.form);" />
								</c:if>
								<input type="hidden" name="review_num" value="${r.review_num }" />
								<input type="hidden" name="review_content" />
							</div>
						</form>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

	<!-- footer 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/footer.jsp" />
	<!-- footer 영역 끝 -->
</body>
</html>