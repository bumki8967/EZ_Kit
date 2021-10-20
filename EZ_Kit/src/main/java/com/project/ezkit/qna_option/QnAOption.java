package com.project.ezkit.qna_option;

public class QnAOption {

   private int qna_option_num;
   private String qna_option_name;

   public QnAOption() {
      super();
   }

   public QnAOption(int qna_option_num, String qna_option_name) {
      super();
      this.qna_option_num = qna_option_num;
      this.qna_option_name = qna_option_name;
   }

   public int getQna_option_num() {
      return qna_option_num;
   }

   public void setQna_option_num(int qna_option_num) {
      this.qna_option_num = qna_option_num;
   }

   public String getQna_option_name() {
      return qna_option_name;
   }

   public void setQna_option_name(String qna_option_name) {
      this.qna_option_name = qna_option_name;
   }

   @Override
   public String toString() {
      return "QnAOption [qna_option_num=" + qna_option_num + ", qna_option_name=" + qna_option_name + "]";
   }

}