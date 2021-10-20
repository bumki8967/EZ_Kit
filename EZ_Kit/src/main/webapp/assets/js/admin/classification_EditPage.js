$(document).ready(function() {

	$("#classification_add_btn").click(function() {
		// 새로 추가할 분류 옵션
		var add_classification = this.form.classification_name.value;
		var classifications = document.getElementsByClassName("classification_btn");

		// 추가 버튼 클릭시 중복체크
		for (i = 0; i < classifications.length; i++) {
			if (classifications[i].value == add_classification) {
				alert("이미 존재하는 옵션입니다.");
				return false;
			}
		}
		this.form.submit();
	});


	// 옵션명 클릭시
	$(".classification_btn").click(function() {
		classification_name = this.value;
		classification_num = $(this).next().val();

		document.getElementById("edit_classification").value = classification_name;
		document.getElementById("classification_num").value = classification_num;
	});

	// 수정 버튼 클릭시
	$("#classification_edit_btn").click(function() {
		var update_classification = this.form.classification_name.value;
		var classifications = document.getElementsByClassName("classification_btn");
		
		for (i = 0; i < classifications.length; i++) {
			if (classifications[i].value == update_classification) {
				alert("이미 존재하는 옵션입니다.");
				return false;
			}
		}
		$("#f").attr('action', '/admin/updateClassification');
		$("#f").submit();
	});

	// 삭제 버튼 클릭시
	$("#classification_del_btn").click(function() {
		var con = confirm("선택한 옵션을 삭제하시겠습니까?");
		
		if (con == true) {
			$("#f").attr('action', '/admin/deleteClassification');
			$("#f").submit();
		}
	});

});