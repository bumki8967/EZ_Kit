package com.project.ezkit.qna;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.ezkit.qna_option.QnAOption;
import com.project.ezkit.qna_option.QnAOptionService;

@Controller
public class QnAController {


   @Autowired
   QnAOptionService qna_option_Service;
   
   @Autowired
   QnAService qna_Service;
   
   /**
    * Q&A 리스트 페이지 (Q&A 메인)
    * @return
    */
   @RequestMapping(value="/qna/QnA_Main")
   public ModelAndView QnA_Main() {
      
      ModelAndView mav = new ModelAndView("/qna/QnA_Main");
      
      try {
    	  ArrayList<QnA> qnaList = (ArrayList<QnA>) qna_Service.selectQnaAll();
    	  ArrayList<QnAOption> qnaOptionList = (ArrayList<QnAOption>)qna_option_Service.selectQnaOptionAll(); 

    	  mav.addObject("qnaOptionList", qnaOptionList);
    	  mav.addObject("qnaList", qnaList);
      } catch (Exception e) {
    	  e.printStackTrace();
      }
      
      return mav;
   }
   
   /**
    * Q&A 내용 페이지
    * @param qna_num 
    * @param count 
    * @return
    */
   @RequestMapping(value="/qna/QnA_View")
   public ModelAndView QnA_View(@RequestParam(value="qna_num") int qna_num, @RequestParam(value="count") int count) {
      
      ModelAndView mav = new ModelAndView("/qna/QnA_View");
      
      try {
    	  QnA qna = qna_Service.selectQnaBynum(qna_num);
    	  ArrayList<QnAOption> qnaOptionList = (ArrayList<QnAOption>)qna_option_Service.selectQnaOptionAll(); 
    	 
    	  mav.addObject("qnaOptionList", qnaOptionList);
    	  mav.addObject("qna",qna);
    	  mav.addObject("count", count);
      } catch (Exception e) {
    	  e.printStackTrace();
      }
      
      return mav;
   }
   
   /**
    * Q&A Side Menu Option별로 Q&A 리스트 출력
    * @param qna_option
    * @return
    */
   @RequestMapping(value="/qna_option/QnAList")
   public ModelAndView QnAList(@RequestParam(value="qna_option")String qna_option) {
	   
      ModelAndView mav = new ModelAndView("/qna/QnA_Main");
      
      try {
    	  ArrayList<QnA> qnaList = (ArrayList<QnA>)qna_Service.selectQnaByOption(qna_option);
    	  ArrayList<QnAOption> qnaOptionList = (ArrayList<QnAOption>)qna_option_Service.selectQnaOptionAll(); 
    	  
    	  mav.addObject("qnaOptionList", qnaOptionList);
    	  mav.addObject("qnaList",qnaList);
      } catch (Exception e) {
    	  e.printStackTrace();
      }
      
      return mav;
   }
   
   
}