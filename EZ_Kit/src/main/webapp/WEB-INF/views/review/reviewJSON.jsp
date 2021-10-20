<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
[
	<c:forEach var="r" items="${list }" varStatus="status">
		<c:if test="${not status.first }">
			,
		</c:if>
		{
			review_num : ${r.review_num },
			user_nick : "${r.user_nick }",
			review_content:"${r.review_content }",
			user_type : "${r.user_type }",
			review_date: "${r.review_date }",
			product_num : ${r.product_num }
		}
	</c:forEach>
]

