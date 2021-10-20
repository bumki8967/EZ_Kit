$(document).ready(function() {

	// 수정완료 버튼 숨기기
	$('#edit_done').hide();

	// 텍스트 박스, 우편번호 찾기 버튼 비활성화
	$('.readonly').attr("disabled", true);

	// 수정하기 버튼 클릭
	$('#addr_edit').on('click', function() {
		var result = confirm("배송지 정보를 변경하시겠습니까?");

		if (result == true) {
			$('#addr_edit').hide();                 // 수정하기 버튼 숨기기
			$('#edit_done').show();                 // 수정완료 버튼 보이기
			$('.readonly').attr("disabled", false); // 입력 활성화
			$('.addr2_textbox').val("");           	// 벨류 비우기
		}
	});

	// 수정완료 버튼 클릭
	$('#edit_done').on('click', function() {
		// 공백 검사
		if ($('.post_code_textbox').val() == "") {
			alert("우편 번호를 입력하세요");
			return false;
		} else if ($('.addr1_textbox').val() == "") {
			alert("주소를 입력하세요");
			return false;
		} else if ($('.addr2_textbox').val() == "") {
			alert("상세주소를 입력하세요");
			return false;
		}

		var result = confirm("배송지 정보를 변경합니다.")

		if (result == true) {
			$('#edit_done').hide();                 // 수정완료 버튼 숨기기
			$('#addr_edit').show();                 // 수정하기 버튼 보이기
			$('.readonly').attr("disabled", true);  // 입력 비활성화
			alert("배송지 정보 업데이트 완료");

			var edited_addr1 = $('.addr1_textbox').val();
			var edited_addr2 = $('.addr2_textbox').val();
			var edited_postcode = $('.post_code_textbox').val();

			$('.addr1').val(edited_addr1);
			$('.addr2').val(edited_addr2);
			$('.postcode').val(edited_postcode);
		}

	});

	// 결제 방법

	$('.input_div').hide(); // 입력창 숨기기

	// 신용카드 입력창 show
	$('.card_btn').on('click', function() {
		$('.input_div').hide(); // 초기화
		$('.card_input_div').show(100);
	});

	// 계좌이체 입력창 show
	$('.account_btn').on('click', function() {
		$('.input_div').hide(); // 초기화
		$('.account_input_div').show(100);
	});

	// 휴대폰 결제 입력창 show
	$('.tel_btn').on('click', function() {
		$('.input_div').hide(); // 초기화
		$('.tel_input_div').show(100);
	})

	// 결제 취소 버튼
	$('.payment_cancel').on('click', function() {
		var result = confirm('입력하신 정보는 저장되지 않습니다.')

		if (result == true) {
			location.href = '#';
		}

	});

	// 결제 완료 버튼
	$('.payment_btn').on('click', function() {
		var form = $("#dataForm")

		//      $(form).attr("method", "post");
		$(form).attr("action", "/order/insertOrder");
		$(form).submit();
	});

	// 포커스 자동 이동
	$(".card_num_text").keyup(function() {
		var charLimit = $(this).attr("maxlength");
		
		if (this.value.length >= charLimit) {
			$(this).next('.card_num_text').focus();
			return false;
		}
	});

	$(".tel_num_text").keyup(function() {
		var charLimit = $(this).attr("maxlength");
		
		if (this.value.length >= charLimit) {
			$(this).next('.tel_num_text').focus();
			return false;
		}
	});
});