$(document).ready(function() {
	var orderStatus = [
		{ status: '결제완료', type: 1 },
		{ status: '재료준비', type: 2 },
		{ status: '배송준비', type: 3 },
		{ status: '배송중', type: 4 },
		{ status: '배송완료', type: 5 },
	]

	// 전체 선택 / 선택취소 클릭
	$(".all_check").click(function() {
		var btn = $(this)
		checkedBtn = allCheckClick(btn)
	});

	// 체크박스 
	$(".checkbox").click(function() {
		var btn = $(this)
		checkBoxClick(btn)
	});

	// 상태 변경
	$(".change_state").click(function() {
		var btn = $(this)
		checkedBtn = $("input[type='checkbox']:checked")

		var user_id = $("#user_id").val()

		var con = stateQuestion(checkedBtn)


		if (con === false) {
			return false
		} else if (con === true) {
			// 바뀐 order_status int로 받음

			var con2 = changeStateText(checkedBtn, btn)
			
			if (con2 === false) {
				return false
			} else if (con2 === true) {
				order_status = stateCheck(checkedBtn, btn, orderStatus)

				for (i = 0; i < checkedBtn.length; i++) {
					var checked = checkedBtn[i]
					var order_product_num = $(checked).data("order_product_num");
					var str2 = `
		               <input type="hidden" name="order_product_num" value="${order_product_num}">
		            `
					$("#updateOrderStatus").append(str2);
				}
				var str1 = `
		               <input type="hidden" id="update_status" name="update_status" value="${order_status}">
		            `
				$("#updateOrderStatus").append(str1);
				$("#updateOrderStatus").submit();
			}
		}


	});
	// 상태별 분류
	$(".select_state").click(function() {
		var btn = $(this);
		var selected_status = $(btn).val();
		var selected_status = statusTextToNumber(selected_status);

		$("#selected_status").val(selected_status);
		$("#selectByStatus").submit();
	});

});

// 전체선택, 선택취소 함수 
// 클릭한 버튼을 매개변수로 받는다
// 체크된 버튼 return
function allCheckClick(btn) {
	var allCheckBtn = $(btn).text()

	if (allCheckBtn === "전체선택") {
		btn = $(".checkbox").prop("checked", true)
		return checkedBtn = btn
	} else if (allCheckBtn === "선택취소") {
		$(".checkbox").prop("checked", false)
		return checkedBtn = null
	}
}

// 체크박스 클릭
// 클릭한 행 idx 반환
function checkBoxClick(btn) {
	var checkedTr = $(btn).parent().parent()
	var idx = $("tr").index(checkedTr)
	return idx
}

// 상태변경 클릭
// 체크된 버튼, 클릭한 버튼, orderStatus 받는다 
// status int로 리턴
function stateCheck(checkedBtn, clickBtn, orderStatus) {
	var checkedBtn = checkedBtn // 체크 되어진 전체 버튼
	var clickBtn = clickBtn // 현재 클릭한 버튼 : 상태 변경 버튼
	var btnState = $(clickBtn).val() // 클릭한 버튼의 배송상태

	// orderType 체크하는 함수
	var returnOrderType = (orderStatus) => {
		if (btnState === orderStatus.status) {
			return true
		}
	}
	var returntype = orderStatus.find(returnOrderType)

	return returntype.type
}


// 표의 글자 바꾸는 함수
// 배송완료 일 때는 false
function changeStateText(checkedBtn, clickBtn) {
	var btnState = $(clickBtn).val() // 클릭한 버튼의 배송상태
	
	for (i = 0; i < checkedBtn.length; i++) {
		var current_btn = checkedBtn[i]
		var textArea = $(current_btn).parent().nextAll()[3]
		
		if ($(textArea).text() === "배송완료") {
			alert("배송완료된 상품은 변경할수 없습니다")
			return false
		}
		$(textArea).text(btnState)
	}
	return true
}

// 상태별 텍스트 -> 숫자
function statusTextToNumber(order_status) {
	if (order_status === "결제완료") {
		selected_status = 1
	} else if (order_status === "재료준비") {
		selected_status = 2
	} else if (order_status === "배송준비") {
		selected_status = 3
	} else if (order_status === "배송중") {
		selected_status = 4
	} else if (order_status === "배송완료") {
		selected_status = 5
	}
	
	return selected_status
}


// 상품 선택, 변경 확인
function stateQuestion(checkedBtn) {
	if ($(checkedBtn).length === 0) {
		alert("상품을 선택해 주세요")
		return false
	} else {
		var question = confirm('상태를 변경하시겠습니까?')
		if (question === false) {
			return false
		} else if (question === true) {
			return true
		}
	}
}








