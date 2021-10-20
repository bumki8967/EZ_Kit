$(document).ready(function() {
	$(".find_pw_btn").click(function() {
		var user_id = $("#user_id").val();

		if (user_id == "") {
			alert("아이디를 입력해주세요");
			return false;
		} else {
			$.post("/user/userCheck", {
				user_id: user_id
			})
				.done(function(data) {
					var data = eval("(" + data + ")");

					if (data.type == 1) {
						alert("입력하신 아이디로 임시비밀번호가 전송되었습니다");
						$(".find_pw_form").attr('action', '/user/user_Find_Pw');
						$(".find_pw_form").submit();
					} else {
						alert("일치하는 회원이 없습니다");
						return false;
					}
				});
		}
	});
});