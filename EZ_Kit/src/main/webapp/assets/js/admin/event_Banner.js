$(document).ready(function() {
	$("#submit_img").hide();
	$(".no_img_label").hide();

	if ($(".event_img_view_set").attr('src') == "/BannerImg?fname=") {
		$(".event_img_view_set").hide();
		$(".no_img_label").show();
	}

	$("#find_img").on('click', function() {
		$("#submit_img").show();
		$("#find_img").hide();
	});

	$("#submit_img").on('click', function() {
		$("#f").submit();
	});


	$(".event_img_set").on('click', function() {
		
		var fname = $(this).attr("id");
		var src = $(this).attr('src');
		
		$("#fname").val(fname);
		$(".event_img_view_set").attr('src', src);
	});

	$(".banner_del_btn").on('click', function() {
		
		var fname = $("#fname").val();
		
		if (fname == "" || fname == undefined) {
			alert("삭제할 사진을 선택하세요");
			return false;
		}
		this.form.submit();
	});
});