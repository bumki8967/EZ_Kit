package com.project.ezkit.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

   void insertProduct(Product p);
   
   Product selectProductByNum(int product_num);
   
   List selectProductByName(String product_name);
   
   List selectProductByClassification(String classification_name);

   List selectProductByHit();
   
   List<Product> selectProductAll();
   
   void updateProduct(Product p);
   
   void updateProductHit(int product_num);
   
   void deleteProduct(int product_num);
   
   int getNum();
   
}