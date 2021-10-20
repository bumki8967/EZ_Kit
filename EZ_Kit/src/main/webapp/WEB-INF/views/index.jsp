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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/top.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/footer.css">
    
    <!-- js -->
    <script type="text/javascript" src="${pageConext.request.contextPath }/assets/js/index_img.js"></script>
    <script type="text/javascript" src="${pageConext.request.contextPath }/assets/js/index.js"></script>

</head>
</head>

<body class="main_body">

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<!-- img -->
	<div class="slide_area">
		<div class="slide_img_area">
			<ul class="img_ul">
				<c:forEach var="b" items="${bannerList }">
					<li class="img_li">
						<img class="slide_img_set" src="${pageContext.request.contextPath }/BannerImg?fname=${b}" />
					</li>
				</c:forEach>
			</ul>
		</div>

		<div class="event_btn_area">
			<button class="event_btn" id="Prev_btn">Prev</button>
			<button class="event_btn" id="Next_btn">Next</button>
		</div>
	</div>
	<!-- img -->

	<!-- best menu -->
	<table class="bestMenu_Table">
		<tr>
			<td class="bestMenu_text_td">
				<label class="bestMenu_label">실시간 베스트</label>
			</td>
		</tr>

		<tr>
			<td class="bestMenu_td">
				<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[0].product_num}">
					<img class="bestMenu_imgSet" src="${pageContext.request.contextPath }productImg?fname=${hitFileList[0]}&product_num=${hitIndexList[0].product_num}&type=1" />
				</a>
				
				<div class="bestMenu_name">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[0].product_num}">${hitIndexList[0].product_name}</a>
				</div>

				<div class="bestMenu_info">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[0].product_num}">
						<span class="bestMenuPrice">${hitIndexList[0].product_price} </span> / ${hitIndexList[0].product_portion}인분</a>
				</div>
			</td>

			<td class="bestMenu_td">
				<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[1].product_num}">
					<img class="bestMenu_imgSet" src="${pageContext.request.contextPath }productImg?fname=${hitFileList[1]}&product_num=${hitIndexList[1].product_num}&type=1" />
				</a>
				
				<div class="bestMenu_name">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[1].product_num}">${hitIndexList[1].product_name}</a>
				</div>

				<div class="bestMenu_info">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[1].product_num}">
						<span class="bestMenuPrice">${hitIndexList[1].product_price} </span> / ${hitIndexList[1].product_portion}인분</a>
				</div>
			</td>

			<td class="bestMenu_td">
				<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[2].product_num}">
					<img class="bestMenu_imgSet" src="${pageContext.request.contextPath }productImg?fname=${hitFileList[2]}&product_num=${hitIndexList[2].product_num}&type=1" />
				</a>
				
				<div class="bestMenu_name">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[2].product_num}">${hitIndexList[2].product_name}</a>
				</div>

				<div class="bestMenu_info">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[2].product_num}">
						<span class="bestMenuPrice">${hitIndexList[2].product_price} </span> / ${hitIndexList[2].product_portion}인분</a>
				</div>
			</td>
			
		<tr>
			<td class="bestMenu_td">
				<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[3].product_num}">
					<img class="bestMenu_imgSet" src="${pageContext.request.contextPath }productImg?fname=${hitFileList[3]}&product_num=${hitIndexList[3].product_num}&type=1" />
				</a>
				
				<div class="bestMenu_name">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[3].product_num}">${hitIndexList[3].product_name}</a>
				</div>

				<div class="bestMenu_info">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[3].product_num}">
						<span class="bestMenuPrice">${hitIndexList[3].product_price} </span> / ${hitIndexList[3].product_portion}인분</a>
				</div>
			</td>

			<td class="bestMenu_td">
				<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[4].product_num}">
					<img class="bestMenu_imgSet" src="${pageContext.request.contextPath }productImg?fname=${hitFileList[4]}&product_num=${hitIndexList[4].product_num}&type=1" />
				</a>
				
				<div class="bestMenu_name">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[4].product_num}">${hitIndexList[4].product_name}</a>
				</div>

				<div class="bestMenu_info">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[4].product_num}">
						<span class="bestMenuPrice">${hitIndexList[4].product_price} </span> / ${hitIndexList[4].product_portion}인분
					</a>
				</div>
			</td>

			<td class="bestMenu_td">
				<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[5].product_num}">
					<img class="bestMenu_imgSet" src="${pageContext.request.contextPath }productImg?fname=${hitFileList[5]}&product_num=${hitIndexList[5].product_num}&type=1" />
				</a>
				
				<div class="bestMenu_name">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[5].product_num}">${hitIndexList[5].product_name}</a>
				</div>

				<div class="bestMenu_info">
					<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${hitIndexList[5].product_num}">
						<span class="bestMenuPrice">${hitIndexList[5].product_price} </span> / ${hitIndexList[5].product_portion}인분</a>
				</div>
			</td>
		</tr>
	</table>
	<!-- best menu -->
  
	<!-- menu list -->
	<table class="menuList_table">
		<tr>
			<td class="menuList_text_td">
				<label class="menuList_label">Menu</label>
			</td>
		</tr>

		<c:forEach var="p" items="${indexList }" varStatus="status">
			<tr>
				<td class="menuList_img_td">
					<a class="menuList_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${p.product_num}">
						<img class="menuList_imgSet" src="${pageContext.request.contextPath }productImg?fname=${fileList[status.index]}&product_num=${p.product_num}&type=1" />
					</a>
				</td>
				
				<td class="menuList_info_td">
					<div class="menuList_name">
						<a class="bestMenu_link" href="${pageContext.request.contextPath }/product/product_detail?product_num=${p.product_num}">${p.product_name}</a>
						<span class="menuList_info menu_price"> ${p.product_price} </span> 
						<span class="menuList_info">/ ${p.product_portion}인분</span>
					</div>
					
					<div class="menuList_info">
						<textarea class="menuList_textarea" disabled>${p.product_info}</textarea>
					</div>
					
					<div class="menuList_btn">
						<form class="cart_add_form">
							<input class="main_cart_btn" type="button" class="" value="장바구니 담기" /> 
							<input type="hidden" class="user_id" name="user_id" value="${sessionScope.user_id }" /> 
							<input type="hidden" class="product_num" name="product_num" value="${p.product_num }" />
						</form>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
	<!-- best menu -->

	<!-- footer 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/footer.jsp" />
	<!-- footer 영역 끝 -->
</body>


</html>