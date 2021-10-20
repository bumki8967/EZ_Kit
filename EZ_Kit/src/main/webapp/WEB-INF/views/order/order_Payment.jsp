<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	
	<!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/order/order_Payment.css">

	<!-- js -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/order/order_Payment.js"></script>

    <!-- 다음 우편번호 검색 스크립트 -->
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/daumPostCode.js"></script>

</head>

<body>
    <!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<div class="payment_area">
		<div class="user_info_div">
			<div>주문자 : ${u.user_nick }님</div>
			<div>휴대폰 번호 : ${u.user_tel }</div>
		</div>

		<div class="user_address_div">
			<div class="post_code_div">
				우편번호 : <input class="post_code_textbox readonly" id="postcode" name="postcode" type="text" value="${u.user_postcode }"> 
						<input type="button" class="find_post_code_btn readonly" onClick='execDaumPostcode("postcode", "addr1", "addr2")' value="우편번호 찾기" />
			</div>
			<div class="addr1_div">
				주소 : <input class="addr1_textbox readonly" id="addr1" name="addr1" 	type="text" value="${u.user_addr1 }">
			</div>
			<div class="addr2_div">
				상세주소 : <input class="addr2_textbox readonly" id="addr2" name="addr2" type="text" value="${u.user_addr2 }">
			</div>
			<div class="addr_edit_btn_div">
				<button class="addr_edit_btn" id="addr_edit">배송지 정보 수정하기</button>
				<button class="addr_edit_btn" id="edit_done">배송지 정보 수정완료</button>
			</div>
		</div>

		<div class="payment_div">
			<div class="payment_btn_div">
				<button class="card_btn">신용카드</button>
				<button class="account_btn">계좌이체</button>
				<button class="tel_btn">휴대폰 결제</button>
			</div>

			<div class="payment_input_div">
				<!-- 신용카드 -->
				<div class="card_input_div input_div">
					카드번호 입력 : <input class="card_num_text" type="text" maxlength="4" onkeyup="$(this).val($(this).val().replace(/\D/g,''));" /> -
								<input class="card_num_text" type="text" maxlength="4" onkeyup="$(this).val($(this).val().replace(/\D/g,''));" /> -
								<input class="card_num_text" type="text" maxlength="4" onkeyup="$(this).val($(this).val().replace(/\D/g,''));" /> -
								<input class="card_num_text" type="text" maxlength="4" onkeyup="$(this).val($(this).val().replace(/\D/g,''));" />
				</div>

				<!-- 계좌이체 -->
				<div class="account_input_div input_div">
					예금주 : <input class="account_name_text" type="text" /> 
					계좌번호 : <input class="account_num_text" type="text" placeholder="- 없이 입력하세요." onkeyup="$(this).val($(this).val().replace(/\D/g,''));" />
				</div>

				<!-- 휴대폰 결제 -->
				<div class="tel_input_div input_div">
					번호 입력 : <input class="tel_num_text" type="text" value="010" maxlength="3" onkeyup="$(this).val($(this).val().replace(/\D/g,''));" /> -
							 <input class="tel_num_text" type="text" maxlength="4" onkeyup="$(this).val($(this).val().replace(/\D/g,''));" /> -
							 <input class="tel_num_text" type="text" maxlength="4" onkeyup="$(this).val($(this).val().replace(/\D/g,''));" />
				</div>
			</div>
		</div>

		<div class="payment_btn_div">
			<button class="payment_cancel">결제취소</button>
			<button class="payment_btn">결제완료</button>
		</div>
	</div>

	<!-- 데이터 전달 폼 -->
	<form id="dataForm">
		<input type="hidden" name="user_id" value="${u.user_id }" /> 
		<input type="hidden" name="used_point" value="${used_point }" /> 
		<input type="hidden" class="addr1" name="edited_user_addresse1" value="" />
		<input type="hidden" class="addr2" name="edited_user_addresse2" value="" /> 
		<input type="hidden" class="postcode" name="edited_user_postcode" value="" />

		<c:forEach var="p" items="${productNum_list }" varStatus="status">
			<input type="hidden" name="product_num" value="${p}" />
			<input type="hidden" name="product_name" value="${productname_list[status.index]}" />
			<input type="hidden" name="product_quantity" value="${productQuantity_list[status.index]}" />
			<input type="hidden" name="product_price" value="${productPriceSum_list[status.index]}" />
		</c:forEach>
	</form>
</body>
</html>