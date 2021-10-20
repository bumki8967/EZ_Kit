package com.project.ezkit.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

   void insertCart(Cart cart);

   Cart selectCartByNum(int cart_num);

   List selectCartProductById(String user_id);
   
   ArrayList<Cart> selectCartById(String user_id);
   
   List selectCartByAll();

   void deleteCart(Map map);
   
   // 장바구니 중복검색
   int selectProductCount(int product_num);
   
   int getNum();

}