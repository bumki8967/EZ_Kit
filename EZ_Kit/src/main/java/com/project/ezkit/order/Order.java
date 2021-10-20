package com.project.ezkit.order;

import java.util.Date;

public class Order {
   private int order_num;
   private String user_id;
   private int order_total_quantity;
   private int order_payment_price;   // 결제금액 : 금액 - 포인트 -> 고객이 실제 결제할 금액
   private int order_save_point;      // 포인트 적립 : 결제금액의 n% user에 적립
   private int order_used_point;      // 사용 포인트 : user가 입력한 포인트 금액
   private String order_user_tel;         // 주문자 연락처 : 없으면 유저id에서 가져오기
   private String order_user_address1;
   private String order_user_address2;
   private String order_user_postcode;
   
   public Order() {
      super();
   }

   public Order(int order_num, String user_id, int order_total_quantity, int order_payment_price,
         int order_save_point, int order_used_point, String order_user_tel, String order_user_address1,
         String order_user_address2, String order_user_postcode) {
      super();
      this.order_num = order_num;
      this.user_id = user_id;
      this.order_total_quantity = order_total_quantity;
      this.order_payment_price = order_payment_price;
      this.order_save_point = order_save_point;
      this.order_used_point = order_used_point;
      this.order_user_tel = order_user_tel;
      this.order_user_address1 = order_user_address1;
      this.order_user_address2 = order_user_address2;
      this.order_user_postcode = order_user_postcode;
   }

   public int getOrder_num() {
      return order_num;
   }

   public void setOrder_num(int order_num) {
      this.order_num = order_num;
   }

   public String getUser_id() {
      return user_id;
   }

   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }


   public int getOrder_total_quantity() {
      return order_total_quantity;
   }

   public void setOrder_total_quantity(int order_total_quantity) {
      this.order_total_quantity = order_total_quantity;
   }

   public int getOrder_payment_price() {
      return order_payment_price;
   }

   public void setOrder_payment_price(int order_payment_price) {
      this.order_payment_price = order_payment_price;
   }

   public int getOrder_save_point() {
      return order_save_point;
   }

   public void setOrder_save_point(int order_save_point) {
      this.order_save_point = order_save_point;
   }

   public int getOrder_used_point() {
      return order_used_point;
   }

   public void setOrder_used_point(int order_used_point) {
      this.order_used_point = order_used_point;
   }

   public String getOrder_user_tel() {
      return order_user_tel;
   }

   public void setOrder_user_tel(String order_user_tel) {
      this.order_user_tel = order_user_tel;
   }

   public String getOrder_user_address1() {
      return order_user_address1;
   }

   public void setOrder_user_address1(String order_user_address1) {
      this.order_user_address1 = order_user_address1;
   }

   public String getOrder_user_address2() {
      return order_user_address2;
   }

   public void setOrder_user_address2(String order_user_address2) {
      this.order_user_address2 = order_user_address2;
   }

   public String getOrder_user_postcode() {
      return order_user_postcode;
   }

   public void setOrder_user_postcode(String order_user_postcode) {
      this.order_user_postcode = order_user_postcode;
   }

   @Override
   public String toString() {
      return "Order [order_num=" + order_num + ", user_id=" + user_id 
            + ", order_total_quantity=" + order_total_quantity + ", order_payment_price=" + order_payment_price
            + ", order_save_point=" + order_save_point + ", order_used_point=" + order_used_point
            + ", order_user_tel=" + order_user_tel + ", order_user_address1=" + order_user_address1
            + ", order_user_address2=" + order_user_address2 + ", order_user_postcode=" + order_user_postcode + "]";
   }

}