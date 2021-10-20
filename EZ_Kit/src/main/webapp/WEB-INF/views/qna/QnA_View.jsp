<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

   	<!-- JQuery -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

   	<!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/board/board_View.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/inc/QnA_SideMenu.css">
      
   	<!-- js -->
   	<script src="${pageContext.request.contextPath }/assets/js/inc/QnA_SideMenu.js"></script>
   
</head>
<body>

    <!-- top 영역 시작 -->
	<c:import url="${pageContext.request.contextPath }/assets/inc/top.jsp" />
	<!-- top 영역 끝 -->

    <div class="QnA_side_menu">
        <div class="label_area">
            <div class="logo_label">EZ Kit</div>
            <div class="QnA_label">Q&A</div>
        </div>
      
        <div class="QnA_link_btn_area">
            <ul class="side_menu_ul">
                <c:forEach var="q" items="${qnaOptionList }">
                   <li>
                      <a href="${pageContext.request.contextPath }/qna_option/QnAList?qna_option=${q.qna_option_name}">
                         <button class="QnA_link_btn">${q.qna_option_name }</button>
                      </a>
                   </li>
               </c:forEach>
            </ul>
        </div>

        <div class="QnA_writing_div">
            <button class="QnA_writing_btn">문의 작성하기</button>
        </div>
    </div>
    
    <input type="hidden" id="user_id" value="${sessionScope.user_id }"/>
    
    <table class="board_view_table">
        <tr>
            <td class="board_num">글 번호 <span>${count }</span></td>
            <td class="board_title">${qna.qna_title }</td>
            <td class="board_writer">작성자 <span>admin</span></td>
        </tr>

        <tr>
            <td class="view_content_td" colspan="5">
                <textarea class="board_view_content" name="" disabled>${qna.qna_content}</textarea>
            </td>
        </tr>
        
        <tr>
            <td class="board_btn_td" colspan="3">
                <span class="footer_text_1">EZ Kit </span>
                <span class="footer_text_2"> Copyright : EZ Kit. All Rights Reserved.</span>
                <c:if test="${sessionScope.user_type == 'admin' }">
                   <input class="board_edit_btn" type="button" value="수정하기" />
                </c:if>
                <input class="board_list_btn" type="button" value="목록으로" onClick="history.back()" />
            </td>
        </tr>
    </table>
</body>
</html>