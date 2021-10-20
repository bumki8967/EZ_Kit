package com.project.ezkit.qna_option;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ezkit.qna_option.QnAOption;

@Service
public class QnAOptionService {

   @Autowired
   private QnAOptionMapper mapper;

   public void insertQnaOption(QnAOption qnaOption) {
      mapper.insertQnaOption(qnaOption);
   }

   public QnAOption selectQnaOptionByNum(int qna_option_num) {
      return mapper.selectQnaOptionByNum(qna_option_num);
   }

   public QnAOption selectQnaOptionByName(String qna_option_name) {
      return mapper.selectQnaOptionByName(qna_option_name);
   }
   
   public List selectQnaOptionAll() {
      return mapper.selectQnaOptionAll();
   }

   public void updateQnaOption(QnAOption qnaOption) {
      mapper.updateQnaOption(qnaOption);
   }

   public void deleteQnaOption(int qna_option_num) {
      mapper.deleteQnaOption(qna_option_num);
   }

}