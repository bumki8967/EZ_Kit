$(document).ready(function() {

	$(".board_del_btn").click(function() {
		var con = confirm("삭제하시겠습니까?");
		
		if (con) {
			$("#f").attr('action', '/admin/notice_Delete');
			$("#f").submit();
		}
	});

	$(".board_edit_btn").click(function() {
		$("#f").attr('action', '/admin/notice_EditForm');
		$("#f").submit();
	});

	$(".board_list_btn").click(function() {
		$("#f").attr('action', '/admin/notice_List');
		$("#f").submit();
	});
});






