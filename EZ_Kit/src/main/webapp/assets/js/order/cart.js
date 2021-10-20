$(document).ready(function() {

	// 천단위 콤마
	var allProductPrice = $(".price_td")
	for (i = 0; i < allProductPrice.length; i++) {
		var price = Number(allProductPrice[i].innerText.replace("원", "")).toLocaleString()
		allProductPrice[i].innerText = price + " 원"
	}

	// 전체 선택
	$(".all_check_btn").click(function() {
		var checkBtnAll = $(".checkbox");
		var totalCheckedTr = checkBtnAll.parent().parent()

		for (i = 0; i < totalCheckedTr.length; i++) {
			var checkedTr = totalCheckedTr[i];
			var checkedbtn = $(checkedTr).children().children().first()
			
			if (checkedbtn.is(":checked") == false) {
				var sumprice = sumProductPrice(checkedbtn)
				var checkIdx = productIndx(checkedbtn)
				var checkedMenuName = $(checkedTr).children().eq(1).text().trim()
				var product_num = $(checkedbtn).data("product_num")
				var quantity = totalQuantity(checkedbtn)
				var printArea = $(".product_name_list_area")
				var product_price = sumProductPrice(checkedbtn)
				var checkedMenu = `
                    <div class="side_menu_product_name" data-sumprice="${sumprice}" id="side_menu_${checkIdx}">${checkedMenuName}</div>
                  	<input type="hidden" id="product_name_${checkIdx}" name="product_name" value="${checkedMenuName}"/>        
                    <input type="hidden" id="product_num_${checkIdx}" name="product_num" value="${product_num}"/>
                    <input type="hidden" id="product_quantity_${checkIdx}" name="product_quantity" value="${quantity}"/>
                    <input type="hidden" id="product_price_${checkIdx}" name="product_price" value="${product_price}"/>
               `
				$(printArea).append(checkedMenu);
				checkedbtn.prop("checked", true);
			}
		}
		a = totalPrice()
	});

	// 선택 취소
	$(".all_check_cancel_btn").click(function() {
		var checkBtnAll = $(".checkbox");
		var totalCheckedTr = checkBtnAll.parent().parent()

		for (i = 0; i < totalCheckedTr.length; i++) {

			var checkedTr = totalCheckedTr[i];
			var checkedbtn = $(checkedTr).children().children().first()
			
			if (checkedbtn.is(":checked") == true) {
				var checkIdx = productIndx(checkedbtn)
				$("#side_menu_" + checkIdx).remove()
				$("#product_num_" + checkIdx).remove()
				$("#product_quantity_" + checkIdx).remove()
				$("#product_price_" + checkIdx).remove()
				
				checkedbtn.prop("checked", false);
			}
		}
		a = totalPrice()
	});

	// 선택 삭제
	$(".select_del_btn").click(function() {
		var con = confirm("목록에서 삭제하시겠습니까?")
		var productNum_list = []
		
		if (con) {
			var checkedAllbtn = $('input[type="checkbox"]:checked')
			var totalCheckedTr = checkedAllbtn.parent().parent()
			var user_id = $("#user_id").val()
			
			for (i = 0; i < totalCheckedTr.length; i++) {
				var checkedTr = totalCheckedTr[i];
				var checkedbtn = $(checkedTr).children().children().first()
				
				if (checkedbtn.is(":checked") == true) {
					var checkIdx = productIndx(checkedbtn)
					var productNum = $("#product_num_" + checkIdx).val()
					
					productNum_list.push(productNum)
					$("#side_menu_" + checkIdx).remove()
					$("#product_num_" + checkIdx).remove()
					$("#product_quantity_" + checkIdx).remove()
					$("#product_price_" + checkIdx).remove()
				}
			}
			totalCheckedTr.remove();

			$.ajax({
				method: 'POST',
				url: '/order/cart_delete',
				traditional: true,
				data: {
					'productNum_list': productNum_list,
					'user_id': user_id
				},
				success: function(data) {
					var obj = JSON.parse(data)
					
					if (obj.result === 1) {
						alert('삭제되었습니다')
					}
				}
			});
		}
		a = totalPrice()
	});

	// 삭제 버튼 클릭시
	$(".cancel_btn").click(function() {
		var con = confirm("목록에서 삭제하시겠습니까?")
		
		if (con) {
			var cancelbtn = $(this)
			var selectedTr = $(cancelbtn).parent().parent()
			var checkIdx = $("tr").index(selectedTr)
			
			console.log(cancelbtn);
			console.log(selectedTr);
			console.log(checkIdx);
			
			$("#side_menu_" + checkIdx).remove()
			$("#product_num_" + checkIdx).remove()
			$("#product_quantity_" + checkIdx).remove()
			$("#product_price_" + checkIdx).remove()
			selectedTr.remove()
			
			var user_id = $("#user_id").val()
			var product_num = $(selectedTr).children().children(".checkbox")
			product_num = $(product_num).data("product_num")

			$.ajax({
				method: 'POST',
				url: '/order/cart_delete',
				traditional: true,
				data: {
					'productNum_list': product_num,
					'user_id': user_id
				},
				success: function(data) {
					var obj = JSON.parse(data)

					if (obj.result === 1) {
						alert("해당 상품이 삭제되었습니다");
						selectedTr.remove()
					}
				}
			});
		}
		totalPrice()
	});

	// 선택시 주문리스트에 상품명 나타나기
	$(".checkbox").click(function() {

		var checkedbtn = $(this)
		var checkIdx = productIndx(checkedbtn)
		var printArea = $(".product_name_list_area")
		var checkedMenuName = checkedbtn.parent().next().text().trim()
		var sumprice = sumProductPrice(checkedbtn)
		var quantity = totalQuantity(checkedbtn)
		var product_num = $(this).data("product_num")
		var product_price = sumProductPrice(checkedbtn)
		var checkedMenu = `
            <div class="side_menu_product_name" data-sumprice="${sumprice}" id="side_menu_${checkIdx}">${checkedMenuName}</div>
            <input type="hidden" id="product_name_${checkIdx}" name="product_name" value="${checkedMenuName}"/>        
            <input type="hidden" id="product_num_${checkIdx}" name="product_num" value="${product_num}"/>
            <input type="hidden" id="product_quantity_${checkIdx}" name="product_quantity" value="${quantity}"/>
            <input type="hidden" id="product_price_${checkIdx}" name="product_price" value="${product_price}"/>
         `
		var quantity_area = $(checkedbtn).parent().nextAll()[2].children[1]
		var quantity = Number(quantity_area.innerText)
		var price = $(checkedbtn).parent().nextAll()[1].innerText
		price = Number(price.replace("원", "").replace(",", ""))
		
		if (checkedbtn.is(":checked") == true) {
			$(printArea).append(checkedMenu);
		} else if (checkedbtn.is(":checked") == false) {
			$("#side_menu_" + checkIdx).remove()
		}
		a = totalPrice()
	});


	// 수량 클릭
	$(".quantity_btn").click(function() {
		var btn = $(this)
		var btnText = $(btn).text()
		var quantity = totalQuantity(btn)
		var quantity_area = $(this).parent().children(".quantity_result")
		var idx = productIndx(btn)

		if (btnText === "+") {
			var max_quantity = Number($(".quantity_result").data("quantity"))

			if (quantity >= max_quantity) {
				alert("최대 수량을 초과하였습니다")
				return false
			}
			quantity += 1
			quantity_area.text(quantity)
		} else if (btnText === "-") {
			quantity -= 1

			if (quantity > 0) {
				quantity_area.text(quantity)

			} else if (quantity <= 0) {
				alert("최소 수량입니다")
				return false
			}
		}
		var sumprice = sumProductPrice(btn)
		sumprice_area = $("#side_menu_" + idx).data("sumprice", `${sumprice}`)

		$("#product_quantity_" + idx).val(quantity)
		$("#product_price_" + idx).val(sumprice)

		totalPrice()
	});

	// 포인트 전액 사용 클릭
	$("#total_use").click(function() {
		user_allPoint = getAllPoint();
		$(".used_point").data("used_point", user_allPoint);
		$("#used_point").val(user_allPoint)

		user_allPoint = pointComma(user_allPoint)
		$(".used_point").text(`사용한 포인트 : ${user_allPoint} p`)
		getUsedPoint()
		totalPrice()
	});

	// 포인트 사용 취소 클릭
	$("#use_cancel").click(function() {
		$(".used_point").removeData("used_point");
		getUsedPoint()
		$(".used_point").text(`사용한 포인트 :  0 p`)
		$("#used_point").val(0)
		totalPrice()
	});

	// 포인트 사용 클릭 : 포인트 입력 안되면 실행 x
	$("#use_btn").click(function() {
		var user_point = $(".point_textBox").val()
		
		if (checkNumber(user_point)) {
			user_point = Number(user_point)
			$("#used_point").val(user_point)
			$(".used_point").data("used_point", user_point);
			user_point = pointComma(user_point)
			$(".used_point").text(`사용한 포인트 : ${user_point} p`)
		}
		totalPrice()
	});


	// 주문하기 클릭
	$(".order_btn").click(function() {
		this.form.submit();
	});
});

// 포인트 입력 숫자만
function checkNumber(point) {
	var regexp = /^[0-9]*$/
	
	if (!regexp.test(point)) {
		alert("숫자만 입력하세요");
		return false;
	}
	return true;
}

// 포인트에 천단위 comma
function pointComma(point) {
	var point = point.toLocaleString()
	
	return point
}

// 현재 유저의 전체 포인트 가져오고 인트로 리턴
function getAllPoint() {
	var allPoint = $(".user_point").data("user_point")
	
	return allPoint;
}

// 결제에 사용한 포인트
function getUsedPoint() {
	var usedPoint = Number($(".used_point").data("used_point"))
	
	return usedPoint;
}

// idx return
function productIndx(btn) {
	var checkedbtn = btn;
	var checkedTr = $(checkedbtn).parent().parent();
	var checkIdx = $("tr").index(checkedTr)
	
	return checkIdx;
}


// 수량 return
function totalQuantity(btn) {

	var checkedbtn = btn;
	var checkedTr = $(checkedbtn).parent().parent();
	var quantity_area = $(checkedTr).children().children(".quantity_result");
	var productQuantity = Number(quantity_area.text());
	
	return productQuantity;

}

// 수량 * 가격 : 상품당 가격 합계
function sumProductPrice(btn) {
	var checkedbtn = btn;
	var checkedTr = $(checkedbtn).parent().parent();
	var price_area = $(checkedTr).children(".price_td")
	var price = Number($(price_area).text().replace("원", "").replace(",", ""))
	var quantity = totalQuantity(btn)
	var productPrice = price * quantity
	
	return productPrice;
}

// 전체 가격 : 총 상품 가격
function totalPrice() {
	// 전체 선택 메뉴
	var selected_menu_list = $(".side_menu_product_name")
	var price_result_area = $(".side_menu_price_result")
	var productPrice = 0
	var total_productPrice = 0
	var user_used_point = getUsedPoint()

	// 하나씩 가격 가져오기
	for (i = 0; i < selected_menu_list.length; i++) {
		var selected_menu = selected_menu_list[i]

		productPrice = Number($(selected_menu).data("sumprice"))
		total_productPrice += productPrice
	}
	total_productPrice = total_productPrice - user_used_point
	$(price_result_area).text(total_productPrice.toLocaleString() + " 원")
	return total_productPrice
}