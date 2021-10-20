$(document).ready(function(){
	
    var user_id = $("#user_id").val();

   //회원탈퇴
   $(".user_out_btn").click(function(){
      var out_id = $("#user_id").val();
      
      if(out_id=="" || out_id == undefined || out_id == null){
         alert("회원을 검색하세요");
         return false;
      }
      var con = confirm("정말 "+out_id +"님을 탈퇴시키겠습니까?");
      
      if(con == false){
         alert("취소되었습니다.");
         return false;
      } else{
         alert("회원이 탈퇴되었습니다.");
         $("#out_form").attr('action', '/admin/deleteUser');
         $("#out_form").submit();
      }
   });
   
   // 회원검색
   $(".find_btn").click(function(){
      var search_id = $("#search_id").val();

      // 공백체크
      if(search_id=="" || search_id == undefined || search_id == null){
         alert("회원을 검색하세요");
         return false;
      }
      
      $.post("/admin/user_Info_JSON",{
         user_id : search_id
      })
      .done(function(data){
         check = eval("("+data+")")
         // 존재하지 않는 아이디
         if(check.result == 0){
            alert("존재하지 않는 id입니다.\n 또는 이메일 형식인지 확인하세요");
            return false;
         }
         // 존재하는 아이디
         else if(check.result == 1){
            $("#search_form").attr('action', '/admin/user_Info');
            $("#search_form").submit();
         }
      });
   });
   
   
    // 등급변경
    $(".rating_btn").click(function(){
    
        var rating = this.value;
        var con = confirm("등급을 변경하시겠습니까?");
        if(con == true){
            $.post("/admin/updateUserRating", {
                user_rating : rating,
                user_id : user_id
            })
            .done(function(){
                $("#user_rating").empty();
                $("#user_rating").append(rating);
                alert("등급이 변경되었습니다.");
            });
        }
    });

    // 갱신된 포인트를 Controller로 전송하는 함수 (DB 갱신)
   var updateUserPoint = function(edit_point) {
      // view 창에 포인트 갱신
        document.getElementById("user_point").value = edit_point;

        // Controller로 갱신된 포인트 전송 (DB 갱신)
        $.post("/admin/updateUserPoint",{
            user_point : edit_point,
            user_id : user_id
        })
        .done(function(){
            alert("포인트가 갱신되었습니다.");
        });
   }

    // 포인트 추가/차감 버튼 클릭시
    $(".point_btn").click(function(){
        // 유저가 현재 보유중인 포인트
       var user_point = $("#user_point").val();
        edit_point = Number(user_point);            // 자료형 숫자로 변환
        
        // 추가/차감한 포인트 값
        var add_point = Number(this.value);
        
        // 현재 보유중인 포인트에 클릭한 포인트만큼 추가
        edit_point += add_point;
        
        if(edit_point < 0){
           alert("보유중인 P보다 차감 P가 커서 0p로 갱신합니다");
           updateUserPoint(0);
        }else{    
           updateUserPoint(edit_point);
        }
    });

    // 포인트 수정 버튼 클릭시
    $(".point_edit_btn").click(function(){
        var user_point = $("#user_point").val();
        edit_point = Number(user_point);

        if(edit_point < 0){
           alert("0p 이상만 수정가능합니다.");
           return false;
        }
        updateUserPoint(edit_point);
    });

    // 포인트 회수 버튼 클릭시
    $(".point_del_btn").click(function(){
        var user_point = $("#user_point").val();
        edit_point = Number(user_point);

        if(edit_point == 0){
           alert("현재 0p입니다.");
           return false;
        }
        updateUserPoint(0);
    });
    
});
