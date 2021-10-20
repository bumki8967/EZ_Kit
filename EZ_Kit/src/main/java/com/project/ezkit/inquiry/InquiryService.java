package com.project.ezkit.inquiry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {

   @Autowired
   InquiryMapper mapper;
   
   public void insertInquiry(Inquiry i) {
      mapper.insertInquiry(i);
   }

   public Inquiry selectInquiryByNum(int inquiry_num) {
      return mapper.selectInquiryByNum(inquiry_num);
   }
   
   public List selectInquiryByUserId(String user_id) {
      return mapper.selectInquiryByUserId(user_id);
   }
   
   public List selectInquiryByResult(int inquiry_result) {
      return mapper.selectInquiryByResult(inquiry_result);
   }

   public List selectInquiryAll() {
      return mapper.selectInquiryAll();
   }

   public void updateInquiryReply(Inquiry i) {
      mapper.updateInquiryReply(i);
   }
   

}