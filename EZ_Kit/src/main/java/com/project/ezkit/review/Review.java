package com.project.ezkit.review;

import java.sql.Date;

public class Review {

	private int review_num;
	private String user_type;
	private String user_nick;
	private String review_content;
	private int product_num;
	private Date review_date;

	public Review() {
	}

	public Review(int review_num, String user_type, String user_nick, String review_content, int product_num,
			Date review_date) {
		super();
		this.review_num = review_num;
		this.user_type = user_type;
		this.user_nick = user_nick;
		this.review_content = review_content;
		this.product_num = product_num;
		this.review_date = review_date;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getProduct_num() {
		return product_num;
	}

	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	@Override
	public String toString() {
		return "Review [review_num=" + review_num + ", user_type=" + user_type + ", user_nick=" + user_nick
				+ ", review_content=" + review_content + ", product_num=" + product_num + ", review_date=" + review_date
				+ "]";
	}

}
