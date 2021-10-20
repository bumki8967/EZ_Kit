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
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/admin/event_Banner.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/QnA_SideMenu.css">

	<!-- js -->
	<script src="${pageContext.request.contextPath }/assets/js/admin/event_Banner.js"></script>
</head>

<body>

	<!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

	<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />

	<div class="banner_area">
		<div class="event_img_list">
			<c:forEach var="f" items="${fileList }" varStatus="status">
				<img class="event_img_set" id="${f }" src="${pageContext.request.contextPath }/BannerImg?fname=${f}">
			</c:forEach>
		</div>

		<div class="event_img_view">
			<div class="view_img_area">
				<div class="no_img_label">등록된 이미지가 없습니다.</div>
				<img class="event_img_view_set" src="${pageContext.request.contextPath }/BannerImg?fname=${fileList[0]}">
			</div>
			<div class="event_btn_div">
				<form method="POST" action="/admin/deleteBanner">
					<button class="banner_del_btn">선택한 배너 삭제</button>
					<input type="hidden" name="fname" id="fname" />
				</form>
				<form method="POST" id="f" enctype="multipart/form-data" action="/admin/insertBanner" >
					<input type="file" name="banner_img" style="display: none" accept="image/*" multiple required /> 
					<input type="button" class="banner_add_btn" id="find_img" onClick="document.all.banner_img.click()" value="사진 찾기"> 
					<input type="button" class="banner_add_btn" id="submit_img" value="이벤트 배너 추가">
				</form>
			</div>
		</div>
	</div>
</body>

</html>