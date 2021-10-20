<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
	<!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/admin/order_State.css">
    
    <!-- Jquery -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- js -->
    <script src="${pageContext.request.contextPath }/assets/js/admin/order_State.js"></script>

</head>
<body>

    <!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->
	
	<c:import url="${pageContext.request.contextPath }/assets/inc/admin_SideMenu.jsp" />
	
    <div class="util_btn_area">
        <div class="util_label">선택 / 취소</div>
        <div class="check_btn_div">
            <button class="all_check_btn all_check">전체선택</button>
            <button class="all_check_cancel_btn all_check">선택취소</button>
        </div>

        <div class="util_label">상태 변경</div>
        <div class="state_btn_div">
            <input class="order_state_btn change_state" type="button" value="재료준비">
            <input class="order_state_btn change_state" type="button" value="배송준비">
            <input class="order_state_btn change_state" type="button" value="배송중">
            <input class="order_state_btn change_state" type="button" value="배송완료">
        </div>

        <div class="util_label">상태별 분류</div>
        <div class="state_btn_div">
            <input class="order_state_btn select_state" type="button" value="결제완료">
            <input class="order_state_btn select_state" type="button" value="재료준비">
            <input class="order_state_btn select_state" type="button" value="배송준비">
            <input class="order_state_btn select_state" type="button" value="배송중">
            <input class="order_state_btn select_state" type="button" value="배송완료">
        </div>
    </div>

    <div class="order_state_area">
        <table class="order_state_table">
            <tr>
                <th class="check_th">선택</th>
                <th class="num_th">번호</th>
                <th class="order_nick_th">주문자</th>
                <th class="name_th">상품명</th>
                <th class="state_th">상태</th>
                <th class="date_th">주문일</th>
            </tr>

      <c:forEach var="p" items="${orderProduct_list }" varStatus="status">
            <tr>
                <td class="check_td">
                    <input class="checkbox" data-order_product_num="${p.order_product_num }" type="checkbox">
                </td>
                <td class="num_td">${status.index + 1 }</td>
                <td class="order_nick_td">${orderUserName_list[status.index] }</td>
                <td class="name_td">${p.product_name }</td>
                <td class="state_td">${orderStatus }</td>
                <td class="date_td">${currentOrderStatusDate_list[status.index] }</td>
            </tr>
        </c:forEach>
        </table>
        
        <form id="selectByStatus" action="${pageContext.request.contextPath }/admin/order_Info">
           <input type="hidden" id="selected_status" name="order_status" value="">
        </form>
        
        <form id="updateOrderStatus" action="${pageContext.request.contextPath}/admin/updateOrderStatus">
        </form>
        
        <input type="hidden" id="user_id"  value="user">
    </div>
</body>

</html>