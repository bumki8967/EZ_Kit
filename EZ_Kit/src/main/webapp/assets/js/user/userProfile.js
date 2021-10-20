$(document).ready(function() {
	var product_result = $(".product_result");

	$('.classification_btn').hide();

	$('.select_classification_btn').on('click', function() {
		$('.classification_btn').fadeToggle(200);
	});

	$('.classification_btn').on('click', function() {
		$('.classification_btn').fadeOut(200);
		$('.select_classification_btn').text($(this).text() + ' ▼');
	});


	var productPrice_list = $(".product_price")

	for (i = 0; i < productPrice_list.length; i++) {
		productPrice = productPrice_list[i];
		price = Number($(productPrice).text().replace("원", ""));
		price = price.toLocaleString();
		
		$(productPrice).text(price + " 원")

	}

	for (i = 0; i < product_result.length; i++) {
		var status = product_result[i]
		var statusText = Number($(status).text())
		var statusText = orderStatusToText(statusText)
		
		$(status).text(statusText)
	}
	orderStatusToText(product_result);

	// 등급 색상 변경
	var rating_span = $(".rating_span");
	changeRaitingColor(rating_span)

	// 배송 상태 색상 변경
	var payment = $(".result_count")[0]
	var product_preparation = $(".result_count")[1]
	var delivery_preparation = $(".result_count")[2]
	var delivery = $(".result_count")[3]
	var delivery_completed = $(".result_count")[4]

	changeResultText(payment)
	changeResultText(product_preparation)
	changeResultText(delivery_preparation)
	changeResultText(delivery)
	changeResultText(delivery_completed)

	// 회원 탈퇴
	$("#del").click(function() {
		var con = confirm("정말 회원탈퇴를 진행하시겠습니까?");

		if (con == true) {
			$("#del").attr('href', '/user/userDelete');
			alert("회원탈퇴가 완료되었습니다");
		}
	});

	$(".classification_btn").on('click', function() {

		var idx = this.value;

		if (idx == undefined || idx == null || idx == "") {
			$("#f").attr("action", "/user/userProfile");
			$("#f").submit();
		} else {
			$("#f").attr("action", "/user/userProfileStatus");
			$("#f").submit();
		}
	});



});

function changeRaitingColor(rating_span) {
	var rating_span_text = rating_span.text()
	var rating_info = 	{
							ratingName: ["Silver", "Gold", "Diamond", "VIP"],
							ratingColor: ["#c0c0c0", "#ffd700", "#4EE2EC", "#FE2E2E"]
						};
						
	for (i = 0; i < rating_info.ratingName.length; i++) {
		if (rating_span_text === rating_info.ratingName[i]) {
			$("." + rating_info.ratingName[i]).css({
				"border": `1px solid ${rating_info.ratingColor[i]}`,
				"box-shadow": `1px 1px 5px ${rating_info.ratingColor[i]}`,
				"color": `${rating_info.ratingColor[i]}`
			})
			$(rating_span).css("color", `${rating_info.ratingColor[i]}`);
		}
	}
}

// 배송 상태 색상 변경 함수
function changeResultText(result) {
	var resultText = result.innerText;
	
	if (resultText !== "0") {
		result.style.color = "#2f1f0d";
	}
}

function orderStatusToText(order_status) {
	let statusText = ""
	
	if (order_status === 1) {
		statusText = "결제완료"
	} else if (order_status === 2) {
		statusText = "재료준비"
	} else if (order_status === 3) {
		statusText = "배송준비"
	} else if (order_status === 4) {
		statusText = "배송중"
	} else if (order_status === 5) {
		statusText = "배송완료"
	}
	return statusText
}





