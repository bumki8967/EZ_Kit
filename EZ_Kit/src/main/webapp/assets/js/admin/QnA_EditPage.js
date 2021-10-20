$(document).ready(function() {

	// 추가 버튼 클릭시 중복체크
	$("#QnA_add_btn").click(function() {
		// 새로 추가할 qna 옵션
		var add_qna_option = this.form.qna_option_name.value;
		var qna_options = document.getElementsByClassName("QnA_title_btn");

		for (i = 0; i < qna_options.length; i++) {
			if (qna_options[i].value == add_qna_option) {
				alert("이미 존재하는 옵션입니다.");
				return false;
			}
		}
		this.form.submit();
	});


	// 옵션명 클릭시
	$(".QnA_title_btn").click(function() {
		qna_title = this.value;
		qna_title_num = $(this).next().val();

		document.getElementById("selected_QnA_option").value = qna_title;
		document.getElementById("edit_QnA_option").value = qna_title;
		document.getElementById("qna_option_num").value = qna_title_num;
	});

	// 수정 버튼 클릭시
	$("#QnA_edit_btn").click(function() {
		var update_qna_option = this.form.qna_option_name.value;
		var qna_options = document.getElementsByClassName("QnA_title_btn");
		
		for (i = 0; i < qna_options.length; i++) {
			if (qna_options[i].value == update_qna_option) {
				alert("이미 존재하는 옵션입니다.");
				return false;
			}
		}
		$("#f").attr('action', '/admin/updateQnAOption');
		$("#f").submit();
	});

	// 삭제 버튼 클릭시
	$("#QnA_del_btn").click(function() {
		var con = confirm("선택한 옵션을 삭제하시겠습니까?");
		if (con == true) {
			$("#f").attr('action', '/admin/deleteQnAOption');
			$("#f").submit();
		}
	});

});