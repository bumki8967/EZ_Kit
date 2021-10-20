package com.project.ezkit.inquiry;

import java.sql.Date;

public class Inquiry {

   private int inquiry_num;
   private String inquiry_title;
   private String inquiry_content;
   private String inquiry_reply;
   private Date inquiry_date;
   private int inquiry_result;
   private String user_id;

   public Inquiry() {
      super();
   }

   public Inquiry(int inquiry_num, String inquiry_title, String inquiry_content, String inquiry_reply,
         Date inquiry_date, int inquiry_result, String user_id) {
      super();
      this.inquiry_num = inquiry_num;
      this.inquiry_title = inquiry_title;
      this.inquiry_content = inquiry_content;
      this.inquiry_reply = inquiry_reply;
      this.inquiry_date = inquiry_date;
      this.inquiry_result = inquiry_result;
      this.user_id = user_id;
   }

   public int getInquiry_num() {
      return inquiry_num;
   }

   public void setInquiry_num(int inquiry_num) {
      this.inquiry_num = inquiry_num;
   }

   public String getInquiry_title() {
      return inquiry_title;
   }

   public void setInquiry_title(String inquiry_title) {
      this.inquiry_title = inquiry_title;
   }

   public String getInquiry_content() {
      return inquiry_content;
   }

   public void setInquiry_content(String inquiry_content) {
      this.inquiry_content = inquiry_content;
   }

   public String getInquiry_reply() {
      return inquiry_reply;
   }

   public void setInquiry_reply(String inquiry_reply) {
      this.inquiry_reply = inquiry_reply;
   }

   public Date getInquiry_date() {
      return inquiry_date;
   }

   public void setInquiry_date(Date inquiry_date) {
      this.inquiry_date = inquiry_date;
   }

   public int getInquiry_result() {
      return inquiry_result;
   }

   public void setInquiry_result(int inquiry_result) {
      this.inquiry_result = inquiry_result;
   }

   public String getUser_id() {
      return user_id;
   }

   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }

   @Override
   public String toString() {
      return "Inquiry [inquiry_num=" + inquiry_num + ", inquiry_title=" + inquiry_title + ", inquiry_content="
            + inquiry_content + ", inquiry_reply=" + inquiry_reply + ", inquiry_date=" + inquiry_date
            + ", inquiry_result=" + inquiry_result + ", user_id=" + user_id + "]";
   }

}