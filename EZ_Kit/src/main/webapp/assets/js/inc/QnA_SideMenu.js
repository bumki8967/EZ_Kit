$(document).ready(function(){
   
   // 문의작성하기 클릭시
   $(".QnA_writing_btn").click(function(){
      var user_id = $("#user_id").val();
      
      if(user_id == "" || user_id == null || user_id == undefined){
         alert("로그인 후 이용가능합니다.");
         return false;
      }
      location.href = "/inquiry/inquiryWriting";
   });
   
});