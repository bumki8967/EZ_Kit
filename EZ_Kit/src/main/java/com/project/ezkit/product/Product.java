package com.project.ezkit.product;

import java.sql.Date;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Product {

	private int product_num;
	private String product_name;
	private int product_price;
	private int product_quantity;
	private String product_classification;
	private int product_portion;
	private int product_time;
	private String product_level;
	private String product_info;
	private Date product_regdate;
	private int product_hit;

	private List<MultipartFile> product_main_img;
	private MultipartFile product_detail_img;

	public Product() {
		super();
	}

	public Product(int product_num, String product_name, int product_price, int product_quantity,
			String product_classification, int product_portion, int product_time, String product_level,
			String product_info, Date product_regdate, int product_hit) {
		super();
		this.product_num = product_num;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_classification = product_classification;
		this.product_portion = product_portion;
		this.product_time = product_time;
		this.product_level = product_level;
		this.product_info = product_info;
		this.product_regdate = product_regdate;
		this.product_hit = product_hit;
	}

	public Product(int product_num, String product_name, int product_price, int product_quantity,
			String product_classification, int product_portion, int product_time, String product_level,
			String product_info, Date product_regdate, int product_hit, List<MultipartFile> product_main_img,
			MultipartFile product_detail_img) {
		super();
		this.product_num = product_num;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_classification = product_classification;
		this.product_portion = product_portion;
		this.product_time = product_time;
		this.product_level = product_level;
		this.product_info = product_info;
		this.product_regdate = product_regdate;
		this.product_hit = product_hit;
		this.product_main_img = product_main_img;
		this.product_detail_img = product_detail_img;
	}

	public int getProduct_num() {
		return product_num;
	}

	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_classification() {
		return product_classification;
	}

	public void setProduct_classification(String product_classification) {
		this.product_classification = product_classification;
	}

	public int getProduct_portion() {
		return product_portion;
	}

	public void setProduct_portion(int product_portion) {
		this.product_portion = product_portion;
	}

	public int getProduct_time() {
		return product_time;
	}

	public void setProduct_time(int product_time) {
		this.product_time = product_time;
	}

	public String getProduct_level() {
		return product_level;
	}

	public void setProduct_level(String product_level) {
		this.product_level = product_level;
	}

	public String getProduct_info() {
		return product_info;
	}

	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}

	public Date getProduct_regdate() {
		return product_regdate;
	}

	public void setProduct_regdate(Date product_regdate) {
		this.product_regdate = product_regdate;
	}

	public int getProduct_hit() {
		return product_hit;
	}

	public void setProduct_hit(int product_hit) {
		this.product_hit = product_hit;
	}

	public List<MultipartFile> getProduct_main_img() {
		return product_main_img;
	}

	public void setProduct_main_img(List<MultipartFile> product_main_img) {
		this.product_main_img = product_main_img;
	}

	public MultipartFile getProduct_detail_img() {
		return product_detail_img;
	}

	public void setProduct_detail_img(MultipartFile product_detail_img) {
		this.product_detail_img = product_detail_img;
	}

	@Override
	public String toString() {
		return "Product [product_num=" + product_num + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_quantity=" + product_quantity + ", product_classification="
				+ product_classification + ", product_portion=" + product_portion + ", product_time=" + product_time
				+ ", product_level=" + product_level + ", product_info=" + product_info + ", product_regdate="
				+ product_regdate + ", product_hit=" + product_hit + ", product_main_img=" + product_main_img
				+ ", product_detail_img=" + product_detail_img + "]";
	}

	
}