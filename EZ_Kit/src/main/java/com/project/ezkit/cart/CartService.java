package com.project.ezkit.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

   @Autowired
   private CartMapper mapper;

   public void insertCart(Cart cart) {
      mapper.insertCart(cart);
   }

   public Cart selectCartByNum(int cart_num) {
      return mapper.selectCartByNum(cart_num);
   }
   
   public List selectCartByAll() {
      return mapper.selectCartByAll();
   }
   
   // 장바구니 중복검색
   public int selectProductCount(int product_num) {
      return mapper.selectProductCount(product_num);
   }

   public List selectCartProductById(String user_id) {
      return mapper.selectCartProductById(user_id);
   }

   public ArrayList<Cart> selectCartById(String user_id){
      return mapper.selectCartById(user_id);
   }
   
   public void deleteCart(int product_num, String user_id) {
      
      Map map = new HashMap();
      map.put("product_num", product_num);
      map.put("user_id", user_id);
      
      mapper.deleteCart(map);
   }
   
   public int getNum() {
      return mapper.getNum();
   }

}