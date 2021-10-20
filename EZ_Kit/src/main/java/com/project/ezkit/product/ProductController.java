package com.project.ezkit.product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ezkit.classification.Classification;
import com.project.ezkit.classification.ClassificationService;
import com.project.ezkit.review.Review;
import com.project.ezkit.review.ReviewService;
import com.project.ezkit.user.User;
import com.project.ezkit.user.UserService;

@Controller
public class ProductController {

	@Autowired
	private ProductService product_Service;

	@Autowired
	private ReviewService review_Service;
	
	@Autowired 
	private UserService user_Service;

	@Autowired
	private ClassificationService classification_Service;

	public static String basePath = "C:\\EZKitImg\\";

	/**
	 * 상품등록 페이지로 이동
	 * @return
	 */
	@RequestMapping(value = "/product/product_Add")
	public ModelAndView product_Add() {
		ModelAndView mav = new ModelAndView("/product/product_Add");
		ArrayList<Classification> classificationList = (ArrayList<Classification>) classification_Service.selectClassificationAll();

		mav.addObject("classificationList", classificationList);
		return mav;
	}

	/**
	 * 상품등록 메소드
	 * @param p - Product (상품)
	 * @return redirect - index (메인페이지)
	 */
	@RequestMapping(value = "/product/productAdd")
	public String productAdd(Product p, RedirectAttributes redirect) {
		
		try {
			int num = product_Service.getNum();
			p.setProduct_num(num);
			
			product_Service.insertProduct(p);
			ArrayList<MultipartFile> multiList = (ArrayList<MultipartFile>) p.getProduct_main_img();
			
			for (int i = 0; i < multiList.size(); i++) {
				saveImg(num, multiList.get(i), 1);
			}
			saveImg(num, p.getProduct_detail_img(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/";
	}

	/**
	 * 등록된 상품들을 출력
	 * @param p - product (상품)
	 * @return mav - product_List 페이지
	 */
	@RequestMapping(value = "/product/product_list")
	public ModelAndView productList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/product/product_List");
		
		try {
			HttpSession session = request.getSession(false);
			String user_id = (String) session.getAttribute("user_id");
			User u = null;
			
			if (user_id != null) {
				u = user_Service.selectUserById(user_id);
				
				mav.addObject("u", u);
			}
			
			// 등록된 모든 상품
			ArrayList<Product> allProdList = (ArrayList<Product>) product_Service.selectProductAll();
			ArrayList<Classification> classificationList = (ArrayList<Classification>) classification_Service.selectClassificationAll();
			
			/* 등록된 이미지 가져오기 */
			ArrayList<String> fileList = new ArrayList<String>();
			String path = "";
			
			for (int i = 0; i < allProdList.size(); i++) {
				Product p = allProdList.get(i);
				path = basePath + p.getProduct_num() + "\\";
				File imgDir = new File(path);
				
				if (imgDir.exists()) {
					String[] files = imgDir.list();
					fileList.add(files[0]);
				}
			}
			
			mav.addObject("classificationList", classificationList);
			mav.addObject("allProdList", allProdList);
			mav.addObject("fileList", fileList);
			mav.addObject("type2", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * 상품 카테고리에 맞춰 상품 출력
	 * @param classification_name - 상품분류 (한식, 양식, 중식, 일식, 분식)
	 * @param type1 - 페이지 새로고침 후 CSS 유지를 위한 스크립트
	 * @return
	 */
	@RequestMapping(value = "/product/product_list_classification")
	public ModelAndView classificationBtn(@RequestParam(value = "classification_name") String classification_name, @RequestParam(value = "type1") int type1) {

		ModelAndView mav = new ModelAndView("/product/product_List");
		
		try {
			ArrayList<Product> prodListByClassification = (ArrayList<Product>) product_Service.selectProductByClassification(classification_name);
			ArrayList<Classification> classificationList = (ArrayList<Classification>) classification_Service.selectClassificationAll();
			
			/* 등록된 이미지 가져오기 */
			ArrayList<String> fileList = new ArrayList<String>();
			String path = "";
			
			for (int i = 0; i < prodListByClassification.size(); i++) {
				Product p = prodListByClassification.get(i);
				path = basePath + p.getProduct_num() + "\\";
				File imgDir = new File(path);
				
				if (imgDir.exists()) {
					String[] files = imgDir.list();
					fileList.add(files[0]);
				}
			}
			
			mav.addObject("classificationList", classificationList);
			mav.addObject("allProdList", prodListByClassification);
			mav.addObject("fileList", fileList);
			mav.addObject("type2", type1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * 상품 상세 페이지
	 * @param product_num
	 * @return
	 */
	@RequestMapping(value = "/product/product_detail")
	public ModelAndView productDetail(HttpServletRequest request, @RequestParam(value = "product_num") int product_num) {

		ModelAndView mav = new ModelAndView("/product/product_Detail");
		
		try {
			HttpSession session = request.getSession(false);
			String user_id = (String) session.getAttribute("user_id");
			User u = null;
			
			if (user_id != null) {
				u = user_Service.selectUserById(user_id);
				
				mav.addObject("u", u);
			}
			
			product_Service.updateProductHit(product_num);
			
			Product p = product_Service.selectProductByNum(product_num);
			ArrayList<Review> list = (ArrayList<Review>) review_Service.selectReviewByProductNum(product_num);
			
			String path = basePath + p.getProduct_num() + "\\";
			File imgDir = new File(path);
			
			String path2 = basePath + p.getProduct_num() + "\\detail\\";
			File imgDir2 = new File(path2);
			String[] detailImg = {};
			
			if (imgDir.exists()) {
				String[] files = imgDir.list();
				ArrayList<String> filesname = new ArrayList<String>();
				
				for (int j = 0; j < files.length; j++) {
					if (imgDir2.exists()) {
						detailImg = imgDir2.list();
						mav.addObject("detailImg", detailImg[0]);
					}
					if (files[j].equals("detail")) {
						continue;
					}
					filesname.add(files[j]);
				}
				
				mav.addObject("filesname", filesname);
			}
			
			mav.addObject("list2", list);
			mav.addObject("p", p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * (관리자)
	 * 상품 수정 페이지
	 * @param product_num
	 * @return
	 */
	@RequestMapping(value = "/product/productEdit")
	public ModelAndView productEditForm(@RequestParam(value = "product_num") int product_num) {

		ModelAndView mav = new ModelAndView("/product/product_Edit");
		try {
			Product p = product_Service.selectProductByNum(product_num);
			
			mav.addObject("p", p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * (관리자)
	 * 상품 수정 실행 메소드
	 * @param redirect
	 * @param p
	 * @param product_num
	 * @return
	 */
	@RequestMapping(value = "/product/product_Edit")
	public String productEdit(RedirectAttributes redirect, Product p, @RequestParam(value = "product_num") int product_num) {

		try {
			// 게시글에 등록된 이미지 삭제
			String path = basePath + p.getProduct_num() + "\\";
			File imgDir = new File(path);
			
			String path2 = basePath + p.getProduct_num() + "\\detail\\";
			File imgDir2 = new File(path2);
			
			ArrayList<MultipartFile> multiList = (ArrayList<MultipartFile>) p.getProduct_main_img();
			
			if (imgDir.exists()) {
				String[] files = imgDir.list();
				
				for (int j = 0; j < files.length; j++) {
					if (imgDir2.exists()) {
						File f = new File(path2 + files);
						f.delete();
					}
					File f = new File(path + files[j]);
					f.delete();
				}
			}
			
			product_Service.updateProduct(p);
			
			for (int i = 0; i < multiList.size(); i++) {
				saveImg(product_num, multiList.get(i), 1);
			}
			saveImg(product_num, p.getProduct_detail_img(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/product/product_list";
	}

	/**
	 * (관리자)
	 * 상품 상세 페이지에서의 삭제 메소드 
	 * @param redirect
	 * @param p
	 * @param product_num
	 * @return
	 */
	@RequestMapping(value = "/product/product_Delete")
	public String product_Delete(RedirectAttributes redirect, Product p, @RequestParam(value = "product_num") int product_num) {
		
		try {
			String path = basePath + p.getProduct_num() + "\\";
			File imgDir = new File(path);
			String path2 = basePath + p.getProduct_num() + "\\detail\\";
			File imgDir2 = new File(path2);
			product_Service.deleteProduct(product_num);
			
			if (imgDir.exists()) {
				String[] files = imgDir.list();
				
				for (int j = 0; j < files.length; j++) {
					if (imgDir2.exists()) {
						File f = new File(path2 + files);
						f.delete();
					}
					File f = new File(path + files[j]);
					f.delete();
				}
			}
			imgDir.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/product/product_list";
	}

	/**
	 * (관리자)
	 * 상품 리스트 페이지에서의 삭제 메소드
	 * @param product_num
	 * @return
	 */
	@RequestMapping(value = "/product/productDelete")
	public ModelAndView productDelete(@RequestParam(value = "product_num") int product_num) {

		ModelAndView mav = new ModelAndView("/product/productJSON");
		
		try {
			int result = 0;
			Product p = product_Service.selectProductByNum(product_num);
			
			if (p != null) {
				result = 1;
				product_Service.deleteProduct(product_num);
				mav.addObject("result", result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * 이미지를 저장하기 위한 메소드
	 * @param num
	 * @param file
	 */
	public void saveImg(int num, MultipartFile file, int type) {

		String fileName = file.getOriginalFilename();

		if (fileName != null && !fileName.equals("")) {
			File dir = new File(basePath + num);
			File f = null;

			if (!dir.exists()) {
				dir.mkdir(); // 폴더 이름을 시퀀스 번호로 생성하고, 그 폴더 안에 이미지가 들어간다.

				fileName = "0" + fileName;
				f = new File(basePath + num + "\\" + fileName);
			} else if (dir.exists()) {
				fileName = "0" + fileName;
				f = new File(basePath + num + "\\" + fileName);
			}
			if (type == 1) {
				f = new File(basePath + num + "\\" + fileName);
			} else if (type == 2) {
				File dir2 = new File(basePath + num + "\\detail");
				dir2.mkdir();
				f = new File(basePath + num + "\\detail\\" + fileName);
			}

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
	}

	/**
	 * 이미지 출력을 위한 메소드
	 * @param fname
	 * @param product_num
	 * @param type
	 * @return
	 */
	@RequestMapping("productImg")
	public ResponseEntity<byte[]> getImg(String fname, int product_num, int type) {

		String path = "";
		if (type == 1) {
			path = basePath + product_num + "\\" + fname;
		} else if (type == 2) {
			path = basePath + product_num + "\\detail\\" + fname;
		}

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
	 * 상품검색 페이지
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/product/findProduct")
	public ModelAndView findProduct(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/product/product_Find");
		
		try {
			HttpSession session = request.getSession(false);
			String user_id = (String) session.getAttribute("user_id");
			User u = null;
			
			if (user_id != null) {
				u = user_Service.selectUserById(user_id);
				
				mav.addObject("u", u);
			}
			
			// 등록된 모든 상품
			ArrayList<Product> allProdList = (ArrayList<Product>) product_Service.selectProductAll();
			
			/* 등록된 이미지 가져오기 */
			ArrayList<String> fileList = new ArrayList<String>();
			String path = "";
			
			for (int i = 0; i < allProdList.size(); i++) {
				Product p = allProdList.get(i);
				path = basePath + p.getProduct_num() + "\\";
				File imgDir = new File(path);
				
				if (imgDir.exists()) {
					String[] files = imgDir.list();
					fileList.add(files[0]);
				}
			}
			
			mav.addObject("allProdList", allProdList);
			mav.addObject("fileList", fileList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return mav;
	}

	/**
	 * 검색어 입력받아 상품을 검색하는 메소드
	 * @param searchKeyword
	 * @return
	 */
	@RequestMapping(value = "/product/searchKeyword")
	public ModelAndView searchKeyword(@RequestParam(value = "searchKeyword") String searchKeyword) {

		ModelAndView mav = new ModelAndView("/product/product_Find");
		
		try {
			ArrayList<Product> allProdList = (ArrayList<Product>) product_Service.selectProductByName(searchKeyword);
			
			/* 등록된 이미지 가져오기 */
			ArrayList<String> fileList = new ArrayList<String>();
			String path = "";
			
			for (int i = 0; i < allProdList.size(); i++) {
				Product p = allProdList.get(i);
				path = basePath + p.getProduct_num() + "\\";
				File imgDir = new File(path);
				
				if (imgDir.exists()) {
					String[] files = imgDir.list();
					fileList.add(files[0]);
				}
			}
			
			mav.addObject("allProdList", allProdList);
			mav.addObject("fileList", fileList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

}
