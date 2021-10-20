package com.project.ezkit.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.ezkit.cart.CartService;
import com.project.ezkit.user.User;
import com.project.ezkit.user.UserService;

@Controller
public class OrderController {

	@Autowired
	private OrderService order_service;

	@Autowired
	private UserService user_service;

	@Autowired
	private OrderProductService orderProduct_service;

	@Autowired
	private CartService cart_service;

	// 결제창으로 이동 : order_Payment.jsp
	// 필요한 데이터 : user_id, product_num, product_quantity, used_point
	// 페이지에 보낼 데이터 : user_id (User), productNum_list(선택한 상품 번호 리스트)
	// productQuantity_list(선택한 각 상품 수량 리스트)
	// productPriceSum_list(선택한 각 상품 합계 : 이미 계산 되어 있다)
	// used_point (사용한 포인트) : 결제완료후 user_point - used_point 계산
	/**
	 * 상품 결제 페이지
	 * @param user_id - 사용자 ID, product_num - 상품번호, product_quantity - 상품수량, used_point - 사용 포인트
	 * @param productQuantity_list - 각 상품의 수량, productPriceSum_list - 각 상품의 합계
	 * @return
	 */
	@RequestMapping(value = "/order/payment")
	public ModelAndView orderPayment(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/order/order_Payment");
		String user_id = request.getParameter("user_id");
		try {
			User u = user_service.selectUserById(user_id);

			String[] productName_Array = request.getParameterValues("product_name");
			ArrayList<String> productname_list = new ArrayList<String>(Arrays.asList(productName_Array));

			ArrayList<Integer> productNum_list = returnList(request.getParameterValues("product_num"));
			ArrayList<Integer> productQuantity_list = returnList(request.getParameterValues("product_quantity"));
			ArrayList<Integer> productPriceSum_list = returnList(request.getParameterValues("product_price"));
			int used_point = Integer.parseInt(request.getParameter("used_point"));
			
			mav.addObject("u", u);
			mav.addObject("used_point", used_point);
			mav.addObject("productNum_list", productNum_list);
			mav.addObject("productname_list", productname_list);
			mav.addObject("productQuantity_list", productQuantity_list);
			mav.addObject("productPriceSum_list", productPriceSum_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	/**
	 * 상품 주문실행 메소드
	 * @param user_id - 사용자 ID, edited_user_postcode - 배송지 우편번호 (수정하지 않을 시 현재 우편번호 자동입력) 
	 * @param edited_user_addresse1 - 배송지 주소, edited_user_addresse2 - 배송지 상세주소 (수정하지 않을 시 현재 주소 & 상세주소 자동입력)
	 * @param productQuantity_list - 각 상품의 수량, productPriceSum_list - 각 상품의 합계
	 * @return
	 */
	@RequestMapping(value = "/order/insertOrder")
	public ModelAndView insertOrder(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("/order/order_Result");

		try {
			int order_num = order_service.getNum();

			String user_id = request.getParameter("user_id");

			String[] productName_Array = request.getParameterValues("product_name");

			ArrayList<Integer> productNum_list = returnList(request.getParameterValues("product_num"));
			ArrayList<Integer> productQuantity_list = returnList(request.getParameterValues("product_quantity"));
			ArrayList<Integer> productPriceSum_list = returnList(request.getParameterValues("product_price"));

			ArrayList<String> user_addrInfo = new ArrayList<String>();
			String order_user_addr1 = request.getParameter("edited_user_addresse1");
			String order_user_addr2 = request.getParameter("edited_user_addresse2");
			String order_user_postcode = request.getParameter("edited_user_postcode");

			if (order_user_addr1 == null || order_user_addr1.equals("")) {
				user_addrInfo = null;
			} else {
				user_addrInfo.add(order_user_addr1);
				user_addrInfo.add(order_user_addr2);
				user_addrInfo.add(order_user_postcode);
			}

			// 사용 포인트
			int order_used_point = Integer.parseInt(request.getParameter("used_point"));

			// order에 넣기
			Order order = orderInsert(order_num, user_id, productQuantity_list, productPriceSum_list, order_used_point, user_addrInfo);

			// orderProduct에 넣기
			ArrayList<OrderProduct> orderProduct_list = orderProductInsert(productNum_list, productName_Array, productQuantity_list, productPriceSum_list, order_num, user_id);

			// 장바구니에서 해당 상품 삭제
			deleteCart(user_id, productNum_list);

			// 사용한 point 차감
			userPointMinus(user_id, order_used_point);

			// 적립 point 넣기
			int sumTotalPrice = sumTotalPrice(productPriceSum_list);
			User u = user_service.selectUserById(user_id);
			String user_rating = u.getUser_rating();
			int save_point = save_point(user_rating, sumTotalPrice);
			userPointPlus(user_id, save_point);

			mav.addObject("used_point", order_used_point);
			mav.addObject("save_point", save_point);
			mav.addObject("orderProduct_list", orderProduct_list);
			mav.addObject("order", order);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	/**
	 * productNum_list, productQuantity_list, productPrice_list 배열로 바꾸는 메서드
	 * @param list
	 * @return integerList - StringList에서 int값으로 변환된 list
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
	 * 모든 상품들의 총 합계
	 * @param productPriceSum_list - 각 상품들의 가격
	 * @return sumTotalPrice - 총 합계
	 */
	public int sumTotalPrice(ArrayList<Integer> productPriceSum_list) {
		int sumTotalPrice = 0;

		for (int i = 0; i < productPriceSum_list.size(); i++) {
			int price = productPriceSum_list.get(i);
			sumTotalPrice += price;
		}
		return sumTotalPrice;
	}

	/**
	 * 상품 전체 수량
	 * @param productQuantity_list - 각 상품들의 갯수
	 * @return sumTotalQuantity - 총 갯수
	 */
	public int sumTotalQuantity(ArrayList<Integer> productQuantity_list) {
		
		int sumTotalQuantity = 0;

		for (int i = 0; i < productQuantity_list.size(); i++) {
			int quantity = productQuantity_list.get(i);
			sumTotalQuantity += quantity;
		}
		return sumTotalQuantity;
	}

	/**
	 * 각 등급별 적립포인트 계산 메소드
	 * @param user_rating - 사용자 등급
	 * @param sumTotalPrice - 결재한 총 가격
	 * @return save_point - 적립된 포인트
	 */
	public int save_point(String user_rating, int sumTotalPrice) {
		
		float userRating = 0f;
		float save_point = 0f;

		switch (user_rating) {
			case "Silver":
				userRating = 0.002f;
				break;
	
			case "Gold":
				userRating = 0.003f;
				break;
	
			case "Diamond":
				userRating = 0.004f;
				break;
	
			case "VIP":
				userRating = 0.005f;
				break;
		}
		save_point = (float) sumTotalPrice * userRating;
		
		return (int) save_point;
	}

	/**
	 * 각 주문별 상품 리스트
	 * @param productNum_list - 상품번호 리스트
	 * @param productName_Array - 상품이름 리스트
	 * @param productQuantity_list - 상품수량 리스트
	 * @param productPriceSum_list - 상품가격 리스트
	 * @param order_num - 주문번호
	 * @param user_id - 사용자 ID
	 * @return orderProduct_list - 주문별 상품 리스트
	 */
	public ArrayList<OrderProduct> orderProductInsert(ArrayList<Integer> productNum_list, String[] productName_Array, ArrayList<Integer> productQuantity_list, 
													  ArrayList<Integer> productPriceSum_list, int order_num, String user_id) {

		int order_status = 1;

		OrderProduct op = new OrderProduct();

		for (int i = 0; i < productNum_list.size(); i++) {
			int product_num = productNum_list.get(i);
			String product_name = productName_Array[i];
			int product_quantity = productQuantity_list.get(i);
			int product_price = productPriceSum_list.get(i);

			op.setOrder_num(order_num);
			op.setUser_id(user_id);
			op.setProduct_num(product_num);
			op.setProduct_name(product_name);
			op.setProduct_quantity(product_quantity);
			op.setProduct_price(product_price);
			op.setOrder_status(order_status);

			orderProduct_service.insertOrderProduct(op);

		}
		ArrayList<OrderProduct> orderProduct_list = orderProduct_service.selectOrderProductByOrderNum(order_num);
		
		return orderProduct_list;
	}

	/**
	 * 구매기록
	 * @param order_num - 상품번호
	 * @param user_id - 사용자 ID
	 * @param productQuantity_list - 상품갯수
	 * @param productPriceSum_list - 상품가격
	 * @param order_used_point - 사용 포인트
	 * @param user_addrInfo - 사용자 배송지 주소
	 * @return
	 */
	public Order orderInsert(int order_num, String user_id, ArrayList<Integer> productQuantity_list, ArrayList<Integer> productPriceSum_list, 
							 int order_used_point, ArrayList<String> user_addrInfo) {

		Order o = new Order();

		User u = user_service.selectUserById(user_id);
		String user_rating = u.getUser_rating();
		String order_user_tel;
		String order_user_addr1;
		String order_user_addr2;
		String order_user_postcode;

		if (user_addrInfo == null) {
			order_user_tel = u.getUser_tel();
			order_user_addr1 = u.getUser_addr1();
			order_user_addr2 = u.getUser_addr2();
			order_user_postcode = u.getUser_postcode();
		} else {
			order_user_tel = u.getUser_tel();
			order_user_addr1 = user_addrInfo.get(0);
			order_user_addr2 = user_addrInfo.get(1);
			order_user_postcode = user_addrInfo.get(2);

		}

		int sumTotalQuantity = sumTotalQuantity(productQuantity_list);
		int sumTotalPrice = sumTotalPrice(productPriceSum_list);
		int save_point = save_point(user_rating, sumTotalPrice);
		int order_payment_price = sumTotalPrice - order_used_point;

		o.setOrder_num(order_num);
		o.setUser_id(user_id);
		o.setOrder_total_quantity(sumTotalQuantity);
		o.setOrder_payment_price(order_payment_price);
		o.setOrder_save_point(save_point);
		o.setOrder_used_point(order_used_point);
		o.setOrder_user_tel(order_user_tel);
		o.setOrder_user_address1(order_user_addr1);
		o.setOrder_user_address2(order_user_addr2);
		o.setOrder_user_postcode(order_user_postcode);

		order_service.insertOrder(o);

		return o;
	}

	/**
	 * 장바구니 삭제 메소드
	 * @param user_id - 사용자 ID
	 * @param productNum_list - 상품별 번호리스트
	 */
	public void deleteCart(String user_id, ArrayList<Integer> productNum_list) {
		
		for (int i = 0; i < productNum_list.size(); i++) {
			int product_num = productNum_list.get(i);
			cart_service.deleteCart(product_num, user_id);
		}
	}

	/**
	 * 포인트 사용 차감 메소드
	 * @param user_id - 사용자 ID
	 * @param used_point - 사용한 포인트
	 */
	public void userPointMinus(String user_id, int used_point) {
		
		User u = user_service.selectUserById(user_id);
		int userPoint = u.getUser_point();
		int resultPoint = userPoint - used_point;

		u.setUser_point(resultPoint);
		user_service.updateUserPoint(u);
	}

	/**
	 * 포인트 적립 메소드
	 * @param user_id - 사용자 ID
	 * @param save_point - 적립된 포인트
	 */
	public void userPointPlus(String user_id, int save_point) {
		
		User u = user_service.selectUserById(user_id);
		int userPoint = u.getUser_point();
		int resultPoint = userPoint + save_point;

		u.setUser_point(resultPoint);
		user_service.updateUserPoint(u);
	}

}