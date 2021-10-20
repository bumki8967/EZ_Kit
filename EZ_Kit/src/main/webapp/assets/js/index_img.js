$(document).ready(function() {
	// ----- 배너 -----
	$('.slide_img_area>ul>li').hide();
	$('.slide_img_area>ul>li:first-child').show();

	var timer = setInterval(function() {
		$('.slide_img_area>ul>li:first-child').fadeOut().next().fadeIn().end(1000).appendTo('.slide_img_area>ul');
	}, 5000);

	$('.event_btn').hover(function() {
		clearInterval(timer);
	}, function() {
		timer = setInterval(function() {
			$('.slide_img_area>ul>li:first-child').fadeOut().next().fadeIn().end(1000).appendTo('.slide_img_area>ul');
		}, 5000);
	});


	$("#Next_btn").click(function() {
		$('.slide_img_area>ul>li:first-child').fadeOut().next().fadeIn().end(500).appendTo('.slide_img_area>ul');
	});

	$("#Prev_btn").click(function() {
		$('.slide_img_area>ul>li:last-child').fadeIn().prev().fadeOut().end(500).prependTo('.slide_img_area>ul');
	});

	//----- 배너 끝 -----

	// 등록된 상품이 없을 때 index 페이지 사진 교체 
	var noImg = $(".bestMenu_imgSet").attr("src");

	if (noImg.split("fname=")[1] === "&product_num=&type=1") {
		$(".bestMenu_imgSet").attr("src", "assets/img/No_Prod_Img.png");
		$(".bestMenu_link").attr("href", "#");
		$(".bestMenu_info").hide();
	}
});




