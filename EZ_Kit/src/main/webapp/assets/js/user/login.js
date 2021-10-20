$(document).ready(function() {
		$(".login_btn").click(function() {
			var user_id = $("#user_id").val();
			var user_pw = $("#user_pw").val();
			
			// 공백체크
			if (user_id == "" && user_pw == "") {
				alert("아이디와 비밀번호를 입력해주세요");
				return false;
			} else if (user_id == "") {
				alert("아이디를 입력해주세요");
				return false;
			} else if (user_pw == "") {
				alert("비밀번호를 입력해주세요");
				return false;
			} 
			
			$.post("/user/loginCheck",{
				user_id : user_id,
				user_pw : user_pw
			})
			.done(function(data){
				data = JSON.parse(data)
				if(data.type==0){
					alert("존재하지 않는 회원입니다.");
					return false;
				} else if(data.type==1){
					alert("비밀번호가 틀렸습니다.");
					return false;
				} else if(data.type==2){
					$("#login_form").attr("action", "/user/user_login");
					$("#login_form").submit();
				}
				
			});
			
		});
		
		$(".reg_btn").click(function() {
			location.href = "/user/agreement";
		});
	});