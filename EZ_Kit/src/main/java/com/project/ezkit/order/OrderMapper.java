package com.project.ezkit.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

   void insertOrder(Order o);
   
   int getNum(); 
   
   // 구매내역 전체 가져오기
   List<Order> selectOrderAll();
   
   // 주문번호로 검색
   List<Order> selectOrderByOrderNum(int order_num); 
   
   // user_id로 검색
   List<Order> selectOrderByUserId(String user_id); 
   
   // 월별 구매 횟수 검색
   int countOrderMonth(String month_start, String month_end); 

   // 주문 변경
   void updateOrder(Map map);
   
   // 주문 상태 변경 -> 변경 상태 리턴
   int updateOrderStatus(Map map);
   
   // 결제완료 날짜 업데이트 : 1
   void updatePaymentDate(Map map);
   
   // 재료준비 날짜 업데이트 : 2
   void updateProductPreparationDate(Map map);
   
   // 배송준비 날짜 업데이트 : 3
   void updateDeliveryPreparationDate(Map map);
   
   // 배송중 날짜 업데이트 : 4
   void updateDeliveryDate(Map map);
   
   // 배송완료 날짜 업데이트 : 5
   void updateDeliveryCompletedDate(Map map);
   
   // 주문 취소
   void deleteOrder(Map map);

}