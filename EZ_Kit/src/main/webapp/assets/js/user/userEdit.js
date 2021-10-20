	$(document).ready(function() {
		$(".register_btn").click(function() {
			alert("정보수정이 완료되었습니다");
			$("#edit_form").attr('action', '/user/Edit');
			$("#edit_form").submit();
		});
	});