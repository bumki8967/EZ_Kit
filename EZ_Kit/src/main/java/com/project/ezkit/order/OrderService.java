package com.project.ezkit.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

   @Autowired
   private OrderMapper mapper;
   
   public void insertOrder(Order o) {
      mapper.insertOrder(o);
   }
   
   public int getNum() {
      return mapper.getNum();
   }
   
   // 구매내역 전체 가져오기
   public List<Order> selectOrderAll() {
      return mapper.selectOrderAll();
   }
   
   // 주문번호로 검색
   public List<Order> selectOrderByOrderNum(int order_num) {
      return mapper.selectOrderByOrderNum(order_num);
   }
   
   // user_id로 검색
   public List<Order> selectOrderByUserId(String user_id) {
      return mapper.selectOrderByUserId(user_id);
   }
   
   // 월별 구매 횟수 검색
   public int countOrderMonth(String month_start, String month_end) {
      return mapper.countOrderMonth(month_start, month_end);
   }

   // 주문 변경
   public void updateOrder(String user_id, int order_num) {
      Map map = new HashMap();
      map.put("user_id", user_id);
      map.put("order_num", order_num);
      mapper.updateOrder(map);
   }
   
   // 주문 상태 변경 -> 변경 상태 int 리턴
   public int updateOrderStatus(String user_id, List<Integer> order_num, int order_status) {
      int status = order_status;
      int order;
      int result = 0;
      Map map = new HashMap();
      
      try {
         for (int i = 0; i < order_num.size(); i++) {
            order= order_num.get(i);
            map.put("user_id", user_id);
            map.put("order_num", order);
            map.put("order_status", order_status);
            mapper.updateOrderStatus(map);
            
            switch (order_status) {
            
            case 1:
               mapper.updatePaymentDate(map);
               break;
               
            case 2:
               mapper.updateProductPreparationDate(map);
               break;
               
            case 3:
               mapper.updateDeliveryPreparationDate(map);
               break;
               
            case 4:
               mapper.updateDeliveryDate(map);
               break;
               
            case 5:
               mapper.updateDeliveryCompletedDate(map);
               break;
            }
         }
         result = 1;
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return result;
   }
   
   // 결제완료 날짜 업데이트 : 1
   public void updatePaymentDate(String user_id, int order_num) {
      Map map = new HashMap();
      map.put("user_id", user_id);
      map.put("order_num", order_num);
      mapper.updatePaymentDate(map);
   };
   
   // 재료준비 날짜 업데이트 : 2
   public void updateProductPreparationDate(String user_id, int order_num) {
      Map map = new HashMap();
      map.put("user_id", user_id);
      map.put("order_num", order_num);
      mapper.updateProductPreparationDate(map);
   };
   
   // 배송준비 날짜 업데이트 : 3
   public void updateDeliveryPreparationDate(String user_id, int order_num) {
      Map map = new HashMap();
      map.put("user_id", user_id);
      map.put("order_num", order_num);
      mapper.updateDeliveryPreparationDate(map);
   };
   
   // 배송중 날짜 업데이트 : 4
   public void updateDeliveryDate(String user_id, int order_num) {
      Map map = new HashMap();
      map.put("user_id", user_id);
      map.put("order_num", order_num);
      mapper.updateDeliveryDate(map);
   };
   
   // 배송완료 날짜 업데이트 : 5
   public void updateDeliveryCompletedDate(String user_id, int order_num) {
      Map map = new HashMap();
      map.put("user_id", user_id);
      map.put("order_num", order_num);
      mapper.updateDeliveryCompletedDate(map);
   };
      
   
   // 주문 취소
   public void deleteOrder(String user_id, int order_num) {
      Map map = new HashMap();
      map.put("user_id", user_id);
      map.put("order_num", order_num);
      mapper.deleteOrder(map);
   }
}