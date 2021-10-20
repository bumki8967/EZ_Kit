package com.project.ezkit.qna_option;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.ezkit.qna.QnA;

@Mapper
public interface QnAOptionMapper {

   void insertQnaOption(QnAOption qnaOption);

   QnAOption selectQnaOptionByNum(int qna_option_num);

   QnAOption selectQnaOptionByName(String qna_option_name);
   
   List selectQnaOptionAll();

   void updateQnaOption(QnAOption qnaOption);

   void deleteQnaOption(int qna_option_num);

}