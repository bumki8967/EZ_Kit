package com.project.ezkit.inquiry;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ezkit.qna.QnAService;
import com.project.ezkit.qna_option.QnAOption;
import com.project.ezkit.qna_option.QnAOptionService;
import com.project.ezkit.user.User;
import com.project.ezkit.user.UserService;

@Controller
public class InquiryController {

	@Autowired
	UserService user_Service;

	@Autowired
	InquiryService inquiry_Service;

	@Autowired
	QnAOptionService qna_option_Service;

	@Autowired
	QnAService qna_Service;

	/**
	 * 문의작성 페이지
	 * @return
	 */
	@RequestMapping(value = "/inquiry/inquiryWriting")
	public ModelAndView inquiry_Writing_Form() {

		ModelAndView mav = new ModelAndView("/inquiry/inquiry_Writing");
		try {
			ArrayList<QnAOption> qnaOptionList = (ArrayList<QnAOption>) qna_option_Service.selectQnaOptionAll();

			mav.addObject("qnaOptionList", qnaOptionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}

	/**
	 * 문의작성 실행 메소드
	 * @param redirect
	 * @param i
	 * @return inquiry_UserList - 문의 리스트
	 */
	@RequestMapping(value = "/inquiry/inquiry_Writing")
	public String inquiry_Writing(RedirectAttributes redirect, Inquiry i) {
		try {
			inquiry_Service.insertInquiry(i);
			
			redirect.addAttribute("user_id", i.getUser_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/inquiry/inquiry_UserList";
	}

	/**
	 * 문의 리스트
	 * @param user_id
	 * @return inquiry_UserList - 문의 리스트
	 */
	@RequestMapping(value = "/inquiry/inquiry_UserList")
	public ModelAndView inquiry_UserList(@RequestParam(value = "user_id") String user_id) {

		ModelAndView mav = new ModelAndView("/inquiry/inquiry_UserList");
		try {
			ArrayList<Inquiry> inquiryList = (ArrayList<Inquiry>) inquiry_Service.selectInquiryByUserId(user_id);
			ArrayList<QnAOption> qnaOptionList = (ArrayList<QnAOption>) qna_option_Service.selectQnaOptionAll();
			
			mav.addObject("qnaOptionList", qnaOptionList);
			mav.addObject("inquiryList", inquiryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}

	/**
	 * 문의 내용 보기
	 * @param inquiry_num
	 * @param num
	 * @return
	 */
	@RequestMapping(value = "/inquiry/inquiry_UserView")
	public ModelAndView inquiry_UserView(@RequestParam(value = "inquiry_num") int inquiry_num, @RequestParam(value = "num") int num) {

		ModelAndView mav = new ModelAndView("/inquiry/inquiry_UserView");
		try {
			Inquiry i = inquiry_Service.selectInquiryByNum(inquiry_num);
			User u = user_Service.selectUserById(i.getUser_id());
			ArrayList<QnAOption> qnaOptionList = (ArrayList<QnAOption>) qna_option_Service.selectQnaOptionAll();

			mav.addObject("qnaOptionList", qnaOptionList);
			mav.addObject("user_nick", u.getUser_nick());
			mav.addObject("i", i);
			mav.addObject("num", num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}

}