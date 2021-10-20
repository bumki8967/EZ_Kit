var reader = null;

// 이미지 등록 후 미리보기
function setPreview(event) {

	// 이미지 미리보기 영역 초기화
	$("#main_img_view_div").empty();
	var i = 0;

	for (var image of event.target.files) {
		// 메인 이미지 최대 4장
		if (i < 4) {
            /*event.target : 이벤트가 시작된 DOM 요소 
            /여기서는 <input type="file">
            /multiple 로 설정해두었으므로 files로 불러온다 */
			var reader = new FileReader(); // FileReader 객체를 생성

			// 이미지 등록 → 열기(load) 시 실행되는 함수
			reader.onload = function(event) {
                /* createElement(html요소) : html 요소 생성
                img 태그를 생성*/
				var img = document.createElement("img");

				// <img> 태그에 src속성 부여 (files 중에서 하나씩 선택해서)
				img.setAttribute("src", event.target.result);
				img.setAttribute("class", "main_img_set");

                /* querySelector : 해당 선택자에 맞는 element들 중에 첫 번째를 반환
                div id="main_img_view_div 영역에 img를 추가*/
				document.querySelector("div#main_img_view_div").appendChild(img);
			}

			console.log(image);

			reader.readAsDataURL(image);

			i += 1;
		}
	}
}

function setPreviewDetail(event) {

	var reader = new FileReader();

	reader.onload = function(event) {
		var img = document.getElementById("info_img_view");
		img.setAttribute("src", event.target.result);
		img.setAttribute("width", "90%");
		img.setAttribute("height", "90%");
	}
	reader.readAsDataURL(event.target.files[0]);

	$(".btn_text").empty();
}

$(document).ready(function() {
	$(".add_product_btn").click(function() {
		alert("상품수정이 완료되었습니다");
		$("#product_add_form").attr('action', '/product/product_Edit');
		$("#product_add_form").submit();
	});
});