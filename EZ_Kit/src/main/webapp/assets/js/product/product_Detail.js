$(document).ready(function() {

   // 페이지 시작하면 금액 정규화
   var quantity = Number($("#quantity_result").val());
   var product_price = $(".price_span").text();
   product_price = Number(product_price.replace("원", ""));
   var result = quantity * product_price;
   product_price = product_price.toLocaleString();
   result = result.toLocaleString();

   $(".price_span").text(product_price + " 원");
   $(".quantity_result_span").text(result + " 원");

   // 이미지 관련 변수
   var mainImg = $(".detail_img_set");
   var mainImgA = $(".detail_img_set_a");

   // 위 아래 버튼
   $(".top_warp_btn").bind('click', function() {
      $('html, body').animate({ scrollTop: '0' }, 600);
   });

   $(".bottom_warp_btn").on('click', function() {
      $("html, body").animate({ scrollTop: $(document).height() }, 600);
   });

	lightbox.option({
         resizeDuration: 800,
         wrapAround: false,
         disableScrolling: false,
         fitImagesInViewport: false,
         maxHeight: 400
    });

   // 서브 사진 클릭 : 메인사진 바꾸기
   $(".detail_sub_img_set").click(function() {
      var subImg = $(this).attr("src");

      $(mainImg).attr("src", subImg)
      $(mainImgA).attr("href", subImg)

   });


 $(".quantityBtn").click(function() {
      var btn = $(this);
      var btnValue = $(btn).val();
      var priceSpan = $(".price_span");
      var price = $(priceSpan).text().replace("원","").replace(",","");
      price = Number(price)
      var quantityArea = $(".quantity_result")
      var quantityResult = Number($(".quantity_result").val());
      var maxQuantity = $(".quantity_result").data("max-quantity");
      var priceResult = 0;

      if (btnValue === "-") {
         if(quantityResult <= 1) {
            alert("주문가능한 최소 수량입니다")
            return false
         } else {
            quantityResult = quantityResult - 1
         }
         $(quantityArea).val(quantityResult)
         priceResult = price * quantityResult;
         priceResult = priceResult.toLocaleString()
         $(".quantity_result_span").text(priceResult + " 원");
      } else if (btnValue === "+") {
         if(quantityResult >= maxQuantity) {
            alert("주문가능한 최대 수량입니다")
            return false
         } else {
            quantityResult = quantityResult + 1
            $(quantityArea).val(quantityResult)
            priceResult = price * quantityResult;
            priceResult = priceResult.toLocaleString()
            $(".quantity_result_span").text(priceResult + " 원");
         };
      };
   });


   // 장바구니 버튼 눌렀을 때
   $(".cart_btn").click(function() {
      var btn = $(this)
      var user_id = $("#user_id").val();
      var product_num = $("#product_num").val();
      var product_quantity = $("#quantity_result").val();

      if (user_id == "" || user_id == undefined) {
         alert("로그인 후 이용가능합니다")
         $("#cart_add_form").attr('action', '/user/login');
         $("#cart_add_form").submit();
      } else {
         $.post("/order/cart_Insert", {
            user_id: user_id,
            product_num: product_num,
         	product_quantity: product_quantity
            
         })
            .done(function(data) {
               var data = eval("(" + data + ")");

               if (data.result == 1) {
                  	alert("상품이 장바구니에 담겼습니다");
				  	$("#cart_add_form").attr('action', '/order/cart_list');
         			$("#cart_add_form").submit();
               } else if (data.result == 2) {
                  alert("이미 담겨있는 상품입니다");
               }
            })
      }
   });


// 주문자 닉네임 클릭
$(".order_nick_btn").click(function() {
   var order_nick = this.value;
   $(".review_writing_text").text(order_nick + "님, ");
});

// (관리자) 상품수정하기 버튼 눌렀을 때
$(".edit_btn").click(function() {
   $("#cart_add_form").attr('action', '/product/productEdit');
   $("#cart_add_form").attr('method', 'POST');
   $("#cart_add_form").submit();
});

// (관리자) 상품삭제하기 버튼 눌렀을 때
$(".del_btn").click(function() {
   var con = confirm("해당 상품을 삭제하시겠습니까?");

   if (con == true) {
      alert("해당 상품이 삭제되었습니다");
      $("#cart_add_form").attr('action', '/product/product_Delete');
      $("#cart_add_form").submit();
   }
});
    // ★★★☆☆★★★ 실행 안해본 코드 ★★★☆☆★★★ //
    
    


// 리뷰 
	$(".review_writing_btn").click(function() {
		var user_nick = $("#user_nick").val();
		var user_type = $("#user_type").val();
		var review_content = $("#review_content").val();
		var product_num = $("#product_num").val();
				
				
		$.post("/review/insertReview", {
			user_nick : user_nick,
			review_content : review_content,
			user_type : user_type,
			product_num : product_num
		})
		.done(function(data) {
			var data = eval("(" + data + ")");
			var str = "";
					
			if (data.review_content == "") {
				alert("리뷰를 입력해주세요");
				return false;
			} else {
				for (i = 0; i < data.length; i++) {
					var writeonly="";
								
					if(user_nick != data[i].user_nick && user_type != 'admin'){
						writeonly = "disabled";
					}
					if(user_type == "" || user_type == null || user_type == undefined){
						writeonly = "disabled";
					}
							
					if (data[i].user_type == 'admin') {
						str += "<tr>"
						str += "<td class='seller_review_td'>"
						str += "<textarea class='seller_review_text' id='" + data[i].review_num + "'" + writeonly+ ">" + data[i].review_content + "</textarea>"
						str += "</td>"
						str += "<td class='seller_review_info'>"
						str += "<form method='POST'>"
						str += "<div class='seller_nick'> 작성자 : <span class='seller_nick_span'>EZ kit</span></div>"
						str += "<div class='seller_review_date'> 작성일 : " + data[i].review_date + "</div>"
						str += "<div class='seller_review_btn_div'>"
						
						if (user_type == 'admin') {
							str += "<input class='order_review_del_btn' type='button' value='삭제' onClick='$.fn.review_del(this.form);'>"
							str += "<input class='order_review_edit_btn' type='button' value='수정' onClick='$.fn.review_edit(this.form);'>"
							str += "<input type='hidden' name='review_num' value='" + data[i].review_num +"'>"
							str += "<input type='hidden' name='review_content'>"
						}
						str += "</div>"
						str += "</form>"
						str += "</td>"
						str += "</tr>"
						} else {	
							str += "<tr>"
							str += "<td class='order_review_td'>"
							str += "<textarea class='order_review_text' id='" + data[i].review_num + "'" + writeonly+ ">" + data[i].review_content + "</textarea>"
							str += "</td>"
							str += "<td class='order_review_info'>"
							str += "<form method='POST'>"
							str += "<div class='order_nick'> 작성자 : <input class='order_nick_btn' type='button' value='" + data[i].user_nick + "'</div>"
							str += "<div class='order_review_date'> 작성일 : " + data[i].review_date + "</div>"
							str += "<div class='order_review_btn_div'>"
							
							if (user_nick == data[i].user_nick || user_type == 'admin') {
								str += "<input class='order_review_del_btn' type='button' value='삭제' onClick='$.fn.review_del(this.form);'>"
								str += "<input class='order_review_edit_btn' type='button' value='수정' onClick='$.fn.review_edit(this.form);'>"
								str += "<input type='hidden' name='review_num' value='" + data[i].review_num +"'>"
								str += "<input type='hidden' name='review_content'>"
							}
							str += "</div>"
							str += "</form>"
							str += "</td>"
							str += "</tr>"
						}
					}
				}
				$("#review_content").val("");
				$("#review_content_table").html(str);
				// 리뷰 작성이 완료되면 스크롤을 하단으로 내린다.
				$('html, body').scrollTop(document.body.scrollHeight);
			});
		});
			
	// 댓글 삭제		
	$.fn.review_del = function(f){
		var con = confirm("댓글을 삭제하시겠습니까?");
		                
		if (con == true) {
			alert("댓글이 삭제되었습니다");
			f.action = '/review/deleteReview';
			f.submit();
		}
	}
			
	// 댓글 수정
	$.fn.review_edit = function(f){
		var con = confirm("댓글을 수정하시겠습니까?");
		//댓글번호
		var idx = f.review_num.value;
		//댓글번호에 해당하는 textarea
		var review_content = document.getElementById(idx).value;
		                
		f.review_content.value = review_content;
		                
		if (con == true) {
			alert("댓글이 수정되었습니다")
			f.action = '/review/updateReview';
			f.submit();
		}
	}
});