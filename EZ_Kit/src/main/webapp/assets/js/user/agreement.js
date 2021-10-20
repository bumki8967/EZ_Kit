$(document).ready(function() {
      // 동의
      $(".consent_btn").click(function() {
         if($("#required_agree").prop("checked")){
            location.href = "/user/register";                     
         } else {            
            alert("필수항목을 체크해주세요");
            return false;
         }
      });
      
      // 취소
      $(".cancel_btn").click(function() {
         var exit = confirm("회원가입을 취소하시겠습니까?");
          
          if (exit == true) {
             alert("회원가입이 취소되었습니다");
            location.href = "/index";
          }
      });
      
      // 전체동의 
      $("#all_check").click(function(){
         
              if ($(".radio_set").prop("checked")) {               // 전체동의 버튼이 클릭되어 있으면
                  $("input[type=checkbox]").prop("checked",true);      // 모든 체크박스에 체크
              } else {                                       // 전체동의 버튼이 클릭되어 있지 않으면
                  $("input[type=checkbox]").prop("checked",false);   // 모든 체크박스 체크해제
              }
      });
      
   });