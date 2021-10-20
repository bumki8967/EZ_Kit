$(document).ready(function() {

	// 천단위  
	var bestMenu_list = $(".bestMenuPrice")
	
	for (i = 0; i < bestMenu_list.length; i++) {
		bestMenu = bestMenu_list[i]
		bestMenuPrice = Number($(bestMenu).text())
		bestMenuPrice = bestMenuPrice.toLocaleString();
		
		$(bestMenu).text(bestMenuPrice + " 원")
	}

	var menuList_price = $(".menu_price")
	
	for (i = 0; i < menuList_price.length; i++) {
		menuList = menuList_price[i]
		menuListPrice = Number($(menuList).text())
		menuListPrice = menuListPrice.toLocaleString();
		
		$(menuList).text(menuListPrice + " 원")
	}


	// 장바구니 버튼 눌렀을 때
	$(".main_cart_btn").click(function() {
		var btn = $(this);
		var product_num = $(btn).nextAll()[1];
		product_num = $(product_num).val();
		var user_id = $("#user_id").val();

		if (user_id == "" || user_id == undefined) {
			alert("로그인 후 이용이 가능합니다");
			$(".cart_add_form").attr('action', '/user/login');
			$(".cart_add_form").submit();
		} else {
			$.post("/order/cart_Insert", {
				user_id: user_id,
				product_num: product_num,
				product_quantity: 1
			})
				.done(function(data) {
					var data = eval("(" + data + ")");

					if (data.result == 1) {
						alert("상품이 장바구니에 담겼습니다");
					} else if (data.result == 2) {
						alert("이미 담겨있는 상품입니다");
					}
				});
		}
	});
});