package com.project.ezkit.inquiry;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InquiryMapper {

   void insertInquiry(Inquiry i);

   Inquiry selectInquiryByNum(int inquiry_num);
   
   List selectInquiryByUserId(String user_id);
   
   List selectInquiryByResult(int inquiry_result);

   List selectInquiryAll();

   void updateInquiryReply(Inquiry i);

}