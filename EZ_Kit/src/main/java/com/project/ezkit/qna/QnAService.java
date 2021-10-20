package com.project.ezkit.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnAService {

   @Autowired
   private QnAMapper mapper;

   public void insertQna(QnA q) {
      mapper.insertQna(q);
   }

   public QnA selectQnaBynum(int qna_num) {
      return mapper.selectQnaBynum(qna_num);
   }

   public List selectQnaByOption(String qna_option) {
         return mapper.selectQnaByOption(qna_option);
      }
   
   public List selectQnaAll() {
      return mapper.selectQnaAll();
   }

   public void updateQna(QnA q) {
      mapper.updateQna(q);
   }

   public void deleteQna(int qna_num) {
      mapper.deleteQna(qna_num);
   }
}