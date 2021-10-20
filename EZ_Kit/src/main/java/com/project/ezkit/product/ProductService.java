package com.project.ezkit.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

   @Autowired
   private ProductMapper mapper;

   public void insertProduct(Product p) {
      mapper.insertProduct(p);
   }

   public Product selectProductByNum(int product_num) {
      return mapper.selectProductByNum(product_num);
   }
   
   public List selectProductByName(String product_name) {
	   return mapper.selectProductByName(product_name);
   }
   
   public List selectProductByClassification(String classification_name) {
      return mapper.selectProductByClassification(classification_name);
   }
   
   public List selectProductByHit() {
      return mapper.selectProductByHit();
   }
   
   public List<Product> selectProductAll() {
      return mapper.selectProductAll();
   }
   

   public void updateProduct(Product p) {
      mapper.updateProduct(p);
   }

   public void updateProductHit(int product_num) {
      mapper.updateProductHit(product_num);
   }
   
   public void deleteProduct(int product_num) {
      mapper.deleteProduct(product_num);
   }
   
   public int getNum() {
      return mapper.getNum();
   }

}