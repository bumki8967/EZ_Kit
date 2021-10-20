package com.project.ezkit.order;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderProductMapper {

   void insertOrderProduct(OrderProduct op);
   
   ArrayList<OrderProduct> selectOrderProductByOrderNum(int order_num);

   ArrayList<OrderProduct> selectOrderProductByUserId(String user_id);

   ArrayList<OrderProduct> selectOrderProductByStatusAndUserId(Map map);
   
   String selectOrderStatusDate(OrderProduct op);
   
   Date selectPaymentDate(Map map);
   
   Date selectProductPreaparationDate(Map map);
   
   Date selectDeliveryPreaparationDate(Map map);
   
   Date selectDeliveryDate(Map map);
   
   Date selectDeliveryCompletedDate(Map map);
   
   int countOrderByOrderStatus(Map map);
   
   // 배송상태에 따라 주문 가져오기
   ArrayList<OrderProduct> selectOrderProductByOrderStatus(int order_status);

   // 주문 상태 변경하기
   void updateProductPreparationDate(int order_product_num);
   
   void updateDeliveryPreparationDate(int order_product_num);
   
   void updateDelieveryDate(int order_product_num);
   
   void updateDeliveryCompletedDate(int order_product_num);




}