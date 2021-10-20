package com.project.ezkit.qna;

import java.sql.Date;

public class QnA {

   private int qna_num;
   private String qna_title;
   private String qna_content;
   private Date qna_date;
   private int qna_hits;
   private String qna_option;

   public QnA() {
      super();
   }

   public QnA(int qna_num, String qna_title, String qna_content, Date qna_date, int qna_hits, String qna_option) {
      super();
      this.qna_num = qna_num;
      this.qna_title = qna_title;
      this.qna_content = qna_content;
      this.qna_date = qna_date;
      this.qna_hits = qna_hits;
      this.qna_option = qna_option;
   }

   public int getQna_num() {
      return qna_num;
   }

   public void setQna_num(int qna_num) {
      this.qna_num = qna_num;
   }

   public String getQna_title() {
      return qna_title;
   }

   public void setQna_title(String qna_title) {
      this.qna_title = qna_title;
   }

   public String getQna_content() {
      return qna_content;
   }

   public void setQna_content(String qna_content) {
      this.qna_content = qna_content;
   }

   public Date getQna_date() {
      return qna_date;
   }

   public void setQna_date(Date qna_date) {
      this.qna_date = qna_date;
   }

   public int getQna_hits() {
      return qna_hits;
   }

   public void setQna_hits(int qna_hits) {
      this.qna_hits = qna_hits;
   }

   public String getQna_option() {
      return qna_option;
   }

   public void setQna_option(String qna_option) {
      this.qna_option = qna_option;
   }

   @Override
   public String toString() {
      return "QnA [qna_num=" + qna_num + ", qna_title=" + qna_title + ", qna_content=" + qna_content + ", qna_date="
            + qna_date + ", qna_hits=" + qna_hits + ", qna_option=" + qna_option + "]";
   }

}