package com.project.ezkit.cart;

import java.net.http.HttpRequest;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ezkit.product.ProductService;
import com.project.ezkit.user.User;
import com.project.ezkit.user.UserService;

@Controller
public class CartController {

	@Autowired
	private CartService cart_Service;

	@Autowired
	private ProductService product_Service;

	@Autowired
	private UserService user_Service;

	/**
	 * 장바구니 등록 메소드 (상품 디테일 페이지)
	 * @param redirect
	 * @param user_id          - 사용자 ID
	 * @param product_num      - 상품번호
	 * @param product_quantity - 상품수량
	 * @return
	 */
	@RequestMapping(value = "/order/cartInsert")
	public String cartInsert(RedirectAttributes redirect, @RequestParam(value = "user_id") String user_id,
							 @RequestParam(value = "product_num") int product_num, @RequestParam(value = "product_quantity") int product_quantity) {

		int cart_num = cart_Service.getNum();

		try {
			Cart c = new Cart(cart_num, product_num, product_quantity, user_id);
			cart_Service.insertCart(c);
			
			redirect.addAttribute("user_id", user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/order/cart_list";
	}

	/**
	 * 장바구니 등록 메소드 (상품 리스트 페이지)
	 * @param user_id          - 사용자 ID
	 * @param product_num      - 상품번호
	 * @param product_quantity - 상품수량
	 * @return
	 */
	@RequestMapping(value = "/order/cart_Insert")
	public ModelAndView cart_Insert(@RequestParam(value = "user_id") String user_id, @RequestParam(value = "product_num") int product_num,
									@RequestParam(value = "product_quantity") int product_quantity) {

		ModelAndView mav = new ModelAndView("/order/cartJSON");

		try {
			int cart_num = cart_Service.getNum();
			int rs = cart_Service.selectProductCount(product_num);
			Cart c = new Cart(cart_num, product_num, product_quantity, user_id);

			int result = 0;

			if (c != null) {
				if (rs > 0) {
					result = 2;
					mav.addObject("result", result);
				} else {
					cart_Service.insertCart(c);
					result = 1;
					mav.addObject("result", result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * 장바구니 리스트
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value = "/order/cart_list")
	public ModelAndView cartList(@RequestParam(value = "user_id") String user_id) {

		ModelAndView mav = new ModelAndView("/order/cart");

		try {
			ArrayList<Cart> myCartList = (ArrayList<Cart>) cart_Service.selectCartProductById(user_id);
			ArrayList<Cart> cartList = cart_Service.selectCartById(user_id);
			User user = user_Service.selectUserById(user_id);

			mav.addObject("myCartList", myCartList);
			mav.addObject("cartList", cartList);
			mav.addObject("u", user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * 장바구니 리스트 삭제
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/order/cart_delete")
	public ModelAndView cartDelete(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/order/cartJSON");
		int result = 0;

		try {
			String user_id = request.getParameter("user_id");
			String[] productNum_list = request.getParameterValues("productNum_list");
			
			for (int i = 0; i < productNum_list.length; i++) {
				int product_num = Integer.parseInt(productNum_list[i]);
				cart_Service.deleteCart(product_num, user_id);
			}
			result = 1;
			
			mav.addObject("result", result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}
}