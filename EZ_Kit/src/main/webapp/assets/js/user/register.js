$(document).ready(function() {

	var id = "";
	$('#selectEmail').change(function() {
		var getUser_id = $('#user_id').val();

		if (id == "") {
			id = getUser_id;
		}

		$('#selectEmail option:selected').each(function() {
			if ($(this).val() == 0) {
				$('#user_id').empty("");
				$('#user_id').val(id + "");
			} else {
				$('#user_id').empty("");
				$('#user_id').val(id + $(this).text());
			}
		});
	});

	$("#user_id").on("keypress", function(e) {
		var text = String.fromCharCode(e.which);
		
		if (text.toUpperCase() == text && text.toLowerCase() !== text && !e.shiftKey) {
			$(".id_caps_check").text("Caps Lock이 활성화되어 있습니다!");
		} else {
			$(".id_caps_check").text("");
		}
	});

	$("#user_pw").on("keypress", function(e) {
		var text = String.fromCharCode(e.which);
		
		if (text.toUpperCase() == text && text.toLowerCase() !== text && !e.shiftKey) {
			$(".pw_caps_check").text("Caps Lock이 활성화되어 있습니다!");
		} else {
			$(".pw_caps_check").text("");
		}
	});

	$(".register_btn").click(function() {
		// user_nick 입력값
		var user = $("#user_nick").val().toUpperCase().replace(/(\s*)/g, "");
		var idx = user.indexOf('ADMIN');
		var idx2 = user.indexOf('EZKIT');

		if (idx != -1 || idx2 != -1) {
			alert("사용 불가능한 닉네임이 포함되어 있습니다 ('admin', 'ezkit')");
		} else {
			alert("회원가입이 완료되었습니다");
			$("#register_form").attr('action', '/user/register');
			$("#register_form").submit();
		}
	});

});