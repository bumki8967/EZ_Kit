package com.project.ezkit.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnAMapper {

   void insertQna(QnA q);

   QnA selectQnaBynum(int qna_num);
   
   List selectQnaByOption(String qna_option);

   List selectQnaAll();

   void updateQna(QnA q);

   void deleteQna(int qna_num);
}