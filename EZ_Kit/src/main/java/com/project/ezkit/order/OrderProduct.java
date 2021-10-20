package com.project.ezkit.order;

import java.util.Date;

public class OrderProduct {

   private int order_product_num;
   private int order_num;
   private String user_id;
   private int product_num;
   private String product_name;
   private int product_quantity;
   private int product_price;
   private int order_status;

   // 주문상태
   // default : 0, 결제완료 : 1, 재료준비 : 2, 배송준비 : 3, 배송중 : 4, 배송완료 : 5

   private Date payment_date; // 결제일
   private Date product_preparation_date; // 상품준비일
   private Date delivery_preparation_date; // 배송준비일
   private Date delivery_date; // 배송중
   private Date delivery_completed_date; // 배송완료일
   public OrderProduct() {
      super();
   }
   public OrderProduct(int order_product_num, int order_num, String user_id, int product_num, String product_name,
         int product_quantity, int product_price, int order_status, Date order_payment_date,
         Date order_product_preparation_date, Date order_delivery_preparation_date, Date order_delivery_date,
         Date order_delivery_completed_date) {
      super();
      this.order_product_num = order_product_num;
      this.order_num = order_num;
      this.user_id = user_id;
      this.product_num = product_num;
      this.product_name = product_name;
      this.product_quantity = product_quantity;
      this.product_price = product_price;
      this.order_status = order_status;
      this.payment_date = order_payment_date;
      this.product_preparation_date = order_product_preparation_date;
      this.delivery_preparation_date = order_delivery_preparation_date;
      this.delivery_date = order_delivery_date;
      this.delivery_completed_date = order_delivery_completed_date;
   }
   public int getOrder_product_num() {
      return order_product_num;
   }
   public void setOrder_product_num(int order_product_num) {
      this.order_product_num = order_product_num;
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
   public int getProduct_num() {
      return product_num;
   }
   public void setProduct_num(int product_num) {
      this.product_num = product_num;
   }
   public String getProduct_name() {
      return product_name;
   }
   public void setProduct_name(String product_name) {
      this.product_name = product_name;
   }
   public int getProduct_quantity() {
      return product_quantity;
   }
   public void setProduct_quantity(int product_quantity) {
      this.product_quantity = product_quantity;
   }
   public int getProduct_price() {
      return product_price;
   }
   public void setProduct_price(int product_price) {
      this.product_price = product_price;
   }
   public int getOrder_status() {
      return order_status;
   }
   public void setOrder_status(int order_status) {
      this.order_status = order_status;
   }
   public Date getPayment_date() {
      return payment_date;
   }
   public void setPayment_date(Date payment_date) {
      this.payment_date = payment_date;
   }
   public Date getProduct_preparation_date() {
      return product_preparation_date;
   }
   public void setProduct_preparation_date(Date product_preparation_date) {
      this.product_preparation_date = product_preparation_date;
   }
   public Date getDelivery_preparation_date() {
      return delivery_preparation_date;
   }
   public void setDelivery_preparation_date(Date delivery_preparation_date) {
      this.delivery_preparation_date = delivery_preparation_date;
   }
   public Date getDelivery_date() {
      return delivery_date;
   }
   public void setDelivery_date(Date delivery_date) {
      this.delivery_date = delivery_date;
   }
   public Date getDelivery_completed_date() {
      return delivery_completed_date;
   }
   public void setDelivery_completed_date(Date delivery_completed_date) {
      this.delivery_completed_date = delivery_completed_date;
   }
   @Override
   public String toString() {
      return "OrderProduct [order_product_num=" + order_product_num + ", order_num=" + order_num + ", user_id="
            + user_id + ", product_num=" + product_num + ", product_name=" + product_name + ", product_quantity="
            + product_quantity + ", product_price=" + product_price + ", order_status=" + order_status
            + ", payment_date=" + payment_date + ", product_preparation_date=" + product_preparation_date
            + ", delivery_preparation_date=" + delivery_preparation_date + ", delivery_date=" + delivery_date
            + ", delivery_completed_date=" + delivery_completed_date + "]";
   }
   
}