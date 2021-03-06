package com.project.ezkit.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ezkit.classification.Classification;
import com.project.ezkit.classification.ClassificationService;
import com.project.ezkit.inquiry.Inquiry;
import com.project.ezkit.inquiry.InquiryService;
import com.project.ezkit.notice.Notice;
import com.project.ezkit.notice.NoticeService;
import com.project.ezkit.order.OrderProduct;
import com.project.ezkit.order.OrderProductService;
import com.project.ezkit.qna.QnA;
import com.project.ezkit.qna.QnAService;
import com.project.ezkit.qna_option.QnAOption;
import com.project.ezkit.qna_option.QnAOptionService;
import com.project.ezkit.user.User;
import com.project.ezkit.user.UserService;

@Controller
public class AdminController {

   @Autowired
   private AdminService admin_Service;

   @Autowired
   private OrderProductService orderProduct_service;

   @Autowired
   private UserService user_Service;

   @Autowired
   private InquiryService inquiry_Service;

   @Autowired
   private ClassificationService classification_Service;

   @Autowired
   private QnAOptionService qnaOption_Service;

   @Autowired
   private QnAService qna_Service;

   @Autowired
   private NoticeService notice_Service;

   public static String basePath = "C:\\EZKitImg\\";

	/**
	 * ????????? ???????????????
	 * @return
	 */
	@RequestMapping(value = "/admin/main")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView("/admin/main");

		ArrayList<Inquiry> inquiryList = (ArrayList<Inquiry>) inquiry_Service.selectInquiryByResult(1); // 1????????? 2??????
		mav.addObject("inquiryList", inquiryList);
		return mav;
	}

	@GetMapping(value = "/admin/user_Info")
	public String user_InfoForm() {
		return "/admin/user_Info";
	}

	/**
	 * ????????????
	 * @param order_status - ?????? ??????
	 * @return
	 */
	@RequestMapping(value = "/admin/order_Info")
	public ModelAndView order_info(@RequestParam(value = "order_status") int order_status) {
		
		ModelAndView mav = new ModelAndView("/admin/order_State");

		try {
			ArrayList<OrderProduct> orderProduct_list = orderProduct_service.selectOrderProductByOrderStatus(order_status);
			ArrayList<Date> currentOrderStatusDate_list = currentOrderStatusDate(orderProduct_list);
			ArrayList<String> orderUserName_list = orderUserName(orderProduct_list);
			String orderStatus = orderStatusText(order_status);

			mav.addObject("orderStatus", orderStatus);
			mav.addObject("orderProduct_list", orderProduct_list);
			mav.addObject("currentOrderStatusDate_list", currentOrderStatusDate_list);
			mav.addObject("orderUserName_list", orderUserName_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	/**
	 * ???????????? ??????
	 * @param request
	 * @param redirect
	 * @return
	 */
	@RequestMapping(value = "/admin/updateOrderStatus")
	public String updateOrderStatus(HttpServletRequest request, RedirectAttributes redirect) {
		
		int order_status = 0;
		
		try {
			ArrayList<Integer> orderProductNum_list = returnList(request.getParameterValues("order_product_num"));
			order_status = Integer.parseInt(request.getParameter("update_status"));
			updateOrderStatusDateType(order_status, orderProductNum_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		redirect.addAttribute("order_status", order_status);
		
		return "redirect:/admin/order_Info";
	}

	/**
	 * ??????????????? ?????? ?????? ?????? ??????
	 * @param status - ????????????
	 * @param orderProductNum_list - ???????????? ??????
	 */
	public void updateOrderStatusDateType(int status, ArrayList<Integer> orderProductNum_list) {

		for (int i = 0; i < orderProductNum_list.size(); i++) {
			int order_product_num = orderProductNum_list.get(i);
			if (status == 2) {
				orderProduct_service.updateProductPreparationDate(order_product_num);
			} else if (status == 3) {
				orderProduct_service.updateDeliveryPreparationDate(order_product_num);
			} else if (status == 4) {
				orderProduct_service.updateDelieveryDate(order_product_num);
			} else if (status == 5) {
				orderProduct_service.updateDeliveryCompletedDate(order_product_num);
			}
		}
	}

	/**
	 * StringList -> ArrayList??? ???????????? ?????????
	 * @param list
	 * @return
	 */
	public ArrayList<Integer> returnList(String[] list) {
		ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(list));
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		
		for (int i = 0; i < stringList.size(); i++) {
			String str = stringList.get(i);
			int num = Integer.parseInt(str);
			integerList.add(num);
		}
		return integerList;
	}

	/**
	 * ?????? ????????? ?????? ????????? ???????????? ?????????
	 * @param op - OrderProduct (????????? ??????)
	 * @return
	 */
	public ArrayList<Date> currentOrderStatusDate(ArrayList<OrderProduct> op) {
		ArrayList<Date> currentOrderStatusDate = new ArrayList<Date>();

		for (int i = 0; i < op.size(); i++) {
			OrderProduct orderProduct = op.get(i);
			Date date = orderProduct_service.selectOrderStatusDate(orderProduct);
			currentOrderStatusDate.add(date);
		}
		return currentOrderStatusDate;
	}

	/**
	 * ??? ?????? ????????? ????????? ??????
	 * @param op - OrderProduct (????????? ??????)
	 * @return
	 */
	public ArrayList<String> orderUserName(ArrayList<OrderProduct> op) {
		ArrayList<String> orderUserName_list = new ArrayList<String>();

		for (int i = 0; i < op.size(); i++) {
			String currentOrderUserId = op.get(i).getUser_id();
			User orderUser = user_Service.selectUserById(currentOrderUserId);
			String orderUserName = orderUser.getUser_name();
			orderUserName_list.add(orderUserName);
		}
		return orderUserName_list;
	}

	/**
	 * Status ???????????? Text??? ???????????? ?????????
	 * @param order_status - int??? (1 ~ 5?????????)
	 * @return
	 */
	public String orderStatusText(int order_status) {
		
		String status = "";

		switch (order_status) {
			case 1:
				status = "????????????";
				break;
			case 2:
				status = "????????????";
				break;
			case 3:
				status = "????????????";
				break;
			case 4:
				status = "?????????";
				break;
			case 5:
				status = "????????????";
				break;
		}
		return status;
	}

	// ----- ???????????? -----

	
	/**
	 * ???????????? ??????
	 * @param user_id - ????????? ID
	 * @return
	 */
	@RequestMapping(value = "/admin/user_Info")
	public ModelAndView user_Info(@RequestParam(value = "user_id") String user_id) {

		ModelAndView mav = new ModelAndView("/admin/user_Info");
	
		try {
			User u = user_Service.selectUserById(user_id);
			mav.addObject("u", u);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * ?????????????????? ??????
	 * @param user_id - ????????? ID
	 * @return
	 */
	@RequestMapping(value = "/admin/user_Info_JSON")
	public ModelAndView user_Info_JSON(@RequestParam(value = "user_id") String user_id) {
		
		ModelAndView mav = new ModelAndView("/admin/user_Info_JSON");
		
		try {
			User u = user_Service.selectUserById(user_id);
			
			if (u == null) {
				mav.addObject("result", 0);
			}
			// ???????????? ??????
			else {
				mav.addObject("result", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * ???????????? ??????
	 * @param user_rating - ????????? ??????
	 * @param user_id - ????????? ID
	 * @return
	 */
	@RequestMapping(value = "/admin/updateUserRating")
	public ModelAndView updateUserPoint(@RequestParam(value = "user_rating") String user_rating, @RequestParam(value = "user_id") String user_id) {
		
		ModelAndView mav = new ModelAndView("/admin/user_Info");
		
		try {
			user_Service.updateUserRating(user_id, user_rating);
			User u = user_Service.selectUserById(user_id);
			mav.addObject("u", u);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;

	}

	/**
	 * ??????????????? ??????
	 * @param user_point - ????????? ?????????
	 * @param user_id - ????????? ID
	 * @return
	 */
	@RequestMapping(value = "/admin/updateUserPoint")
	public ModelAndView updateUserPoint(@RequestParam(value = "user_point") int user_point, @RequestParam(value = "user_id") String user_id) {

		ModelAndView mav = new ModelAndView("/admin/user_Info");

		try {
			User u = user_Service.selectUserById(user_id);
			
			u.setUser_point(user_point);
			user_Service.updateUserPoint(u);
			
			mav.addObject("u", u);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * ????????????
	 * @param redirect
	 * @param user_id - ????????? ID
	 * @return
	 */
	@RequestMapping(value = "/admin/deleteUser")
	public String deleteUser(RedirectAttributes redirect, @RequestParam(value = "user_id") String user_id) {

		try {
			redirect.addAttribute("user_id", user_id);
			user_Service.deleteUser(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/admin/user_Info";
	}

	// ----- ?????? -----

	/**
	 * ???????????? ????????? ?????? ?????????
	 * @param inquiry_result
	 * @return
	 */
	@RequestMapping(value = "/admin/inquiry_AdminList")
	public ModelAndView inquiry_AdminList(@RequestParam(value = "inquiry_result") int inquiry_result) {

		ModelAndView mav = new ModelAndView("/admin/inquiry_AdminList");

		ArrayList<Inquiry> inquiryList = (ArrayList<Inquiry>) inquiry_Service.selectInquiryByResult(inquiry_result);
		ArrayList<String> userNickList = new ArrayList<String>();

		try {
			for (int i = 0; i < inquiryList.size(); i++) {
				String user_id = inquiryList.get(i).getUser_id();
				User u = user_Service.selectUserById(user_id);
				userNickList.add(u.getUser_nick());
			}
			
			mav.addObject("i", inquiryList);
			mav.addObject("u", userNickList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}

	/**
	 * ???????????? ????????? ???????????? ??? ????????? ????????? ???????????? ?????????
	 * @param inquiry_num - ???????????? ??????
	 * @return
	 */
	@RequestMapping(value = "/admin/inquiry_AdminWritingForm")
	public ModelAndView inquiry_AdminWritingForm(@RequestParam(value = "inquiry_num") int inquiry_num) {

		ModelAndView mav = new ModelAndView("/admin/inquiry_AdminWriting");
		
		try {
			Inquiry i = inquiry_Service.selectInquiryByNum(inquiry_num);
			User u = user_Service.selectUserById(i.getUser_id());
			
			mav.addObject("i", i);
			mav.addObject("u", u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * ?????? ?????? ?????? ??? ????????? ???????????? ?????????
	 * @param redirect
	 * @param i
	 * @return
	 */
	// ?????? ?????? ?????? ??? ??????
	@RequestMapping(value = "/admin/inquiry_AdminWriting")
	public String inquiry_AdminWriting(RedirectAttributes redirect, Inquiry i) {

		try {
			inquiry_Service.updateInquiryReply(i);
			redirect.addAttribute("inquiry_num", i.getInquiry_num());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/inquiry_AdminView";
	}

	/**
	 * ???????????? ?????????
	 * @param inquiry_num
	 * @return
	 */
	@RequestMapping(value = "/admin/inquiry_AdminView")
	public ModelAndView inquiry_AdminView(@RequestParam(value = "inquiry_num") int inquiry_num) {

		ModelAndView mav = new ModelAndView("/admin/inquiry_AdminView");
		
		try {
			Inquiry i = inquiry_Service.selectInquiryByNum(inquiry_num);
			User u = user_Service.selectUserById(i.getUser_id());
			mav.addObject("i", i);
			mav.addObject("u", u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}

	/**
	 * ?????? ???????????????
	 * @param inquiry_num
	 * @return
	 */
	@RequestMapping(value = "/admin/inquiry_AdminEditForm")
	public ModelAndView inquiry_AdminEditForm(int inquiry_num) {
		ModelAndView mav = new ModelAndView("/admin/inquiry_AdminEdit");
		
		try {
			Inquiry i = inquiry_Service.selectInquiryByNum(inquiry_num);
			User u = user_Service.selectUserById(i.getUser_id());
			mav.addObject("user_nick", u.getUser_nick());
			mav.addObject("i", i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}

	// ----- ?????? ?????? -----

	@RequestMapping(value = "/admin/event_Banner")
	public ModelAndView event_Banner() {
		
		ModelAndView mav = new ModelAndView("/admin/event_Banner");

		try {
			/* ????????? ????????? ???????????? */
			ArrayList<String> fileList = new ArrayList<String>();
			String path = basePath + "Banner";
			
			File imgDir = new File(path);
			
			if (imgDir.exists()) {
				String[] files = imgDir.list();
				for (int i = 0; i < files.length; i++) {
					fileList.add(files[i]);
				}
			}
			
			mav.addObject("fileList", fileList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * ??????????????? ?????????
	 * @param e
	 * @return
	 */
	@RequestMapping(value = "/admin/insertBanner")
	public String insertBanner(Event e) {

		ArrayList<MultipartFile> bannerList = (ArrayList<MultipartFile>) e.getBanner_img();

		try {
			for (int i = 0; i < bannerList.size(); i++) {
				saveImg(bannerList.get(i));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "redirect:/admin/event_Banner";
	}

	/**
	 * ??????????????? ????????? ??????
	 * @param file
	 */
	public void saveImg(MultipartFile file) {

		try {
			String fileName = file.getOriginalFilename();
			
			if (fileName != null && !fileName.equals("")) {
				File dir = new File(basePath + "Banner");
				File f = null;
				
				if (!dir.exists()) {
					dir.mkdir(); // ????????? ????????????, ??? ?????? ?????? ???????????? ????????????.
				}
				
				f = new File(basePath + "Banner\\" + fileName);
				
				try {
					file.transferTo(f);
				} catch (IllegalStateException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ????????? ????????? ????????????
	 * @param fname
	 * @return
	 */
	@RequestMapping("BannerImg")
	public ResponseEntity<byte[]> getImg(String fname) {

		String path = basePath + "Banner\\" + fname;

		File f = new File(path);
		HttpHeaders header = new HttpHeaders();
		ResponseEntity<byte[]> result = null;

		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** 
	 * ????????? ????????? ??????
	 * @param fname
	 * @return
	 */
	@RequestMapping(value = "admin/deleteBanner")
	public String deleteBanner(@RequestParam(value = "fname") String fname) {
		String path = basePath + "Banner\\";
		File imgDir = new File(path);

		if (imgDir.exists()) {
			File f = new File(path + fname);
			f.delete();
		}

		return "redirect:/admin/event_Banner";
	}

   // ----- ???????????? -----

	/**
	 * ???????????? ?????? ?????????
	 * @return
	 */
   // ???????????? Edit ???
   @RequestMapping(value = "/admin/classification_EditPage")
   public ModelAndView classification_EditPage() {
	   
      ModelAndView mav = new ModelAndView("/admin/classification_EditPage");
      
      try {
    	  ArrayList<Classification> classificationList = (ArrayList<Classification>) classification_Service.selectClassificationAll();
    	  mav.addObject("classificationList", classificationList);
      } catch (Exception e) {
    	  e.printStackTrace();
      }

      return mav;
   }

   /**
    * ???????????? ??????
    * @param c - ????????????
    * @return
    */
   @RequestMapping(value = "/admin/insertClassification")
   public String insertClassification(Classification c) {

	   try {
		   classification_Service.insertClassification(c);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	      
	   return "redirect:/admin/classification_EditPage";
   }

   /**
    * ???????????? ??????
    * @param c - ????????????
    * @return
    */
   @RequestMapping(value = "/admin/updateClassification")
   public String updateClassification(Classification c) {
	   try {
		   classification_Service.updateClassification(c);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return "redirect:/admin/classification_EditPage";
   }

   /**
    * ???????????? ??????
    * @param classification_num - ???????????? ?????????
    * @return
    */
   @RequestMapping(value = "/admin/deleteClassification")
   public String deleteClassification(@RequestParam(value = "classification_num") int classification_num) {
	   try {
		   classification_Service.deleteClassification(classification_num);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return "redirect:/admin/classification_EditPage";
   }

   // ----- QnA -----

   /** 
    * Q&A ?????? ?????????
    * @param qna_option_name
    * @return
    */
   @RequestMapping(value = "/admin/QnA_WritingForm")
   public ModelAndView QnA_WritingForm(@RequestParam(value = "qna_option_name") String qna_option_name) {
	   
	   ModelAndView mav = new ModelAndView("/admin/QnA_Writing");
	   try {
		   mav.addObject("qna_option_name", qna_option_name);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return mav;
   }
   
   /**
    * Q&A ?????? ?????????
    * @return
    */
   @RequestMapping(value = "/admin/QnA_EditPage")
   public ModelAndView QnA_EditPage() {
	   
      ModelAndView mav = new ModelAndView("/admin/QnA_EditPage");
	   try {
		   ArrayList<QnAOption> qnaOptionList = (ArrayList<QnAOption>) qnaOption_Service.selectQnaOptionAll();
		   mav.addObject("q", qnaOptionList);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return mav;
   }

   /**
    * Q&A ?????? 
    * @param qna
    * @return
    */
   @RequestMapping(value = "/admin/QnA_Writing")
   public String QnA_Writing(QnA qna) {
	   try {
		   qna_Service.insertQna(qna);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return "redirect:/admin/QnA_EditPage";
   }

   /**
    * Q&A ?????? ??????
    * @param qnaOption
    * @return
    */
   @RequestMapping(value = "/admin/insertQnAOption")
   public String insertQnAOption(QnAOption qnaOption) {
	   try {
		   qnaOption_Service.insertQnaOption(qnaOption);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return "redirect:/admin/QnA_EditPage";
   }

   /**
    * Q&A ?????? ??????
    * @param qnaOption
    * @return
    */
   @RequestMapping(value = "/admin/updateQnAOption")
   public String updateQnAOption(QnAOption qnaOption) {
	   try {
		   qnaOption_Service.updateQnaOption(qnaOption);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return "redirect:/admin/QnA_EditPage";
   }

   /**
    * Q&A ?????? ??????
    * @param qna_option_num
    * @return
    */
   @RequestMapping(value = "/admin/deleteQnAOption")
   public String deleteQnAOption(@RequestParam(value = "qna_option_num") int qna_option_num) {
	   try {
		   qnaOption_Service.deleteQnaOption(qna_option_num);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return "redirect:/admin/QnA_EditPage";
   }

   // ----- ???????????? Notice -----

   /**
    * ???????????? ?????? ?????????
    * @return
    */
   @RequestMapping(value = "/admin/notice_WritingForm")
   public String notice_WritingForm() {
	   
	   return "/notice/notice_Writing";
   }

   /** 
    * ???????????? ?????? ?????????
    * @param redirect
    * @param n
    * @return
    */
   @RequestMapping(value = "/admin/notice_Writing")
   public String notice_Writing(RedirectAttributes redirect, Notice n) {
	   try {
		   int notice_num = notice_Service.getNoticeNum();
		   n.setNotice_num(notice_num);
		   notice_Service.insertNotice(n);
		   redirect.addAttribute("notice_num", notice_num);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }	   

	   return "redirect:/admin/notice_List";
   }
   
   /**
    * ???????????? ?????????
    * @return
    */
   @RequestMapping(value = "/admin/notice_List")
   public ModelAndView noticeList() {
	   
      ModelAndView mav = new ModelAndView("/notice/notice_List");
      
	   try {
		   ArrayList<Notice> noticeList = (ArrayList<Notice>) notice_Service.selectAllNotice();
		   mav.addObject("noticeList", noticeList);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }

	   return mav;
   }


   /**
    * ???????????? ?????? ?????????
    * @param notice_num
    * @return
    */
   @RequestMapping(value = "/admin/notice_View")
   public ModelAndView notice_View(@RequestParam(value = "notice_num") int notice_num) {

      ModelAndView mav = new ModelAndView("/notice/notice_View");
      
	   try {
		   notice_Service.noticeHits(notice_num);
		   Notice n = notice_Service.selectNoticeByNum(notice_num);
		   mav.addObject("n", n);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return mav;
   }

   /**
    * ???????????? ?????? ?????????
    * @param notice_num
    * @return
    */
   @RequestMapping(value = "/admin/notice_EditForm")
   public ModelAndView notice_EditForm(@RequestParam(value = "notice_num") int notice_num) {
	   
      ModelAndView mav = new ModelAndView("/notice/notice_Edit");
	   try {
		   Notice n = notice_Service.selectNoticeByNum(notice_num);
		   mav.addObject("n", n);
	   } catch (Exception e) {
		   e.printStackTrace();
	   } 
	   
	   return mav;
   }
   
	/**
	 * ???????????? ?????? ?????????
	 * @param redirect
	 * @param n
	 * @return
	 */
   @RequestMapping(value = "/admin/notice_Edit")
   public String notice_Edit(RedirectAttributes redirect, Notice n) {
	   try {
		   notice_Service.updateNotice(n);
		   redirect.addAttribute("notice_num", n.getNotice_num());
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return "redirect:/admin/notice_View";
   }

   /**
    * ???????????? ?????? ?????????
    * @param notice_num
    * @return
    */
   @RequestMapping(value = "/admin/notice_Delete")
   public String notice_Delete(@RequestParam(value="notice_num") int notice_num) {
	   try {
		   notice_Service.deleteNotice(notice_num);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
      
	   return "redirect:/admin/notice_List";
   }
   
   

}