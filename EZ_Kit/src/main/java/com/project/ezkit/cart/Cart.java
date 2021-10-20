package com.project.ezkit.cart;

public class Cart {

   private int cart_num;
   private int product_num;
   private int product_quantity;
   private String user_id;

   public Cart() {
      super();
   }

   public Cart(int cart_num, int product_num, int product_quantity, String user_id) {
      super();
      this.cart_num = cart_num;
      this.product_num = product_num;
      this.product_quantity = product_quantity;
      this.user_id = user_id;
   }

   public int getCart_num() {
      return cart_num;
   }

   public void setCart_num(int cart_num) {
      this.cart_num = cart_num;
   }

   public int getProduct_num() {
      return product_num;
   }

   public void setProduct_num(int product_num) {
      this.product_num = product_num;
   }

   public int getProduct_quantity() {
      return product_quantity;
   }

   public void setProduct_quantity(int product_quantity) {
      this.product_quantity = product_quantity;
   }

   public String getUser_id() {
      return user_id;
   }

   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }

   @Override
   public String toString() {
      return "Cart [cart_num=" + cart_num + ", product_num=" + product_num + ", product_quantity=" + product_quantity
            + ", user_id=" + user_id + "]";
   }
}