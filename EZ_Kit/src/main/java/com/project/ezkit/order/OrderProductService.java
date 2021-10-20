package com.project.ezkit.order;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

	@Autowired
	private OrderProductMapper mapper;

	public void insertOrderProduct(OrderProduct op) {
		mapper.insertOrderProduct(op);
	}

	public ArrayList<OrderProduct> selectOrderProductByOrderNum(int order_num) {
		return mapper.selectOrderProductByOrderNum(order_num);
	}

	public ArrayList<OrderProduct> selectOrderProductByUserId(String user_id) {
		return mapper.selectOrderProductByUserId(user_id);
	}

	public ArrayList<OrderProduct> selectOrderProductByStatusAndUserId(String user_id, int order_status) {
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("order_status", order_status);
		return mapper.selectOrderProductByStatusAndUserId(map);
	}

	public Date selectOrderStatusDate(OrderProduct op) {
		int order_num = op.getOrder_num();
		int order_status = op.getOrder_status();
		int product_num = op.getProduct_num();

		Map map = new HashMap();
		map.put("order_num", order_num);
		map.put("product_num", product_num);
		Date date = null;

		switch (order_status) {
		case 1:
			date = mapper.selectPaymentDate(map);
			break;
		case 2:
			date = mapper.selectProductPreaparationDate(map);
			break;
		case 3:
			date = mapper.selectDeliveryPreaparationDate(map);
			break;
		case 4:
			date = mapper.selectDeliveryDate(map);
			break;
		case 5:
			date = mapper.selectDeliveryCompletedDate(map);
			break;
		}
		return date;
	};

	public int countOrderByOrderStatus(String user_id, int order_status) {
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("order_status", order_status);
		return mapper.countOrderByOrderStatus(map);
	};

	// 배송상태에 따라 주문 가져오기
	public ArrayList<OrderProduct> selectOrderProductByOrderStatus(int order_status) {
		return mapper.selectOrderProductByOrderStatus(order_status);
	}

	// 주문 상태 변경하기 : 바꿀 날짜 / order_product_num
	public void updateProductPreparationDate(int order_product_num) {
		mapper.updateProductPreparationDate(order_product_num);
	}

	public void updateDeliveryPreparationDate(int order_product_num) {
		mapper.updateDeliveryPreparationDate(order_product_num);
	}

	public void updateDelieveryDate(int order_product_num) {
		mapper.updateDelieveryDate(order_product_num);
	}

	public void updateDeliveryCompletedDate(int order_product_num) {
		mapper.updateDeliveryCompletedDate(order_product_num);
	}

}